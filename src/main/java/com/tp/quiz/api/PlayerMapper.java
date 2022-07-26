package com.tp.quiz.api;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerMapper {


    public static PlayerDTO convertToPlayerDTO(Player player){

         PlayerDTO dto = new PlayerDTO();
            dto.setPartieGagne(player.getScore());
            dto.setPartieJoue(player.getPartie());
            dto.setName(player.getName());

        return dto;
    }
}
