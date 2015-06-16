object jamrtest {


import edu.cmu.lti.nlp.amr._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(136); 

val args = Array[String]("-1", "C:\\AMR\\testAMR.txt", ">", "C:\\AMR\\alignments.txt");System.out.println("""args  : Array[String] = """ + $show(args ));$skip(31); 
val help = Array[String]("-h");System.out.println("""help  : Array[String] = """ + $show(help ));$skip(120); 
//Aligner.parseOptions(scala.collection.mutable.Map[Symbol, Any](), args.toList)

val processor = new StanfordProcessor;System.out.println("""processor  : edu.cmu.lti.nlp.amr.StanfordProcessor = """ + $show(processor ));$skip(68); 

val output = processor.parse("Estonia, (EE); Lithuania (LT)").head;System.out.println("""output  : List[edu.cmu.lti.nlp.amr.ConllToken] = """ + $show(output ));$skip(23); 
output foreach println}


}
