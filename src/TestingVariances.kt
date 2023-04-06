fun main() {
    val d = SomeClass<SubDog>()
    val g = List<Dog>(2){Dog()}
    val strs = mutableListOf<String>("D")
    append(strs)
    val subDog = SubDog()
    val superDog = Dog()
//    val copySubDog : SubDog = superDog
//    val copySuperDog: Dog = subDog

    val dogList = List<SubDog>(1){SubDog()}
    val dogListCopy: List<Dog> = dogList
    dogListCopy


    val dog: SomeClass<Dog> = SomeClass()
    val outDog: SomeClass<SubDog> = dog


}

fun append(list: List<Any>) {
    list[3]
}




open class Dog

class SubDog: Dog()

class SomeClass<in T> {
    fun doRandom(subDog: T) {

    }

//    fun doOutRandom(): T? {
//        return null
//    }
}

    fun <T> doRandom(subDog: T) {

    }


sealed class Responses<F, G> {
    class Success<R>(): Responses<R, Nothing>()

}

fun addAnimal(list: MutableList<in SubDog>): SubDog {
    list.add(SubDog())
    return SubDog()
//    val d: SubDog = list[2]
//    return list[2]
}

fun main2() {
    val animals = mutableListOf<Dog>()
    addAnimal(animals)
}
