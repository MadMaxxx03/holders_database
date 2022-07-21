package Service;

import BL.SessionUtil;
import Classes.PassedTest;
import DAO.PassedTestDAO;
import org.hibernate.Session;

import java.sql.SQLException;

public class PassedTestService extends SessionUtil implements PassedTestDAO {

    @Override
    public void add(PassedTest passedTest) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(passedTest);

        //close session with a transaction
        closeTransactionSession();
    }
}
