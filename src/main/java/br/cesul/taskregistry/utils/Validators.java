package br.cesul.taskregistry.utils;

public class Validators {
    private Validators() { }

    public static boolean notBlank(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // exemplo simples: título obrigatório e tamanho max 100
    public static boolean validTitle(String input){
        return notBlank(input) && input.trim().length() <= 100;
    }

    // descrição opcional, mas se presente limitar tamanho
    public static boolean validDescription(String input){
        return input == null || input.trim().length() <= 1000;
    }
}
