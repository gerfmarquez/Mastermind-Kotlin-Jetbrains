package mastermind

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = mutableListOf<Char>()
    var wrongPosition = mutableListOf<Char>()

    var missing = guess

    fun isRightPosition(letterSecret: Char, letterGuess: Char) = letterSecret == letterGuess
    fun isWrongPosition(letter : Char)  = letter in missing

    for(index in secret.indices) {

        if(isRightPosition(secret[index], guess[index])) {
            rightPosition.add(secret[index])
            missing = missing.replaceFirst(
                    Regex(secret[index].toString()),"-")
        }
    }
    for(index in secret.indices) {

        if(!isRightPosition(secret[index], guess[index]) &&
                isWrongPosition(secret[index])) {
            wrongPosition.add(secret[index])
            missing = missing.replaceFirst(
                    Regex(secret[index].toString()),"-")
        }
    }

    return Evaluation(rightPosition.size, wrongPosition.size)

}
