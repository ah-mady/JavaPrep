package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import com.reddit.demo.models.User;
import com.reddit.demo.models.Vote;
import com.reddit.demo.repositories.PostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

  private PostRepository postRepository;
  private VoteService voteService;

  public PostServiceImp(PostRepository postRepository, VoteService voteService) {
    this.postRepository = postRepository;
    this.voteService = voteService;
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

  @Override
  public void likePost(Post likedPost, User loggedUser) {
    Vote votedPost = voteService.returnVoteByPostAndUser(likedPost, loggedUser);
   /* if (likedPost.getUser().getId() == loggedUser.getId()){
    } else */

    if (votedPost == null) {
      votedPost = new Vote();
      votedPost.setPost(likedPost);
      votedPost.setVotedByUserId(loggedUser);
    } else if (votedPost.getUpVote() == 1) {
      return;
    }
    likedPost.like();
    votedPost.setUpVote(votedPost.getUpVote()+1);
    voteService.setVote(votedPost);
    postRepository.save(likedPost);
  }

  @Override
  public void dislikePost(Post dislikedPost, User loggedUser) {
    Vote votedPost = voteService.returnVoteByPostAndUser(dislikedPost, loggedUser);
/*    if (dislikedPost.getUser().getId() == loggedUser.getId()){ //so the user cant dislike own posts
    } else */
    if (votedPost == null) {
      votedPost = new Vote();
      votedPost.setPost(dislikedPost);
      votedPost.setVotedByUserId(loggedUser);
    } else if (votedPost.getUpVote() == -1) {
      return;
    }
    dislikedPost.dislike();
    votedPost.setUpVote(votedPost.getUpVote()-1);
    voteService.setVote(votedPost);
    postRepository.save(dislikedPost);
  }

  @Override
  public List<List<String>> getMyLikes(User loggedUser) {
//    List<Vote> myVotes = voteService.returnAllVotesByUser(loggedUser);
//    List<List<String>> LikedPostsDetailsList = new ArrayList<>();
//
//    for(Vote vote:myVotes ) {
//      List<String> likedPostDetail = new ArrayList<>();
//
//      String totalLikes = vote.getVotedPost().getLikes().toString();
//      String postTitle = vote.getVotedPost().getTitle();
//      String myLikeOrDislike = new String();
//      if(vote.getUpvote()==1) {
//        myLikeOrDislike = "Like";
//      } else if(vote.getUpvote()==-1) {
//        myLikeOrDislike = "Dislike";
//      } else if (vote.getUpvote()==0) {
//        myLikeOrDislike ="Like/Dislike revoked";
//      }
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//      String votedDate = vote.getVotedDateTime().format(formatter);
//      String postCreatedBy = vote.getVotedPost().getOwner().getUserName();
//
//      likedPostDetail.addAll(
//          Arrays.asList(totalLikes,postTitle,myLikeOrDislike,votedDate,postCreatedBy));
//      LikedPostsDetailsList.add(likedPostDetail);
//    }
//    return LikedPostsDetailsList;
    return null;
  }

}
