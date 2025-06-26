package org.intellectsoft.platform.u20221c486.portfolio.domain.exceptions;

public class DuplicateFrontendUrlException extends RuntimeException {
    public DuplicateFrontendUrlException(String url) {
        super("A web application with the frontend URL already exists: " + url);
    }
}