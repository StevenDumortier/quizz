package com.tp.quiz.api;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Player;
import com.tp.quiz.business.Question;
import com.tp.quiz.business.QuestionsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class QuizController {
    @Autowired
    QuestionsStore store;

    @GetMapping("/questions")
    public String question(Model model) {

        model.addAttribute("questions", store.getQuestions());

        return "affichagequestion.html";
    }

    @GetMapping("/randomquestion")
    public String randomQuestion(Model model) {

        model.addAttribute("questions", store.getRandomQuestion());

        return "affichagequestion.html";
    }

    @GetMapping("/classement")
    public String classement(Model model) {
        model.addAttribute("joueurs", store.getPlayerDTOByScore());
        return "affichageclassement.html";
    }

    @GetMapping("/play")
    public String gamePlayer(Question questionRandom, Model model1, Model model2, Model model3) {
        model1.addAttribute("players", store.getPlayerDTOByScore());
        questionRandom = store.getRandomQuestion();
        model2.addAttribute("question", questionRandom);
        model3.addAttribute("answers", questionRandom.getAnswers());

        return "jouer.html";
    }
    @PostMapping("/play")
            public String envoieGamePlayer(MelangeIDPlay melangeIDPlay, Model model, Model model1){
        Question question = store.getQuestionById(melangeIDPlay.getQuestion());
        Answer answer = store.getAnswerById(melangeIDPlay.getAnswer());
        Player player = store.getPlayerById(melangeIDPlay.getPlayer());
        store.playerPlay(question, answer, player);
        model.addAttribute("joueurs", store.getPlayerDTOByScore());
        model1.addAttribute("isWin", answer.isCorrectAnswer());
        return "affichageclassement.html";
    }

    @GetMapping("/addplayer")
    public String addPlayer() {
        return "ajoutplayer.html";
    }

    @PostMapping ("/addplayer")
    public String addPlayer (Player player, Model model){
        store.addPlayer(player);
        model.addAttribute("joueurs", store.getPlayerDTOByScore());
        return "affichageclassement.html";




    }

}
