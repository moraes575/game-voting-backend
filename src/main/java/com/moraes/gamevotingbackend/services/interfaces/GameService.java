package com.moraes.gamevotingbackend.services.interfaces;

import com.moraes.gamevotingbackend.dto.GameDTO;

import java.util.List;

public interface GameService {

    List<GameDTO> findAll();

}
