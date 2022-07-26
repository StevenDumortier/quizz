package com.tp.quiz.api;

import com.tp.quiz.business.Question;

public class AnswerDTO {
        private Long id;
        private String title;
        private Question question;
        private boolean correctAnswer;


        public AnswerDTO() {
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

        public boolean isCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(boolean correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }

        @Override
        public String toString() {
            return "Answer{" + "id=" + id + ", title=" + title + ", correctAnswer=" + correctAnswer + '}';
        }

    }



