package Service;

import BL.SessionUtil;
import Classes.Holder;
import Classes.Question;
import Classes.Test;
import DAO.QuestionDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class QuestionService extends SessionUtil implements QuestionDAO {

    @Override
    public void add(Question question) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(question);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Question> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM QUESTION";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Question.class);
        List<Question> questionList = query.list();

        closeTransactionSession();;

        return questionList;
    }
}
