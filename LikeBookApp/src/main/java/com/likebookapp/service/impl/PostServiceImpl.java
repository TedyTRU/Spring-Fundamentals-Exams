package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.model.service.PostServiceModel;
import com.likebookapp.model.view.PostViewModel;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.service.MoodService;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final MoodService moodService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, MoodService moodService, CurrentUser currentUser, UserService userService) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.moodService = moodService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public PostServiceModel addPost(PostServiceModel postAddServiceModel) {

        Mood mood = moodService.findMoodByNameEnum(postAddServiceModel.getMood());
        User user = userService.findUserById(currentUser.getId());

        Post post = modelMapper.map(postAddServiceModel, Post.class);
        post
                .setMood(mood)
                .setUser(user)
                .setUserLikes(0);

        return modelMapper.map(postRepository.save(post), PostServiceModel.class);
    }

    @Override
    public List<PostViewModel> getUsersPosts(Long id) {

        List<Post> posts = postRepository.findByUser_Id(id);

        return posts.stream().map(post -> modelMapper.map(post, PostViewModel.class)).collect(Collectors.toList());

    }

    @Override
    public void removePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostViewModel> getAllOthersPosts(Long id) {
        return postRepository.findAllOthersPosts(id)
                .stream().map(post -> modelMapper.map(post, PostViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public Integer getCountOfPosts(Long id) {
        return postRepository.findAllOthersPosts(id).size();
    }

    @Override
    public void likePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            return;
        }

        post.setUserLikes(post.getUserLikes() + 1);

        postRepository.save(post);
    }

}
