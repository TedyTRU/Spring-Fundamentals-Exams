package com.likebookapp.repository;

import com.likebookapp.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser_Id(Long user_id);

    @Query("SELECT p FROM Post p WHERE p.user.id NOT IN :p_id")
    List<Post> findAllOthersPosts(@Param(value = "p_id") Long user_id);

}
