package com.BlogsProject.Functions.Service;

import com.BlogsProject.Functions.Entity.Event;
import com.BlogsProject.Functions.Repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements GeneralService<Event> {

    private final EventRepository er;

    @Override
    public void create(Event event) {
        er.save(event);
    }

    @Override
    public void update(Event event) {
        er.save(event);
    }

    @Override
    public Event findById(int id) {
        return er.findById(id).get();
    }

    @Override
    public List<Event> finAll() {
        return er.findAll();
    }

    @Override
    public void delete(Event event) {
        er.delete(event);
    }
}
