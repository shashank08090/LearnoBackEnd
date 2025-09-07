package com.shashank.demo.Service;

import com.shashank.demo.Question;
import com.shashank.demo.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Question getQuestionById(Integer id) {
        Optional<Question> question = questionDao.findById(id);
        return question.orElse(null);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Question added successfully";
    }

    public String updateQuestion(Integer id, Question updatedQuestion) {
        Optional<Question> existingQuestionOpt = questionDao.findById(id);

        if (existingQuestionOpt.isPresent()) {
            Question existingQuestion = existingQuestionOpt.get();

            if (updatedQuestion.getQuestionTitle() != null) {
                existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
            }
            if (updatedQuestion.getOption1() != null) {
                existingQuestion.setOption1(updatedQuestion.getOption1());
            }
            if (updatedQuestion.getOption2() != null) {
                existingQuestion.setOption2(updatedQuestion.getOption2());
            }
            if (updatedQuestion.getOption3() != null) {
                existingQuestion.setOption3(updatedQuestion.getOption3());
            }
            if (updatedQuestion.getOption4() != null) {
                existingQuestion.setOption4(updatedQuestion.getOption4());
            }
            if (updatedQuestion.getRightAnswer() != null) {
                existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
            }
            if (updatedQuestion.getDifficultyLevel() != null) {
                existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
            }
            if (updatedQuestion.getCategory() != null) {
                existingQuestion.setCategory(updatedQuestion.getCategory());
            }

            questionDao.save(existingQuestion);
            return "Question updated successfully";
        } else {
            return "Question not found with ID: " + id;
        }
    }

    public String deleteQuestion(Integer id) {
        Optional<Question> question = questionDao.findById(id);

        if (question.isPresent()) {
            questionDao.deleteById(id);
            return "Question deleted successfully";
        } else {
            return "Question not found with ID: " + id;
        }
    }
}