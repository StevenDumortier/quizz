package com.tp.quiz.api;

import com.tp.quiz.business.Answer;

import java.util.ArrayList;
import java.util.List;

public class AnswerMapper {

    public static List<AnswerDTO> convertToDTO(List<Answer> answers){

        List<AnswerDTO> dtos = new ArrayList<>();
         for(Answer answer : answers){
             AnswerDTO dto = new AnswerDTO();
             dto.setCorrectAnswer(answer.isCorrectAnswer());
             dto.setQuestion(answer.getQuestion());
             dto.setId(answer.getId());
             dto.setTitle(answer.getTitle());
             dtos.add(dto);
         }
        return dtos;
    }
    public static List<Answer> convertToAnswer(List<AnswerDTO> dtos){


        List<Answer> answers = new ArrayList<>();
        for(AnswerDTO dto : dtos) {
            Answer answer = new Answer();
            answer.setQuestion(dto.getQuestion());
            answer.setCorrectAnswer(dto.isCorrectAnswer());
            answer.setTitle(dto.getTitle());
            answer.setId(dto.getId());
            answers.add(answer);
        }
        return answers;
    }
}
