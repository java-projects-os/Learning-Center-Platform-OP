package org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ClientId(Long clientId) {
    public ClientId {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client ID must not be null or less than one");
        }
    }

    public Long getClientId() {
        return clientId;
    }
}
