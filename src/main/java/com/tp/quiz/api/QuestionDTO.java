package com.tp.quiz.api;

import com.tp.quiz.business.Answer;

import java.util.List;

public class QuestionDTO {

        private Long id;
        private String title;
        private List<AnswerDTO> answersDTO;


        public QuestionDTO() {
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<AnswerDTO> getAnswersDTO() {
            return answersDTO;
        }

        public void setAnswers(List<AnswerDTO> answersDTO) {
            this.answersDTO = answersDTO;
        }

        public void addAnswer(AnswerDTO answerDTO){
            answersDTO.add(answerDTO);
        }

        @Override
        public String toString() {
            return "Question{" + "id=" + id + ", title=" + title + ", answersDTO=" + answersDTO + '}';
        }



    }


