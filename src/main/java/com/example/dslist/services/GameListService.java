package com.example.dslist.services;

import com.example.dslist.dto.GameListDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.entities.GameList;
import com.example.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    public GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList result = gameListRepository.findById(id).get();
        GameListDTO dto = new GameListDTO(result);

        return dto;
    }
}
