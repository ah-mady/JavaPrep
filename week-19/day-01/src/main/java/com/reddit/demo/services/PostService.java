package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  List<Post> findAll();

  void save(Post posts);

  Post findById(Long id);

}
