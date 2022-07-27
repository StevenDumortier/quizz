package com.tp.quiz.business;


import com.tp.quiz.api.PlayerDTO;
import com.tp.quiz.api.PlayerMapper;
import com.tp.quiz.dao.AnswerRepository;
import com.tp.quiz.dao.PlayerRepository;
import com.tp.quiz.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class QuestionsStore implements QuestionsStoreInterface {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    PlayerRepository playerRepository;


    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void addAnswer(List<Answer> answers) {

        for (int i = 0; i < answers.size(); i++) {
            answerRepository.save(answers.get(i));
        }
    }
    public void addPlayer(Player player){
        playerRepository.save(player);
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long idQuestion) {
        return questionRepository.findById(idQuestion).get();
    }

    public Question getRandomQuestion(){return questionRepository.findRandom();}

    public Answer getAnswerById(Long idAnswer) {
        return answerRepository.findById(idAnswer).get();
    }

    public Player getPlayerById(Long idPlayer) {
        return playerRepository.findById(idPlayer).get();
    }
    public PlayerDTO getPlayerDTOById(Long idPlayer) {
        return PlayerMapper.convertToPlayerDTO(playerRepository.findById(idPlayer).get());
    }

    public void deleteQuestion(Long idQuestion) {
        questionRepository.deleteById(idQuestion);
    }

    public void deleteAnswer(Long idAnswer) {
        answerRepository.deleteById(idAnswer);
    }

    public void updateQuestion(Question question,Long idQuestion) {
        question.setId(idQuestion);
        questionRepository.save(question);
    }

    public void updateAnswer(Answer answer, Long idAnswer) {
        answer.setId(idAnswer);
        answerRepository.save(answer);
    }


    public void playerPlay(Question question, Answer answer, Player player) {
        player.game(answer.isCorrectAnswer());
        playerRepository.save(player);
    }

    public void addQuestionAndAnswers(Question question){

        for( int i=0; i<question.getAnswers().size();i++){
          question.getAnswers().get(i).setQuestion(question);
        }
        questionRepository.save(question);
    }

    public List<PlayerDTO> getPlayerDTO() {
        List<PlayerDTO> dtos=new ArrayList<>();
        for (Player player : playerRepository.findAll()){
            dtos.add(PlayerMapper.convertToPlayerDTO(player));}
        return dtos;

    }

    public List<PlayerDTO> getPlayerDTOByScore() {
        List<PlayerDTO> dtos=new ArrayList<PlayerDTO>();
        int classement=0;
        for (Player player : playerRepository.findAllByOrderByScoreDesc()){
            classement++;
            PlayerDTO playerDTO = PlayerMapper.convertToPlayerDTO(player);
            playerDTO.setClassement(classement);
            dtos.add(playerDTO);
        }
        return dtos;

    }
//    public void patchQuestionAndAnswers(Question question, Long id){
//
//        if (question.getId().equals(id)){
//            for( int i=0; i<question.getAnswers().size();i++){
//                question.getAnswers().get(i).setQuestion(question);
//            }
//            questionRepository.save(question);
//        }
//
//        }


}


