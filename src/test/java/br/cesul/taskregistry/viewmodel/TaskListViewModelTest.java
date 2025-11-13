package br.cesul.taskregistry.viewmodel;

import br.cesul.taskregistry.model.Task;
import br.cesul.taskregistry.repository.TaskRepositoryFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListViewModelTest {

    private TaskListViewModel vm;
    private TaskRepositoryFake repo;

    @BeforeEach
    void setUp() {
        repo = new TaskRepositoryFake();
        vm = new TaskListViewModel(repo);
    }

    @Test
    void addTask_shouldAddAndPersist() {
        assertTrue(vm.getItems().isEmpty());
        vm.addTask("Nova", "descricao");
        assertEquals(1, vm.getItems().size());
        assertEquals(1, repo.findAll().size());
    }

    @Test
    void loadAll_shouldPopulateItems() {
        repo.save(new Task("Um", "x"));
        repo.save(new Task("Dois", "y"));
        vm.loadAll();
        assertEquals(2, vm.getItems().size());
    }

    @Test
    void toggleCompleted_shouldChangeFlag() {
        Task t = vm.addTask("Test", "desc");
        assertFalse(t.isCompleted());
        vm.toggleCompleted(t);

        assertTrue(vm.getItems().get(0).isCompleted());
    }
}
