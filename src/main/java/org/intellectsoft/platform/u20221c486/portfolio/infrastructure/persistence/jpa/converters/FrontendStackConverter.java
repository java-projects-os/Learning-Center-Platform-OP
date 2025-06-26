package org.intellectsoft.platform.u20221c486.portfolio.infrastructure.persistence.jpa.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.intellectsoft.platform.u20221c486.portfolio.domain.model.valueobjects.FrontendStack;

@Converter(autoApply = true)
public class FrontendStackConverter implements AttributeConverter<FrontendStack, Integer> {
    @Override
    public Integer convertToDatabaseColumn(FrontendStack bs) {
        return (bs != null) ? bs.getId() : null;
    }

    @Override
    public FrontendStack convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return FrontendStack.fromValue(dbData);
    }
}