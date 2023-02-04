import kotlin.contracts.Returns

class  Compani{
    //data class Companies(
        var Name: String = String()
        var Activity: String = String()
    //    var Description: String,
        var ListOfVacancies: List<Vacancies> = listOf()
     //   var Contacts: String
   // )

    data class Vacancies(
        var Profession: String,
        var Level: String,
        var Salary: Int
    )

    fun Inilise(name: String, activity: String){
        Name = name
        Activity = activity
        ListOfVacancies = IniliseVacansies()

    }
    fun IniliseVacansies():List<Vacancies>{
        var process = listOf("Developer","QA", "Project Manager", "Analyst", "Designer")
        var level = listOf("junior", "middle","senior")
        val salary = listOf( 40000, 50000, 140000)
        var listOfVacancies:List<Vacancies> = listOf()

        for (p in 0..process.size-1){
            for(l in 0..level.size-1) {
                listOfVacancies += Vacancies(
                    Profession = process[p],
                    Level = level[l],
                    Salary = salary[l]
                )
            }
        }
        return (listOfVacancies)
    }

}
fun AskPrinter(proffession: List<String>): Int{
   var num = 0
    for (i in proffession){
        println("$num. $i")
        num ++
    }
    var choose = readln().toInt()
    while(choose < 0 || choose > proffession.size ){
         choose = readln().toInt()
    }
    return choose
}
fun  MinusArr(activitys: List<Compani>, proffession: List<String>, activ : Int): List<Compani>{
    var num = 0
    var compani :List<Compani> = activitys
    while (num < compani.size){
        var j = 0
        while( j < (compani[num].ListOfVacancies).size){
            if(((compani[num]).ListOfVacancies[j]).Profession !in proffession[activ]){
                compani[num].ListOfVacancies-= compani[num].ListOfVacancies[j]
                //companies +=activitys[num].ListOfVacancies[j]
                j--
            }
            j++
        }
        num++

    }
    return (compani)
}
fun main(args: Array<String>) {
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    var process: Array<String> = arrayOf("edu", "sber21", "Git", "Project", "apple","mouse","elements7","list",
        "attention","string")
    var activity: Array<String> = arrayOf("It","Banking", "Public services")
    var compani = Compani()
    // создать массив побольше
    var proffession: List<String> = listOf("ALL","It","Banking", "Public services")
    var companies : List<Compani> = listOf()
    var num =0
    for(i in process){
        companies += compani
        companies[num].Inilise(i,activity[num%activity.size])
        num += 1

    }
    println("Select a field of activity:")
    var activ = AskPrinter(proffession)

    var activitys: List<Compani> = listOf()
    when(activ){
        0 -> {
            activitys = companies
        }
        else->{
            num = 0
            while (num < companies.size){
                if(companies[num].Activity in proffession[activ]){
                    activitys += companies[num]
                }
                num++
            }
        }
    }
    proffession = listOf("ALL") // профессии которые есть по направлению
   // num = 0

    for(i in 0..(activitys.size)-1){ // добавили выбранные профессии в поиск
        //println((activitys[i].ListOfVacancies))
        for(j in 0..(activitys[i].ListOfVacancies).size - 1){
            if(activitys[i].ListOfVacancies[j].Profession !in proffession){
                proffession += activitys[i].ListOfVacancies[j].Profession

         }
        }
    }

    activ = AskPrinter(proffession)

    when(activ){ // создаем список того какой уровень умений
        0 -> { activitys
                 }
        else->{
            activitys=MinusArr(activitys, proffession, activ )
        }
    }
    proffession = listOf("All")
    num = 0
    for(i in 0..(activitys.size)-1){ // добавили выбранные профессии в поиск
        for(j in 0..(activitys[i].ListOfVacancies).size - 1){
            if(activitys[i].ListOfVacancies[j].Level !in proffession){
                proffession+= ((activitys[i]).ListOfVacancies[j]).Level
                //println((activitys[i]).ListOfVacancies[j])
                num++
            }
        }
    }
    activ = AskPrinter(proffession)
    when(activ){ // создаем список того какой уровень зарплат
        0 -> {
        }
        else->{
            activitys=MinusArr(activitys, proffession, activ)
        }
    }

    proffession = listOf("All")
    var salary:List<Int> = listOf()
    num = 0
    for(i in 0..( activitys.size)-1){ // добавили выбранные профессии в поиск
        var f = ( activitys[i].ListOfVacancies).size - 1

        for(j in 0..f){
            if((( activitys[i]).ListOfVacancies[j]).Salary.toString() !in proffession){
                proffession+= ((activitys[i]).ListOfVacancies[j]).Salary.toString()
                salary+=(( activitys[i]).ListOfVacancies[j]).Salary
                num++
            }
        }
    }

    activ = AskPrinter(proffession)

    when(activ){ // создаем список того какой уровень умений
        0 -> {
                 activitys

        }
        else->{
            activitys=MinusArr(activitys, proffession, activ )
        }
    }
    for(i in 0..activitys.size){
        println(activitys[i].Name)
        println(activitys[i].Activity)
        println(activitys[i].ListOfVacancies)
    }

}