package springApp.DAO;

import java.util.List;

public interface GeneralDAO<T> {

    void save(T obj);
    List<T> getAll();

    //T get(int id);

    void update(T obj);

    void delete(T obj);
}
