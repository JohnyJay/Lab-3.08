package com.example.labs.lab308.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="president_id")
    private Member president;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    private List<Member> list = new ArrayList<>();

    public Chapter(int id, String name, String district) {
        this.id = id;
        this.name = name;
        this.district = district;
    }

    public void addMember(Member member) {
        list.add(member);
        member.setChapter(this);
    }
}
