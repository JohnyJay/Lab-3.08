package com.example.labs.lab308.repository;

import com.example.labs.lab308.model.Chapter;
import com.example.labs.lab308.model.Member;
import com.example.labs.lab308.model.STATUS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChapterRepositoryTest {

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    MemberRepository memberRepository;

    Chapter chapterOne;
    Member president;
    Member member1;
    Member member2;


    @BeforeEach
    public void setUp(){
        chapterOne = new Chapter();
        chapterOne.setName("First Order");
        //chapterRepository.save(chapterOne);
        president = new Member();
        president.setName("Loebly");
        member1 = new Member();
        member1.setName("Goselen");
        member2 = new Member();
        member2.setName("Lieken");
        chapterOne.addMember(president);
        chapterOne.addMember(member1);
        chapterOne.addMember(member2);
        chapterOne.setPresident(president);
        chapterRepository.save(chapterOne);
//        memberRepository.save(president);
//        memberRepository.save(member1);
//        memberRepository.save(member2);
    }

    @AfterEach
    public void tearDown(){
        //memberRepository.deleteAll();
        chapterRepository.deleteAll();
    }

    @Test
    public void checkSizeofMemberList_validList_correctSize(){
        assertEquals(3,chapterOne.getList().size());
    }

    @Test
    public void checkMembersPersist_validChapter_memberNames(){
        List<Member> memberList = memberRepository.findAll();
        System.out.println(memberList.get(1).getName());
        assertEquals("Goselen",memberList.get(1).getName());
    }
}