import scala.annotation.tailrec

object SumOfNPrimes extends App {
  def sumOfFirstNPrimes(n: Int): Int = {
    @tailrec
    def primeHelper(i: Int, sum: Int, counter: Int): Int =
      if (counter <= 0) sum
      else if (isPrime(i)) primeHelper(i + 1, sum + i, counter - 1)
      else primeHelper(i + 1, sum, counter)

    primeHelper(2, 0, n)
    
    // - Old implementation with side effects
    //
    //var i = 2
    //var sum = 0
    //var count = n
    //while (count > 0) {
    //  if (isPrime(i)) {
    //    sum += i
    //    count -= 1
    //  }
    //  i += 1
    //}
    //sum
  }
  
  
  def isPrime(number: Int): Boolean = {
    for (i <- 2 to (Math.sqrt(number).toInt)) {
      if (number % i == 0)
        return false
    }
    true
  }

  println(sumOfFirstNPrimes(40))
  //40 - 3080

 }
