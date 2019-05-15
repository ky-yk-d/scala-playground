package generics

trait Transformer[-A, B] {
  def transform(element: A): B
}
