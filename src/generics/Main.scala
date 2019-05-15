package generics

object Main extends App {

  class Animal(val age: Int, val name: String){
    def typeName: String = "動物"
    override def toString: String = s"($typeName、名前は$name、年齢は${age}歳。)"
  }
  class Cat(age: Int, name: String) extends Animal(age, name) {
    override def typeName: String = "猫"
  }
  class Dog(age: Int, name: String) extends Animal(age, name){
    override def typeName: String = "犬"
  }

  // a Cat IS-A(n) Animal
  val animal: Animal = new Cat(12, "Tama") // 猫は動物の一種

  // 共変：COVARIANT
  class CovariantList[+A]
  // a list of Cat IS-A list of Animal
  val animalList: CovariantList[Animal] = new CovariantList[Cat] // 猫の一覧は動物の一覧でもある
  // a list of Animal IS-NOT-A list of Cat (コンパイルエラー)
//  val catList: CovariantList[Cat] = new CovariantList[Animal] // 動物の一覧は猫の一覧ではない

  // 反変：CONTRAVARIANT
  class Trainer[-A]
  // a Trainer of Animal IS-A Trainer of Cat
  val catTrainer: Trainer[Cat] = new Trainer[Animal] // 動物訓練士は猫訓練士でもある（猫も訓練できる）
  // a Trainer of Cat IS-NOT-A Trainer of Animal (コンパイルエラー)
//  val animalTrainer: Trainer[Animal] = new Trainer[Cat] // 猫訓練士は動物訓練士ではない（動物一般を訓練できない）
  println("---自作リストの動作確認---")
  val integers = Cons(1, Cons(2, Cons(3, Empty)))
  println("1番目の要素: " + integers.head)
  println("2番目の要素: " + integers.tail.head)
  println("3番目の要素: " + integers.tail.tail.head)
  println("4番目以降のリスト: " + integers.tail.tail.tail)
  println("4番目以降のリストが空: " + integers.tail.tail.tail.isEmpty)
  println("add操作後: " + integers.add(4))
  val strings = Cons("A", Cons("B", Cons("C", Empty)))
  println("文字列のリスト: " + strings)

  println("操作前: " + integers)
  println("map操作後: " + integers.map((element: Int) => "Number: " + (element * 2)))
  println("filter操作後: " + integers.filter((element: Int) => element % 2 == 1))
  println("flatMap操作後: " + integers.flatMap[String](
    (element: Int) => Cons(String.valueOf(element), Cons(String.valueOf(element + 100), Empty))
  ))

  println("---動物リストの動作確認---")
  val tama: Cat = new Cat(10, "タマ")
  val hachi: Dog = new Dog(4, "ハチ公")
  val sebastian: Animal = new Animal(20, "セバスチャン")
  println(tama)
  val listOfAnimal: SimpleList[Animal] = Cons(sebastian, Empty)
  val with3Animals: SimpleList[Animal] = listOfAnimal.add(tama).add(hachi)
  println(with3Animals)
  val olderThan9: Predicate[Animal] = new Predicate[Animal] {
    override def test(element: Animal): Boolean = element.age > 9
  }
  println(with3Animals.filter(olderThan9))
  val youngerThan10: Predicate[Cat] = new Predicate[Cat] {
    override def test(element: Cat): Boolean = element.age < 10
  }
  val listOfCat: SimpleList[Cat] =
    Cons(tama, Cons(new Cat(5, "そら"), Empty))
  println(listOfCat)
  println(listOfCat.filter(youngerThan10))
  println(listOfCat.filter(olderThan9))


}
