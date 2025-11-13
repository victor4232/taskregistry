package br.cesul.taskregistry.repository;

import br.cesul.taskregistry.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryFakeTest {

    private TaskRepositoryFake repo;

    @BeforeEach
    void setUp() {
        repo = new TaskRepositoryFake();
    }

    @Test
    void saveAndFindAll_shouldWork() {
        Task t1 = new Task("A", "desc A");
        Task t2 = new Task("B", "desc B");

        repo.save(t1);
        repo.save(t2);

        List<Task> all = repo.findAll();
        assertEquals(2, all.size());
    }

    @Test
    void deleteAll_shouldClearStorage() {
        repo.save(new Task("A","a"));
        repo.deleteAll();
        assertTrue(repo.findAll().isEmpty());
    }
}
