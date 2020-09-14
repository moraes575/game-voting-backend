package com.moraes.gamevotingbackend.services.implementations;

import com.moraes.gamevotingbackend.dto.GameDTO;
import com.moraes.gamevotingbackend.repositories.GameRepository;
import com.moraes.gamevotingbackend.services.interfaces.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        return repository.findAll()
                .stream().map(GameDTO::new)
                .collect(Collectors.toList());
    }

}
