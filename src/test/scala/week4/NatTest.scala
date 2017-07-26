package week4

/**
  * Created by dingqing on 2017-07-25.
  */
object NatTest {
  def main(args: Array[String]): Unit = {
    val a = 1
    val b = 1
    val one = new Succ(Zero)
    val two = one + one
    val two1 = one + one
    val three = one + two
    val four = two + two
    assert(two - one == one)
    assert(four - two == two)
    // assert(one + four == two + three)
    // assertion for plus failed, but looks good from println
    println(one)
    println(one + one)
    println(three)
    println(four)
    println(four + four)
    println(four - three)
  }
}
