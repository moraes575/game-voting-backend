package com.moraes.gamevotingbackend.controllers;

import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.dto.RecordPostDTO;
import com.moraes.gamevotingbackend.services.interfaces.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService service;

    @PostMapping
    public ResponseEntity<RecordDTO> save(@RequestBody RecordPostDTO recordPostDTO) {
        RecordDTO recordDTO = service.save(recordPostDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(recordDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(recordDTO);
    }

}
