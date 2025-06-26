package org.intellectsoft.platform.u20221c486.portfolio.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.commandservices.CreateWebApplicationCommand;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.BackendStack;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.ClientId;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.CloudPlatform;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.FrontendStack;
import org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.converters.BackendStackConverter;
import org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.converters.CloudPlatformConverter;
import org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.converters.FrontendStackConverter;
import org.intellectsoft.platform.u20221c486.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.intellectsoft.platform.u20221c486.shared.domain.model.valueobjects.WebAddress;

import java.util.Date;
/**
 * Aggregate root representing a Web Application in the domain.
 * <p>
 * Encapsulates business-relevant data such as technology stacks, URLs, availability,
 * cloud platform, and deployment information.
 * <p>
 * Implements JPA annotations for persistence and uses value objects for stronger domain modeling.
 *
 * @author Paul Sulca
 */
@Getter
@Entity
public class WebApplication extends AuditableAbstractAggregateRoot<WebApplication> {
    @NotBlank
    @Size(max = 80)
    @Column(length = 80, nullable = false)
    private String name;

    @Embedded
    @AttributeOverride(name  = "clientId", column = @Column(name = "client_id", nullable = false))
    private ClientId clientId;

    @Convert(converter = FrontendStackConverter.class)
    @Column(nullable = false)
    private FrontendStack frontendStack;

    @Embedded
    @AttributeOverride(name  = "webAddress", column = @Column(name = "frontend_url", nullable = false, length = 512))
    private WebAddress frontendUrl;

    @Convert(converter = BackendStackConverter.class)
    @Column(nullable = false)
    private BackendStack backendStack;

    @Embedded
    @AttributeOverride(name  = "webAddress", column = @Column(name = "backend_url", nullable = false, length = 512))
    private WebAddress backendUrl;

    @Convert(converter = CloudPlatformConverter.class)
    @Column(nullable = false)
    private CloudPlatform cloudPlatform;

    @NotBlank
    @Size(max = 360)
    @Column(length = 360, nullable = false)
    private String description;

    @Min(85)
    @Max(99)
    @NotNull
    private Integer availabilityPercentage;

    @NotNull
    private Date launchDate;

    /**
     * Default constructor for JPA
     */
    public WebApplication() {
        // Required by JPA
    }

    /**
     * Constructor to create a WebApplication from a CreateWebApplicationCommand
     * @param command the command containing the web application data
     */
    public WebApplication(CreateWebApplicationCommand command) {
        this();
        this.name = command.name();
        this.clientId = new ClientId(command.clientId());
        this.frontendStack = FrontendStack.fromString(command.frontendStack());
        this.frontendUrl = new WebAddress(command.frontendUrl());
        this.backendStack = BackendStack.fromString(command.backendStack());
        this.backendUrl = new WebAddress(command.backendUrl());
        this.cloudPlatform = CloudPlatform.fromString(command.cloudPlatform());
        this.description = command.description();
        this.availabilityPercentage = command.availabiltyPercentage();
        this.launchDate = command.launchDate();
    }
    public Long getClientId() {
        return this.clientId.getClientId();
    }
    public int getFrontendStack() {
        return frontendStack.getId();
    }
    public int getBackendStack() {
        return backendStack.getId();
    }
    public int getCloudPlatform() {
        return cloudPlatform.getId();
    }
    public String getFrontendUrl() {
        return frontendUrl.getWebAddress();
    }
    public String getBackendUrl() {
        return backendUrl.getWebAddress();
    }
}
