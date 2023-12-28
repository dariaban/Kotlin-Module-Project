import java.util.Scanner

class Note : Reusable() {
    private val name: String = "что-то"
    override val archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    private val listOfNote: MutableList<String> = mutableListOf()

    override fun create() {
        do {
            println("Чтобы добавить заметку, введите имя заметки, для выхода введите нет")
            val nameOfNote = Scanner(System.`in`).nextLine()
            listOfNote.add(nameOfNote)
            check(nameOfNote, "Имя заметки")
            if ((nameOfNote == "") || (nameOfNote == "нет")) {
                listOfNote.remove(nameOfNote)
            }
            archiveMap[name] = listOfNote
        } while (nameOfNote != "нет")
    }

    override fun open(archiveMap: MutableMap<String, MutableList<String>>) {
        println("Все заметки: ${archiveMap.values}")
        val notes = archiveMap[name]
        println("Выберете заметку")
        do {
            val nameOfNote = (Scanner(System.`in`).nextLine()).substringBefore(" ")
            if (notes?.contains(nameOfNote) == true) {
                println("Вы находитесь в заметке $nameOfNote")
                do {
                    println("Если хотите добавить текст в заметку, напечатайте его ниже или 'нет' для выхода")
                    val text = Scanner(System.`in`).nextLine()
                    add(nameOfNote, text)
                    check(text, "Текст заметки")
                } while (text != "нет")
            } else if (nameOfNote == "назад") {
                menu("заметок", "заметку", "моя созданная заметка")
                break
            } else {
                println("Имя заметки не найдено попробуйте еще раз или введите назад чтобы вернуться")
            }
        } while (notes?.contains(nameOfNote) != true)
    }
    private fun add(nameOfNote: String, text: String){
        val textOfNote = "$nameOfNote $text"
        val listOfNotes: MutableMap<String, String> = mutableMapOf()
        listOfNotes[nameOfNote] = textOfNote
        println("Текст вашей заметки $nameOfNote: \n ${listOfNotes[nameOfNote]}")
    }

    override fun exit() {
        menu("архивов", "архив", "мой созданный архив")
    }

}


