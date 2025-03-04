package com.example.labs.lab308.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name= "event_id")
@Data
@NoArgsConstructor
public class Conference extends Event{
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Speaker> speakerList = new ArrayList<>();

    public void addSpeaker(Speaker speaker){
        this.speakerList.add(speaker);
        speaker.setConference(this);
    }
}
