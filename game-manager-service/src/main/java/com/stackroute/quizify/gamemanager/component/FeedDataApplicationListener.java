package com.stackroute.quizify.gamemanager.component;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.domain.Category;
import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.domain.Genre;
import com.stackroute.quizify.gamemanager.domain.Topic;
import com.stackroute.quizify.gamemanager.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@Slf4j
@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
{
    private GameService gameService;
    private Category entertainment;
    private Category generalKnowledge;
    private Topic movies;
    private Topic tvShows;
    private Topic capitals;
    private Topic presidents;
    private Topic languages;
    private Genre drama;
    private Genre historical;
    private Genre action;
    private Genre thriller;
    private Genre comedy;
    private Genre anime;
    private Genre romance;
    private Genre scifi;
    private Genre documentary;
    private Genre talkshow;
    private Genre gk;
    private Game game;

    private Environment environment;

    private File file;
    private XSSFWorkbook myWorkBook;
    private XSSFSheet mySheet;

    @Autowired
    public FeedDataApplicationListener(Environment environment, GameService gameService) {
        this.environment = environment;
        this.gameService = gameService;
        /**
         * Data For Category
         */
        this.entertainment = new Category();
        this.entertainment.setId(1);
        this.entertainment.setName("Entertainment");
        this.entertainment.setImageUrl("https://mitaanexpress.com/wp-content/uploads/2017/12/336fdcf7d540e4b430a890b63da159c9-1503648561-768x432.png");

        this.generalKnowledge = new Category();
        this.generalKnowledge.setId(2);
        this.generalKnowledge.setName("General Knowledge");
        this.generalKnowledge.setImageUrl("https://www.quizony.com/general-knowledge-quiz/imageForSharing.png");

        /**
         * Data For Topic
         */
        this.movies = new Topic();
        this.movies.setId(1);
        this.movies.setName("Movies");
        this.movies.setImageUrl("https://image.freepik.com/free-vector/cinema-logo_23-2147503279.jpg?1");

        this.tvShows = new Topic();
        this.tvShows.setId(2);
        this.tvShows.setName("TV Shows");
        this.tvShows.setImageUrl("https://tallypress.com/wp-content/uploads/2016/12/9-Popular-TV-shows-with-a-Malaysian-Flavour-1.jpg");

        this.capitals = new Topic();
        this.capitals.setId(3);
        this.capitals.setName("Capitals");
        this.capitals.setImageUrl("https://cdn.shopify.com/s/files/1/0765/0807/products/Screen_Shot_2016-07-14_at_12.35.43_PM_grande.png?v=1532538624");

        this.presidents = new Topic();
        this.presidents.setId(4);
        this.presidents.setName("Presidents");
        this.presidents.setImageUrl("https://i.imgur.com/ZPT1n.png");

        this.languages = new Topic();
        this.languages.setId(5);
        this.languages.setName("Languages");
        this.languages.setImageUrl("https://thumbs.dreamstime.com/b/black-welcome-phrases-different-languages-world-countries-flags-square-illustration-76035959.jpg");

        /**
         * Data For Genre
         */
        this.documentary = new Genre();
        this.documentary.setId(1);
        this.documentary.setName("Documentary");
        this.documentary.setImageUrl("https://www.filmsite.org/images/documentary-genre.jpg");

        this.talkshow = new Genre();
        this.talkshow.setId(2);
        this.talkshow.setName("Reality & Talk Shows");
        this.talkshow.setImageUrl("https://cmkt-image-prd.global.ssl.fastly.net/0.1.0/ps/2661428/580/386/m1/fpnw/wm1/c1-.jpg?1494334679&s=b42e439d379c45825713ec1c3421f902");

        this.action = new Genre();
        this.action.setId(3);
        this.action.setName("Action");
        this.action.setImageUrl("http://bcheights.com/wp-content/uploads/2017/04/isabella-column-online.jpg");

        this.thriller = new Genre();
        this.thriller.setId(4);
        this.thriller.setName("Thriller");
        this.thriller.setImageUrl("https://image.slidesharecdn.com/thrillergenre-141005134450-conversion-gate01/95/thriller-genre-1-638.jpg?cb=1412606265");

        this.comedy = new Genre();
        this.comedy.setId(5);
        this.comedy.setName("Comedy");
        this.comedy.setImageUrl("http://lionhearttheatre.org/wp-content/uploads/2016/01/download-14.jpg");

        this.anime = new Genre();
        this.anime.setId(6);
        this.anime.setName("Anime");
        this.anime.setImageUrl("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/intermediary/f/7d3e695a-edba-4591-84d3-c8fa7896170a/d477hhk-235dfbf8-1fb0-497b-b8d0-49df393ece70.jpg");

        this.romance = new Genre();
        this.romance.setId(7);
        this.romance.setName("Romance");
        this.romance.setImageUrl("https://image.slidesharecdn.com/media-141105104952-conversion-gate02/95/romance-genre-powerpoint-1-638.jpg?cb=1415184629");

        this.drama = new Genre();
        this.drama.setId(8);
        this.drama.setName("Drama");
        this.drama.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMqK5BdSyRyCS8B5zTZ0AC3DYc0P4x2dRKMKLLbDUTGeOQPwDJ0g");

        this.scifi = new Genre();
        this.scifi.setId(9);
        this.scifi.setName("SciFi");
        this.scifi.setImageUrl("https://www.indiewire.com/wp-content/uploads/2013/12/sci-fi-genre.jpg");

        this.historical = new Genre();
        this.historical.setId(10);
        this.historical.setName("Historical");
        this.historical.setImageUrl("https://www.listchallenges.com/f/lists/87b065de-25d3-4020-800e-ba0434ecb908.jpg");

        this.gk = new Genre();
        this.gk.setId(11);
        this.gk.setName("GK");
        this.gk.setImageUrl("http://www.theinterview.in/wp-content/uploads/2017/01/gk1.jpg");

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        this.file = new File("./assets/GameMovies.xlsx");


        try
        {
            // Finds the XLSX file

            // Finds the workbook instance for XLSX file

            this.myWorkBook = new XSSFWorkbook(new FileInputStream(file));
            // Return first sheet from the XLSX workbook
            this.mySheet = myWorkBook.getSheetAt(0);
            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = mySheet.iterator();
            // Traversing over each row of XLSX file
            rowIterator.next();//Skipping 1st line
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                this.game = new Game();
                game.setId(0);
                for (int i=1; cellIterator.hasNext(); i++)
                {
                    cell = cellIterator.next();
                    switch (i)
                    {
                        case 1:
                            this.game.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            switch(cell.getStringCellValue())
                            {
                                case "Entertainment":
                                    this.game.setCategory(this.entertainment);
                                    break;
                                case "General Knowledge":
                                    this.game.setCategory(this.generalKnowledge);
                                    break;
                                default:
                                    this.game.setCategory(null);
                            }
                            break;
                        case 3:
                            switch (cell.getStringCellValue())
                            {
                                case "Movies":
                                    this.game.setTopic(this.movies);
                                    break;
                                case "TV Shows":
                                    this.game.setTopic(this.tvShows);
                                    break;
                                case "Capitals":
                                    this.game.setTopic(this.capitals);
                                    break;
                                case "Presidents":
                                    this.game.setTopic(this.presidents);
                                    break;
                                case "Languages":
                                    this.game.setTopic(this.languages);
                                    break;
                                default:
                                    this.game.setTopic(null);
                            }
                            break;
                        case 4:
                            switch (cell.getStringCellValue())
                            {
                                case "Drama":
                                    this.game.setGenre(this.drama);
                                    break;
                                case "Historical":
                                    this.game.setGenre(this.historical);
                                    break;
                                case "Action":
                                    this.game.setGenre(this.action);
                                    break;
                                case "Thriller":
                                    this.game.setGenre(this.thriller);
                                    break;
                                case "Comedy":
                                    this.game.setGenre(this.comedy);
                                    break;
                                case "Anime":
                                    this.game.setGenre(this.anime);
                                    break;
                                case "Romance":
                                    this.game.setGenre(this.romance);
                                    break;
                                case "SciFi":
                                    this.game.setGenre(this.scifi);
                                    break;
                                case "Documentary":
                                    this.game.setGenre(this.documentary);
                                    break;
                                case "Reality & Talk Shows":
                                    this.game.setGenre(this.talkshow);
                                    break;
                                case "GK":
                                    this.game.setGenre(this.gk);
                                    break;
                                default:
                                    this.game.setGenre(null);
                            }
                            break;
                        case 5:
                            this.game.setLevel(cell.getStringCellValue());
                            if(this.game.getLevel().equals("easy"))
                                this.game.setPointPerQuestion(1);
                            else if(this.game.getLevel().equals("medium"))
                                this.game.setPointPerQuestion(3);
                            else if(this.game.getLevel().equals("hard"))
                                this.game.setPointPerQuestion(5);
                            break;
                        case 6:
                            this.game.setImageUrl(cell.getStringCellValue());
                            break;
                        case 7:
                            this.game.setNumOfQuestion((int)cell.getNumericCellValue());
                            this.game.setTotalPoints(this.game.getPointPerQuestion() * this.game.getNumOfQuestion());
                            break;
                        case 8:
                            this.game.setRules(Arrays.asList(cell.getStringCellValue().split("\\+")));
                            break;
                        case 9:
                            this.game.setTimeDuration((int)cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }

                }
                if (this.game.getName() == null)
                    break;
                this.game.setQuestions(new ArrayList<>());
                this.gameService.saveGame(this.game);
            }
        }
        catch (IOException | GameAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        finally
        {
            this.mySheet = null;
            try
            {
                this.myWorkBook.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            this.file = null;
        }
    }
}
