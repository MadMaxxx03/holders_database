package DAO;

import Classes.Holder;
import Classes.PassedTest;
import Classes.Question;
import Classes.Test;
import jakarta.persistence.Table;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestDAO {

    private final SessionFactory sessionFactory;

    public TestDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Test test){
        sessionFactory.getCurrentSession().save(test);
    }

    public List<Test> getAll(){
        return new ArrayList<Test>(sessionFactory.getCurrentSession()
                .createQuery("from Test ", Test.class)
                .list());
    }

    public Set<Question> getQuestionsById(int id){
        return (sessionFactory.getCurrentSession().get(Test.class, id)).getQuestions();
    }

    /*
    //create
    void add(Test test) throws SQLException;

    //read
    List<Test> getAll() throws  SQLException;

    //getQuestionsById
    Set<Question> getQuestionsById(int id) throws  SQLException;

     */

}
