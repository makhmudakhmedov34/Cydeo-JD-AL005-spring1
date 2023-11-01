package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> moviesList;

}
