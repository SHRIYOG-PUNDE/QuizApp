package com.example.quizapp

object Constants {
    const val UESR_NAME : String = "uesr_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWER :String = "correct_answer"


    fun getQuestions() : ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1,
            R.drawable.india,
            "Which country does this flag belongs to?",
            "India",
            "Austria",
            "Belgium",
            "America",
            1
            )
        questionsList.add(que1)

        val que2 = Questions(
            2,
            R.drawable.argentina,
            "Which country does this flag belongs to?",
            "Brazil",
            "Austria",
            "Argentina",
            "Belgium",
            3
        )
        questionsList.add(que2)
        val que3 = Questions(
            1,
            R.drawable.brazil,
            "Which country does this flag belongs to?",
            "India",
            "America",
            "Germany",
            "Brazil",
            4
        )
        questionsList.add(que3)
        val que4 = Questions(
            1,
            R.drawable.canada,
            "Which country does this flag belongs to?",
            "Canada",
            "Austria",
            "Austria",
            "France",
            1
        )
        questionsList.add(que4)
        val que5 = Questions(
            1,
            R.drawable.belgium,
            "Which country does this flag belongs to?",
            "India",
            "Argentina",
            "Belgium",
            "Germany",
            3
        )
        questionsList.add(que5)
        val que6 = Questions(
            1,
            R.drawable.austria
            ,
            "Which country does this flag belongs to?",
            "Australia",
            "Austria",
            "Belgium",
            "America",
            2
        )
        questionsList.add(que6)
        val que7 = Questions(
            1,
            R.drawable.france,
            "Which country does this flag belongs to?",
            "India",
            "Austria",
            "Belgium",
            "America",
            1
        )
        questionsList.add(que7)
        val que8 = Questions(
            1,
            R.drawable.australia,
            "Which country does this flag belongs to?",
            "Australia",
            "Austria",
            "Belgium",
            "America",
            1
        )
        questionsList.add(que8)

        return questionsList
    }
}