package Application.controller;

public class MelangeIDPlay {
    private Long player;
    private Long question;
    private Long answer;

    public MelangeIDPlay(Long player, Long question, Long answer) {
        this.player = player;
        this.question = question;
        this.answer = answer;
    }
    public MelangeIDPlay() {
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public Long getQuestion() {
        return question;
    }

    public void setQuestion(Long question) {
        this.question = question;
    }

    public Long getAnswer() {
        return answer;
    }

    public void setAnswer(Long answer) {
        this.answer = answer;
    }
}
