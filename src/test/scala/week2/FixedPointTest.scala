/**
  * Created by dingqing on 2017-07-20.
  */

import week2.FixedPoint

object FixedPointTest {
  def main(args: Array[String]): Unit = {
    val a: Double = FixedPoint.fixedPoint(x => 1 + x / 2)(1.0)

    val b: Double = FixedPoint.sqr(2.0)

    def avg: Double => Double = {
      FixedPoint.averageDamp(x => 6 / x)
    }

    val c: Double = avg(2.0)

    println(a)
    println(b)
    println(c)
  }

}



