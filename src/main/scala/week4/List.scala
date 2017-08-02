package week4

/**
  * Created by dingqing on 2017-07-23.
  */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
  //field def of head and tail is already a valid implementation of methods in traits
  def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  //Nothing is a subtype of any other type
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  //List(1, 2) is expanded List.apply(1,2)
  def apply = new Nil
  def apply[T] (elem1: T): List[T] = new Cons(elem1, new Nil[T])
  def apply[T] (elem1: T, elem2: T): List[T] = new Cons(elem1, new Cons(elem2, new Nil[T]))
}
