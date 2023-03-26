import com.google.common.collect.ImmutableList


data class ViewState(
        val title: String?,
        val creator: String?
) {
}


fun main() {
    val f = ImmutableList.of("DD","EE","FF", "FRR")

    val g = ImmutableList.copyOf(f.filter { it.contains("F") })

    print(g)

    val j = f(f)
    a(f = "", r = "")
}

fun a(f: String, r: String) {

}

fun f(list: ImmutableList<String>): List<String> {
    return list.filter { it.contains("F") }
}