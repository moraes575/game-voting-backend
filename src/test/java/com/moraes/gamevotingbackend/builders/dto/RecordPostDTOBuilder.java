package com.moraes.gamevotingbackend.builders.dto;

import com.moraes.gamevotingbackend.dto.RecordPostDTO;
import lombok.Builder;

@Builder
public class RecordPostDTOBuilder {

    @Builder.Default
    private final String name = "Matheus Moraes";

    @Builder.Default
    private final Integer age = 17;

    @Builder.Default
    private final Long gameId = 1L;

    public RecordPostDTO buildRecordPostDTO() {
        return new RecordPostDTO(name, age, gameId);
    }

}
