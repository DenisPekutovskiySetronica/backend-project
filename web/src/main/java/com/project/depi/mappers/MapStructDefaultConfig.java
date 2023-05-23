package com.project.depi.mappers;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Typical configuration for converters
 */
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring"
)
public interface MapStructDefaultConfig {
}
