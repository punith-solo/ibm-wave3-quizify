package com.stackroute.quizify.dto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
public class UserDTO {
    @Id
    private long id;
    private String name;
    private String password;
    private String emailId;
    private List<TopicDTO> topics;
    private List<GenreDTO> genres;
    private List<GameDTO> gamesPlayed;
    private String gender;
}
