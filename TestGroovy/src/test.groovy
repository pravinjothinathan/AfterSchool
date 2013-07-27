import numberpicker.NumberPicker;


class test {

	static main(args) {
		//		def test = [ 1, 3, 2, 7 , 5]
		//		println test[0]
		//		println test
		//		test.add(46);
		//		println test
		//		def size = test.size() - 1
		//		def newtest =  test.clone()
		//		newtest.add(100)
		//		println test.sum()
		//		println newtest.sum()
		profile{

					def test = new NumberPicker()

					//println test.findWinner([1, 3, 7, 2, -4, 3, 2, 9]);
					def val1 =  new FileReader('small2.txt').text.split(/\n/).collect {Integer.parseInt(it)}
					println val1
					//		def start = System.currentTimeMillis();
					println test.findWinner(val1);
					//		def stop = System.currentTimeMillis();
					//		println stop - start

					//		def val2 =  new FileReader('small2.txt').text.split(/\n/).collect {Integer.parseInt(it)}
					//		println test.findWinner(val2);
					//def nums1 = this.class.classLoader.getResourceAsStream('small1.txt').text.split(/\n/).collect {Integer.parseInt(it)}
					//println nums1
					// code to be profiled
				}.prettyPrint()

	}

}
