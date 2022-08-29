package edu.miu.numbersquiz;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {

    private static final String SESSION_NAME = "quiz";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        quizLogic(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        quizLogic(request, response);
    }

    private void quizLogic (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Quiz quiz = (Quiz) session.getAttribute(SESSION_NAME);
        boolean error = false; // The user is right until now.
        if (quiz == null) {
            // If this is the first time you're attempting the quiz.
            quiz = new Quiz();
            genQuizPage(quiz, out, error);
            session.setAttribute(SESSION_NAME, quiz);
        }
        else if (quiz.getNumQuestions() > quiz.getCurrentQuestionIndex()) {
            String attemptedAnswer = request.getParameter("txtAnswer");
            error = String.valueOf(quiz.getCurrentAnswer()).equals(attemptedAnswer);
            if (!error) quiz.scoreAnswer();
            genQuizPage(quiz, out, error);
        }
        else {
            genQuizOverPage(out);
            session.setAttribute(SESSION_NAME, null);
        }
    }

    private void genQuizPage(Quiz sessQuiz, PrintWriter out, boolean error) {

        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(sessQuiz.getCurrentQuestion() + "</p>");

        out.print("<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (String.valueOf(sessQuiz.getCurrentAnswer()) != null)) {
            //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

        out.print("</form>");
        out.print("</body></html>");
    }

    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
        out.print("<head >");
        out.print("<title>NumberQuiz is over</title> ");
        out.print("</head> ");
        out.print("<body> ");
        out.print("<p style='color:red'>The number quiz is over!</p>	</body> ");
        out.print("</html> ");
    }

    public void destroy() {
    }
}