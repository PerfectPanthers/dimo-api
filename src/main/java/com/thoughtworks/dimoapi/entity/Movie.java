package com.thoughtworks.dimoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    @Id
    private String id;
    private String homepage;
    private String overview;
    private String tagline;
    private String title;
    private String status;
    private Long budget;
    private Long revenue;
    private String posterUrl;
    private Float popularity;
    private Float vote_average;
    private Float vote_count;
    private Integer runtime;
    private List genres;
    private List spoken_languages;
    private List keywords;
    @Field("production_companies")
    private List productionCompanies;
    @Field("production_countries")
    private List productionCountries;
    @Field("id")
    private long movieId;
    @Field("original_title")
    private String originalTitle;
    @Field("release_date")
    private String releaseDate;
    @Field("original_language")
    private String originalLanguage;
}
