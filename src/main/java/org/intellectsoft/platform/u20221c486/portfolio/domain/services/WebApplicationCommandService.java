package org.intellectsoft.platform.u20221c486.portfolio.domain.services;

import org.intellectsoft.platform.u20221c486.portfolio.domain.model.aggregates.WebApplication;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.commandservices.CreateWebApplicationCommand;

import java.util.Optional;

public interface WebApplicationCommandService {
    Optional<WebApplication> handle(CreateWebApplicationCommand command);

}
