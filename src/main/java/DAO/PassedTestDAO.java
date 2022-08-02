package DAO;

import Classes.PassedTest;

import java.sql.SQLException;

public interface PassedTestDAO {

    //create
    void add(PassedTest passedTest) throws SQLException;
}
