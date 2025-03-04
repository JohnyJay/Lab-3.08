package com.example.labs.lab308.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    private String renewalDate;
    @ManyToOne
    @JoinColumn(name="chapter_id")
    private Chapter chapter;

    public Member(int id, String name, STATUS status, String renewalDate) {
        Id = id;
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
    }
}
