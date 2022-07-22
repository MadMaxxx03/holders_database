package Classes;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TEST")
public class Test {

    @Id
    @Column(name = "TID")
    private int tId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HID")
    private Holder holder;

    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER)
    private Set<Question> questions;

    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER)
    private Set<PassedTest> passedTests;

    public Test(){

    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Set getQuestions() {
        return questions;
    }

    public void setQuestions(Set questions) {
        this.questions = questions;
    }

    public Set getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(Set passedTests) {
        this.passedTests = passedTests;
    }

    @Override
    public String toString() {
        return "Test{" +
                "tId=" + tId +
                ", holder=" + holder +
                '}';
    }
}
