package Application.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
//@Getter
//@Setter
//@ToString
//@Builder
@Table(name = "answers")
//@NoArgsConstructor
//@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;

       @ManyToOne
       @JoinColumn(name = "id_question")
       @JsonIgnore
        private Question question;

        @Column(name = "correct_answer")
        private Boolean correctAnswer;

        public Answer() {
        }

        public Answer(String title, Boolean correctAnswer) {
            this.title = title;
            this.correctAnswer = correctAnswer;
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

