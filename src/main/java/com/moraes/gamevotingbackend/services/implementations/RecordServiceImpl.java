package com.moraes.gamevotingbackend.services.implementations;

import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.dto.RecordPostDTO;
import com.moraes.gamevotingbackend.models.Game;
import com.moraes.gamevotingbackend.models.Record;
import com.moraes.gamevotingbackend.repositories.GameRepository;
import com.moraes.gamevotingbackend.repositories.RecordRepository;
import com.moraes.gamevotingbackend.services.interfaces.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@AllArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository repository;
    private final GameRepository gameRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest) {
        return repository.findByMoment(minDate, maxDate, pageRequest)
                .map(RecordDTO::new);
    }

    @Override
    @Transactional
    public RecordDTO save(RecordPostDTO recordPostDTO) {
        Record record = new Record();
        record.setName(recordPostDTO.getName());
        record.setAge(recordPostDTO.getAge());
        record.setMoment(Instant.now());

        Game game = gameRepository.getOne(recordPostDTO.getGameId());
        record.setGame(game);

        return new RecordDTO(repository.save(record));
    }

}
