package org.intellectsoft.platform.u20221c486.portfolio.domain.model.commandservices;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/**
 * Create Web Application Command
 *
 * @summary Command to create a new web application with validated fields using the fail-fast pattern.
 * This record represents the structure and constraints required to create a web application domain object.
 *
 * @param name the name of the web application (non-null, non-empty, max 80 characters)
 * @param clientId the identifier of the associated client (must be positive)
 * @param frontendStack the name of the frontend technology stack (non-null, non-empty)
 * @param frontendUrl the URL of the frontend (non-null, non-empty, max 512 characters)
 * @param backendStack the name of the backend technology stack (non-null, non-empty)
 * @param backendUrl the URL of the backend (non-null, non-empty, max 512 characters)
 * @param cloudPlatform the name of the cloud platform (non-null, non-empty)
 * @param description a textual description of the web application (non-null, non-empty, max 360 characters)
 * @param availabiltyPercentage the availability percentage of the application (between 85 and 99, assumed to be validated externally)
 * @param launchDate the launch date of the web application (cannot be in the future)
 *
 * @author Paul Sulca
 */

public record CreateWebApplicationCommand(
        String name,
        Long clientId,
        String frontendStack,
        String frontendUrl,
        String backendStack,
        String backendUrl,
        String cloudPlatform,
        String description,
        Integer availabiltyPercentage,
        Date launchDate) {

    public CreateWebApplicationCommand {
        if (name == null || name.isEmpty() || name.length() > 80) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Invalid clientId: " + clientId);
        }
        if (frontendUrl == null || frontendUrl.isEmpty()) {
            throw new IllegalArgumentException("Invalid frontendStack: " + frontendStack);
        }
        if (frontendUrl.length() > 512) {
            throw new IllegalArgumentException("Frontend URL cannot exceed 512 characters");
        }
        if (frontendStack == null || frontendStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid frontendStack: " + frontendStack);
        }
        if (backendUrl == null || backendUrl.isEmpty()) {
            throw new IllegalArgumentException("Inavlid backendStack: " + backendStack);
        }
        if (backendUrl.length() > 512) {
            throw new IllegalArgumentException("Backend URL cannot exceed 512 characters");
        }
        if (backendStack == null || backendStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid backendStack: " + backendStack);
        }
        if (cloudPlatform == null || cloudPlatform.isEmpty()) {
            throw new IllegalArgumentException("Invalid cloudPlatform: " + cloudPlatform);
        }
        if (description == null || description.isEmpty() || description.length() > 360) {
            throw new IllegalArgumentException("Invalid description: " + description);
        }
        if (availabiltyPercentage == null) {
            throw new IllegalArgumentException("AvailabiltyPercentage cant be null");
        }
        if (availabiltyPercentage < 85 || availabiltyPercentage > 100) {
            throw new IllegalArgumentException("AvailabiltyPercentage out of range: " + availabiltyPercentage);
        }
        if (launchDate == null) {
            throw new IllegalArgumentException("Launch Date can't be null");
        }

        LocalDate ldIntellectSoftActualDateFounding = LocalDate.of(2007,7,15);
        var intellectSoftActualDateFouding = Date.from(ldIntellectSoftActualDateFounding.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (launchDate.before(intellectSoftActualDateFouding)) {
            throw new IllegalArgumentException("Launch date cannot be before the intellectSoftActualDateFounding");
        }

        var actualDate = new Date();
        if (launchDate.after(actualDate)) {
            throw new IllegalArgumentException("Launch date cannot be in the future");
        }

    }
}
