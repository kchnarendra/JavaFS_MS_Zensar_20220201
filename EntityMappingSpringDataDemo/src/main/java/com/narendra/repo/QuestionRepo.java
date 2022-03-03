package com.narendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.entity.one_to_many.QuestionEntity;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Long>{

}