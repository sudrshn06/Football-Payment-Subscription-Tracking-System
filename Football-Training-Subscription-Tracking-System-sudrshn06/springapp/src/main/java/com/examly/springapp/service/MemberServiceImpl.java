package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class MemberServiceImpl implements MemberService{
   @Autowired
   private MemberRepository repo;
   
   @Override
   public Member createMember(Member member)
   {
    return repo.save(member);
   }
   @Override
   public Member getMemberById(Long id)
   {
    Optional<Member>member = repo.findById(id);
    return member.orElse(null);
   }

   @Override
   public Member updateMember(Long  id,Member member)
   {
    if(repo.existsById(id))
    {
        member.setId(id);
        return repo.save(member);
    }
    return null;
   }
   @Override
   public List<Member> getMembersPage(int page , int size)
   {
    return repo.findAll();
   }
   
}
