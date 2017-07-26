package week4

/**
  * Created by dingqing on 2017-07-25.
  */

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true

  def predecessor: Nat = throw new Error("No predecessor of zero")

  def + (that: Nat): Nat = that

  def - (that: Nat): Nat = {
    if(that.isZero) this
    else throw new Error("No negative elements")
  }

  override def toString: String = "0 | zero"
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false

  def predecessor: Nat = n

  // multiple solutions for plus method

  //def + (that: Nat): Nat = new Succ(this.predecessor + that)
  // notice that n is equivalent to this.predecessor
  //def + (that: Nat): Nat = new Succ(n + that)
  //def + (that: Nat): Nat = this.predecessor + that.successor


  // However, this will not work
  // def + (that: Nat): Nat = new Succ(this + that.predecessor)
  // why?
  // we have object Zero to check (this), but we cannot check argument (that) automatically
  // we have to manually check that.predecessor

  def + (that: Nat): Nat =
    if(that.isZero) this
    else this.successor + that.predecessor

  def - (that: Nat): Nat =
    if (that.isZero) this
    else this.predecessor - that.predecessor

  override def toString: String = {
    def num(that: Nat): Int =
      if(that.isZero) 0
      else 1 + num(that.predecessor)
    val number = num(this)
    s"$number"
  }

}
