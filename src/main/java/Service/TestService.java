package Service;

import BL.SessionUtil;
import BL.TransactionHelper;
import Classes.Holder;
import Classes.PassedTest;
import Classes.Question;
import Classes.Test;
import DAO.HolderDAO;
import DAO.TestDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class TestService {

    private final TestDAO testDAO;
    private final TransactionHelper th;

    public TestService(SessionFactory sessionFactory, TestDAO testDAO){
        this.testDAO = testDAO;
        this.th = new TransactionHelper(sessionFactory);
    }

    public List<Test> getAll(){
        return th.inTransaction(testDAO::getAll);
    }

    public void add(Test test){
        th.inTransaction(() -> testDAO.add(test));
    }

    public Set<Question> getQuestionsById(int id){
        return th.inTransaction(() -> testDAO.getQuestionsById(id));
    }

    /*
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

     */
}
