package tailrecfunc

import scala.annotation.tailrec
import scala.math.abs

object Part_1 {

  def main(args: Array[String]) {
        zad1a
        zad1b
        zad1c
        zad3
        zad4a //foldl
        zad4b //foldr
        zad4c //foldl z "T"
        zad5
        zad6
        zad7
        print( zad8(List(0,1,2,3,0,4,0)))
        print( zad9(List(1,2,3,4)))
        print( zad10( List(-6,-5,-4,-3,-2,-1,0,1,2,11,12,13,14)) )
  }

  def zad10(lst: List[Float]): List[Float] = {
    val filtered = lst.filter(x =>(x > -5 && x < 12))
    filtered.map(x => abs(x))
  }

  def zad9(lst: List[Int]): List[Int] = {
    lst.map(x => x + 1)
  }

  def zad8(lst: List[Int], acc: List[Int] = List.empty): List[Int] = {
    lst match {
      case Nil => acc
      case 0 :: t => zad8(t, acc)
      case h :: t => zad8(t, h :: acc)
    }
  }

  def zad7 = {

    def findProductPriceByName(products: Map[String, Int], name: String): Option[Int] = {
      products.get(name)
    }

    val product =
      Map("Mysz" -> 5, "Klawiatura" -> 10, "Galaxy" -> 20, "Mac" -> 30)

    println(findProductPriceByName(product, "Mysz"))
    println(findProductPriceByName(product, "Mysz_super_gracza_2x_drozsza_ale_taka_sama")) // to sie marketing nazywa :)
  }

  def zad6 = {
    val k1 = ("abc", 1, 5.5)
    viewKrotka(k1)

  }

  def viewKrotka(krotka: Tuple3[String, Int, Double]) = {
    println(krotka._1)
    println(krotka._2)
    println(krotka._3)
  }

  def zad5: Unit = {
    val product =
      Map("Mysz" -> 5, "Klawiatura" -> 10, "Galaxy" -> 20, "Mac" -> 30)

    val newProduct = product.map { case (k, v) => (k, v * 0.9) }

    println(newProduct)
  }

  def zad4c: Unit = {
    def concatWhile(dayA: String, dayB: String): String = {
      if (dayB.startsWith("T"))
        dayA
      else
        dayA.concat(",").concat(dayB)
    }

    var listDay = createListDayWeek()

    print(listDay.foldLeft("")(concatWhile(_, _)).drop(1))
  }

  def zad4b: Unit = {
    var listDay = createListDayWeek()
    print(listDay.foldRight("")(_.concat(",").concat(_)).dropRight(1))
  }

  def zad4a: Unit = {
    var listDay = createListDayWeek()
    print(listDay.foldLeft("")(_.concat(",").concat(_)).drop(1))
  }

  var returnString: String = ""

  def zad2: Unit = {
    var listDay = createListDayWeek()

    (printList(listDay))
    println(returnString.dropRight(1))
  }

  def zad3: Unit = {

    @tailrec
    def printListTailRec(daysList: List[Any]): Unit = {
      if (!daysList.isEmpty) {
        returnString = returnString.concat((daysList.head + ","))
        printListTailRec(daysList.tail)
      }
    }

    printListTailRec(createListDayWeek())
    println(returnString.dropRight(1))
  }

  def printList(daysList: List[Any]) {
    if (!daysList.isEmpty) {
      returnString = returnString.concat((daysList.head + ","))
      printList(daysList.tail)
    }
  }


  def zad1b: Unit = {
    //        b. Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P” - zmieniłem na T gdyz po ang. nie ma P :)
    var listDay = createListDayWeek()

    var returnString: String = ""

    for (day <- listDay if day.startsWith("T")) {
      returnString = returnString.concat(day + ",")
    }

    println(returnString.dropRight(1))
  }

  def zad1c: Unit = {
    //        c. Pętli while
    var listDay = createListDayWeek()
    var lngth = listDay.length - 1

    var returnString: String = ""

    var i = 0
    while (i <= lngth) {
      returnString = returnString.concat(listDay(i) + ",")
      i += 1
    }

    println(returnString.dropRight(1))
  }

  def zad1a: Unit = {
    var listDay = createListDayWeek()

    var returnString: String = ""

    for (day <- listDay) {
      returnString = returnString.concat(day + ",")
    }

    println(returnString.dropRight(1))
  }

  def createListDayWeek(): List[String] = {
    var dayWeek: List[String] = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "SunDay")


    return dayWeek
  }
}
