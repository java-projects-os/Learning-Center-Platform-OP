package org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum BackendStack {
    SPRING_BOOT(1, "SPRING BOOT"),
    DOTNET(2, ".NET"),
    NODEJS(3, "NODE.JS");

    private final int id;
    private final String option;

    BackendStack (int id, String option) {
        this.id = id;
        this.option = option;
    }

    public static BackendStack fromString(String value) {
        value = value.toUpperCase();
        for (BackendStack bs : BackendStack.values()) {
            if (bs.option.equals(value)) {
                return bs;
            }
        }
        throw new IllegalArgumentException("BackendStack invalid: " + value);
    }

    public static BackendStack fromValue(int id) {
        for (BackendStack bs : BackendStack.values()) {
            if (bs.id == id) {
                return bs;
            }
        }
        throw new IllegalArgumentException("BackendStack invalid: " + id);
    }

}
