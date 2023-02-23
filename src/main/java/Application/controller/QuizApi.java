
package Application.controller;


import Application.model.dto.AnswerDto;
import Application.model.dto.PlayerDTO;
import Application.model.dto.QuestionDTO;
import Application.model.entity.Player;
import Application.model.mapper.AnswerMapper;
import Application.model.mapper.QuestionMapper;
import Application.service.QuestionsStore;
import Application.model.entity.Answer;
import Application.model.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class QuizApi {

    @Autowired
    QuestionsStore store;


    @GetMapping("questions")
    public List<Question> getQuestions() {
        return store.getQuestions();
    }

    @GetMapping("question/{questionId}")
    public Question getQuestions(@PathVariable("questionId") Long id) {
        return store.getQuestionById(id);
    }

    @GetMapping("players")
    public List<PlayerDTO> getAllPlayer(){return store.getPlayerDTO();}

    @GetMapping("score")
    public List<PlayerDTO> getScore(){return store.getPlayerDTOByScore();}

    @GetMapping("player/{playerId}")
    public PlayerDTO getPlayer(@PathVariable("playeurId") Long id){return store.getPlayerDTOById(id);}

    @GetMapping("question/{questionId}/answer/{answerId}")
    public ResponseEntity validate(@PathVariable("questionId") Long questionId,
                                   @PathVariable("answerId") Long answerId) {
        Question question = store.getQuestionById(questionId);
        Answer answer = store.getAnswerById(answerId);
        if (!question.getId().equals(answer.getQuestion().getId())) {
            return ResponseEntity.status(404).build();
        }
        boolean win = answer.isCorrectAnswer();
        if(win){
            return ResponseEntity.status(200).body("Bravo");
        }
        return ResponseEntity.status(200).body("Perdu");
    }


    @PostMapping("addquestion")
    public void addQuestion(@RequestBody Question question){
        store.addQuestion(question);
    }
    @PostMapping("addanswers")
    public void addAnswers(@RequestBody List<AnswerDto>answersdto){
        store.addAnswer(AnswerMapper.convertToAnswer(answersdto));
    }
    @PostMapping("addplayer")
    public void addPlayer(@RequestBody Player player){
        store.addPlayer(player);
    }

    @DeleteMapping("question/{id}")
    public void deleteQuestion(@PathVariable("id")Long id){
        store.deleteQuestion(id);
    }

    @DeleteMapping("answer/{id}")
    public void deleteAnswser(@PathVariable("id")Long id){
        store.deleteAnswer(id);
    }
    @PutMapping("question/{id}")
    public void updateQuestion(@RequestBody Question question,@PathVariable("id")Long id){
        store.updateQuestion(question,id);
    }
    @PutMapping("answer/{id}")
    public void updateAnswer(@RequestBody Answer answer,@PathVariable("id")Long id){
        store.updateAnswer(answer,id);
    }
    @PostMapping("addquestionanswers")
    public void addQuestionAndAnswers(@RequestBody QuestionDTO questionDTO){
        store.addQuestionAndAnswers(QuestionMapper.convertToQuestion(questionDTO));
    }
    @PatchMapping("patchquestion/{id}")
    public void updateQuestionOrAnswers(@RequestBody Question question, @PathVariable("id") Long id){
        store.patchQuestionAndAnswers(question,id);
    }
@GetMapping("question/{questionId}/answer/{answerId}/player/{playerId}")
public ResponseEntity gamePlayer(@PathVariable("questionId") Long questionId,
                               @PathVariable("answerId") Long answerId,@PathVariable("playerId")Long playerId) {
    Question question = store.getQuestionById(questionId);
    Answer answer = store.getAnswerById(answerId);
    Player player = store.getPlayerById(playerId);
    store.playerPlay(question,answer,player);
    if (!question.getId().equals(answer.getQuestion().getId())) {
        return ResponseEntity.status(404).build();
    }
    boolean win = answer.isCorrectAnswer();
    if(win){
        return ResponseEntity.status(200).body("Bravo");
    }
    return ResponseEntity.status(200).body("Perdu");
}

}
