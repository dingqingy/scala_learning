class Rational(x: Int, y: Int){
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  val g: Int = gcd(x, y)
  def numer: Int = x/g
  def denom: Int = y/g

  def add(that: Rational): Rational =
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom
    )

  override def toString: String = numer + "/" + denom

  def neg: Rational = new Rational(-this.numer, this.denom)

  def sub(that: Rational): Rational = add(that.neg)

}

val a = new Rational(1, 2)
val b = new Rational(3, 4)

a.add(b)

b.sub(a)




