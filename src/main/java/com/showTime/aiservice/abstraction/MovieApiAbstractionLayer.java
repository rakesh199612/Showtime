package com.showTime.aiservice.abstraction;

import com.showTime.aiservice.enums.ResultCode;
import com.showTime.aiservice.models.api.CreateNewMovieRequestBody;
import com.showTime.aiservice.models.api.CreateNewUserResponseBody;
import com.showTime.aiservice.models.api.ResultStatusInfo;
import com.showTime.aiservice.models.api.ShowTimeResponseBody;
import com.showTime.aiservice.models.db.MovieData;
import com.showTime.aiservice.models.db.MovieListData;
import com.showTime.aiservice.models.db.Userdata;
import com.showTime.aiservice.repository.MovieDescriptionRepository;
import com.showTime.aiservice.repository.UserDescriptionRepository;
import com.showTime.aiservice.util.IdGenerationUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieApiAbstractionLayer {

    @Autowired
    UserDescriptionRepository userRepo;
    @Autowired
    MovieDescriptionRepository movieRepo;

    public ShowTimeResponseBody<String> handleCreateNewMovie(String UserName, CreateNewMovieRequestBody createNewMovie){
        ShowTimeResponseBody<String> apiResponse=new ShowTimeResponseBody<>();
        ResultStatusInfo resultStatusInfo=new ResultStatusInfo();
        MovieData movieData=new MovieData();
        String movieId=IdGenerationUtil.generateMovieIdentifier(createNewMovie.getMovieName());
        movieData.setM_id(movieId);
        movieData.setM_name(createNewMovie.getMovieName());
        movieData.setDescription(createNewMovie.getMovieDescription());
        movieData.setTheatre(createNewMovie.getTheatre());
        movieData.setPrice(createNewMovie.getPrice());
        movieData.setL_id(createNewMovie.getLanguage());
        movieRepo.saveMovie(movieData);
        if(movieRepo.findByMovieID(movieId)!=null){
            apiResponse.setData(movieId);
            resultStatusInfo.setResultCode(ResultCode.Success.name());
            resultStatusInfo.setMessage("User successfully created");
        }else{
            resultStatusInfo.setResultCode(ResultCode.Failure.name());
            resultStatusInfo.setMessage("DB error");
        }
        apiResponse.setResultStatusInfo(resultStatusInfo);
        return apiResponse;
    }

    public ShowTimeResponseBody<String> handleCreateNewUser(@NotNull CreateNewUserResponseBody createNewUser){
        ShowTimeResponseBody<String> apiResponse=new ShowTimeResponseBody<>();
        ResultStatusInfo resultStatusInfo=new ResultStatusInfo();
        Userdata uData=new Userdata();
        String userID= IdGenerationUtil.generateUserIdentifier(createNewUser.getFirstName());
        uData.setU_id(userID);
        uData.setEmail(createNewUser.getEmail());
        uData.setPassword(createNewUser.getPassword());
        uData.setLocation(createNewUser.getLocation());
        uData.setUserType(createNewUser.getUserType());
        uData.setFName(createNewUser.getFirstName());
        uData.setLName(createNewUser.getLastName());
        uData.setPhone_no(createNewUser.getPhone_no());
        userRepo.saveUser(uData);
        if(userRepo.findByUserId(userID)!=null){
            apiResponse.setData(userID);
            resultStatusInfo.setResultCode(ResultCode.Success.name());
            resultStatusInfo.setMessage("User successfully created");
        }else{
            resultStatusInfo.setResultCode(ResultCode.Failure.name());
            resultStatusInfo.setMessage("DB error");
        }
        apiResponse.setResultStatusInfo(resultStatusInfo);
        return apiResponse;

    }

    public ShowTimeResponseBody handleGetUser(String email,String password, String userType){
        ShowTimeResponseBody<Userdata> apiResponse=new ShowTimeResponseBody<>();
        ResultStatusInfo resultStatusInfo=new ResultStatusInfo();
        Userdata uData=new Userdata();
        uData = userRepo.findByEmail(email);
        if(uData.getEmail().equals(email)&&uData.getPassword().equals(password)&&uData.getUserType().equals(userType))
        {
            apiResponse.setData(uData);
            resultStatusInfo.setResultCode(ResultCode.Success.name());
            resultStatusInfo.setMessage("User successfully logged in");
        }
        else {
            resultStatusInfo.setResultCode(ResultCode.Failure.name());
            resultStatusInfo.setMessage("User is not registered");
        }
        apiResponse.setResultStatusInfo(resultStatusInfo);
        return apiResponse;

    }

    public ShowTimeResponseBody<List<MovieData>> handleGetAllMovie(){
        ShowTimeResponseBody<List<MovieData>> apiResponse=new ShowTimeResponseBody<>();
        ResultStatusInfo resultStatusInfo=new ResultStatusInfo();
        List<MovieData> movieListData=new ArrayList<>();
        List<MovieData> movieList=movieRepo.findAllMovie();
        if(movieList==null||movieList.isEmpty()){
            resultStatusInfo.setResultCode(ResultCode.NotFound.name());
            apiResponse.setResultStatusInfo(resultStatusInfo);
            return apiResponse;
        }
        for(MovieData movieRepo : movieList){
            MovieData movieData=new MovieData();
            movieData.setM_id(movieRepo.getM_id());
            movieData.setM_name(movieRepo.getM_name());
            movieData.setDescription(movieRepo.getDescription());
            movieData.setTheatre(movieRepo.getTheatre());
            movieData.setPrice(movieRepo.getPrice());
            movieData.setL_id(movieRepo.getL_id());
            movieListData.add(movieData);
        }
        resultStatusInfo.setMessage("retrieval success");
        resultStatusInfo.setResultCode(ResultCode.Success.name());
        apiResponse.setData(movieListData);
        apiResponse.setResultStatusInfo(resultStatusInfo);
        return apiResponse;

    }

    public ShowTimeResponseBody handleGetAllMovieCount(){
        ShowTimeResponseBody apiResponse=new ShowTimeResponseBody();
        ResultStatusInfo resultStatusInfo=new ResultStatusInfo();
        List<MovieData> movieList = movieRepo.findAllMovie();
        if(movieList==null||movieList.isEmpty()){
            resultStatusInfo.setResultCode(ResultCode.NotFound.name());
            apiResponse.setResultStatusInfo(resultStatusInfo);
            return apiResponse;
        }
        resultStatusInfo.setResultCode(ResultCode.Success.name());
        resultStatusInfo.setMessage("Retrival success");
        apiResponse.setData(movieList.size());
        apiResponse.setResultStatusInfo(resultStatusInfo);
        return apiResponse;

    }

    public ShowTimeResponseBody<List<MovieData>> handleGetMovieByName(String name) {
        ShowTimeResponseBody<List<MovieData>> apiResponse=new ShowTimeResponseBody<>();
        ResultStatusInfo resultStatusInfo=new ResultStatusInfo();
        List<MovieData> movieListData=new ArrayList<>();
        List<MovieData> movieList=movieRepo.findMovieByName(name);
        if(movieList==null||movieList.isEmpty()){
            resultStatusInfo.setResultCode(ResultCode.NotFound.name());
            apiResponse.setResultStatusInfo(resultStatusInfo);
            return apiResponse;
        }
        for(MovieData movieRepo : movieList){
            MovieData movieData=new MovieData();
            movieData.setM_id(movieRepo.getM_id());
            movieData.setM_name(movieRepo.getM_name());
            movieData.setDescription(movieRepo.getDescription());
            movieData.setTheatre(movieRepo.getTheatre());
            movieData.setPrice(movieRepo.getPrice());
            movieData.setL_id(movieRepo.getL_id());
            movieListData.add(movieData);
        }
        resultStatusInfo.setMessage("retrieval success");
        resultStatusInfo.setResultCode(ResultCode.Success.name());
        apiResponse.setData(movieListData);
        apiResponse.setResultStatusInfo(resultStatusInfo);
        return apiResponse;

    }
}
