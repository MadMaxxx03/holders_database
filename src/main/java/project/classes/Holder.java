package project.classes;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "HOLDER")
public class Holder {

    @Id
    @Column(name = "HID")
    private int hId;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private boolean role;

    @OneToMany(mappedBy = "holder", fetch = FetchType.LAZY)
    private Set<PassedTest> passedTests;

    @OneToMany(mappedBy = "holder", fetch = FetchType.LAZY)
    private Set<Test> tests;

    public Holder(){

    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public Set getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(Set passedTests) {
        this.passedTests = passedTests;
    }

    public Set getTests() {
        return tests;
    }

    public void setTests(Set tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "hId=" + hId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
