package com.BlogsProject.Functions.Service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface GeneralService<T> {

    public void create(T t);

    public void update(T t);

    public T findById(int id);

    public List<T> finAll();

    public void delete(T t);
}
