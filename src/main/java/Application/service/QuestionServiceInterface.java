package Application.service;

import Application.model.dto.QuestionDto;
import Application.model.entity.Answer;
import Application.model.entity.Player;
import Application.model.entity.Question;

import java.util.List;


public interface QuestionServiceInterface {

    public void addQuestion(Question question);

    public void addAnswer(List<Answer> answers);

    public List<QuestionDto> getQuestions();

    public Question getQuestionById(Long idQuestion);

    public Answer getAnswerById(Long idAnswer);

    public void deleteQuestion(Long idQuestion);

    public void deleteAnswer(Long idAnswer);

    public void updateQuestion(Question question, Long idQuestion);

    public void updateAnswer(Answer answer, Long idAnswer);

    public void playerPlay(Question question, Answer answer, Player player);


}
