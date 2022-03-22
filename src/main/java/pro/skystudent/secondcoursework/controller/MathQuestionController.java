package pro.skystudent.secondcoursework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.exceptions.WrongRequestException;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    @GetMapping("add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new WrongRequestException();
    }
    @GetMapping("remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new WrongRequestException();
    }
    @GetMapping
    public Collection<Question> getAllQuestions(@RequestParam String question, @RequestParam String answer) {
        throw new WrongRequestException();
    }
}
