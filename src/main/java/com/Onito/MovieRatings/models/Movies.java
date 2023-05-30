package com.Onito.MovieRatings.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "titleType")
    private String titleType;

    @Column(name = "primaryTitle")
    private String primaryTitle;

    @Column(name = "runtimeMinutes")
    private Integer runtimeMinutes;

    @Column(name = "genres")
    private String genres;

    @OneToOne(mappedBy = "movies")
    private Ratings ratings;

}
