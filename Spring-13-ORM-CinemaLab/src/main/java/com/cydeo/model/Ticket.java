package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity{

    private Integer seatNumber;
    private Integer rowNumber;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;



}
