package com.showTime.aiservice.repository;

import com.showTime.aiservice.models.db.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UserDescriptionRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Userdata saveUser(Userdata uData){
        return mongoTemplate.save(uData);
    }

    public Userdata findByUserId(String userID){
        Query query=new Query(Criteria.where("U_id").is(userID));
        return mongoTemplate.findOne(query,Userdata.class);
    }

    public Userdata findByEmail(String email){
        Query query=new Query(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query,Userdata.class);
    }
}
