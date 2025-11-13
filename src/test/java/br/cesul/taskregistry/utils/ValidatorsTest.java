package br.cesul.taskregistry.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    @Test
    void notBlank_shouldReturnFalseForNullOrEmpty() {
        assertFalse(Validators.notBlank(null));
        assertFalse(Validators.notBlank(""));
        assertFalse(Validators.notBlank("   "));
        assertTrue(Validators.notBlank("abc"));
    }

    @Test
    void validTitle_and_validDescription() {
        assertTrue(Validators.validTitle("Título válido"));
        assertFalse(Validators.validTitle(""));
        String longDesc = "a".repeat(1000);
        assertTrue(Validators.validDescription(longDesc));
    }
}
