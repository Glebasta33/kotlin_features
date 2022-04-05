package csv

import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter

fun main() {

    val questions = mutableListOf<Question>()

    for (i in 1..100) {
        val question = Question(
            id = "id$i",
            respondentId = "respondentId$i",
            text = "Text of question ${i * 17}",
            answer = (Math.random() * 5).toInt() + 1
        )
        questions.add(question)
    }

    lateinit var writer: FileWriter
    try {
        writer = FileWriter(File("Questions.csv"))

        val builder = StringBuilder()
        val columnNames = "Id,RespondentId,Question,Answer"
        builder.append(columnNames + "\n")
        for (q in questions) {
            builder.append("${q.id},${q.respondentId},${q.text},${q.answer}\n")
        }
        writer.write(builder.toString())
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        writer.close()
    }


}