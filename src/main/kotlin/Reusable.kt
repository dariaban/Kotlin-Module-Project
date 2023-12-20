
import java.lang.Character.isDigit
import java.lang.Character.isLetter
import java.util.Scanner
abstract class Reusable{
    abstract val archiveMap: MutableMap<String, MutableList<String>>
    abstract var name: String

    fun menu(line1: String, line2: String, line3: String) {
        do {println("Список $line1:\n0. Создать $line2\n1. Это $line3\n2. Выход")
        println("Введите число чтобы выбрать")
            var input = Scanner(System.`in`).next().single()
        when (input) {
            '0' -> create(name)
            '1' -> open(archiveMap, name)
            '2' -> exit()
            else -> {if (!isDigit(input)){
                println("Введите число")
            }else{println("Введите число соответствующее пунктам меню")}}
        }
        } while (true)
    }
    abstract fun create(name:String): MutableMap<String, MutableList<String>>
    abstract fun open(archiveMap:MutableMap<String, MutableList<String>>, name: String): String
    abstract fun exit()}
