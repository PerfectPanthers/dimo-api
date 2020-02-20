package com.thoughtworks.dimoapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Document(collection = "movies")
@NoArgsConstructor
@Data
public class Movies {


    private String homepage;
    private String overview;
    private String tagline;

    @Field("id")
    private long movieId;

    @Field("original_title")
    private String originalTitle;

    @Field("release_date")
    private String releaseDate;

    @Field("original_language")
    private String originalLanguage;

    private List genres;
    private List production_companies;


}
