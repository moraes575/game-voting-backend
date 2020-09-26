package com.moraes.gamevotingbackend.controllers;

import com.moraes.gamevotingbackend.dto.GameDTO;
import com.moraes.gamevotingbackend.services.interfaces.GameService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService service;

    @ApiOperation(value = "Find all games")
    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
