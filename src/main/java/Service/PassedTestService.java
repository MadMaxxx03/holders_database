package Service;

import BL.SessionUtil;
import BL.TransactionHelper;
import Classes.Holder;
import Classes.PassedTest;
import DAO.HolderDAO;
import DAO.PassedTestDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class PassedTestService {

    private final PassedTestDAO passedTestDAO;
    private final TransactionHelper th;

    public PassedTestService(SessionFactory sessionFactory, PassedTestDAO passedTestDAO){
        this.passedTestDAO = passedTestDAO;
        this.th = new TransactionHelper(sessionFactory);
    }

    public void add(PassedTest passedTest){
        th.inTransaction(() -> passedTestDAO.add(passedTest));
    }

    /*
    @Override
    public void add(PassedTest passedTest) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(passedTest);

        //close session with a transaction
        closeTransactionSession();
    }
     */
}
