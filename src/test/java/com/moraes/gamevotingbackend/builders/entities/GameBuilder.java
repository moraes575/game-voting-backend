package com.moraes.gamevotingbackend.builders.entities;

import com.moraes.gamevotingbackend.models.Game;
import com.moraes.gamevotingbackend.models.Genre;
import com.moraes.gamevotingbackend.models.Record;
import com.moraes.gamevotingbackend.models.enums.Platform;
import lombok.Builder;
import lombok.Singular;

import java.util.HashSet;
import java.util.Set;

@Builder
public class GameBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String title = "Gears of War";

    @Builder.Default
    private final Platform platform = Platform.XBOX;

    @Builder.Default
    private final Genre genre = GenreBuilder.builder().build().buildGenre();

    @Singular
    private final Set<Record> records = new HashSet<>();

    public Game buildGame() {
        return new Game(id, title, platform, genre, records);
    }

}
