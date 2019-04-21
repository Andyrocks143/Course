package com.juraonline.Course.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = ImmutableUnitIndexCourse.class)
public abstract class UnitIndexCourse {

    @Value.Parameter
    public abstract Map<String,UnitCourse> getIndex();
}
