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
                                                  //| hPCFG.ser.gz ... done [1.0 sec].
                                                  //| Adding annotator lemma
                                                  //| Adding annotator ner
                                                  //| Loading classifier from edu/stanford/nlp/models/ner/english.all.3class.dists
                                                  //| im.crf.ser.gz ... done [4.2 sec].
                                                  //| Loading classifier from edu/stanford/nlp/models/ner/english.muc.7class.dists
                                                  //| im.crf.ser.gz ... done [2.1 sec].
                                                  //| Loading classifier from edu/stanford/nlp/models/ner/english.conll.4class.dis
                                                  //| tsim.crf.ser.gz ... done [3.8 sec].
                                                  //| Reading TokensRegex rules from edu/stanford/nlp/models/sutime/defs.sutime.tx
                                                  //| t
                                                  //| Reading TokensRegex rules from edu/stanford/nlp/models/sutime/english.sutime
                                                  //| .txt
                                                  //| Jun 15, 2015 4:09:47 PM edu.stanford.nlp.ling.tokensregex.CoreMapExpressionE
                                                  //| xtractor appendRules
                                                  //| INFO: Ignoring inactive rule: null
                                                  //| Jun 15, 2015 4:09:47 PM edu.stanford.nlp.ling.tokensregex.CoreMapExpressionE
                                                  //| xtractor appendRules
                                                  //| INFO: Ignoring inactive rule: temporal-composite-8:ranges
                                                  //| Reading TokensRegex rules from edu/stanford/nlp/models/sutime/english.holida
                                                  //| ys.sutime.txt
                                                  //| Initializing JollyDayHoliday for sutime with classpath:edu/stanford/nlp/mode
                                                  //| ls/sutime/jollyday/Holidays_sutime.xml
                                                  //| Reading TokensRegex rules from edu/stanford/nlp/models/sutime/defs.sutime.tx
                                                  //| t
                                                  //| Reading TokensRegex rules from edu/stanford/nlp/models/sutime/english.sutime
                                                  //| .txt
                                                  //| Jun 15, 2015 4:09:48 PM edu.stanford.nlp.ling.tokensregex.CoreMapExpressionE
                                                  //| xtractor appendRules
                                                  //| INFO: Ignoring inactive rule: null
                                                  //| Jun 15, 2015 4:09:48 PM edu.stanford.nlp.ling.tokensregex.CoreMapExpressionE
                                                  //| xtractor appendRules
                                                  //| INFO: Ignoring inactive rule: temporal-composite-8:ranges
                                                  //| Reading TokensRegex rules from edu/stanford/nlp/models/sutime/english.holida
                                                  //| ys.sutime.txt
                                                  //| processor  : edu.cmu.lti.nlp.amr.StanfordProcessor = edu
                                                  //| Output exceeds cutoff limit.

val output = processor.parse("2 of the men were held for more than 3 months before being released at the start of the summer of 2008.").head
                                                  //> output  : List[edu.cmu.lti.nlp.amr.ConllToken] = List(1	2	_	
                                                  //| CD	CD	2	6	nsubjpass	_	NUMBER, 2	of	
                                                  //| _	IN	IN	of	1	prep	_	O, 3	the	_	
                                                  //| DT	DT	the	4	det	_	O, 4	men	_	NNS	
                                                  //| NNS	man	2	pobj	_	O, 5	were	_	VBD	VBD	
                                                  //| be	6	auxpass	_	O, 6	held	_	VBN	VBN	hold	
                                                  //| 0	root	_	O, 7	for	_	IN	IN	for	6	
                                                  //| prep	_	O, 8	more	_	JJR	JJR	more	9	
                                                  //| mwe	_	DURATION, 9	than	_	IN	IN	than	10	
                                                  //| quantmod	_	DURATION, 10	3	_	CD	CD	3	
                                                  //| 11	num	_	DURATION, 11	months	_	NNS	NNS	month	
                                                  //| 7	pobj	_	DURATION, 12	before	_	IN	IN	before	
                                                  //| 6	prep	_	O, 13	being	_	VBG	VBG	be	14	
                                                  //| auxpass	_	O, 14	released	_	VBN	VBN	release	
                                                  //| 12	pcomp	_	O, 15	at	_	IN	IN	at	14	
                                                  //| prep	_	O, 16	the	_	DT	DT	the	17	
                                                  //| det	_	DATE, 17	start	_	NN	NN	start	15	
                                                  //| pobj	_	DATE, 18	of	_	IN	IN	of	
                                                  //| 17	prep	_	DATE, 19	the	_	DT	DT	the	
                                                  //| 20	det	_	DATE, 20	summer	_	NN	NN	summer	
                                                  //| 18	pobj	_	DATE, 21	of	_	IN	IN	of	
                                                  //| 20	prep	_	DATE, 22	2008	_	CD	CD	2008	
                                                  //| 21	pobj	_	DATE, 23	.	_	.	.	.	
                                                  //| 6	punct	_	O)
output foreach println                            //> 1	2	_	CD	CD	2	6	nsubjpass	_	
                                                  //| NUMBER
                                                  //| 2	of	_	IN	IN	of	1	prep	_	O
                                                  //| 3	the	_	DT	DT	the	4	det	_	O
                                                  //| 4	men	_	NNS	NNS	man	2	pobj	_	O
                                                  //| 5	were	_	VBD	VBD	be	6	auxpass	_	O
                                                  //| 6	held	_	VBN	VBN	hold	0	root	_	O
                                                  //| 7	for	_	IN	IN	for	6	prep	_	O
                                                  //| 8	more	_	JJR	JJR	more	9	mwe	_	DURATION
                                                  //| 
                                                  //| 9	than	_	IN	IN	than	10	quantmod	_	
                                                  //| DURATION
                                                  //| 10	3	_	CD	CD	3	11	num	_	DURATION
                                                  //| 
                                                  //| 11	months	_	NNS	NNS	month	7	pobj	_	DURATION
                                                  //| 
                                                  //| 12	before	_	IN	IN	before	6	prep	_	O
                                                  //| 13	being	_	VBG	VBG	be	14	auxpass	_	O
                                                  //| 14	released	_	VBN	VBN	release	12	pcomp	_	
                                                  //| O
                                                  //| 15	at	_	IN	IN	at	14	prep	_	O
                                                  //| 16	the	_	DT	DT	the	17	det	_	DATE
                                                  //| 17	start	_	NN	NN	start	15	pobj	_	DATE
                                                  //| 18	of	_	IN	IN	of	17	prep	_	DATE
                                                  //| 19	the	_	DT	DT	the	20	det	_	DATE
                                                  //| 20	summer	_	NN	NN	summer	18	pobj	_	DATE
                                                  //| 21	of	_	IN	IN	of	20	prep	_	DATE
                                                  //| 22	2008	_	CD	CD	2008	21	pobj	_	DATE
                                                  //| 23	.	_	.	.	.	6	punct	_	O


}