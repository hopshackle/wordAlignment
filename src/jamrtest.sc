object jamrtest {


import edu.cmu.lti.nlp.amr._

val args = Array[String]("-1", "C:\\AMR\\testAMR.txt", ">", "C:\\AMR\\alignments.txt")
                                                  //> args  : Array[String] = Array(-1, C:\AMR\testAMR.txt, >, C:\AMR\alignments.t
                                                  //| xt)
val help = Array[String]("-h")                    //> help  : Array[String] = Array(-h)
//Aligner.parseOptions(scala.collection.mutable.Map[Symbol, Any](), args.toList)

val processor = new StanfordProcessor             //> Adding annotator tokenize
                                                  //| Adding annotator ssplit
                                                  //| Adding annotator parse
                                                  //| Loading parser from serialized file edu/stanford/nlp/models/lexparser/englis
                                                  //| hPCFG.ser.gz ... done [1.2 sec].
                                                  //| processor  : edu.cmu.lti.nlp.amr.StanfordProcessor = edu.cmu.lti.nlp.amr.Sta
                                                  //| nfordProcessor@77ec78b9

val output = processor.parse("NATO CONSIDERS cyber attacks a threat to military and civilian computer networks after the Estonian Government was struck by cyber attacks in 2007.").head
                                                  //> output  : List[edu.cmu.lti.nlp.amr.ConllToken] = List(1	NATO	_	
                                                  //| NNP	NNP	_	3	nn	_	_, 2	CONSIDERS	_	
                                                  //| NNP	NNP	_	3	nn	_	_, 3	cyber	_	NN	
                                                  //| NN	_	4	nsubj	_	_, 4	attacks	_	VBZ	VBZ	
                                                  //| _	0	root	_	_, 5	a	_	DT	DT	_	
                                                  //| 6	det	_	_, 6	threat	_	NN	NN	_	4	
                                                  //| dobj	_	_, 7	to	_	TO	TO	_	4	
                                                  //| prep	_	_, 8	military	_	JJ	JJ	_	
                                                  //| 12	amod	_	_, 9	and	_	CC	CC	_	8	
                                                  //| cc	_	_, 10	civilian	_	JJ	JJ	_	8	
                                                  //| conj	_	_, 11	computer	_	NN	NN	_	
                                                  //| 12	nn	_	_, 12	networks	_	NNS	NNS	_	
                                                  //| 7	pobj	_	_, 13	after	_	IN	IN	_	18	
                                                  //| mark	_	_, 14	the	_	DT	DT	_	16	
                                                  //| det	_	_, 15	Estonian	_	JJ	JJ	_	16	
                                                  //| amod	_	_, 16	Government	_	NN	NN	_	
                                                  //| 18	nsubjpass	_	_, 17	was	_	VBD	VBD	_	
                                                  //| 18	auxpass	_	_, 18	struck	_	VBN	VBN	_	4	
                                                  //| advcl	_	_, 19	by	_	IN	IN	_	18	
                                                  //| prep	_	_, 20	cyber	_	NN	NN	_	21	
                                                  //| nn	_	_, 21	attacks	_	NNS	NNS	_	19	pobj	
                                                  //| _	_, 22	in	_	IN	IN	_	21	prep	_	
                                                  //| _, 23	2007	_	CD	CD	_	22	pobj	_	
                                                  //| _, 24	.	_	.	.	_	4	punct	_	
                                                  //| _)
output foreach println                            //> 1	NATO	_	NNP	NNP	_	3	nn	_	_
                                                  //| 2	CONSIDERS	_	NNP	NNP	_	3	nn	_	
                                                  //| _
                                                  //| 3	cyber	_	NN	NN	_	4	nsubj	_	_
                                                  //| 4	attacks	_	VBZ	VBZ	_	0	root	_	_
                                                  //| 5	a	_	DT	DT	_	6	det	_	_
                                                  //| 6	threat	_	NN	NN	_	4	dobj	_	_
                                                  //| 7	to	_	TO	TO	_	4	prep	_	_
                                                  //| 8	military	_	JJ	JJ	_	12	amod	_	
                                                  //| _
                                                  //| 9	and	_	CC	CC	_	8	cc	_	_
                                                  //| 10	civilian	_	JJ	JJ	_	8	conj	_	
                                                  //| _
                                                  //| 11	computer	_	NN	NN	_	12	nn	_	
                                                  //| _
                                                  //| 12	networks	_	NNS	NNS	_	7	pobj	_	
                                                  //| _
                                                  //| 13	after	_	IN	IN	_	18	mark	_	_
                                                  //| 14	the	_	DT	DT	_	16	det	_	_
                                                  //| 15	Estonian	_	JJ	JJ	_	16	amod	_	
                                                  //| _
                                                  //| 16	Government	_	NN	NN	_	18	nsubjpass	
                                                  //| _	_
                                                  //| 17	was	_	VBD	VBD	_	18	auxpass	_	_
                                                  //| 18	struck	_	VBN	VBN	_	4	advcl	_	_
                                                  //| 19	by	_	IN	IN	_	18	prep	_	_
                                                  //| 20	cyber	_	NN	NN	_	21	nn	_	_
                                                  //| 21	attacks	_	NNS	NNS	_	19	pobj	_	_
                                                  //| 22	in	_	IN	IN	_	21	prep	_	_
                                                  //| 23	2007	_	CD	CD	_	22	pobj	_	_
                                                  //| 24	.	_	.	.	_	4	punct	_	_


}