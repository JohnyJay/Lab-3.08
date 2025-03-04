package com.example.labs.lab308.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Speaker {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double presentationDuration;
    @ManyToOne
    @JoinColumn(name="conference_id")
    private Conference conference;


}
