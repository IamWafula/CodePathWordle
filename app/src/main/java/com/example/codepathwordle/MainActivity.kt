package com.example.codepathwordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restart_button = findViewById<Button>(R.id.restartButton);
        var currentWord = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord();
        var userInput = findViewById<EditText>(R.id.guessText);
        var currentGuess = 1;


       restart_button.setOnClickListener{

           if (currentGuess == 1) {
               findViewById<TextView>(R.id.guess1text).text = userInput.text.toString()
               findViewById<TextView>(R.id.guessResult).text = checkGuess(userInput.text.toString(), currentWord)
           }else if (currentGuess == 2) {
               findViewById<TextView>(R.id.guess2text).text = userInput.text.toString()
               findViewById<TextView>(R.id.guessResult2).text = checkGuess(userInput.text.toString(), currentWord)
           }else if (currentGuess == 3) {
               findViewById<TextView>(R.id.guess3text).text = userInput.text.toString()
               findViewById<TextView>(R.id.guessResult3).text = checkGuess(userInput.text.toString(), currentWord)
           }else {
               Toast.makeText(it.context, "Over the limit bruv", Toast.LENGTH_SHORT).show();
           }
           currentGuess++;
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
