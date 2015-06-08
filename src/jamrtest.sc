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
                                                  //| nfordProcessor@77ec78b9

val output = processor.parse("Estonia, (EE); Lithuania (LT)").head
                                                  //> output  : List[edu.cmu.lti.nlp.amr.ConllToken] = List(1	Estonia	_	
                                                  //| NNP	NNP	_	0	root	_	_, 2	,	_	,	
                                                  //| ,	_	1	punct	_	_, 3	(	_	-LRB-	-LRB-	
                                                  //| _	4	punct	_	_, 4	EE	_	NNP	NNP	_	
                                                  //| 1	appos	_	_, 5	)	_	-RRB-	-RRB-	_	4	
                                                  //| punct	_	_, 6	;	_	:	:	_	1	
                                                  //| punct	_	_, 7	Lithuania	_	NNP	NNP	_	
                                                  //| 1	dep	_	_, 8	(	_	-LRB-	-LRB-	_	9	
                                                  //| punct	_	_, 9	LT	_	NNP	NNP	_	7	
                                                  //| appos	_	_, 10	)	_	-RRB-	-RRB-	_	9	
                                                  //| punct	_	_)
output foreach println                            //> 1	Estonia	_	NNP	NNP	_	0	root	_	_
                                                  //| 2	,	_	,	,	_	1	punct	_	_
                                                  //| 3	(	_	-LRB-	-LRB-	_	4	punct	_	_
                                                  //| 4	EE	_	NNP	NNP	_	1	appos	_	_
                                                  //| 5	)	_	-RRB-	-RRB-	_	4	punct	_	_
                                                  //| 6	;	_	:	:	_	1	punct	_	_
                                                  //| 7	Lithuania	_	NNP	NNP	_	1	dep	_	
                                                  //| _
                                                  //| 8	(	_	-LRB-	-LRB-	_	9	punct	_	_
                                                  //| 9	LT	_	NNP	NNP	_	7	appos	_	_
                                                  //| 10	)	_	-RRB-	-RRB-	_	9	punct	_	_


}