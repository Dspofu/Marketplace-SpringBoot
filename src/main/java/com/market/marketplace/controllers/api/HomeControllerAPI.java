package com.market.marketplace.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerAPI {
  @GetMapping("/api")
  public String index() {
    return "opa";
  }
}
