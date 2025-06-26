package org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.converters;

import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.BackendStack;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BackendStackConverter implements AttributeConverter<BackendStack, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BackendStack bs) {
        return (bs != null) ? bs.getId() : null;
    }

    @Override
    public BackendStack convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return BackendStack.fromValue(dbData);
    }
}
