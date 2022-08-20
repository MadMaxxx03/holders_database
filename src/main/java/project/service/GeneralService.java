package project.service;

import project.classes.Holder;

import java.util.List;

public interface GeneralService<T> {

    void save(T obj);

    List<T> getAll();

    void update(T obj);

    void delete(T obj);

    boolean isObjPresent(T obj);
}
