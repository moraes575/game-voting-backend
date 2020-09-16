package com.moraes.gamevotingbackend.services.interfaces;

import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.dto.RecordPostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;

public interface RecordService {

    Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest);

    RecordDTO save(RecordPostDTO recordPostDTO);

}
