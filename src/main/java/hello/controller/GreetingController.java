package hello.controller;

import hello.entity.Blog;
import hello.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    BlogService blogService;
    @ResponseBody
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

       model.addAttribute("name", name);

        return "bloglist";
    }

    @RequestMapping("/assets")
    public String platform(){
        //跳转到后台管理界面

        return "index";
    }
}
