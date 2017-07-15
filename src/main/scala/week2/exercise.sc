def factorial (n: Int): Int = {
  // to implement tail recursive factorial
  // the function itself has to take 2 parameter
  def loop(acc: Int, n: Int): Int =
  if(n == 1) acc
  else loop(acc * n, n-1)
  loop(1, n)
}


// perform summation of some functions
// eg, n, n^3, n!
// formally summation of function f(n) from a to b
def sumInts (a: Int , b: Int): Int =
  if(a > b) 0 else a + sumInts(a+1, b)

def cube (n: Int) = n * n * n

def sumCubes (a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a+1, b)

def sumFacs (a: Int, b:Int): Int =
  if( a > b) 0 else factorial(a) + sumFacs(a+1, b)

def sum (f: Int => Int, a: Int, b: Int): Int=
  if(a>b) 0 else f(a) + sum(f, a+1, b)

// example function literals
(x: Int, y: Int) => x + y
(x: Int) => x * x * x

//summation with anonymous functions
def sumIntsLit(a: Int, b: Int) =
  sum(x => x, a, b)

def sumCubesLit(a: Int, b: Int) =
  sum(x => x * x * x, a, b)

//tail recursion version of sum
//unlike factorial, sum can benefit from this tail recursive optimization
//if the interval between a and b is large,
//you might get a lot of different recursive steps,
//so you might risk a stack overflow
def sumTailRec (f: Int => Int, a: Int, b: Int): Int ={
  def loop(a: Int, acc: Int): Int =
    if (a > b) acc else loop(a+1, f(a) + acc)
  loop(a, 0)
}

sumTailRec(x => x * x, 3, 5)


def sumOfSq(a: Int, b: Int) = a * a + b * b
//this is equivalent to (a: Int, b: Int) => a * a + b * b


