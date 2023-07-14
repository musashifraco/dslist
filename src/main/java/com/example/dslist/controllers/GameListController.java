package com.example.dslist.controllers;

import com.example.dslist.dto.GameListDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.dto.ReplacementDTO;
import com.example.dslist.services.GameListService;
import com.example.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    public GameListService gameListService;

    @Autowired
    public GameService gameService;

    @GetMapping()
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable(value = "id") Long id) {
        GameListDTO result = gameListService.findById(id);
        return result;
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable(value = "listId")Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable(value = "listId")Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
