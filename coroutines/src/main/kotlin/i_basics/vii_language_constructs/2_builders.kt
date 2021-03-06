package i_basics.vii_language_constructs

private data class MyDTO(val id: String, val number: Int)

@ExperimentalStdlibApi
fun main() {
    val currentApproachResult = mutableListOf<MyDTO>().apply {
        repeat(10) {
            add(
                MyDTO(
                    id = "1",
                    number = 1
                )
            )
        }
    }.toList()

    val resultFromBuilder = buildList {
        repeat(10) {
            add(
                MyDTO(
                    id = "1",
                    number = 1
                )
            )
        }
    }
}
