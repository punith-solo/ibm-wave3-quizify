package com.stackroute.quizify.userregistrationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    private long id;
    private String name;
    private String imageUrl;
}
