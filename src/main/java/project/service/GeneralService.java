package project.service;

import project.classes.Holder;

import java.util.List;

public interface GeneralService<T> {

    void save(T obj);

    List<T> getAll();

    void update(T obj);

    void delete(T obj);

    T getById(int id);

    boolean isObjPresent(T obj);

    boolean isObjSame(T obj);

}
