package csv

data class Question(
    val id: String,
    val respondentId: String,
    val text: String,
    val answer: Int
)
