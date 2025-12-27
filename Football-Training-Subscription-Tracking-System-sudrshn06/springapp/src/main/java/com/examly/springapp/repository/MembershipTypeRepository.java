package com.examly.springapp.repository;
import com.examly.springapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MembershipTypeRepository extends JpaRepository<MembershipType , Long>  {
 
      List<MembershipType> findByTypeName(String typeName);
      List<MembershipType> findByPriceBetween(Double min , Double max);
      List<MembershipType> findByDurationInMonthsGreaterThan(Integer duration);
      List<MembershipType> findByPriceLessThanOrderByTypeIdAsc(Double price);
}
