package com.example.codepathwordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit_button = findViewById<Button>(R.id.submitButton)
        val restart_button = findViewById<Button>(R.id.restartButton)
        var currentWord = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
        var userInput = findViewById<EditText>(R.id.guessText)
        var correct_ans = findViewById<TextView>(R.id.correctAnswer)

        var listGuesses = listOf<TextView>(findViewById(R.id.guess1text), findViewById(R.id.guess2text), findViewById(R.id.guess3text))
        var listResult = listOf<TextView>(findViewById(R.id.guessResult), findViewById(R.id.guessResult2), findViewById(R.id.guessResult3))

        var currentGuess = 1;




        submit_button.setOnClickListener{

           if (currentGuess == 1) {
               listGuesses[0].text = userInput.text.toString()
               listResult[0].text = checkGuess(userInput.text.toString(), currentWord)
               currentGuess++
           }else if (currentGuess == 2) {
               listGuesses[1].text = userInput.text.toString()
               listResult[1].text = checkGuess(userInput.text.toString(), currentWord)
               currentGuess++
           }else if (currentGuess == 3) {
               listGuesses[2].text = userInput.text.toString()
               listResult[2].text = checkGuess(userInput.text.toString(), currentWord)

               if (listResult[2].text == "OOOO") {
                   Toast.makeText(
                       it.context,
                       "Correct answer!",
                       Toast.LENGTH_SHORT
                   ).show()

               } else {
                   Toast.makeText(
                       it.context,
                       "You have exceeded the maximum number of guesses!",
                       Toast.LENGTH_SHORT
                   ).show()
               }

               correct_ans.text = currentWord
               correct_ans.visibility = View.VISIBLE

               submit_button.isEnabled = false
               restart_button.visibility = View.VISIBLE

               restart_button.setOnClickListener{
                   currentWord = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
                   currentGuess = 1

                   for (guess in listGuesses) {
                       guess.text = ""
                   }

                   for (result in listResult) {
                       result.text = ""
                   }

                   restart_button.visibility = View.INVISIBLE
                   correct_ans.visibility = View.INVISIBLE
                   submit_button.isEnabled = true

               }


           }
       }


    }


    private fun checkGuess(guess: String, word_guess: String) : String {
        var result = ""
        var user_guess = word_guess.lowercase()
        for (i in 0..3) {
            if (guess[i] == user_guess[i]) {
                result += "O"
            }
            else if (guess[i] in user_guess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        println(guess)
        println(word_guess)
        return result
    }

}
