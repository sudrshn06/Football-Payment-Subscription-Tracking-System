package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import java.util.List;

public interface MemberService
{
    Member createMember(Member member);
    Member getMemberById(Long id);
    Member updateMember(Long id, Member member);
    List<Member> getMembersPage(int page , int size);
}
