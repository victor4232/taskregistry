package br.cesul.taskregistry.viewmodel;

import br.cesul.taskregistry.model.Task;
import br.cesul.taskregistry.repository.TaskRepository;
import br.cesul.taskregistry.utils.Validators;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TaskListViewModel {
    private final ObservableList<Task> items = FXCollections.observableArrayList();
    private final BooleanProperty loading = new SimpleBooleanProperty(false);

    private final TaskRepository repository;

    public TaskListViewModel(TaskRepository repository) {
        this.repository = repository;
    }

    public ObservableList<Task> getItems() {
        return items;
    }

    public BooleanProperty loadingProperty() {
        return loading;
    }

    public boolean isLoading() {
        return loading.get();
    }

    public void loadAll() {
        loading.set(true);
        try {
            List<Task> all = repository.findAll();
            items.setAll(all);
        } finally {
            loading.set(false);
        }
    }

    public Task addTask(String title, String description) {
        if (!Validators.validTitle(title)) {
            throw new IllegalArgumentException("Título inválido");
        }
        if (!Validators.validDescription(description)) {
            throw new IllegalArgumentException("Descrição inválida");
        }

        Task t = new Task(title.trim(), description == null ? "" : description.trim());
        repository.save(t);
        items.add(t);
        return t;
    }

    public void toggleCompleted(Task task) {
        if (task == null) return;
        repository.toggleCompleted(task.getId());
        task.setCompleted(true);
    }



}
