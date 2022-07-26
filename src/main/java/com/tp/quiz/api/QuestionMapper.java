package com.tp.quiz.api;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapper {

        public static QuestionDTO convertToDTO(Question question){
                QuestionDTO dto = new QuestionDTO();
                dto.setId(question.getId());
                dto.setAnswers(AnswerMapper.convertToDTO(question.getAnswers()));
                dto.setTitle(question.getTitle());
                return dto;
            }

        public static Question convertToQuestion(QuestionDTO questionDTO){

                Question question = new Question();

                question.setId(questionDTO.getId());
                question.setAnswers(AnswerMapper.convertToAnswer(questionDTO.getAnswersDTO()));
                question.setTitle(questionDTO.getTitle());
            return question;
            }

        }



