class MTRandomTest {
    var mt_rnd = MTRandom()

    /**
     * Chi-squared Test
     * If chi-squared is less than chi-squared(alpha), random numbers follow a uniform distribution.
     *
     * e.g.
     * chi-squared(alpha) = 16.919, when alpha = 0.05 and degree of freedom = 9
     */
    fun MTRandomTest01() {
        val N = 10000
        val M = 10
        val f = Array<Int>(10){0}
        var chi2 = 0.0

        for (i in 1..N) {
            val rndValue: Int = mt_rnd.nextInt(M)
            f[rndValue] += 1
        }

        val f0: Double = N / M.toDouble()
        for (i in 0..M-1) {
            chi2 += (f[i].toDouble() - f0) * (f[i].toDouble() - f0) / f0
        }
        println("chi-squared: $chi2")
    }
}

fun main(){
    var mttest = MTRandomTest()
    mttest.MTRandomTest01()
}