import java.util.*
import kotlin.Comparator
import kotlin.Triple

open class Fruits {
    open val englishName: String = "D"
}

data class Oranges(override val englishName: String = "Orange") : Fruits()

val fruitNameComparators: Comparator<Fruits> = compareBy { it.englishName }


//fun main() {
//    val list = listOf<Oranges>(Oranges(), Oranges(), Oranges(), Oranges(), Oranges())
//    val oranges: Fruits = list.binarySearchInflexible(Oranges(), fruitNameComparators)
//    val orange: Oranges = list.binarySearchFlexible(Oranges(), fruitNameComparators)
//}

public fun <T> List<T>.binarySearchInflexible(element: T, comparator: Comparator<T>, fromIndex: Int = 0, toIndex: Int = size): T =
        get(binarySearchIndex(element, comparator, fromIndex, toIndex))

public fun <T> List<T>.binarySearchFlexible(element: T, comparator: Comparator<in T>, fromIndex: Int = 0, toIndex: Int = size): T =
        get(binarySearchIndex(element, comparator, fromIndex, toIndex))


public fun <T> List<T>.binarySearchIndex(element: T, comparator: Comparator<in T>, fromIndex: Int = 0, toIndex: Int = size): Int {
    
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
    val g = Triple<Oranges, Int, Int>(Oranges(), 1, 1)
    val h: Oranges = g.first
    val t = arrayListOf<String>()
}

fun fill(dest: Array<in String>, value: String) {
    dest[2] = value
}

fun fills(dest: Array<out String>, value: String) {
    //
}
public data class Triple<out Fruits, out B, out C>(
        public val first: A,
        public val second: B,
        public val third: C
) {
}