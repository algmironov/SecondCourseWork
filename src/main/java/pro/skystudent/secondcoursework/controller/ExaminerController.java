package pro.skystudent.secondcoursework.controller;

import org.springframework.web.bind.annotation.*;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.service.ExaminerService;

import java.util.Collection;

@RequestMapping
@RestController
public class ExaminerController {
    public final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
