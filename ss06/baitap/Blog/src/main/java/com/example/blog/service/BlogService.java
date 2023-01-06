package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
      blogRepository.save( blog );
    }

    @Override
    public void update(int id, Blog blog) {
      Blog bl = findByIdMy( id );
      blogRepository.save( bl );
    }

    @Override
    public Blog findByIdMy(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
     blogRepository.deleteById( id );
    }
}
