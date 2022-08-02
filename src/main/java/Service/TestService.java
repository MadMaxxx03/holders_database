package Service;

import BL.SessionUtil;
import Classes.Holder;
import Classes.Question;
import Classes.Test;
import DAO.TestDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class TestService extends SessionUtil implements TestDAO {


    @Override
    public void add(Test test) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(test);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Test> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM TEST";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Test.class);
        List<Test> testList = query.list();

        closeTransactionSession();;

        return testList;
    }

    @Override
    public Set<Question> getQuestionsById(int id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM TEST WHERE TID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Test.class);
        query.setParameter("id", id);

        Test test = (Test) query.getSingleResult();
        Set<Question> questions = test.getQuestions();

        return questions;
    }


}
