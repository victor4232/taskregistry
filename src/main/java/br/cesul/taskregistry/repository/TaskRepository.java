package br.cesul.taskregistry.repository;

import br.cesul.taskregistry.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task save(Task t);
    void deleteAll();

}
