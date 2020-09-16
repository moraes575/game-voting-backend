package com.moraes.gamevotingbackend.builders.dto;

import com.moraes.gamevotingbackend.dto.GameDTO;
import com.moraes.gamevotingbackend.models.enums.Platform;
import lombok.Builder;

@Builder
public class GameDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String title = "Gears of War";

    @Builder.Default
    private final Platform platform = Platform.XBOX;

    public GameDTO buildGameDTO() {
        return new GameDTO(id, title, platform);
    }

}
