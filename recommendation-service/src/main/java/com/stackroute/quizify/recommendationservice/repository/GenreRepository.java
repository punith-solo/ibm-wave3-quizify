package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Genre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface GenreRepository extends Neo4jRepository<Genre,Long>{
    @Query("MATCH (Genre) RETURN Genre")
    public List<Genre> getAllNodes();


    @Query("MATCH p=(g:Genre)-[r:is_type_of]->(c:Category) WHERE c.id={categoryId}  RETURN g")
    List<Genre> getGenresBycategory(long categoryId);


    @Query("MATCH p=(g:Genre)-[r:is_type_of]->(c:Category) WHERE c.name={categoryName}  RETURN g")
    List<Genre> getGenresByCategoryName(String categoryName);
}
