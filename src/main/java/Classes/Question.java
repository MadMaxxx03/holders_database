package Classes;

public class Question {
    private int qId;
    private String question;
    private String answer;
    private float score;
    private Test test;

    public Question(){

    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qId=" + qId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", test=" + test +
                '}';
    }
}
