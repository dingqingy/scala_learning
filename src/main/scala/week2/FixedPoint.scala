package week2
import scala.math.abs

/**
  * Created by dingqing on 2017-07-20.
  * calculate the fixed point of a specific function
  */

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

  def averageDamp(f: Double => Double)(x: Double):Double = (x + f(x))/2

  def sqr(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1.0)

}