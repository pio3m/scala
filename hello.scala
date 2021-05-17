object HelloWord {

    def main(args: Array[String]){
       var listDay = createListDayWeek()

       var returnString : String = ""
        returnString.concat("v")

       for(day <- listDay){
           returnString =  returnString.concat(day + ",")
       }     
       
       println(returnString.dropRight(1))
    } 


        
    def createListDayWeek() : List[String] = {
       var dayWeek: List[String] = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "SunDay")
        

       return dayWeek
    }
}
