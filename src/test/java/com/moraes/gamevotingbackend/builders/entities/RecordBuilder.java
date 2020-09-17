package com.moraes.gamevotingbackend.builders.entities;

import com.moraes.gamevotingbackend.models.Game;
import com.moraes.gamevotingbackend.models.Record;
import lombok.Builder;

import java.time.Instant;

@Builder
public class RecordBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Matheus Moraes";

    @Builder.Default
    private final Integer age = 17;

    @Builder.Default
    private final Instant moment = Instant.now();

    @Builder.Default
    private final Game game = GameBuilder.builder().build().buildGame();

    public Record buildRecord() {
        return new Record(id, name, age, moment, game);
    }

}
