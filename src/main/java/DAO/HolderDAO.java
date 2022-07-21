package DAO;

import Classes.Holder;
import Classes.PassedTest;
import Classes.Question;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface HolderDAO {

    //create
    void add(Holder holder) throws SQLException;

    //update status
    void update(Holder holder) throws SQLException;

    //read
    List<Holder> getAll() throws  SQLException;

    //getPassedTestsById
    Set<PassedTest> getPassedTestsById(int id) throws  SQLException;

}
