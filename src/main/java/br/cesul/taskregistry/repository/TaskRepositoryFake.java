package br.cesul.taskregistry.repository;

import br.cesul.taskregistry.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskRepositoryFake implements TaskRepository {
    // usaremos uma lista em memória para simular persistência
    private final List<Task> storage = new CopyOnWriteArrayList<>();

    public TaskRepositoryFake() {
        // opcional: popular com alguns itens de exemplo
        // storage.add(new Task("Exemplo 1", "Descrição do exemplo 1"));
    }

    @Override
    public List<Task> findAll() {
        // retornar cópia para evitar que chamador modifique diretamente o storage
        return new ArrayList<>(storage);
    }

    @Override
    public Task save(Task t) {
        // se o id já existir, atualizamos (simples replace por id), caso contrário insert
        boolean found = false;
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId().equals(t.getId())) {
                storage.set(i, t);
                found = true;
                break;
            }
        }
        if (!found) storage.add(t);
        return t;
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }
}
