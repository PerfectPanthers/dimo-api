package com.thoughtworks.dimoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;


@Document(collection = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    @Id()
    String id;
    @Field("homepage")
    String imageUrl;

    @Field("original_title")
    String title;

    @Field("original_language")
    String language;

    @Field("release_date")
    Date releaseDate;

    @Field("genres")
    List<String> genres;

    String overview;

}
