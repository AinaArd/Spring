package app.dao;

import app.models.Participant;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SimpleDao<T> {
    List<Object> getAll();
    void save(String name, String city, String email);
    void save(String text, Long id);
}
