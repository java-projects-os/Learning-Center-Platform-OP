package org.intellectsoft.platform.u20221c486.portfolio.application.internal.commandservices;

import org.intellectsoft.platform.u20221c486.portfolio.domain.exceptions.DuplicateBackendUrlException;
import org.intellectsoft.platform.u20221c486.portfolio.domain.exceptions.DuplicateFrontendUrlException;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.aggregates.WebApplication;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.commandservices.CreateWebApplicationCommand;
import org.intellectsoft.platform.u20221c486.portfolio.domain.services.WebApplicationCommandService;
import org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.repositories.WebApplicationRepository;
import org.intellectsoft.platform.u20221c486.shared.domain.model.valueobjects.WebAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebApplicationCommandServiceImpl implements WebApplicationCommandService {
    private final WebApplicationRepository webApplicationRepository;


    /**
     * Constructs the service with the provided WebApplicationRepository.
     *
     * @param webApplicationRepository the repository used to persist WebApplication entities
     */
    public WebApplicationCommandServiceImpl(WebApplicationRepository webApplicationRepository) {
        this.webApplicationRepository = webApplicationRepository;
    }

    /**
     * Handles the creation of a new WebApplication instance from a command object.
     * <p>
     * Validates that the backend and frontend URLs do not already exist in the system.
     * Throws custom exceptions if duplicates are found.
     *
     * @param command the command containing the data needed to create a WebApplication
     * @return an Optional containing the newly created WebApplication, or empty if creation failed
     * @throws DuplicateBackendUrlException if the backend URL already exists
     * @throws DuplicateFrontendUrlException if the frontend URL already exists
     */

    @Override
    public Optional<WebApplication> handle(CreateWebApplicationCommand command) {

        // Create value objects for frontend and backend URLs
        var backendUrl = new WebAddress(command.backendUrl());
        var frontendUrl = new WebAddress(command.frontendUrl());

        // Check for duplicate backend URL
        if (webApplicationRepository.existsByBackendUrl(backendUrl)) {
            throw new DuplicateBackendUrlException(command.backendUrl());
        }

        // Check for duplicate frontend URL
        if (webApplicationRepository.existsByFrontendUrl(frontendUrl)) {
            throw new DuplicateFrontendUrlException(command.frontendUrl());
        }

        // Create and persist the new WebApplication
        var webApplication = new WebApplication(command);
        webApplicationRepository.save(webApplication);
        return Optional.of(webApplication);
    }
}
