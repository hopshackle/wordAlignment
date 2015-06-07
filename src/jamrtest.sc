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
                                                  //| hPCFG.ser.gz ... done [1.3 sec].
                                                  //| processor  : edu.cmu.lti.nlp.amr.StanfordProcessor = edu.cmu.lti.nlp.amr.Sta
                                                  //| nfordProcessor@1a3869f4

val output = processor.parse("The police want to arrest Michael Karras in Singapore.").head
                                                  //> output  : List[edu.cmu.lti.nlp.amr.ConllToken] = List(1	The	_	
                                                  //| DT	DT	_	2	det	_	_, 2	police	_	NN	
                                                  //| NN	_	3	nsubj	_	_, 3	want	_	VBP	VBP	
                                                  //| _	0	root	_	_, 4	to	_	TO	TO	_	
                                                  //| 5	aux	_	_, 5	arrest	_	VB	VB	_	3	
                                                  //| xcomp	_	_, 6	Michael	_	NNP	NNP	_	7	
                                                  //| nn	_	_, 7	Karras	_	NNP	NNP	_	5	dobj	
                                                  //| _	_, 8	in	_	IN	IN	_	7	prep	_	
                                                  //| _, 9	Singapore	_	NNP	NNP	_	8	pobj	
                                                  //| _	_, 10	.	_	.	.	_	3	punct	_	
                                                  //| _)
output foreach println                            //> 1	The	_	DT	DT	_	2	det	_	_
                                                  //| 2	police	_	NN	NN	_	3	nsubj	_	_
                                                  //| 3	want	_	VBP	VBP	_	0	root	_	_
                                                  //| 4	to	_	TO	TO	_	5	aux	_	_
                                                  //| 5	arrest	_	VB	VB	_	3	xcomp	_	_
                                                  //| 6	Michael	_	NNP	NNP	_	7	nn	_	_
                                                  //| 7	Karras	_	NNP	NNP	_	5	dobj	_	_
                                                  //| 8	in	_	IN	IN	_	7	prep	_	_
                                                  //| 9	Singapore	_	NNP	NNP	_	8	pobj	_	
                                                  //| _
                                                  //| 10	.	_	.	.	_	3	punct	_	_


RunStanfordParser.main(args)                      //> Adding annotator tokenize
                                                  //| Adding annotator ssplit
                                                  //| Adding annotator parse
                                                  //| Starting
                                                  //| Starting
                                                  //| 1	A	_	DT	DT	_	2	det	_	_
                                                  //| 2	staff	_	NN	NN	_	7	nsubj	_	_
                                                  //| 3	of	_	IN	IN	_	2	prep	_	_
                                                  //| 4	30	_	CD	CD	_	5	num	_	_
                                                  //| 5	specialists	_	NNS	NNS	_	3	pobj	_	
                                                  //| _
                                                  //| 6	will	_	MD	MD	_	7	aux	_	_
                                                  //| 7	conduct	_	VB	VB	_	0	root	_	_
                                                  //| 8	research	_	NN	NN	_	7	dobj	_	
                                                  //| _
                                                  //| 9	and	_	CC	CC	_	8	cc	_	_
                                                  //| 10	training	_	NN	NN	_	8	conj	_	
                                                  //| _
                                                  //| 11	on	_	IN	IN	_	7	prep	_	_
                                                  //| 12	cyber	_	NN	NN	_	13	nn	_	_
                                                  //| 13	warfare	_	NN	NN	_	11	pobj	_	_
                                                  //| 14	.	_	.	.	_	7	punct	_	_
                                                  //| 
                                                  //| Starting
                                                  //| 1	The	_	DT	DT	_	2	det	_	_
                                                  //| 2	police	_	NN	NN	_	3	nsubj	_	_
                                                  //| 3	want	_	VBP	VBP	_	0	root	_	_
                                                  //| 4	to	_	TO	TO	_	5	aux	_	_
                                                  //| 5	arrest	_	VB	VB	_	3	xcomp	_	_
                                                  //| 6	Michael	_	NNP	NNP	_	7	nn	_	_
                                                  //| 7	Karras	_	NNP	NNP	_	5	dobj	_	_
                                                  //| 8	in	_	IN	IN	_	7	prep	_	_
                                                  //| 9	Singapore	_	NNP	NNP	_	8	pobj	_	
                                                  //| _
                                                  //| 10	.	_	.	.	_	3	punct	_	_
                                                  //| 

}