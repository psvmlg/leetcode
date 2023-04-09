import kotlin.concurrent.timer

fun main(){
    var f = 2.coerceAtLeast(3)
    var start = System.currentTimeMillis()
    repeat(1000000000) {
        f = Math.min(2, 3)
        val g = Math.min(f, 34)
        val u = Math.min(g, 34)
        f = Math.max(u, 34)
    }
    println(System.currentTimeMillis() - start)

    start = System.currentTimeMillis()
    repeat(1000000000) {
        f = 2.coerceAtLeast(3)
        val g = f.coerceAtLeast(34)
        val u = g.coerceAtLeast(34)
        f = u.coerceAtLeast(34)
    }
    println(System.currentTimeMillis() - start)
    println(f)


}

