package com.shashank.demo.dao;



import com.shashank.demo.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    // JpaRepository provides findAll() method automatically
    List<Question> findByCategory(String Category);
}
