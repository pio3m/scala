
object Part_1 {

  def main(args: Array[String]): Unit = {

    //cw1
    println(zad1("Thursday"))
    println(zad1("SunDay"))
    println(zad1("Nie ma takiego dnia"))

    //cw2
    var kB = new KontoBankowe(10.0)
    var kB2 = new KontoBankowe()
    println(kB.stan)
    println(kB2.stan)

    //cw3
    var person1 = new Person("Piotr", "Abacki")
    var person2 = new Person("Jan", "Babacki")
    var person3 = new Person("Tom", "Cabacki")

    println(helloPerson(person1))
    println(helloPerson(person2))
    println(helloPerson(person3))

    //cw4
    def example1(n: Int) = n * n

    println(functionAsParam(example1, 2))

    //cw5
    var osoba1 = new Osoba("Piotr", "Abacki") with Student
    println(osoba1.podatek()) //0

    var osoba2 = new Osoba("Piotr", "Babacki") with Pracownik
    osoba2.pensja = 100
    println(osoba2.podatek()) // 20

    var osoba3 = new Osoba("Piotr", "Cabacki") with Nauczyciel
    osoba3.pensja = 100
    println(osoba3.podatek()) // 10

    var osoba4 = new Osoba("Piotr", "Abacki") with Student with Pracownik
    osoba4.pensja = 100
    println(osoba4.podatek()) // od prawej do lewej więc Pracownik nadpisał Studenta - życie :)

    var osoba5 = new Osoba("Piotr", "Babacki") with Pracownik with Student
    osoba5.pensja = 100
    println(osoba5.podatek()) // 0

  }

  def functionAsParam(f: Int => Int, valueToProceed: Int): Int = {
    f(valueToProceed) + f(valueToProceed) + f(valueToProceed)
  }

  def helloPerson(person: Person): String = {
    person match {
      case person if person.name.contains("Piotr") => s"Ola amigo ${person.name}"
      case person if person.name.contains("Jan") => "Hello"
      case _ => "enemy unknown"
    }
  }

  def zad1(day: String): String = day match {
    case day if day.contains("Saturday") || day.contains("SunDay") => "Weekend"
    case day if day.contains("Monday") || day.contains("Tuesday") || day.contains("Wednesday") || day.contains("Thursday") || day.contains("Friday") => "Praca"
    case _ => "Nie ma takiego dnia"
  }


  def createListDayWeek(): List[String] = {
    var dayWeek: List[String] = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "SunDay")
    return dayWeek
  }


}

class KontoBankowe(val stan: Double) {
  def this() = this(0)
}

class Person(val name: String, val surname: String) {}


// -------------- CW 5 -------------- //

abstract class Osoba(val imie: String, val nazwisko: String) {
  def podatek(): Double
}

trait Student extends Osoba {
  override def podatek(): Double = 0
}

trait Pracownik extends Osoba {
  private var _pensja: Integer = 0

  def pensja: Integer = _pensja


  def pensja_=(newValue: Integer): Unit = {
    _pensja = newValue
  }

  override def podatek(): Double = _pensja.toDouble * 0.20

}

trait Nauczyciel extends Pracownik {
  override def podatek(): Double = super.pensja * 0.10
}

