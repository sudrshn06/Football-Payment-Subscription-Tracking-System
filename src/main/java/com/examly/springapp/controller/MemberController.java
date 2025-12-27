package com.examly.springapp.controller;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController
{
    @Autowired
    private MemberService service;
    //create member
    @PostMapping
    public ResponseEntity<Member>createMember(@RequestBody Member member)
    {
        Member savedMember = service.createMember(member);
        return new ResponseEntity<>(savedMember,HttpStatus.CREATED);
    }
    //GET MEMBER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id)
    {
        Member member = service.getMemberById(id);
        if(member !=null)
        {
            return new ResponseEntity<>(member , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id,@RequestBody Member member)
    {
        Member updatedMember =  service.updateMember(id,member);
        if(updatedMember != null)
        {
            return new ResponseEntity<>(updatedMember,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Member[]>getMembersPage(@PathVariable int page,@PathVariable int size)
    {
        List<Member> list = service.getMembersPage(page,size);
        Member[] arr = list.toArray(new Member[0]);
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }
}