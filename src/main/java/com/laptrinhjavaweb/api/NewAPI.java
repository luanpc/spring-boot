package com.laptrinhjavaweb.api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;

@RestController
public class NewAPI {

   @PostMapping(value = "/new")
   public NewDTO createNew(@RequestBody NewDTO model) {
      return model;
   }
}