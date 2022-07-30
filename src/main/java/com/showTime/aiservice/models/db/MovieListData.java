package com.showTime.aiservice.models.db;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Name")
@Data
public class MovieListData {
    private String m_id;
    private String m_name;
    private String description;
    private String theatre;
    private String price;
    private String l_id;

}