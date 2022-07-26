package com.tp.quiz.business;

import com.tp.quiz.business.Answer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;

        @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL})
        private List<Answer> answers;


        public Question() {
        }

        public Question(String title) {
            this.title = title;
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

        public List<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

        public void addAnswer(Answer answer){
            answers.add(answer);
        }

        @Override
        public String toString() {
            return "Question{" + "id=" + id + ", title=" + title + ", answers=" + answers + '}';
        }






}
