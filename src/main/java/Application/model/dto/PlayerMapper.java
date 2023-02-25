package Application.model.dto;

import Application.model.entity.Player;


public interface PlayerMapper {

//    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
//
//    }


    public static PlayerDTO convertToPlayerDTO(Player player) {

        PlayerDTO dto = new PlayerDTO();
        dto.setPartieGagne(player.getScore());
        dto.setPartieJoue(player.getPartie());
        dto.setName(player.getName());
        dto.setId(player.getId());

        return dto;
    }
}
