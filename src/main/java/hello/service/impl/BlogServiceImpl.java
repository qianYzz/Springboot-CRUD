package hello.service.impl;

import hello.dao.BlogDao;
import hello.entity.Blog;
import hello.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogDao blogDao;


    public List<Blog> getAllBlog() {
        List<Blog> blogList = blogDao.getAllBlog();
        return blogList;
    }


    public Blog getBlogByid(String id) {
        Blog blog = blogDao.getBlogByid(id);
        return blog;
    }


    public int addBlog(Blog blog) {
        int i = blogDao.addBlog(blog);
        return i;
    }


    public int delete(String id) {
        int i = blogDao.delete(id);
        return i;
    }


    public int updataBlog(Blog blog) {
        return blogDao.updataBlog(blog);
    }
}
