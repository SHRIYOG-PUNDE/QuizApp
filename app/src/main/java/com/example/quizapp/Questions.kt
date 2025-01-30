package com.example.quizapp

data class Questions(
    val id : Int,
    val image : Int,
    val question : String,
    val opt1 : String,
    val opt2 : String,
    val opt3 : String,
    val opt4 : String,
    val correctAns : Int
    )
