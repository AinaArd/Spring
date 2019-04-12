package app.dao;

import app.models.Participant;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SimpleDao {
    List<Participant> getParticipants();
    void saveParticipant(String name, String city, String email);
}
