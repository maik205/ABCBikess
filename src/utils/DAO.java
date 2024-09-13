package utils;

import java.util.Map;
import java.util.Optional;

public interface DAO<T> {
    
    Optional<T> get(String id);
    
    Map<String, T> getAll();
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
}
