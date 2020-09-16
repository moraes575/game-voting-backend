package com.moraes.gamevotingbackend.builders.dto;

import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.models.enums.Platform;
import lombok.Builder;

import java.time.Instant;

@Builder
public class RecordDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final Instant moment = Instant.now();

    @Builder.Default
    private final String name = "Matheus Moraes";

    @Builder.Default
    private final Integer age = 17;

    @Builder.Default
    private final String gameTitle = "Gears of War";

    @Builder.Default
    private final Platform gamePlatform = Platform.XBOX;

    @Builder.Default
    private final String genreName = "Action";

    public RecordDTO buildRecordDTO() {
        return new RecordDTO(id, moment, name, age, gameTitle, gamePlatform, genreName);
    }

}
