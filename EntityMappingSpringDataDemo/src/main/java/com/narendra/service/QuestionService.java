package com.narendra.service;


import java.util.List;

import com.narendra.json.Question;

public interface QuestionService {
	public Question createQuestion(Question question);
	public List<Question> getAllQuestions();
}