package Service;

import BL.SessionUtil;
import BL.TransactionHelper;
import Classes.Holder;
import Classes.PassedTest;
import Classes.Question;
import Classes.Test;
import DAO.HolderDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class HolderService {

    private final HolderDAO holderDAO;
    private final TransactionHelper th;

    public HolderService(SessionFactory sessionFactory, HolderDAO holderDAO){
        this.holderDAO = holderDAO;
        this.th = new TransactionHelper(sessionFactory);
    }

    public List<Holder> getAll(){
        return th.inTransaction(holderDAO::getAll);
    }

    public void add(Holder holder){
        th.inTransaction(() -> holderDAO.add(holder));
    }

    public Set<PassedTest> getPassedTestsById(int id){
        return th.inTransaction(() -> holderDAO.getPassedTestsById(id));
    }

    public void  update(Holder holder){
        th.inTransaction(() -> holderDAO.update(holder));
    }

    /*
    @Override
    public void add(Holder holder) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(holder);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void update(Holder holder) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(holder);

        closeTransactionSession();
    }

    @Override
    public List<Holder> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM HOLDER";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Holder.class);
        List<Holder> holderList = query.list();

        closeTransactionSession();;

        return holderList;
    }

    @Override
    public Set<PassedTest> getPassedTestsById(int id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM HOLDER WHERE HID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Holder.class);
        query.setParameter("id", id);

        Holder holder = (Holder) query.getSingleResult();
        Set<PassedTest> passedTests = holder.getPassedTests();

        return passedTests;
    }
    */
}
