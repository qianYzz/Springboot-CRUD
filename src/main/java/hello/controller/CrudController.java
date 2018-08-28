package hello.controller;

import com.alibaba.fastjson.JSONObject;
import hello.entity.Blog;
import hello.service.BlogService;
import hello.util.CodeHeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CrudController {

    @Autowired
    BlogService blogService;

    //跳转到新增页面
    @RequestMapping("/add")
    public String toAddPage(){
        return "add";
    }

    //跳转到编辑页面
    @RequestMapping("/edit/{id}")
    public String toEditPage(@PathVariable(value = "id") String id,Model model){
        System.out.println("111111111111111111:"+id);
        Blog blog = blogService.getBlogByid(id);
        model.addAttribute("blog",blog);
        return "edit";
    }

    //get请求获取全部数据
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

    //delete请求删除数据 返回json
    @ResponseBody
    @DeleteMapping("/blog/{id}")
    public String deleteBlogById(@PathVariable(value = "id") String id){
        JSONObject json = new JSONObject();
        int i = blogService.delete(id);
        if(i!=0){
            json.put("status","0");
            json.put("msg","删除成功");
        }else{
            json.put("status","1");
            json.put("msg","删除失败");
        }
        return JSONObject.toJSONString(json);
    }

    //post请求新增数据 返回json
    @ResponseBody
    @PostMapping("/blog")
    public String addBlog(String title,String content){
        JSONObject json = new JSONObject();
        Blog blog=new Blog();
        blog.setCreateTime(CodeHeper.getNowDateTime());
        blog.setId(CodeHeper.getUUID());
        blog.setContent(content);
        blog.setTitle(title);
        int i = blogService.addBlog(blog);
        if(i==0){
            json.put("status","1");
            json.put("msg","添加失败");
        }
        return JSONObject.toJSONString(json);
    }

    //put请求进行修改数据
    @ResponseBody
    @PutMapping("/blog")
    public String editBlog(String id,String title,String content) {
        JSONObject json = new JSONObject();
        Blog blog=new Blog();
        blog.setCreateTime(CodeHeper.getNowDateTime());
        blog.setId(id);
        blog.setContent(content);
        blog.setTitle(title);
        int i = blogService.updataBlog(blog);
        if(i==0){
            json.put("status","1");
            json.put("msg","添加失败");
        }
        return JSONObject.toJSONString(json);
    }
}
