package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import com.reddit.demo.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  List<Post> findAll();

  void save(Post posts);

  Post findById(Long id);

  void likePost(Post likedPost, User loggedUser);

  void dislikePost(Post disLikedPost, User loggedUser);

  List<List<String>> getMyLikes(User loggedUser);
}
