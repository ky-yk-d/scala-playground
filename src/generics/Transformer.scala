package generics

/**
  * ある値を別の値に変換する。<br>
  *   AのTransformerはAのサブタイプのTransformerにもなる。
  * @tparam A 変換元の型
  * @tparam B 変換先の型
  */
trait Transformer[-A, B] {
  def transform(element: A): B
}
