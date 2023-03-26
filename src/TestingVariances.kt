open class Fruit {
    open var englishName: String = "Fruit"
}

val fruitNameComparator: Comparator<Fruits> = compareBy { it.englishName }

class Apple: Fruits() {
    override var englishName = "Apple"
}

class Orange: Fruits() {
    override var englishName = "Orange"
}


public fun <T> List<T>.binarySearchs(element: T, comparator: Comparator<T>, fromIndex: Int = 0, toIndex: Int = size): Int {
    rangeCheck(size, fromIndex, toIndex)

    var low = fromIndex
    var high = toIndex - 1

    while (low <= high) {
        val mid = (low + high).ushr(1) // safe from overflows
        val midVal = get(mid)
        val cmp = comparator.compare(midVal, element)

        if (cmp < 0)
            low = mid + 1
        else if (cmp > 0)
            high = mid - 1
        else
            return mid // key found
    }
    return -(low + 1)  // key not found
}


private fun rangeCheck(size: Int, fromIndex: Int, toIndex: Int) {
    when {
        fromIndex > toIndex -> throw IllegalArgumentException("fromIndex ($fromIndex) is greater than toIndex ($toIndex).")
        fromIndex < 0 -> throw IndexOutOfBoundsException("fromIndex ($fromIndex) is less than zero.")
        toIndex > size -> throw IndexOutOfBoundsException("toIndex ($toIndex) is greater than size ($size).")
    }
}


fun main() {
//    val list = listOf(Orange(), Orange(), Orange(), Orange(), Orange())
//
//    print(list.binarySearchs(Orange(), fruitNameComparator))

    val f: Equivalence<Apple> = Equivalence<Fruits>()
    val g: Equivalence<Apple> = Equivalence<Fruits>()
    g.something(Apple())
    //val g: Equivalence<Fruit> = Equivalence<Apple>()
}

class Equivalence<in T> {
    fun something(input : T) = false
}