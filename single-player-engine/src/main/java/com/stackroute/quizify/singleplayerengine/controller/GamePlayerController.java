package com.stackroute.quizify.singleplayerengine.controller;



import com.stackroute.quizify.singleplayerengine.domain.Game;

import com.stackroute.quizify.singleplayerengine.domain.SinglePlayer;

import com.stackroute.quizify.singleplayerengine.service.PlayerService;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;



@CrossOrigin

@RestController

@RequestMapping("/api/v1")

@Api(description="Single Player Service")

@Slf4j

public class GamePlayerController {



    private PlayerService playerService;

    private ResponseEntity<?> responseEntity;

    RestTemplate restTemplate;

    SinglePlayer singlePlayer;



    @Autowired
    public GamePlayerController(PlayerService playerService)

    {
        restTemplate=new RestTemplate();
        singlePlayer = new SinglePlayer();

        this.playerService = playerService;

    }



    @ApiOperation(value = "Get User Game")
    @GetMapping(value = "/singlePlayer/{playerName}/game/{id}")
    public ResponseEntity<?> getGame(@PathVariable String playerName , @PathVariable long id)
    {

        String url = "http://0.0.0.0:8102/api/v1/games/game/" +id;

        Game game = restTemplate.getForObject(url, Game.class);

        if(game.getQuestions() == null)
            return new ResponseEntity<String>("Game Is Not Ready Yet !",HttpStatus.NOT_FOUND);
        else
        {
            singlePlayer.setGame(game);
            singlePlayer.setPlayerName(playerName);
            return new ResponseEntity<SinglePlayer>(singlePlayer,HttpStatus.OK);
        }
    }



    @ApiOperation(value = "send User Game")
    @PostMapping(value = "/singlePlayer")
    public ResponseEntity<?> postGame(@RequestBody SinglePlayer singlePlayer)
    {
        return new ResponseEntity<SinglePlayer>(this.playerService.sendSinglePlayer(singlePlayer), HttpStatus.OK);

    }

}