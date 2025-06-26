package org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum FrontendStack {
    ANGULAR(1, "ANGULAR"),
    VUE(2, "VUE"),
    REACT(3, "REACT");

    private final int id;
    private final String option;

    FrontendStack(int id, String option) {
        this.id = id;
        this.option = option;
    }

    public static FrontendStack fromString(String value) {
        value = value.toUpperCase();
        for (FrontendStack fs : FrontendStack.values()) {
            if (fs.option.equals(value)) {
                return fs;
            }
        }
        throw new IllegalArgumentException("Invalid FrontendStack option: " + value);
    }

    public static FrontendStack fromValue(int id) {
        for (FrontendStack fs : FrontendStack.values()) {
            if (fs.getId() == id) {
                return fs;
            }
        }
        throw new IllegalArgumentException("Inavalid FrontendStack id: " + id);
    }
}
