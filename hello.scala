package tailrecfunc

import scala.annotation.tailrec

object HelloWord {

  def main(args: Array[String]) {
    //    zad1a
    //    zad1b
    //    zad1c

    zad3
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
