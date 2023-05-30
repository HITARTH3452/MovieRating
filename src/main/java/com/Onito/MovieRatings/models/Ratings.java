package com.Onito.MovieRatings.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Ratings {

    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "tconst")
    private Movies movies;

    @Column(name = "averageRating")
    private Float averageRating;

    @Column(name = "numVotes")
    private Integer numVotes;
}
