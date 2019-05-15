package generics

abstract class SimpleList[+A] {
  def head: A
  def tail: SimpleList[A]
  def isEmpty: Boolean
  def add[B >: A](element :B): SimpleList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: Transformer[A, B]): SimpleList[B]
  def filter(predicate: Predicate[A]): SimpleList[A]
  def flatMap[B](transformer: Transformer[A, SimpleList[B]]): SimpleList[B]
  def ++[B >: A](list: SimpleList[B]): SimpleList[B]
}
