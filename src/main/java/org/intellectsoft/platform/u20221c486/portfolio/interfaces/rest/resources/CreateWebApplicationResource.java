package org.intellectsoft.platform.u20221c486.portfolio.interfaces.rest.resources;

import java.util.Date;

//AQUI NO DEBE ESTAR EN EL CLIENTID PQ SE ESPECIFICA QUE ESTA EN EL PATH
//LA PLANTILLA DEL SWAGGER
public record CreateWebApplicationResource(
        String name,
        String frontendStack,
        String frontendUrl,
        String backendStack,
        String backendUrl,
        String cloudPlatform,
        String description,
        Integer availabiltyPercentage,
        Date launchDate) {

    public CreateWebApplicationResource {
        if (name == null || name.isEmpty() || name.length() > 80) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        if (frontendUrl == null || frontendUrl.isEmpty() || frontendUrl.length() > 512) {
            throw new IllegalArgumentException("Invalid frontendStack: " + frontendStack);
        }
        if (frontendStack == null || frontendStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid frontendStack: " + frontendStack);
        }
        if (backendUrl == null || backendUrl.isEmpty() || backendUrl.length() > 512) {
            throw new IllegalArgumentException("Inavlid backendStack: " + backendStack);
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
            throw new IllegalArgumentException("AvailabiltyPercentage out of range");
        }
        if (launchDate == null || launchDate.after(new Date())) {
            throw new IllegalArgumentException("Invalid launchDate: " + launchDate);
        }
    }
}
