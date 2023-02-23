package Application.model.mapper;

import Application.model.dto.PlayerDTO;
import Application.model.entity.Player;

public class PlayerMapper {


    public static PlayerDTO convertToPlayerDTO(Player player){

         PlayerDTO dto = new PlayerDTO();
            dto.setPartieGagne(player.getScore());
            dto.setPartieJoue(player.getPartie());
            dto.setName(player.getName());
            dto.setId(player.getId());

        return dto;
    }
}
