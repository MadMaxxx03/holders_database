package DAO;

import Classes.Holder;
import Classes.PassedTest;
import org.hibernate.SessionFactory;

public class PassedTestDAO {

    private final SessionFactory sessionFactory;

    public PassedTestDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(PassedTest passedTest){
        sessionFactory.getCurrentSession().save(passedTest);
    }
    /*
    //create
    void add(PassedTest passedTest) throws SQLException;
    */
}
