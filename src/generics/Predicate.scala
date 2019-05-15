package generics

/**
  * ある値について真偽を返す。<br>
  *   Tについての述語は、Tのサブタイプについての述語にもなる。
  * @tparam T テスト対象の型
  */
trait Predicate[-T] {
  def test(element: T): Boolean
}
