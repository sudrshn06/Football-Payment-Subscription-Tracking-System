package com.examly.springapp.controller;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.service.MembershipTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {
  @Autowired
  private MembershipTypeService service;
@PostMapping
public ResponseEntity<MembershipType>createMembershipType(@RequestBody MembershipType membershipType)
{
   MembershipType saved = service.createMembershipType(membershipType);
   return new ResponseEntity<>(saved,HttpStatus.CREATED);
}
  @GetMapping("/{id}")
  public ResponseEntity<MembershipType>getMembershipTypeById(@PathVariable Long id)
  {
      MembershipType type = service.getMembershipTypeById(id);
      if(type !=null)
      {
         return new ResponseEntity<>(type,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
   @PutMapping("/{id}")
   public ResponseEntity<MembershipType>updateMembershipType(@PathVariable Long id,@RequestBody MembershipType membershipType)
   {
      MembershipType updated = service.updateMembershipType(id, membershipType);
      if(updated !=null)
      {
         return new ResponseEntity<>(updated , HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @GetMapping
   public ResponseEntity<List<MembershipType>> getAllMembershipTypes()
   {
      List<MembershipType> list = service.getAllMembershipTypes();
      return new ResponseEntity<>(list,HttpStatus.OK);
   }


   @GetMapping("/name/{name}")
   public ResponseEntity<?> getByName(@PathVariable String name)
   {
      List<MembershipType> list = service.getMembershipTypesByName(name);
      if(list == null || list.isEmpty()){
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
      }
      return new ResponseEntity<>(list,HttpStatus.OK);
   }

   // Accept query params as tests call /price?min=...&max=...
   @GetMapping("/price")
   public ResponseEntity<List<MembershipType>> getByPriceRange(@RequestParam Double min, @RequestParam Double max)
   {
      List<MembershipType> list = service.getMembershipTypesByPriceRange(min,max);
      return new ResponseEntity<>(list,HttpStatus.OK);
   }

   // Tests call /duration-greater/{duration}
   @GetMapping("/duration-greater/{duration}")
   public ResponseEntity<?> getByDurationGreaterThan(@PathVariable Integer duration)
   {
      List<MembershipType> list = service.getMembershipTypesByDurationGreaterThan(duration);
      if(list == null || list.isEmpty()){
         return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body("No membership types found with duration greater than " + duration);
      }
      return new ResponseEntity<>(list,HttpStatus.OK);
   }

   // price less than endpoint for tests
   @GetMapping("/price-less/{price}")
   public ResponseEntity<?> getByPriceLessThan(@PathVariable Double price){
      List<MembershipType> list = service.getMembershipTypesByPriceLessThan(price);
      if(list == null || list.isEmpty()){
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
      }
      return ResponseEntity.ok(list);
   }

  
}
