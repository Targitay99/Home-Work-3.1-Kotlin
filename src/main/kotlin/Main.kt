package ru.netology

fun main() {
    agoToText("Саша", 60)
    agoToText("Петя", 60 * 21)
    agoToText("Таня", 60 * 60 * 10)
    agoToText("Света", 60 * 60 * 24 * 2)
    agoToText("Ника", 60 * 60 * 24 * 3)
    agoToText("Вероника", 60 * 60 * 24 * 4)
}

fun agoToText(userId: String, timeToLeft: Int) {
    val timeToLeftText: String
    val hour: Int
    val hourToText: String
    val minute: Int
    val minuteToText: String
    timeToLeftText = when (timeToLeft) {
        in 0..60 -> "только что."
        in 61..60 * 60 -> {
            minute = timeToLeft / 60
            minuteToText = agoToTextMinute(minute)
            "$minute $minuteToText назад."
        }
        in 60 * 60 + 1..24 * 60 * 60 -> {
            hour = timeToLeft / 60 / 60
            hourToText = agoToTextHour(hour)
            "$hour $hourToText назад."
        }
        in 60 * 60 * 24 + 1..60 * 60 * 24 * 2 -> "сегодня."
        in 60 * 60 * 24 * 2 + 1..60 * 60 * 24 * 3 -> "вчера."
        else -> "давно."
    }
    println("$userId был(а) $timeToLeftText")
}

fun agoToTextHour(hour: Int): String {
    return when (hour) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> {
            "часов"
        }
    }
}

fun agoToTextMinute(minute: Int): String {
    if (minute in 11..14) {
        return "минут"
    }
    return when (minute % 10) {
        1 -> "минуту"
        0 -> "минут"
        in 2..4 -> "минуты"
        else -> {
            "минут"
        }
    }
}












