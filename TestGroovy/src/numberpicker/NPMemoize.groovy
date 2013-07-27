package numberpicker

import groovyx.gpars.GParsPool

/**
* Demonstrates closure result caching through the gmemoize mechanism
* Without caching the raw algorithm would end-up taking very long to finish given the inherent
* exponential time complexity of it.
* Thanks to caching introduced through gmemoize(), each Fibonacci number has to be calculated only once
* and so we turned the exponential complexity algorithm into a sequential one. With a single extra method call.
*/

GParsPool.withPool {
    Closure valueOfListClosure
    valueOfListClosure = { List<Integer> input ->
	  return this.valueOfListImpl(input)
	}.gmemoizeAtMost(20000) //try to remove the gmemoize() method call to get the original slow exponential complexity behavior
    
	
}
