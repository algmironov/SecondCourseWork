package pro.skystudent.secondcoursework.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    public final QuestionService javaQuestionServiceImpl;

    public JavaQuestionController(@Qualifier("javaService") QuestionService javaQuestionServiceImpl) {
        this.javaQuestionServiceImpl = javaQuestionServiceImpl;
    }

    @GetMapping(path = "/add")
    public boolean addQuestion(@RequestParam("question") String question,@RequestParam("answer") String answer) {
        return javaQuestionServiceImpl.addQuestion(question, answer);
    }

    @GetMapping(path = "/remove")
    public boolean removeQuestion(@RequestParam("question") String question,@RequestParam("answer") String answer) {
        return javaQuestionServiceImpl.removeQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return javaQuestionServiceImpl.getAllQuestions();
    }
}
