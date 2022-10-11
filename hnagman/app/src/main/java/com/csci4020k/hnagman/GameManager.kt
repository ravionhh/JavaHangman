package com.csci4020k.hnagman

import kotlin.random.Random


class GameManager {

    private var lettersUsed: String = ""
    private lateinit var underscoreWord: String
    private lateinit var wordToGuess: String
    private val maxTries = 7
    private var currentTries = 0
    private var drawable: Int = R.drawable.game0

    fun startNewGame(): GameState {
        lettersUsed = ""
        currentTries = 0
        drawable = R.drawable.game7
        var category = ""
        category = CategoryActivity.getValue()
        when (category) {
            "movies" -> {
                val randomIndex = Random.nextInt(0, MoviesList.words.size)
                wordToGuess = MoviesList.words[randomIndex]
                generateUnderscore(wordToGuess)
            }
            "animals" -> {
                val randomIndex = Random.nextInt(0, AnimalsList.words.size)
                wordToGuess = AnimalsList.words[randomIndex]
                generateUnderscore(wordToGuess)
            }
            "cars" -> {
                val randomIndex = Random.nextInt(0, CarsList.words.size)
                wordToGuess = CarsList.words[randomIndex]
                generateUnderscore(wordToGuess)
            }
            "foods" -> {
                val randomIndex = Random.nextInt(0, FoodsList.words.size)
                wordToGuess = FoodsList.words[randomIndex]
                generateUnderscore(wordToGuess)
            }
            "brands" -> {
                val randomIndex = Random.nextInt(0, BrandsList.words.size)
                wordToGuess = BrandsList.words[randomIndex]
                generateUnderscore(wordToGuess)
            }
        }
        //val randomIndex = Random.nextInt(0, AnimalsList.words.size)
        //wordToGuess = AnimalsList.words[randomIndex]
        //generateUnderscore(wordToGuess)
        return getGameState()
    }

    private fun generateUnderscore(word: String) {
        val sb = StringBuilder()
        word.forEach { char ->
            if (char == '/') {
                sb.append('/')
            } else {
                sb.append("_")
            }
        }
        underscoreWord = sb.toString()

    }

    private fun getGameState(): GameState {

        if (underscoreWord.equals(wordToGuess, true))
            return GameState.Won(wordToGuess)
        if (currentTries == maxTries) {
            return GameState.Lost(wordToGuess)
        }
        drawable = getHangmanDrawable()
        return GameState.Running(lettersUsed, underscoreWord, drawable)
    }

    private fun getHangmanDrawable(): Int {
        return when (currentTries) {
            0 -> R.drawable.game0
            1 -> R.drawable.game1
            2 -> R.drawable.game2
            3 -> R.drawable.game3
            4 -> R.drawable.game4
            5 -> R.drawable.game5
            6 -> R.drawable.game6
            7 -> R.drawable.game7
            else -> R.drawable.game7

        }
    }

    fun play(letter: Char): GameState {
        if (lettersUsed.contains(letter)) {
            return GameState.Running(lettersUsed, underscoreWord, drawable)
        }
        lettersUsed += letter
        val indexes = mutableListOf<Int>()
        wordToGuess.forEachIndexed { index, char ->
            if (char.equals(letter, true))
                indexes.add(index)
        }


    var finalUnderscoreWord = "" + underscoreWord
    indexes.forEach{index ->
        val sb = StringBuilder(finalUnderscoreWord).also {
            it.setCharAt(index, letter)
        }
        finalUnderscoreWord = sb.toString()
    }
    if(indexes.isEmpty()) {
        currentTries++
    }
    underscoreWord = finalUnderscoreWord
    return getGameState()
}
}