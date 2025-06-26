package org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.repositories;

import org.intellectsoft.platform.u20221c486.portfolio.domain.model.aggregates.WebApplication;
import org.intellectsoft.platform.u20221c486.shared.domain.model.valueobjects.WebAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * WebApplicationRepository
 *
 * @summary Repository interface for accessing and managing WebApplication entities.
 * Extends JpaRepository to provide basic CRUD operations and includes custom
 * query methods to check for unique frontend and backend URLs.
 *
 * @author Paul Sulca
 */

public interface WebApplicationRepository extends JpaRepository<WebApplication, Long> {
    boolean existsByFrontendUrl(WebAddress frontendUrl);
    boolean existsByBackendUrl(WebAddress backendUrl);
}
