/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.miu.numbersquiz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @since 4/8/09
 * @author levi
 * JUnit test for the TestQuiz class.  Basic verification tests that all pass as of 4/8/09.
 */
public class TestQuiz {
    Quiz quizUnderTest = new Quiz();

    public TestQuiz() {

    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testIsCorrect() {
        /* should be at first question, answer should be "9" */
        assertTrue(quizUnderTest.isCorrect("9"), "first question answer should be '9'");
        // If answer is right or wrong for the current question....
    }

    @Test
    public void testGetNumberQuestions() {
        /* should be at first question, answer should be 5 */
        assertEquals(5, quizUnderTest.getNumQuestions()); // how many questions are there
    }

    @Test
    public void testGetNumberCorrect() {
        /* should be at first question, answer should be 0 */
        assertEquals(0, quizUnderTest.getNumCorrect());  // Number of correct attempts

        quizUnderTest.scoreAnswer(); //should increment the score and the current question number
        assertEquals(1, quizUnderTest.getNumCorrect());
        assertEquals(1, quizUnderTest.getCurrentQuestionIndex()); // What is the current question index

    }
}