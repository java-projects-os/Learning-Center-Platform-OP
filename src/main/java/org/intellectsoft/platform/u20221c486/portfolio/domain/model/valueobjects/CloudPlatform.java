package org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum CloudPlatform {
    AWS(1, "AWS"),
    AZURE(2, "AZURE"),
    GCP(3, "GCP");

    private final int id;
    private final String option;

    CloudPlatform(int id, String option) {
        this.id = id;
        this.option = option;
    }

    public static CloudPlatform fromString(String value) {
        value = value.toUpperCase();
        for (CloudPlatform cp : CloudPlatform.values() ) {
            if (cp.option.equals(value)) {
                return cp;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public static CloudPlatform fromValue(int id) {
        for (CloudPlatform cp : CloudPlatform.values()) {
            if (cp.getId() == id) {
                return cp;
            }
        }
        throw new IllegalArgumentException("CloudPlatform invalid: " + id);
    }
}
