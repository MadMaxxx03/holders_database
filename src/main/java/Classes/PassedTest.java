package Classes;

public class PassedTest {
    private int pId;
    private float progress;
    private Holder holder;
    private Test test;

    public PassedTest(){

    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "PassedTest{" +
                "pId=" + pId +
                ", progress=" + progress +
                ", holder=" + holder +
                ", test=" + test +
                '}';
    }
}
