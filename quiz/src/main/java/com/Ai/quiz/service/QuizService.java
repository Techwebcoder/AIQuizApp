package com.Ai.quiz.service;

import com.Ai.quiz.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final GroqService groqService;

    public QuizService(GroqService groqService) {
        this.groqService = groqService;
    }

    public List<Question> generateQuiz(String topic) {
        return groqService.generateQuiz(topic);
    }

}