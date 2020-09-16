package com.moraes.gamevotingbackend.builders.entities;

import com.moraes.gamevotingbackend.models.Game;
import com.moraes.gamevotingbackend.models.Genre;
import lombok.Builder;
import lombok.Singular;

import java.util.HashSet;
import java.util.Set;

@Builder
public class GenreBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Action";

    @Singular
    private final Set<Game> games = new HashSet<>();

    public Genre buildGenre() {
        return new Genre(id, name, games);
    }

}
