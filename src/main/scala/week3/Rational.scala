package week3

/**
  * Created by dingqing on 2017-07-17.
  */
class Rational(x: Int, y: Int){
  require(y != 0, "denominator must be non zero")
  def this(x: Int) = this(x, 1)
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  val g: Int = gcd(x, y)

  val numer: Int = x/g
  val denom: Int = y/g

  def + (that: Rational): Rational =
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom
    )

  override def toString: String = numer + "/" + denom

  //def neg: Rational = new Rational(-this.numer, this.denom)

  def unary_- : Rational = new Rational(-this.numer, this.denom)
  // note the space between - and :

  //def sub (that: Rational): Rational = add(that.neg)

  def - (that: Rational): Rational = this + -that

  def < (that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational): Rational =
    if (this < that) that else this

}
