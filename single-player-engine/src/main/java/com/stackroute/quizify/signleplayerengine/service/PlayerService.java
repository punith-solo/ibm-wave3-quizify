package com.stackroute.quizify.signleplayerengine.service;

import com.stackroute.quizify.signleplayerengine.domain.Game;
import com.stackroute.quizify.signleplayerengine.domain.GameUserHistory;
import com.stackroute.quizify.signleplayerengine.domain.SinglePlayer;
import com.stackroute.quizify.signleplayerengine.domain.User;
import com.stackroute.quizify.signleplayerengine.exception.GamePlayerAlreadyExistsException;

import java.util.Optional;

public interface PlayerService {

    SinglePlayer saveGameHistory(SinglePlayer singlePlayer) throws GamePlayerAlreadyExistsException;



}
