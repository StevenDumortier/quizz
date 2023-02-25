package Application.model.dto;

import Application.model.entity.Answer;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionDto {

    private String title;

    private String answer1;
    private String answer2;
    private String answer3;

    private Answer answer11;
    private Answer answer22;
    private Answer answer33;


    private boolean isWin1;

    private boolean isWin2;

    private boolean isWin3;


    private List<Answer> answers;


//     //*   public QuestionDto() {
//        }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAnswer1() {
//        return answer1;
//    }
//
//    public void setAnswer1(String answer1) {
//        this.answer1 = answer1;
//    }
//
//    public String getAnswer2() {
//        return answer2;
//    }
//
//    public void setAnswer2(String answer2) {
//        this.answer2 = answer2;
//    }
//
//    public String getAnswer3() {
//        return answer3;
//    }
//
//    public void setAnswer3(String answer3) {
//        this.answer3 = answer3;
//    }
//
//    public Answer getAnswer11() {
//        this.answer11.setTitle(this.getAnswer1());
//        this.answer11.setCorrectAnswer(this.isWin1);
//        return this.answer11;
//    }
//
//    public void setAnswer11(Answer answer11) {
//        this.answer11.setTitle(this.getAnswer1());
//        this.answer11.setCorrectAnswer(this.isWin1);
//    }
//
//    public Answer getAnswer22() {
//        this.answer22.setTitle(this.getAnswer2());
//        this.answer22.setCorrectAnswer(this.isWin2);
//        return this.answer22;
//    }
//
//    public void setAnswer22(Answer answer22) {
//        this.answer22.setTitle(this.getAnswer2());
//        this.answer22.setCorrectAnswer(this.isWin2);
//    }
//
//    public Answer getAnswer33() {
//        this.answer33.setTitle(this.getAnswer3());
//        this.answer33.setCorrectAnswer(this.isWin3);
//        return answer33;
//    }
//
//    public void setAnswer33(Answer answer33) {
//        this.answer33.setTitle(this.getAnswer3());
//        this.answer33.setCorrectAnswer(this.isWin3);
//    }
//
//    public boolean isWin1() {
//        return isWin1;
//    }
//
//    public void setWin1(boolean win1) {
//        isWin1 = win1;
//    }
//
//    public boolean isWin2() {
//        return isWin2;
//    }
//
//    public void setWin2(boolean win2) {
//        isWin2 = win2;
//    }
//
//    public boolean isWin3() {
//        return isWin3;
//    }
//
//    public void setWin3(boolean win3) {
//        isWin3 = win3;
//    }
//
//    public List<Answer> getAnswers() {
//        this.answers.add(this.getAnswer11());
////        this.answers.add(this.getAnswer22());
////        this.answers.add(this.getAnswer33());
//        return this.answers;
//    }
//
//    public void setAnswers(List<Answer> answers) {
//        this.answers.add(this.getAnswer11());
////        this.answers.add(this.getAnswer22());
////        this.answers.add(this.getAnswer33());
//        this.answers = answers;
//    }//

//    @Override
//    public String toString() {
//        return "Question{" + "id=" + id + ", title=" + title + ", answers=" + answers + '}';
//    }


}


