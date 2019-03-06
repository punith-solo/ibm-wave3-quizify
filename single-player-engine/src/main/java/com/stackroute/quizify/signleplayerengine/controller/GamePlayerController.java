package com.stackroute.quizify.signleplayerengine.controller;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.SinglePlayer;
import com.stackroute.quizify.signleplayerengine.service.PlayerService;
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

    RestTemplate restTemplate=new RestTemplate();

    @Autowired
    public GamePlayerController(PlayerService playerService)
    {
        this.playerService = playerService;
    }

    @ApiOperation(value = "Get User Game")
    @GetMapping(value = "/game/{id}")
    public ResponseEntity<?> getGame( @PathVariable long id)
    {

            SinglePlayer singlePlayer = new SinglePlayer();
//            String url = "http://13.232.243.68:8102/api/v1/games/" +id;
//                   singlePlayer.getGame().setId(gameId);

        String url = "http://localhost:8102/api/v1/game/" +id;
        log.info(url);

            Game game = restTemplate.getForObject(url, Game.class);
            log.info(""+game);
            singlePlayer.setGame(game);
            log.info(""+singlePlayer);
            return new ResponseEntity<SinglePlayer>(singlePlayer,HttpStatus.OK);
    }


}
