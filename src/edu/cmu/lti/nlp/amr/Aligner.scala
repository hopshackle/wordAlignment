package edu.cmu.lti.nlp.amr

import java.text.SimpleDateFormat
import java.io._
import scala.collection.immutable.Map

/****************************** Driver Program *****************************/
object Aligner {

  val usage = """Usage: scala -classpath . edu.cmu.lti.nlp.amr.Aligner < amr_file > alignments"""
  type OptionMap = Map[Symbol, Any]
  val processor = new StanfordProcessor

  def parseOptions(map: OptionMap, list: List[String]): OptionMap = {
    def isSwitch(s: String) = (s(0) == '-')
    list match {
      case Nil => map
      //case "--train" :: tail =>
      //          parseOptions(map ++ Map('train -> true), tail)
      case "-i" :: value :: tail =>
        parseOptions(map ++ Map('amrfile -> value), tail)
      case "-o" :: value :: tail =>
        parseOptions(map ++ Map('outputfile -> value), tail)
      //case "--only" :: tail =>
      //          parseOptions(map ++ Map('only -> true), tail)
      case "-h" :: value :: tail =>
        parseOptions(map ++ Map('help -> value.toInt), tail)
      case "-1" :: tail =>
        parseOptions(map ++ Map('aligner1 -> true), tail)
      case "-v" :: value :: tail =>
        parseOptions(map ++ Map('verbosity -> value.toInt), tail)
      //case string :: opt2 :: tail if isSwitch(opt2) => 
      //          parseOptions(map ++ Map('infile -> string), list.tail)
      //case string :: Nil =>  parseOptions(map ++ Map('infile -> string), list.tail)
      case option :: tail =>
        println("Error: Unknown option " + option)
        sys.exit(1)
    }
  }

  def main(args: Array[String]): Unit = {
    val options = parseOptions(Map(), args.toList)
    if (options.contains('help)) { println(usage); sys.exit(1) }

    if (options.contains('verbosity)) {
      verbosity = options('verbosity).asInstanceOf[Int]
    }

    var aligner2 = true
    if (options.contains('aligner1)) {
      aligner2 = false
    }

    val sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
    val input = Source.fromFile(options('amrfile).toString).getLines()
    val output = new FileWriter(options('outputfile).toString)
    for (block <- Corpus.splitOnNewline(input)) {
      if (block.split("\n").exists(_.startsWith("("))) { // Does it contain some AMR?
        logger(2, "**** Processsing Block *****")
        logger(2, block)
        logger(2, "****************************")
        val extrastr: String = block.split("\n").filter(_.matches("^# ::.*")).mkString("\n")
        val amrstr: String = block.split("\n").filterNot(_.matches("^#.*")).mkString("\n")

        val amr = Graph.parse(amrstr)
        val extras = AMRTrainingData.getUlfString(extrastr)
        // output the English sentence
        write("# ::snt " + extras("::snt") +"\n", output)
        val tokenized = extras("::snt").split(" ")
        val wordAlignments = AlignWords.alignWords(tokenized, amr)
        val parseTree = toSpanGraph(processor.parse(extras("::snt")))
        write(parseTree.toOutputFormat, output)
        val spanAlignments = if (aligner2) {
          AlignSpans3.align(tokenized, amr)
        } else {
          AlignSpans.alignSpans(tokenized, amr, wordAlignments)
        }
        AlignSpans.logUnalignedConcepts(amr.root)

        val spans = amr.spans
        for ((span, i) <- spans zipWithIndex) {
          logger(1, "Span " + (i + 1).toString + ":  " + span.words + " => " + span.amr)
          logger(3, "* " + span.format)
        }
        //               write("# ::alignments "+spans.map(_.format).mkString(" ")+" ::annotator Aligner v.02 ::date "+sdf.format(new Date), output)
        write("# ::AMRGraph", output)
        write(amr.printNodes.map(x => "# ::node\t" + x).mkString("\n"), output)
        write(amr.printRoot, output)
        if (amr.root.relations.size > 0) {
          write(amr.printEdges.map(x => "# ::edge\t" + x).mkString("\n"), output)
        }
//        write(amrstr + "\n", output)
      } else {
//        write(block + "\n", output)
      }
      write("", output)
    }
    if (output != null) output.close()
  }

  def write(output: String, outputFile: FileWriter): Unit = {
    println(output)
    if (outputFile != null) outputFile.write(output + "\n")
  }


case class SpanGraph(nodes: Map[String, String], nodeSpans: Map[String, (Int, Int)], arcs: List[(String, String, String)]) {
  
  def toOutputFormat: String = {
    val nodeOutput = nodes.keys.toList map (x => s"# ::node\t${x}\t${nodes(x)}\t${nodeSpans(x)._1}\t${nodeSpans(x)._2}\n")
    val arcOutput = arcs map (x => s"# ::edge\t${x._1}\t${x._2}\t${x._3}\n")

    "# ::SpanGraph\n" + nodeOutput.mkString + arcOutput.mkString
  }
}

  def toSpanGraph(parseTree: List[ConllToken]): SpanGraph = {
    
    val nodes = (for {
      ConllToken(Some(index), Some(form), lemma, pos, cpos, feats, Some(parentIndex), Some(deprel), phead, pdeprel) <- parseTree
      if deprel != "punct"
    } yield (index.toString -> form)).toMap
    
    val arcs = for {
      ConllToken(Some(index), Some(form), lemma, pos, cpos, feats, Some(parentIndex), deprel, phead, pdeprel) <- parseTree
      if deprel.getOrElse("") != "punct"
    } yield (parentIndex.toString, index.toString, deprel.getOrElse("UNK"))
   
    val nodeSpans = (for {
      (ConllToken(Some(index), Some(form), lemma, pos, cpos, feats, Some(parentIndex), deprel, phead, pdeprel), wordCount) <- 
        (parseTree filter (x => x.deprel.getOrElse("") != "punct") zipWithIndex)
    } yield (index.toString -> (wordCount+1, wordCount+2))).toMap + ("0" -> (0, 1))
    
    SpanGraph(nodes, nodeSpans, arcs)
  }
}

