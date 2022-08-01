package DAO;

import Classes.Holder;
import Classes.Question;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    private final SessionFactory sessionFactory;

    public QuestionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Question question){
        sessionFactory.getCurrentSession().save(question);
    }

    public List<Question> getAll(){
        return new ArrayList<Question>(sessionFactory.getCurrentSession()
                .createQuery("from Question", Question.class)
                .list());
    }

    /*
    //create
    void add(Question question) throws SQLException;

    //read
    List<Question> getAll() throws  SQLException;

     */
}
