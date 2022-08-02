package DAO;

import Classes.Holder;
import Classes.Question;
import Classes.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface TestDAO {
    //create
    void add(Test test) throws SQLException;

    //read
    List<Test> getAll() throws  SQLException;

    //getQuestionsById
    Set<Question> getQuestionsById(int id) throws  SQLException;

}
