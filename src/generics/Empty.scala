package generics

/**
  * 空のリストを表現するオブジェクト
  */
case object Empty extends SimpleList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: SimpleList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): SimpleList[B] = Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Transformer[Nothing, B]): SimpleList[B] = Empty

  override def filter(predicate: Predicate[Nothing]): SimpleList[Nothing] = Empty

  override def flatMap[B](transformer: Transformer[Nothing, SimpleList[B]]): SimpleList[B] = Empty

  override def ++[B >: Nothing](list: SimpleList[B]): SimpleList[B] = list
}
