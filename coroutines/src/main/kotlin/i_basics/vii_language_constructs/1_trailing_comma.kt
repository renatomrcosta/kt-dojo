package i_basics.vii_language_constructs

class MyFunnyClass() {
    fun myFun(arg1: String, arg2: Int, arg3: List<String>) = println("hi there!")
}

fun main() {
    // Really convenient to change signatures / invocation order
    // Also you can mix named and default arguments, but you probably shouldn't
    // Install the Fill Class plugin in Intellij for an easier time with functions / classes
    MyFunnyClass().myFun(
        "",
        arg3 = listOf(),
        arg2 = 0,
    )
}

