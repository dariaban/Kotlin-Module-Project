import java.util.Scanner
class Archive: Reusable() {
   val note = Note()
    var something: String = "архив"
    override var name : String =""
    override val archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    override fun create(name: String): MutableMap<String, MutableList<String>>{
        println("Введите имя архива")
        var name = Scanner(System.`in`).nextLine()
        archiveMap.put(name, mutableListOf())
           do {println("Чтобы добавить еще один архив, введите имя архива, для выхода введите нет")
            name = Scanner(System.`in`).nextLine()
        archiveMap.put(name, mutableListOf())
               if (name=="нет") archiveMap.remove(name, mutableListOf())
           }
           while(name != "нет")
        return archiveMap
    }
    override fun open(archiveMap: MutableMap<String, MutableList<String>>, name: String): String{
        println("Все архивы: ${archiveMap.keys}")
        println("Выберете архив")
        do {var name = Scanner(System.`in`).nextLine()
        if (archiveMap.containsKey(name)){
            println("Вы находитесь в архиве $name")
            note.menu( "заметок", "заметку", "моя созданная заметка")
            return name
        }else{println("Имя архива не найдено попробуйте еще раз")}}
            while(!archiveMap.containsKey(name))
        return name
    }

    override fun exit(){
        System.exit(1)
    }
}