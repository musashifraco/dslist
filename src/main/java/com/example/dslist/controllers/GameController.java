package com.example.dslist.controllers;

import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    public GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable(value = "id") Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }



}
