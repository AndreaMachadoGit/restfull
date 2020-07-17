package com.andrea.restfull.enums;

import java.util.stream.Stream;

public enum Raca {
    HUMANO("humano"),
    ELFO("elfo"),
    ORC("orc"),
    ANAO("anao");

    private String value;

    public static Raca of(String value) {
        return Stream.of(Raca.values())
                .filter(r -> r.getValue().equals(value))
                .findFirst()
                .orElseThrow();
    }

    public String getValue() {
        return value;
    }

    Raca(String value) {
        this.value = value;
    }


}
