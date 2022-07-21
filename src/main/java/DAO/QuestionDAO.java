package DAO;

import Classes.Question;
import Classes.Test;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDAO {

    //create
    void add(Question question) throws SQLException;

    //read
    List<Question> getAll() throws  SQLException;
}
