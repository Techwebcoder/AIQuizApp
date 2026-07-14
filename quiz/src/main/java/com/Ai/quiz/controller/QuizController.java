package com.Ai.quiz.controller;

import com.Ai.quiz.entity.Question;
import com.Ai.quiz.service.QuizService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Ai.quiz.model.Result;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

    private final QuizService quizService;

    private List<Question> quiz;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String home() {

        return "index";

    }

    @PostMapping("/quiz")
    public String generateQuiz(@RequestParam String topic,
                               Model model) {

        quiz = quizService.generateQuiz(topic);

        model.addAttribute("questions", quiz);

        return "quiz";

    }

    @PostMapping("/submit")
    public String submit(HttpServletRequest request, Model model) {

        int score = 0;

        List<Result> wrongAnswers = new ArrayList<>();

        for (int i = 0; i < quiz.size(); i++) {

            Question q = quiz.get(i);

            String user = request.getParameter("q" + i);

            if (user != null && user.equals(q.getAnswer())) {

                score++;

            } else {

                String userOption = "Not Answered";

                if ("A".equals(user))
                    userOption = q.getOptionA();

                else if ("B".equals(user))
                    userOption = q.getOptionB();

                else if ("C".equals(user))
                    userOption = q.getOptionC();

                else if ("D".equals(user))
                    userOption = q.getOptionD();

                String correctOption = "";

                switch (q.getAnswer()) {

                    case "A":
                        correctOption = q.getOptionA();
                        break;

                    case "B":
                        correctOption = q.getOptionB();
                        break;

                    case "C":
                        correctOption = q.getOptionC();
                        break;

                    case "D":
                        correctOption = q.getOptionD();
                        break;
                }

                wrongAnswers.add(new Result(

                        q.getQuestion(),

                        userOption,

                        correctOption,

                        q.getReason()

                ));

            }

        }

        double percentage = score * 100.0 / quiz.size();

        model.addAttribute("score", score);
        model.addAttribute("total", quiz.size());
        model.addAttribute("percentage", percentage);
        model.addAttribute("wrongAnswers", wrongAnswers);

        return "result";
    }

}