package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginComtroller {

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username)&&"123456".equals(password)){
            return "redirect:/assets";
        }else{
            return "forward:/";
        }
    }

}
