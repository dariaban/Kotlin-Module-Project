import java.util.Scanner
import kotlin.system.exitProcess

class Archive : Reusable() {
    override val archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    private val note = Note()
    override fun create() {
        do {
            println("Чтобы добавить архив, введите имя архива, для выхода введите нет")
            val input = Scanner(System.`in`).nextLine()
            archiveMap[input] = mutableListOf()
            check(input, "Имя архива")
            if ((input == "") || (input == "нет")) archiveMap.remove(input, mutableListOf())
        } while (input != "нет")

    }

    override fun open(archiveMap: MutableMap<String, MutableList<String>>) {
        println("Все архивы: ${archiveMap.keys}")
        println("Выберете архив")
        do {
            val input = Scanner(System.`in`).nextLine()
            if (archiveMap.containsKey(input)) {
                println("Вы находитесь в архиве $input")
                note.menu("заметок", "заметку", "моя созданная заметка")

            } else if (input == "назад") {
                menu("архивов", "архив", "мой созданный архив")
                break
            } else {
                println("Имя архива не найдено попробуйте еще раз или введите назад чтобы вернуться")

            }
        } while (!archiveMap.containsKey(input))


    }

    override fun exit() {
        exitProcess(1)
    }
}