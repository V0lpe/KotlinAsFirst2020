@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence", "IMPLICIT_CAST_TO_ANY")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var absV = 0.0
    return if (v.isNotEmpty()) {
        for (element in v) {
            absV += sqr(element)
        }
        sqrt(absV)
    } else
        absV
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var scalar = 0
    for (i in a.indices)
        scalar += a[i] * b[i]
    return scalar
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    var sum = 0
    for (i in list.indices) {
        sum += list[i]
        list[i] = sum
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */

fun factorize(n: Int): List<Int> {
    var number = n
    var multiplier = 2
    val multipliers = mutableListOf<Int>()
    while (number > 1) {
        if (number % multiplier == 0) {
            multipliers.add(multiplier)
            number /= multiplier
        } else {
            ++multiplier
        }
    }
    return multipliers
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
    val multipliers = factorize(n)
    return multipliers.joinToString(separator = "*")
}

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */

fun roman(n: Int): String {
    val decNum = listOf<Int>(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val romNum = listOf<String>("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var number = n
    var romNumber = ""
    for (i in 0..12) {
        while (number >= decNum[i]) {
            number -= decNum[i]
            romNumber += romNum[i]
        }
    }
    return romNumber
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun toRus(num: Int, partOfNum: Int): String {
    var number = num
    val digits = listOf<String>(
        "один", "два", "три", "четыре", "пять", "шесть",
        "семь", "восемь", "девять", "одна", "две", "девяно"
    )
    val teensDigit = listOf<String>(
        "четыр", "пят", "шест", "сем", "восем", "девят"
    )
    val teens = "надцать"
    val tens = listOf<String>("десят", "дцать", "сорок")
    val hundreds = listOf<String>("сто", "сти", "ста", "сот")
    val thousands = listOf<String>("тысяча", "тысячи", "тысяч")
    val space = " "
    var numberInRus = ""
    numberInRus += when (number / 100) {
        1 -> hundreds[0]
        2 -> digits[10] + hundreds[1]
        in 3..4 -> digits[number / 100 - 1] + hundreds[2]
        in 5..9 -> digits[number / 100 - 1] + hundreds[3]
        else -> ""
    }
    number %= 100
    if (number != 0 && numberInRus != "") {
        if (numberInRus[numberInRus.lastIndex] != ' ')
            numberInRus += space
    }
    if (number / 10 == 1) {
        numberInRus += when (number % 10) {
            1 -> digits[number % 10 - 1] + teens
            2 -> digits[10] + teens
            3 -> digits[number % 10 - 1] + teens
            in 4..9 -> teensDigit[number % 10 - 4] + teens
            else -> "десять"
        }
        if (partOfNum == 1)
            numberInRus += space + thousands[2]
        return numberInRus
    } else {
        numberInRus += when (number / 10) {
            in 2..3 -> digits[number / 10 - 1] + tens[1]
            4 -> tens[2]
            in 5..8 -> digits[number / 10 - 1] + tens[0]
            9 -> digits[11] + hundreds[0]
            else -> ""
        }
    }
    number %= 10
    if (number != 0 && numberInRus != "") {
        if (numberInRus[numberInRus.lastIndex] != ' ')
            numberInRus += space
    }
    if (partOfNum == 1) {
        if (number != 0) {
            when (number % 10) {
                1 -> numberInRus += digits[9] + space + thousands[0]
                2 -> numberInRus += digits[10] + space + thousands[1]
                in 3..4 -> numberInRus += digits[number - 1] + space + thousands[1]
                in 5..9 -> numberInRus += digits[number - 1] + space + thousands[2]
                else -> ""
            }
        } else {
            if (numberInRus[numberInRus.lastIndex] != ' ')
                numberInRus += space
            numberInRus += thousands[2]
        }
    } else {
        if (number != 0)
            numberInRus += digits[number - 1]
    }
    return numberInRus
}

fun russian(n: Int): String {
    var numberInRus = ""
    if (n >= 1000)
        numberInRus += toRus(n / 1000, 1)
    if (n % 1000 != 0 && numberInRus != "")
        numberInRus += " "
    numberInRus += toRus(n % 1000, 2)
    return numberInRus
}