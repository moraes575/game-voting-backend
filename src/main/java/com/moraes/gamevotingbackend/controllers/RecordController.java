package com.moraes.gamevotingbackend.controllers;

import com.moraes.gamevotingbackend.dto.RecordDTO;
import com.moraes.gamevotingbackend.dto.RecordPostDTO;
import com.moraes.gamevotingbackend.services.interfaces.RecordService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;

@AllArgsConstructor
@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService service;

    @ApiOperation(value = "Find all records")
    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if (linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok(service.findByMoment(minDate, maxDate, pageRequest));
    }

    @ApiOperation(value = "Save a new record")
    @PostMapping
    public ResponseEntity<RecordDTO> save(@RequestBody RecordPostDTO recordPostDTO) {
        RecordDTO recordDTO = service.save(recordPostDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(recordDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(recordDTO);
    }

}
