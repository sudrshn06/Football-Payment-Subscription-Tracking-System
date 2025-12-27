package com.examly.springapp.service;
import com.examly.springapp.model.MembershipType;
import java.util.List;
public interface  MembershipTypeService {

    MembershipType createMembershipType(MembershipType membershipType);
    MembershipType getMembershipTypeById(Long id);
    MembershipType updateMembershipType(Long id , MembershipType membershipType);
    List<MembershipType> getAllMembershipTypes();

    // Queries for Day-10
    List<MembershipType> getMembershipTypesByName(String name);
    List<MembershipType> getMembershipTypesByPriceRange(Double min, Double max);
    List<MembershipType> getMembershipTypesByDurationGreaterThan(Integer duration);
    List<MembershipType> getMembershipTypesByPriceLessThan(Double price);
}
