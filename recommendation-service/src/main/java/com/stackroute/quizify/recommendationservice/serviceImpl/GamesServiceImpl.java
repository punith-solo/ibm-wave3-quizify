package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Category;
import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.domain.Topic;
import com.stackroute.quizify.recommendationservice.repository.GamesRepository;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GamesServiceImpl implements GamesService {

    GamesRepository gamesRepository;

    @Autowired
    private GameIsATopicService gameIsATopicService;

    @Autowired
    private GameTypeOfGenreService gameTypeOfGenreService;
    @Autowired
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Game> getAll() {
        return gamesRepository.getAllNodes();
    }

    @Override
    public Game getone(long gamesId) {
        return gamesRepository.getNode(gamesId);
    }

    @Override
    public Game create(Game game) {
        long id= game.getId();
        String name= game.getName();
        String level= game.getLevel();
        String imageUrl= game.getImageUrl();
        int numOfQuestion= game.getNumOfQuestion();
        int timeDuration= game.getTimeDuration();
        int liked= game.getLiked();
        List<String> rules= game.getRules();
        int playcount= game.getPlayCount();
        int pointPerQuestion=game.getPointPerQuestion();
        int totalPoints=game.getTotalPoints();
        int playerScore=game.getPlayerScore();
//        Category category=game.getCategory();
//        Topic topic=game.getTopic();
//        Genre genre=game.getGenre();
        Game game1 =gamesRepository.createNode(id,name,playcount,level,imageUrl,numOfQuestion,timeDuration,liked,rules,pointPerQuestion,totalPoints,playerScore); //,category,topic,genre
        gameIsATopicService.createRelationship(game);
        gameTypeOfGenreService.createRelationship(game);
        return game1;
    }

    @Override
    public Game delete(long gamesId) {
        return gamesRepository.deleteNode(gamesId);
    }

    @Override
    public Game update(Game game) {
        long id= game.getId();
        String name= game.getName();
        return gamesRepository.updateNode(id,name);
    }

    @Override
    public List<Game> getMostPlayed() {
        return gamesRepository.getMostPlayed();

    }

    @Override
    public List<Game> getAllRelatedGamesOfAGenre(long genreId) {
        return gamesRepository.getAllRelatedGamesOfAGenre(genreId);
    }

    @Override
    public List<Game> getAllRelatedGamesOfAGenreByName(String genreName) {
        return gamesRepository.getAllRelatedGamesOfAGenreByName(genreName);
    }

    @Override
    public List<Game> getAllRelatedGamesOfATopic(long topicId) {
        return gamesRepository.getAllRelatedGamesOfATopic(topicId);
    }

    @Override
    public List<Game> getAllRelatedGamesOfATopicByName(String topicName) {
        return gamesRepository.getAllRelatedGamesOfATopicByName(topicName);
    }

    @Override
    public List<Game> getAllGamesPlayedByAUser(long userId) {
        return gamesRepository.getAllGamesPlayedByAUser(userId);
    }

    @Override
    public List<Game> getAllGamesPlayedByAUserName(String userName) {
        return gamesRepository.getAllGamesPlayedByAUserName(userName);
    }

    @Override
    public List<Game> getAllGamesLikedByAUserName(String userName) {
        return gamesRepository.getAllGamesLikedByAUserName(userName);
    }

    @Override
    public List<Game> getAllGamesLikedByAUser(long userId) {
        return gamesRepository.getAllGamesLikedByAUser(userId);
    }

    @Override
    public List<Game> getAllGamesByLevel(String level,int playerScore, int totalPoints) {
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^ playerscore: "+playerScore +"  totalpoints: "+totalPoints+"  level:" +level);
        double checkPoint=playerScore*100/totalPoints;
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ checkpoint:  "+checkPoint+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        log.info("level:   easy?=> "+(level.equalsIgnoreCase("easy"))+"  medium?? =>" +(level.equalsIgnoreCase("medium")) + "hard?? =>"+(level=="hard"));
        if(checkPoint>=75){

            if(level.equalsIgnoreCase("easy")) {
                log.info("checkpoint >75 and level easy ..... so recommend medium");
                return gamesRepository.getAllGamesByLevel("medium");
            }
            else {
                log.info("checkpoint >75 and level medium,hard ..... so recommend hard");
                return gamesRepository.getAllGamesByLevel("hard");
            }
        }
        else if(checkPoint>=40 && checkPoint<75)
        {
            if(level.equalsIgnoreCase("easy")) {
                log.info("checkpoint 40-75 and level easy ..... so recommend easy");
                return gamesRepository.getAllGamesByLevel("easy");
            }
            else if(level.equalsIgnoreCase("medium")){
                log.info("checkpoint 40-75 and level medium ..... so recommend medium");
                return gamesRepository.getAllGamesByLevel("medium");
            }
            else{
                log.info("checkpoint 40-75 and level hard ..... so recommend hard");
                return gamesRepository.getAllGamesByLevel("hard");
            }
        }
        else{
            if(level.equalsIgnoreCase("hard")) {
                log.info("checkpoint <40 and level hard ..... so recommend medium");
                return gamesRepository.getAllGamesByLevel("medium");
            }
            else{ // (level=="medium" || level=="easy")
                log.info("checkpoint <40 and level medium,easy ..... so recommend easy");
                return gamesRepository.getAllGamesByLevel("easy");
            }
        }
    }
}
