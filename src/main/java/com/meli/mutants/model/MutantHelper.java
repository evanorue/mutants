package com.meli.mutants.model;

public class MutantHelper {
    public static boolean isMutantNitrogenBase(String base){
        return base.matches("[ACG]");
    }

    public static boolean hasSequence(String nitrogenSequence){
        String patron1 = "(?s)^([^A]*[A]){4}.*";
        String patron2 = "(?s)^([^G]*[G]){4}.*";
        String patron3 = "(?s)^([^C]*[C]){4}.*";
        String patron4 = "(?s)^([^T]*[T]){4}.*";
        return 	nitrogenSequence.matches(patron1) ||
                nitrogenSequence.matches(patron2) ||
                nitrogenSequence.matches(patron3) ||
                nitrogenSequence.matches(patron4);
    }
}
