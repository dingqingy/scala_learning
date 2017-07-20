/*

import scala.math.abs

object FixedPoint {
  val tolerance = 0.0001
  //the results oscillate within a small range
  def isGoodEnough(xPrev: Double, xNew: Double): Boolean =
    abs((xPrev - xNew) / xPrev) < tolerance
  // f passed to fixedPoint method is similar to improve method in week1
  def fixedPoint(f: Double => Double)(firstGuess: Double):Double = {
    def iterate(guess: Double): Double = {
      //println("guess" + guess)
      val next = f(guess)
      if(isGoodEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double):Double = (x + f(x)) /2

  def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1.0)

}
*/

//sqrt(2.0)



import week2._

FixedPoint.fixedPoint(x => 1 + x / 2)(1.0)

FixedPoint.sqr(2.0)

def iter: Double => Double = {
  FixedPoint.fixedPoint(x => x / 2 +5)
}

iter(1.0)








