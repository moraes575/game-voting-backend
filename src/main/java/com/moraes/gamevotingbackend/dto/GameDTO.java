package com.moraes.gamevotingbackend.dto;

import com.moraes.gamevotingbackend.models.Game;
import com.moraes.gamevotingbackend.models.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDTO {

    private Long id;
    private String title;
    private Platform platform;

    public GameDTO(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.platform = game.getPlatform();
    }

}
