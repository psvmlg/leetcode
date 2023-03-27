import java.util.*
import kotlin.collections.HashSet

fun main() {
    val names: HashSet<Person> = HashSet()



    val person = Person("AA", "BB")
    names.add(person)
    names.add(Person("FF", "JJ"))
    names.add(Person("KOK", "UHGU"))
    print(names)
    print(person in names)
    person.name = "TEST"
    print(names)
    print(person in names)
}

data class Person(var name: String, val surName: String)