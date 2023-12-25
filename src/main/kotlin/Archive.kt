import java.util.Scanner

class Archive : Reusable() {
    val note = Note()
    override var name: String = ""
    override val archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    override fun create(name: String): MutableMap<String, MutableList<String>> {
        do {
            println("Чтобы добавить архив, введите имя архива, для выхода введите нет")
            var name = Scanner(System.`in`).nextLine()
            archiveMap.put(name, mutableListOf())
            note.check(name, "Имя архива")
            if ((name == "") || (name == "нет")) archiveMap.remove(name, mutableListOf())
        } while (name != "нет")
        return archiveMap
    }

    override fun open(archiveMap: MutableMap<String, MutableList<String>>, name: String) {
        println("Все архивы: ${archiveMap.keys}")
        println("Выберете архив")
        do {
            var name = Scanner(System.`in`).nextLine()
            if (archiveMap.containsKey(name)) {
                println("Вы находитесь в архиве $name")
                note.menu("заметок", "заметку", "моя созданная заметка")

            } else if (name == "назад") {
                menu("архивов", "архив", "мой созданный архив")
                break
            } else {
                println("Имя архива не найдено попробуйте еще раз или введите назад чтобы вернуться")

            }
        } while (!archiveMap.containsKey(name))


    }

    override fun exit() {
        System.exit(1)
    }
}