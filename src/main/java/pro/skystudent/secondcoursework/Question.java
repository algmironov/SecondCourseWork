package pro.skystudent.secondcoursework;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question1 = (Question) o;

        if (!getQuestion().equals(question1.getQuestion())) return false;
        return getAnswer().equals(question1.getAnswer());
    }

    @Override
    public int hashCode() {
        int result = getQuestion().hashCode();
        result = 31 * result + getAnswer().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
