package com.moraes.gamevotingbackend.services.interfaces;

import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.dto.RecordPostDTO;

public interface RecordService {

    RecordDTO save(RecordPostDTO recordPostDTO);

}
