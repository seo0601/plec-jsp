package com.acorn.project;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   
   @GetMapping("/")
   public String home(HttpServletRequest request) {
      
      
      return "home";
   }
   
   @GetMapping("/qna_users/list")
   public String qna_user(HttpServletRequest request) {
      
      
      return "qna_user/list";
   }
   
}























