package com.juraonline.Course.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = ImmutableUnitCourse.class)
public abstract class UnitCourse {

    @Value.Parameter
    @JsonProperty(value = "title")
    public abstract String getTitle();

    @Value.Parameter
    @JsonProperty(value = "children")
    public abstract UnitIndexCourse getChildren();
}
