import java.util.Scanner

class Note: Reusable() {
    override var name: String = "что-то"
    override val archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    var nameOfNote: String = ""
    override fun create(name:String): MutableMap<String, MutableList<String>>{
        println("Введите имя заметки")
        var nameOfNote = Scanner(System.`in`).nextLine()
        var listOfNote: MutableList<String> = mutableListOf()
        listOfNote.add(nameOfNote)
        archiveMap.set(name, listOfNote)
        do {println("Чтобы добавить еще одину заметку, введите имя заметки, для выхода введите нет")
            nameOfNote = Scanner(System.`in`).nextLine()
            listOfNote.add(nameOfNote)
            archiveMap.set(name, listOfNote)
            if (nameOfNote=="нет") listOfNote.remove(nameOfNote)
        }
        while(nameOfNote != "нет")
        return archiveMap
    }
    override fun open(archiveMap: MutableMap<String, MutableList<String>>, name: String): String {
        println("Все заметки: ${archiveMap.values}")
        var notes = archiveMap.get(name)
        println("Выберете заметку")
        do {var nameOfNote = Scanner(System.`in`).nextLine()
            if (notes?.contains(nameOfNote) == true){
                println("Вы находитесь в заметке $nameOfNote")
                println("Если хотите добавить текст в заметку, напечатайте его ниже")
                var text = nameOfNote.plus(" ").plus(Scanner(System.`in`).nextLine())
                println("Текст вашей заметки $nameOfNote: \n$text")
                archiveMap.put(name, mutableListOf())
                return nameOfNote
            }else{println("Имя заметки не найдено попробуйте еще раз")}}
        while(notes?.contains(nameOfNote) != true)
        return nameOfNote
    }

    override fun exit() {
        val note2 = Note()
        note2.menu("архивов", "архив", "мой созданный архив")
    }
    fun show(listOfNote: MutableList<String>){
        var text: String = ""
        val noteMap: MutableMap<MutableList<String>, String> =
            mutableMapOf(listOfNote to text)
        print(text)
        println("Если хотите добавить текст в заметку, напечатайте его ниже")

    }


}