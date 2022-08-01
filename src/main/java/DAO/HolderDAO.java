package DAO;

import Classes.Holder;
import Classes.PassedTest;
import Classes.Question;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HolderDAO {

    private final SessionFactory sessionFactory;

    public HolderDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Holder> getAll(){
        return new ArrayList<Holder>
                (sessionFactory.getCurrentSession().
                        createQuery("from Holder", Holder.class).list());
    }

    public void add(Holder holder){
        sessionFactory.getCurrentSession().save(holder);
    }

    public Set<PassedTest> getPassedTestsById(int id){
        return (sessionFactory.getCurrentSession().get(Holder.class, id)).getPassedTests();
    }

    public void  update(Holder holder){
        sessionFactory.getCurrentSession().update(holder);
    }

    /*
    //create
    void add(Holder holder) throws SQLException;

    //update status
    void update(Holder holder) throws SQLException;

    //read
    List<Holder> getAll() throws  SQLException;

    //getPassedTestsById
    Set<PassedTest> getPassedTestsById(int id) throws  SQLException;
    */

}
