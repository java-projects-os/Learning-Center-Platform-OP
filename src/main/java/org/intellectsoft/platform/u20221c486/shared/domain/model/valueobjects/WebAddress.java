package org.intellectsoft.platform.u20221c486.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.net.URI;
import java.net.URISyntaxException;

@Embeddable
public record WebAddress(String webAddress) {
    public WebAddress {
        if (webAddress == null || webAddress.isEmpty()) {
            throw new IllegalArgumentException("webAddress is null or empty");
        }
        if (webAddress.length() > 512) {
            throw new IllegalArgumentException("webAddress is too long");
        }
        try {
            URI uri = new URI(webAddress);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (scheme == null || host == null || !(scheme.equals("http") ||  scheme.equals("https")))
            {
                throw new IllegalArgumentException("Web Address is invalid cause must start with http or https: " + webAddress);
            }
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Web Address is invalid: " + webAddress);
        }
    }

    public String getWebAddress() {
        return webAddress;
    }
}
