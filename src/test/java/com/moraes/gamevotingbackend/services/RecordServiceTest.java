package com.moraes.gamevotingbackend.services;

import com.moraes.gamevotingbackend.builders.dto.RecordDTOBuilder;
import com.moraes.gamevotingbackend.builders.dto.RecordPostDTOBuilder;
import com.moraes.gamevotingbackend.builders.entities.GameBuilder;
import com.moraes.gamevotingbackend.builders.entities.RecordBuilder;
import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.dto.RecordPostDTO;
import com.moraes.gamevotingbackend.models.Record;
import com.moraes.gamevotingbackend.repositories.GameRepository;
import com.moraes.gamevotingbackend.repositories.RecordRepository;
import com.moraes.gamevotingbackend.services.implementations.RecordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecordServiceTest {

    @Mock
    private RecordRepository repository;

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private RecordServiceImpl service;

    private RecordDTOBuilder recordDTOBuilder;

    private RecordPostDTOBuilder recordPostDTOBuilder;

    private RecordBuilder recordBuilder;

    private GameBuilder gameBuilder;

    @BeforeEach
    void setUp() {
        recordDTOBuilder = RecordDTOBuilder.builder().build();
        recordPostDTOBuilder = RecordPostDTOBuilder.builder().build();
        recordBuilder = RecordBuilder.builder().build();
        gameBuilder = GameBuilder.builder().build();
    }

    @Test
    void whenValidRecordPostDTOIsGivenThenRecordDTOShouldBeReturned() {
        RecordDTO expectedRecordDTO = recordDTOBuilder.buildRecordDTO();
        RecordPostDTO recordPostDTO = recordPostDTOBuilder.buildRecordPostDTO();
        Record record = new Record();

        when(gameRepository.getOne(recordPostDTO.getGameId())).thenReturn(gameBuilder.buildGame());
        when(repository.save(record)).thenReturn(recordBuilder.buildRecord());

        RecordDTO recordDTOCreated = service.save(recordPostDTO);

        assertEquals(expectedRecordDTO.getId(), recordDTOCreated.getId());
        assertEquals(expectedRecordDTO.getName(), recordDTOCreated.getName());
        assertEquals(expectedRecordDTO.getAge(), recordDTOCreated.getAge());
        assertEquals(expectedRecordDTO.getGameTitle(), recordDTOCreated.getGameTitle());
        assertEquals(expectedRecordDTO.getGamePlatform(), recordDTOCreated.getGamePlatform());
        assertEquals(expectedRecordDTO.getGenreName(), recordDTOCreated.getGenreName());
    }

    @Test
    void whenFindByMomentIsCalledThenRecordDTOPageableShouldBeReturned() {
        Record expectedRecord = recordBuilder.buildRecord();
        Instant minDate = Instant.MIN;
        Instant maxDate = Instant.MAX;
        PageRequest pageRequest = PageRequest.of(0, 1);
        Page<Record> recordPage = new PageImpl<>(Collections.singletonList(expectedRecord), pageRequest, 1);

        when(repository.findByMoment(minDate, maxDate, pageRequest)).thenReturn(recordPage);

        Page<RecordDTO> recordDTOPageCreated = service.findByMoment(minDate, maxDate, pageRequest);

        assertEquals(1L, recordDTOPageCreated.getTotalElements());
        assertEquals(expectedRecord.getId(), recordDTOPageCreated.get().findFirst().get().getId());
        assertEquals(expectedRecord.getName(), recordDTOPageCreated.get().findFirst().get().getName());
        assertEquals(expectedRecord.getAge(), recordDTOPageCreated.get().findFirst().get().getAge());
        assertEquals(expectedRecord.getGame().getTitle(), recordDTOPageCreated.get().findFirst().get().getGameTitle());
        assertEquals(expectedRecord.getGame().getPlatform(), recordDTOPageCreated.get().findFirst().get().getGamePlatform());
        assertEquals(expectedRecord.getGame().getGenre().getName(), recordDTOPageCreated.get().findFirst().get().getGenreName());

    }

}
