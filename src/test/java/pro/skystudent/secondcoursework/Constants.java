package pro.skystudent.secondcoursework;

import java.util.Set;

public class Constants {

    public static final String QUESTION1 = "What?";
    public static final String QUESTION2 = "Where?";
    public static final String QUESTION3 = "When?";

    public static final String ANSWER1 = "That!";
    public static final String ANSWER2 = "Here!";
    public static final String ANSWER3 = "Now!";

    public static final Question QUESTION_FOR_SET_1 = new Question(QUESTION1, ANSWER1);
    public static final Question QUESTION_FOR_SET_2 = new Question(QUESTION2, ANSWER2);
    public static final Question QUESTION_FOR_SET_3 = new Question(QUESTION3, ANSWER3);

    public static final Set<Question> TEST_QUESTIONS_SET = Set.of(QUESTION_FOR_SET_1,QUESTION_FOR_SET_2);

    public static final String EMPTY_ANSWER = null;

}
