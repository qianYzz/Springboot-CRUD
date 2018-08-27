package hello.dao;

import hello.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogDao {

    List<Blog> getAllBlog();

    Blog getBlogByid(String id);

    int addBlog(Blog blog);

    int delete(String id);

    int updataBlog(Blog blog);
}
