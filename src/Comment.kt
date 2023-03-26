/**
We want to be able to give the user a breakdown of how much time, over the duration

of the workout, they spent in each heart rate zone.

I.e. we want to be able display the user a report like:

Great job on your 30 minute HIIT class! Here's a breakdown of how much time you

spent in each of your heart rate zones:

PEAK: 7 minutes

CARDIO: 10 minutes

FAT BURN: 10 minutes

WARM UP: 3 minutes

To do so, we need to write a function to calculate how much

time over the workout duration was spent in each heart rate zone.

We'll use 4 standard heart rate zones, which we can represent as a list of pairs:

WARM UP: 0 - 60 percent of the user's maximum heart rate (0, 60)

FAT BURN: 60 - 75 percent of the user's maximum heart rate (60, 75)

CARDIO: 75 - 85 percent of the user's maximum heart rate (75, 85)

PEAK: 85 - 100 percent of the user's maximum heart rate (85, 100)

If a user's heart rate falls on the border of the upper and lower range of a

zone, we'll bucket them into the upper zone. For example, if we end up with a

set of zones [(157, 185), (139, 157), (111, 139), (0, 111)], a heart rate of

157 will be considered in the (157, 185) heart rate zone.

Write a function "timeInHeartRateZonesForWorkout" given:

- an array of (time, bpm) integer pairs for a user

- the ending time of the of the exercise (in seconds from start)

- the user's maximum heart rate, which is used to calculate their heart rate zones

The function should return an array of seconds the exerciser spent in each heart

rate zone sorted from PEAK to WARM UP. If the exerciser did not spend any time in

one of the four zones, return 0 for that zone.

For example, given a array of times and beats per minute:

[(0 70),(50 90), (60 120), (70 135), (100 150), (300 180), (400 75)],

[(49 170),(50 90), (60 120), (70 135), (100 150), (300 180), (400 75)],

a maximum heart rate of 185, and a workout duration of 500, the function should

return [100, 200, 40, 160]. The exerciser spent 100 seconds in PEAK, 200 in CARDIO,

40 in FAT BURN, and 160 in WARM UP.

Interviewer Notes:

 * all times and beats per minute are always positive, whole numbers

 * any time before the first data point is spent in the WARM UP zone */


fun main() {

    val high = 185
    val aa = listOf<List<Int>>()
    val com = Comparator { a: List<Int>, b: List<Int> ->
        return@Comparator a[0] - b[0]
    }
    aa.binarySearch(mutableListOf(2), com)

    val peakRange = listOf((high * 0.85).toInt(), high)
    val cardioRange = listOf((high * 0.75).toInt(), (high * 0.85).toInt() - 1)
    val burnRange = listOf((high * 0.60).toInt(), (high * 0.75).toInt() - 1)
    val warmUpRange = listOf(0, (high * 0.60).toInt() - 1)

}

public fun <T> Iterable<T>.sortedWith(comparator: Comparator<in T>): List<T> {
    if (this is Collection) {
        if (size <= 1) return this.toList()
        @Suppress("UNCHECKED_CAST")
        return (toTypedArray<Any?>() as Array<T>).apply { sortWith(comparator) }.asList()
    }
    return toMutableList().apply { sortWith(comparator) }
}

public inline fun <T, R : Comparable<R>> Iterable<T>.sortedBy(crossinline selector: (T) -> R?): List<T> {
    return sortedWith(compareBy(selector))
}


public inline fun <T> compareBy(crossinline selector: (T) -> Comparable<*>?): Comparator<T> {
    test(selector)
    return Comparator { a, b -> compareValuesBy(a, b, selector) }
}


public inline fun <T> compareValuesBy(a: T, b: T, selector: (T) -> Comparable<*>?): Int {
    return compareValues(selector(a), selector(b))
}

inline fun <T> test(block: (T) -> Comparable<*>?): Int {
    return 3
}