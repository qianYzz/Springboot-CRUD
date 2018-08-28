package hello.dao.impl;

import hello.dao.BlogDao;
import hello.entity.Blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Blog> getAllBlog() {
        return jdbcTemplate.query( "select * from blog ", new BeanPropertyRowMapper(Blog.class));
    }

    @Override
    public Blog getBlogByid(String id) {
        List<Blog> list = jdbcTemplate.query("select * from blog where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Blog.class));
        if(list!=null && list.size()>0){
            Blog user = list.get(0);
            return user;
        }else{
            return null;
        }
    }

    @Override
    public int addBlog(Blog blog) {
        return  jdbcTemplate.update(" INSERT INTO blog(id,title,content,createTime)VALUES (?,?,?,?)",
                blog.getId(),blog.getTitle(),blog.getContent(),blog.getCreateTime());
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update("delete FROM blog where id=?",id);
    }

    @Override
    public int updataBlog(Blog blog) {
        return jdbcTemplate.update("UPDATE blog SET title=?,content=?,createTime=? where id=?",
                blog.getTitle(),blog.getContent(),blog.getCreateTime(),blog.getId());
    }

}
