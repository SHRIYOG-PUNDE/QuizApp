package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 1
    private var mQuestionsList : ArrayList<Questions>? = null
    private var mSelectedOptionPosition = 0
    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0


    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestions : TextView? = null
    private var tvImage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btn_submit : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra(Constants.UESR_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestions = findViewById(R.id.tv_Questions)
        tvImage = findViewById(R.id.tv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btn_submit = findViewById(R.id.btn_submit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btn_submit?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionsView()
        val question: Questions = mQuestionsList!![mCurrentPosition - 1]
        tvImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestions?.text = question.question
        tvOptionOne?.text = question.opt1
        tvOptionTwo?.text = question.opt2
        tvOptionThree?.text = question.opt3
        tvOptionFour?.text = question.opt4
        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit?.text = "FINISH"
        }else{
            btn_submit?.text = "SUBMIT"
        }
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

        }
    }
    private fun selectedOptionsView(tv : TextView, selectedOptionNum:Int){
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_border_color_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one->{
             tvOptionOne?.let {
                 selectedOptionsView(it, 1)

             }
            }
            R.id.tv_option_two->{
                tvOptionTwo?.let {
                    selectedOptionsView(it, 2)

                }
            }
            R.id.tv_option_three->{
                tvOptionThree?.let {
                    selectedOptionsView(it, 3)

                }
            }
            R.id.tv_option_four->{
                tvOptionFour?.let {
                    selectedOptionsView(it, 4)

                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.UESR_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit?.text = "SUBMIT"
                    }else{
                        btn_submit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer : Int, drawableView: Int){
        when(answer){
            1->{
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }


        }
    }
}