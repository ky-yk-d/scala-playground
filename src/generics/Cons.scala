package generics

case class Cons[+A](h: A, t: SimpleList[A]) extends SimpleList[A] {
  override def head: A = h

  override def tail: SimpleList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): SimpleList[B] = Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def map[B](transformer: Transformer[A, B]): SimpleList[B] =
    Cons(transformer.transform(h), t.map(transformer))

  override def filter(predicate: Predicate[A]): SimpleList[A] =
    if (predicate.test(h)) Cons[A](h, t.filter(predicate))
    else t.filter(predicate)

  override def flatMap[B](transformer: Transformer[A, SimpleList[B]]): SimpleList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  override def ++[B >: A](list: SimpleList[B]): SimpleList[B] = Cons(h, tail++list)
}
