package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import com.reddit.demo.repositories.PostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

  PostRepository postRepository;

  public PostServiceImp(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  @Override
  public void save(Post posts) {
    postRepository.save(posts);
  }

  @Override
  public Post findById(Long id) {
    return postRepository.findById(id).orElse(null);
  }

}
