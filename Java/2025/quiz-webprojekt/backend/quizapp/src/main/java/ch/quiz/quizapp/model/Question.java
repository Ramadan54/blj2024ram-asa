package ch.quiz.quizapp.model;

import java.util.List;

public class Question {
    private String question;
    private List<String> answers;
    private int correctIndex;
    private String category;

    public Question() {}

    public Question(String question, List<String> answers, int correctIndex, String category) {
        this.question = question;
        this.answers = answers;
        this.correctIndex = correctIndex;
        this.category = category;
    }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public List<String> getAnswers() { return answers; }
    public void setAnswers(List<String> answers) { this.answers = answers; }

    public int getCorrectIndex() { return correctIndex; }
    public void setCorrectIndex(int correctIndex) { this.correctIndex = correctIndex; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}