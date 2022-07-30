package com.showTime.aiservice.controller;

import com.showTime.aiservice.abstraction.MovieApiAbstractionLayer;
import com.showTime.aiservice.models.api.CreateNewMovieRequestBody;
import com.showTime.aiservice.models.api.CreateNewUserResponseBody;
import com.showTime.aiservice.models.api.ShowTimeResponseBody;
import com.showTime.aiservice.models.db.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class MovieController {

    @Autowired
    private MovieApiAbstractionLayer movieApiHandler;

    @PostMapping("/newMovie")
    public ShowTimeResponseBody<String> createNewMovie(@RequestHeader(value="userName") String userName,
    @RequestBody CreateNewMovieRequestBody createNewMovie){
        return movieApiHandler.handleCreateNewMovie(userName, createNewMovie);
    }

    @GetMapping("/searchByName")
    public ShowTimeResponseBody<List<MovieData>> getMovieByName(@RequestParam String name){
        return movieApiHandler.handleGetMovieByName(name);
    }

    @PostMapping("/newUser")
    public ShowTimeResponseBody<String> createNewUser(@RequestBody CreateNewUserResponseBody createNewUser){
        return movieApiHandler.handleCreateNewUser(createNewUser);
    }

    @GetMapping("userLogin")
    public ShowTimeResponseBody<String> getUser(@RequestParam String email, @RequestParam String password, @RequestParam String userType){
        return movieApiHandler.handleGetUser(email,password,userType);
    }

    @GetMapping("movieList")
    public ShowTimeResponseBody<List<MovieData>> getAllMovie(){
        return  movieApiHandler.handleGetAllMovie();
    }

    @GetMapping("movieListCount")
    public ShowTimeResponseBody getAllMovieCount(){
        return  movieApiHandler.handleGetAllMovieCount();
    }
}
