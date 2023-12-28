import java.lang.Character.isDigit
import java.util.Scanner

abstract class Reusable {
    abstract val archiveMap: MutableMap<String, MutableList<String>>
    fun menu(line1: String, line2: String, line3: String) {
        do {
            println("Список $line1:\n0. Создать $line2\n1. Это $line3\n2. Выход")
            println("Введите число чтобы выбрать")
            when (val input= Scanner(System.`in`).next()[0]) {
                '0' -> create()
                '1' -> open(archiveMap)
                '2' -> exit()
                else -> {
                    if (!isDigit(input)) {
                        println("Введите число")
                    } else {
                        println("Введите число соответствующее пунктам меню")
                    }
                }
            }
        } while (true)
    }

    fun check(nameOfSomething: String, line4: String): Boolean {
        if (nameOfSomething.isBlank()) {
            println("$line4 не может быть пустым")
        }
        return false
    }

    abstract fun create()
    abstract fun open(archiveMap: MutableMap<String, MutableList<String>>)
    abstract fun exit()
}
