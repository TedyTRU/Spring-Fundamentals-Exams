package com.likebookapp.service;

import com.likebookapp.model.service.PostServiceModel;
import com.likebookapp.model.view.PostViewModel;

import java.util.List;

public interface PostService {

    PostServiceModel addPost(PostServiceModel postAddServiceModel);

    List<PostViewModel> getUsersPosts(Long id);

    void removePost(Long id);

    List<PostViewModel> getAllOthersPosts(Long id);

    Integer getCountOfPosts(Long id);

    void likePost(Long id);
}
