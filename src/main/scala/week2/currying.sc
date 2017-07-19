def factorial (n: Int): Int = {
  // to implement tail recursive factorial
  // the function itself has to take 2 parameter
  def loop(acc: Int, n: Int): Int =
  if(n == 1) acc
  else loop(acc * n, n-1)
  loop(1, n)
}

//rewrite sum function (version 1)
def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

//stepwise application
def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFactorials = sum(factorial)

sum(x => x * x * x)(1, 5)
def cube(x: Int) = x * x * x
sum(cube) // this is a valid expression itself
//consecutive stepwise application
sum(cube)(1, 5) // this is equivalent to
//(sum(cube))(1, 5)

def product(f: Int => Int)(a: Int, b: Int): Int =
//  if (a > b) 1 else f(a) * product(f)(a + 1, b)
  mapReduce(f, (x, y) => x * y, 1)(a, b)

def mapReduce(f: Int => Int, combine: (Int, Int)=> Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

product(x => x * x)(3, 4)

def fact(n: Int) =  product(x => x)(1, n)

fact(5)



