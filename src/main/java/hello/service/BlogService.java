package hello.service;

import hello.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BlogService {

    List<Blog> getAllBlog();

    Blog getBlogByid(String id);

    int addBlog(Blog blog);

    int delete(String id);

    int updataBlog(Blog blog);
}
