1+5
def abs(x: Double): Double = if (x < 0) -x else x
abs (-3)

//we want to perform sqrt(x) with guess
def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  // here we want to use
  // relative error rather than absolute error
  // otherwise for small and large number, it gives
  // inaccurate result
  def isGoodEnough(guess: Double) = {
    abs(guess * guess - x) / x < 0.001
  }

  def improve(guess: Double) =
    (guess + x / guess) / 2

  sqrtIter(1)

}


def gcd (a: Int, b: Int): Int = {
  if(b == 0) a else gcd(b, a % b)
}

//gcd (14, 21)


def factorial (n: Int): Int =
  if (n == 1) 1 else n * factorial(n - 1)

def facTailRec (n: Int): Int = {
  // to implement tail recursive factorial
  // the function itself has to take 2 parameter
  def loop(acc: Int, n: Int): Int =
    if(n == 1) acc
    else loop(acc * n, n-1)
  loop(1, n)
}

facTailRec(5)

facTailRec(10)


factorial(4)

factorial(10)

factorial(3)


sqrt(2)

sqrt(1e-6)

sqrt(1e60)






