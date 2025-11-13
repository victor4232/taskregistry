package br.cesul.taskregistry.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void defaultConstructor_shouldInitializeFields() {
        Task t = new Task();

        assertNotNull(t.getId(), "Id não deve ser nulo");
        assertFalse(t.getId().trim().isEmpty(), "Id não deve ser vazio");
        assertEquals("", t.getTitle(), "Título padrão deve ser vazio");
        assertEquals("", t.getDescription(), "Descrição padrão deve ser vazia");
    }

    @Test
    void paramConstructor_shouldSetFields() {
        Task t = new Task("Comprar pão", "Pão integral");

        assertNotNull(t.getId());
        assertEquals("Comprar pão", t.getTitle());
        assertEquals("Pão integral", t.getDescription());
    }

    @Test
    void settersAndGetters_shouldWork() {
        Task t = new Task();
        t.setTitle("Titulo X");
        t.setDescription("Desc X");
        t.setId("custom-id-123");

        assertEquals("Titulo X", t.getTitle());
        assertEquals("Desc X", t.getDescription());
        assertEquals("custom-id-123", t.getId());
    }
}
