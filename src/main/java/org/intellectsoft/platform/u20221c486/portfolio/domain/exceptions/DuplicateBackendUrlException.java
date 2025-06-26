package org.intellectsoft.platform.u20221c486.portfolio.domain.exceptions;

public class DuplicateBackendUrlException extends RuntimeException {
    public DuplicateBackendUrlException(String url) {
        super("A web application with the backend URL already exists: " + url);
    }
}