import gridsearch.GridSearch;


class testGridSearch {

	static main(args) {
		int[][] decaSet = readFile('input10.txt')
		int[][] hectoSet = readFile('input100.txt')
		//static final int[][] kiloSet = readFile('input1000.txt')
		//println decaSet
		def search = new GridSearch()
//		search.findInGrid(decaSet, 83)
//		search.findInGrid(decaSet, 79)
//		search.findInGrid(decaSet, 79)
//		search.findInGrid(decaSet, 67)
		search.findInGrid(decaSet, 72)
		search.findInGrid(decaSet, 0)
		search.findInGrid(decaSet, 170)

//		def search1 = new GridSearch()
//		println hectoSet.length
//		search1.findInGrid(hectoSet, 70)
//		search1.findInGrid(hectoSet, 5066)
//		search1.findInGrid(hectoSet, 5191)
//		search1.findInGrid(hectoSet, 5750)
//	
	}
	
	static int[][] readFile(String fileName) {
		def text = new FileReader(fileName).text
		def lines = text.split('\n')
		lines[1..-1].collect {it.split(' ').collect {Integer.parseInt(it)}}
	  }

}
