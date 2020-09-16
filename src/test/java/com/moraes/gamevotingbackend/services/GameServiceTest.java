package com.moraes.gamevotingbackend.services;

import com.moraes.gamevotingbackend.builders.dto.GameDTOBuilder;
import com.moraes.gamevotingbackend.builders.entities.GameBuilder;
import com.moraes.gamevotingbackend.dto.GameDTO;
import com.moraes.gamevotingbackend.models.Game;
import com.moraes.gamevotingbackend.repositories.GameRepository;
import com.moraes.gamevotingbackend.services.implementations.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GameRepository repository;

    @InjectMocks
    private GameServiceImpl service;

    private GameDTOBuilder gameDTOBuilder;

    private GameBuilder gameBuilder;

    @BeforeEach
    void setUp() {
        gameDTOBuilder = GameDTOBuilder.builder().build();
        gameBuilder = GameBuilder.builder().build();
    }

    @Test
    void whenFindAllIsCalledThenItShouldReturnAllDTOGames() {
        GameDTO expectedGameDTO = gameDTOBuilder.buildGameDTO();
        Game game = gameBuilder.buildGame();

        when(repository.findAll()).thenReturn(Collections.singletonList(game));

        List<GameDTO> gameDTOList = service.findAll();

        assertEquals(1, gameDTOList.size());
        assertEquals(expectedGameDTO, gameDTOList.get(0));

    }

}
