package generics

trait Predicate[-T] {
  def test(element: T): Boolean
}
