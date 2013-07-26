void createFile(int size = 10) {
  File testResources = new File('../../../test/resources').absoluteFile.canonicalFile
  def file = new File(testResources, "input${size}.txt".toString())
  def a = new int[size][size]

  for (int i = 0; i < size; i ++) {
    for (int j = 0; j < size; j ++) {
      def rand = new Random().nextInt(size) + 1
      a[i][j] = i == 0 ? (j == 0 ? rand : a[i][j-1] + rand) : (
        j == 0 ? a[i-1][j] + rand : Math.max(a[i-1][j], a[i][j-1]) + rand
      )
    }
  }

  file << size << '\n'
  a.each {
    file << it.toList().join(' ') << '\n'
  }
//  file << size
//  file << a*.join(' ').join('\n')
}
//createFile(10)
//createFile(100)
createFile(1000)
