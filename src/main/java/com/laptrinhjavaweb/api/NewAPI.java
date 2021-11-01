package com.laptrinhjavaweb.api;
import org.springframework.web.bind.annotation.*;

import com.laptrinhjavaweb.dto.NewDTO;

@RestController
public class NewAPI {

   @PostMapping(value = "/news")
   public NewDTO createNew(@RequestBody NewDTO model) {
      return model;
   }
   
   @PutMapping(value = "/news")
   public NewDTO updateNew(@RequestBody NewDTO model) {
      return model;
   }
   
   @DeleteMapping(value = "/news")
   public void deleteNew(@RequestBody long[] ids) {
   }
}