package hello.controller;

import hello.entity.Blog;
import hello.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CrudController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    public String getBlogList(Model model){
        List<Blog>  ls = blogService.getAllBlog();
        if(ls.size()>0){
            model.addAttribute("ls",ls);
        }else{
            model.addAttribute("ls","暂无数据");
        }
        return "/list";
    }


}
