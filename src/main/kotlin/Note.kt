import java.util.Scanner

class Note : Reusable() {
    override var name: String = "что-то"
    override val archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    val listOfNote: MutableList<String> = mutableListOf()
    override fun create(name: String): MutableMap<String, MutableList<String>> {
        val note2 = Note()
        do {
            println("Чтобы добавить заметку, введите имя заметки, для выхода введите нет")
            var nameOfNote = Scanner(System.`in`).nextLine()
            listOfNote.add(nameOfNote)
            check(nameOfNote, "Имя заметки")
            if ((nameOfNote == "") || (nameOfNote == "нет")) {
                listOfNote.remove(nameOfNote)
            }
            archiveMap.set(name, listOfNote)
        } while (nameOfNote != "нет")
        return archiveMap
    }

    override fun open(archiveMap: MutableMap<String, MutableList<String>>, name: String) {
        println("Все заметки: ${archiveMap.values}")
        val notes = archiveMap.get(name)
        println("Выберете заметку")
        do {
            val nameOfNote = (Scanner(System.`in`).nextLine()).substringBefore(" ")
            if (notes?.contains(nameOfNote) == true) {
                println("Вы находитесь в заметке $nameOfNote")
                do {
                    println("Если хотите добавить текст в заметку, напечатайте его ниже или 'нет' для выхода")
                    var text = Scanner(System.`in`).nextLine()
                    check(text, "Текст заметки")
                    text = nameOfNote.plus(" ").plus(text)
                    val listOfNotes: MutableMap<String, String> = mutableMapOf()
                    listOfNotes.put(nameOfNote, text)
                    println("Текст вашей заметки $nameOfNote: \n ${listOfNotes.get(nameOfNote)}")
                } while (text != "нет")
            } else if (nameOfNote == "назад") {
                menu("заметок", "заметку", "моя созданная заметка")
                break
            } else {
                println("Имя заметки не найдено попробуйте еще раз или введите назад чтобы вернуться")
            }
        } while (notes?.contains(nameOfNote) != true)
    }

    override fun exit() {
        menu("архивов", "архив", "мой созданный архив")
    }

}


