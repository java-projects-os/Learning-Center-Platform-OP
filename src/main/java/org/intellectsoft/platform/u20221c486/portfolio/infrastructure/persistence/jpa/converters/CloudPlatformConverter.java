package org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.CloudPlatform;

@Converter(autoApply = true)
public class CloudPlatformConverter implements AttributeConverter<CloudPlatform, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CloudPlatform cp) {
        return (cp != null) ? cp.getId() : null;
    }

    @Override
    public CloudPlatform convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return CloudPlatform.fromValue(dbData);
    }
}
