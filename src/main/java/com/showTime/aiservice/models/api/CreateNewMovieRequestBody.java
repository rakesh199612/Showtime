package com.showTime.aiservice.models.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateNewMovieRequestBody {
    private String movieName;
    private String movieDescription;
    private String theatre;
    private String price;
    private String language;

}
