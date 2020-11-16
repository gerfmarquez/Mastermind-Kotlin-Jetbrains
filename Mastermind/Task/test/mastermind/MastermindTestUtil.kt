package mastermind

import org.junit.Assert

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

internal fun testEvaluation(first: String, second: String, positions: Int, letters: Int) {
    val evaluation = Evaluation(positions, letters)
    testEvaluationOneWay(secret = first, guess = second, expected = evaluation)
    testEvaluationOneWay(guess = second, secret = first, expected = evaluation)
}

internal fun testEvaluationOneWay(secret: String, guess: String, expected: Evaluation) {
    val evaluation = evaluateGuess(secret, guess)
    Assert.assertEquals("Wrong evaluation for secret=$secret, guess=$guess",
            expected, evaluation)
}
