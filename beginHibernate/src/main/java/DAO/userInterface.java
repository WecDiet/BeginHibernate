package DAO;

import java.util.List;

public interface userInterface<T> {
    public List<T> selectAll();
    public T selectByName(T t, String name);
    public boolean insert(T t);
    public boolean updateByUsername(T t, String username);
    public boolean deleteByUsername(T t, String username);
}
