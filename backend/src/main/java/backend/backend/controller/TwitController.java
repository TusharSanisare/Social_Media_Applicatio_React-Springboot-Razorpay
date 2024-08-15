package backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import backend.backend.service.TwitService;
import backend.backend.service.UserService;

@Controller
@RequestMapping("/api/twits")
public class TwitController {

  @Autowired
  private TwitService twitService;

  @Autowired
  private UserService userService;
}
