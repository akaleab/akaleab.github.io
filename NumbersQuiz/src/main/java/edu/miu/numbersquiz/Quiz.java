package edu.miu.numbersquiz;

public class Quiz {
    private static String[] questions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 4, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };
    private static int[] answers = {9, 8, 36, 13, 32};
    private int index;  // which question are you in?
    private int score; // how much did the user score?

    public int getNumQuestions() {return questions.length;}

    public int getNumCorrect () {
        return score;
    }

    public int getCurrentQuestionIndex () {
        return index;
    }

    public void scoreAnswer () {
        index++;
        score++;
    }

    public String getCurrentQuestion () {
        return questions[index];
    }

    public int getCurrentAnswer () {
        return answers[index];
    }

    public boolean isCorrect(String attempt) {
        if (index >= answers.length) return false;
        return String.valueOf(answers[index]).equals(attempt);
    }
}
