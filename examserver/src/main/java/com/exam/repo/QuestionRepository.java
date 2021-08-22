package com.exam.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entitiy.exam.Question;
import com.exam.entitiy.exam.Quiz;

public interface QuestionRepository  extends JpaRepository<Question, Long> {
    
	 Set<Question> findByQuiz(Quiz quiz);

}
