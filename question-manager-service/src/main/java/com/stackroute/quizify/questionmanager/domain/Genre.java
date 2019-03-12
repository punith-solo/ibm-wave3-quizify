package com.stackroute.quizify.questionmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    private long id;
    private String name;
    private String imageUrl;
}
