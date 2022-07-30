package com.showTime.aiservice.repository;

import com.showTime.aiservice.models.db.MovieData;
import com.showTime.aiservice.models.db.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDescriptionRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<MovieData> findAllMovie(){
        Query query=new Query();
        return mongoTemplate.find(query, MovieData.class);
    }

    public MovieData saveMovie(MovieData movieData){
        return mongoTemplate.save(movieData);
    }

    public MovieData findByMovieID(String mID) {
        Query query=new Query(Criteria.where("m_id").is(mID));
        return mongoTemplate.findOne(query,MovieData.class);
    }

    public List<MovieData> findMovieByName(String name) {
        Query query=new Query(Criteria.where("m_name").is(name));
        return mongoTemplate.find(query, MovieData.class);
    }
}
