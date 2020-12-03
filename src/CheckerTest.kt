import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.assertSame

class CheckerTest {
    var c_ = Checker()

    /**
     * @author mori 2020/11/30
     * Check the Carmichael numbers under 100000 are not a prime number.
     */
    fun CheckerTest01(){
        val cnum = listOf(561L, 1105L, 1729L, 2465L, 2821L, 6601L, 8911L, 10585L, 15841L, 29341L, 41041L, 46657L, 52633L, 62745L, 63973L, 75361L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test001 is OK!")
    }


    /**
     *  @author thomas 2020/12/01
     * Check the super-Poulet numbers under 90000 are not a prime number.
     */
    fun CheckerTest02(){
        val cnum = listOf(341L, 1387L, 2047L, 2701L, 3277L, 4033L, 4369L, 4681L, 5461L, 7957L, 8321L, 10261L, 13747L, 14491L, 15709L, 18721L, 19951L, 23377L, 31417L, 31609L, 31621L, 35333L, 42799L, 49141L, 49981L, 60701L, 60787L, 65077L, 65281L, 80581L, 83333L, 85489L, 88357L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test002 is OK!")
    }

    /**
     * @author Johan 2020/12/01
     * Check if the Euler–Jacobi pseudoprimes under than 100000 for bases 10 are not a prime number.
     */
    fun CheckerTest03(){
        val cnum = listOf(9L, 91L, 481L, 1729L, 4187L, 6533L, 6601L, 8149L, 8401L, 10001L, 11111L, 11169L, 11649L, 12801L, 15841L, 19201L, 20961L, 21931L, 24013L, 34441L, 41041L, 50851L, 50881L, 63973L, 69921L, 75361L, 79003L, 83119L, 94139L, 95161L, 97681L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test003 is OK!")
    }

    /**
     * @author Nanai Kouki 2020/12/02
     * 強いリュカ擬素数20個（Strong Lucas pseudoprimes）.
     */
    fun CheckerTest04(){
        val cnum = listOf(5459L, 5777L, 10877L, 16109L, 18971L, 22499L, 24569L, 25199L, 40309L, 58519L, 75077L, 97439L, 100127L, 113573L, 115639L, 130139L, 155819L, 158399L, 161027L, 162133L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test004 is OK!")
    }

    /**
     * @author Taiki Hanada 2020/12/03
     * Check the Frobenius pseudoprimes with respect to Fibonacci polynomial x^2 - x - 1 are not a prime number.
     */
    fun CheckerTest06(){
        val cnum = listOf(4181L, 5777L, 6721L, 10877L, 13201L, 15251L, 34561L, 51841L, 64079L, 64681L, 67861L, 68251L, 75077L, 90061L, 96049L, 97921L, 100127L, 113573L, 118441L, 146611L, 161027L, 162133L, 163081L, 186961L, 197209L, 219781L, 231703L, 252601L, 254321L, 257761L, 268801L, 272611L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test006 is OK!")
    }

    /**
     * @author Riku Iikura 2020/12/03
     * Check the Fermat pseudoprimes to base 2, also called Sarrus numbers or Poulet numbers.
     */
    fun CheckerTest07(){
        val cnum = listOf(341L, 561L, 645L, 1105L, 1387L, 1729L, 1905L, 2047L, 2465L, 2701L, 2821L, 3277L, 4033L, 4369L, 4371L, 4681L, 5461L, 6601L, 7957L, 8321L, 8481L, 8911L, 10261L, 10585L, 11305L, 12801L, 13741L, 13747L, 13981L, 14491L, 15709L, 15841L, 16705L, 18705L, 18721L, 19951L, 23001L, 23377L, 25761L, 29341L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test007 is OK!")
    }

    fun binPowTest01(){
        assertEquals(c_.binPow(2.toBigInteger(),9.toBigInteger(),1000.toBigInteger()),512.toBigInteger())
        assertEquals(c_.binPow(6.toBigInteger(),5.toBigInteger(),31.toBigInteger()),26.toBigInteger())
        assertEquals(c_.binPow(111111111.toBigInteger(),11111111111.toBigInteger(),1000000007.toBigInteger()),249517433.toBigInteger())
        println("Test005 is OK!")
    }
}

fun main(args: Array<String>){
    var ctest = CheckerTest()
    ctest.CheckerTest01()
    ctest.CheckerTest02()
    ctest.CheckerTest03()
    ctest.CheckerTest04()
    ctest.CheckerTest06()
    ctest.CheckerTest07()
    ctest.binPowTest01()
}
