package com.examly.springapp.service;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    @Autowired
    private MembershipTypeRepository repository;

    @Override
    public MembershipType createMembershipType(MembershipType membershipType) {
        return repository.save(membershipType);
    }

    @Override
    public MembershipType getMembershipTypeById(Long id) {
        Optional<MembershipType> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public MembershipType updateMembershipType(Long id, MembershipType membershipType) {
        if (repository.existsById(id)) {
            membershipType.setTypeId(id);
            return repository.save(membershipType);
        }
        return null;
    }

    @Override
    public List<MembershipType> getAllMembershipTypes() {
        return repository.findAll();
    }

    @Override
    public List<MembershipType> getMembershipTypesByName(String name) {
        return repository.findByTypeName(name);
    }

    @Override
    public List<MembershipType> getMembershipTypesByPriceRange(Double min, Double max) {
        return repository.findByPriceBetween(min, max);
    }

    @Override
    public List<MembershipType> getMembershipTypesByDurationGreaterThan(Integer duration) {
        return repository.findByDurationInMonthsGreaterThan(duration);
    }

    @Override
    public List<MembershipType> getMembershipTypesByPriceLessThan(Double price) {
        return repository.findByPriceLessThanOrderByTypeIdAsc(price);
    }
}
