package com.example.labs.lab308.repository;

import com.example.labs.lab308.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventTest {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    SpeakerRepository speakerRepository;

    Conference defcon;
    Speaker president;
    Speaker techBoss;
    Guest member1;
    Guest member2;
    List<Speaker> speakerList;

    @BeforeEach
    public void setUp(){
        speakerList = new ArrayList<>();
        defcon = new Conference();
        defcon.setTitle("First Con");
        //chapterRepository.save(chapterOne);
        president = new Speaker();
        president.setName("Buzz");
        techBoss = new Speaker();
        techBoss.setName("Bozz");
        member1 = new Guest();
        member1.setName("Goselen");
        member2 = new Guest();
        member2.setName("Lieken");
        defcon.addSpeaker(president);
        defcon.addSpeaker(techBoss);
        defcon.addGuest(member1);
        defcon.addGuest(member2);
        conferenceRepository.save(defcon);
//        memberRepository.save(president);
//        memberRepository.save(member1);
//        memberRepository.save(member2);
    }

    @AfterEach
    public void tearDown(){
        //memberRepository.deleteAll();
        conferenceRepository.deleteAll();
    }

    @Test
    public void checkSizeofGuestList_validList_correctSize(){
        List<Conference> conf = conferenceRepository.findAll();

        assertEquals(2,conf.get(0).getGuestList().size());
        assertEquals(2,conf.get(0).getSpeakerList().size());
    }

    @Test
    public void checkSpeakersPersist_validConference_speakerNames(){
        speakerList = speakerRepository.findAll();
        System.out.println(speakerList.get(1).getName());
        assertEquals("Bozz",speakerList.get(1).getName());
    }
}