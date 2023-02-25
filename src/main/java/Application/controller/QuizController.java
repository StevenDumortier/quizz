package Application.controller;


import Application.model.dto.*;
import Application.model.entity.Answer;
import Application.model.entity.Player;
import Application.model.entity.Question;
import Application.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuizController {

    private QuestionService questionService;

    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("questions")
    public List<QuestionDto> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("question/{questionId}")
    public Question getQuestions(@PathVariable("questionId") Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("players")
    public List<PlayerDTO> getAllPlayer() {
        return questionService.getPlayerDTO();
    }

    @GetMapping("score")
    public List<PlayerDTO> getScore() {
        return questionService.getPlayerDTOByScore();
    }

    @GetMapping("player/{playerId}")
    public PlayerDTO getPlayer(@PathVariable("playeurId") Long id) {
        return questionService.getPlayerDTOById(id);
    }

    @GetMapping("question/{questionId}/answer/{answerId}")
    public ResponseEntity validate(@PathVariable("questionId") Long questionId,
                                   @PathVariable("answerId") Long answerId) {
        Question question = questionService.getQuestionById(questionId);
        Answer answer = questionService.getAnswerById(answerId);
        if (!question.getId().equals(answer.getQuestion().getId())) {
            return ResponseEntity.status(404).build();
        }
        boolean win = answer.isCorrectAnswer();
        if (win) {
            return ResponseEntity.status(200).body("Bravo");
        }
        return ResponseEntity.status(200).body("Perdu");
    }


    @PostMapping("addquestion")
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @PostMapping("addanswers")
    public void addAnswers(@RequestBody List<AnswerDto> answersdto) {
        questionService.addAnswer(AnswerMapper.convertToAnswer(answersdto));
    }

    @PostMapping("addplayer")
    public void addPlayer(@RequestBody Player player) {
        questionService.addPlayer(player);
    }

    @DeleteMapping("question/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }

    @DeleteMapping("answer/{id}")
    public void deleteAnswser(@PathVariable("id") Long id) {
        questionService.deleteAnswer(id);
    }

    @PutMapping("question/{id}")
    public void updateQuestion(@RequestBody Question question, @PathVariable("id") Long id) {
        questionService.updateQuestion(question, id);
    }

    @PutMapping("answer/{id}")
    public void updateAnswer(@RequestBody Answer answer, @PathVariable("id") Long id) {
        questionService.updateAnswer(answer, id);
    }

    @PostMapping("addquestionanswers")
    public void addQuestionAndAnswers(@RequestBody QuestionDto questionDTO) {
        questionService.addQuestionAndAnswers(QuestionMapper.INSTANCE.mapToQuestion(questionDTO));
    }

    @PatchMapping("patchquestion/{id}")
    public void updateQuestionOrAnswers(@RequestBody Question question, @PathVariable("id") Long id) {
        questionService.patchQuestionAndAnswers(question, id);
    }

    @GetMapping("question/{questionId}/answer/{answerId}/player/{playerId}")
    public ResponseEntity gamePlayer(@PathVariable("questionId") Long questionId,
                                     @PathVariable("answerId") Long answerId, @PathVariable("playerId") Long playerId) {
        Question question = questionService.getQuestionById(questionId);
        Answer answer = questionService.getAnswerById(answerId);
        Player player = questionService.getPlayerById(playerId);
        questionService.playerPlay(question, answer, player);
        if (!question.getId().equals(answer.getQuestion().getId())) {
            return ResponseEntity.status(404).build();
        }
        boolean win = answer.isCorrectAnswer();
        if (win) {
            return ResponseEntity.status(200).body("Bravo");
        }
        return ResponseEntity.status(200).body("Perdu");
    }

}
