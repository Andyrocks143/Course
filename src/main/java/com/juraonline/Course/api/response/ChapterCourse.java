package com.juraonline.Course.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import java.io.Serializable;

@Value.Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = ImmutableChapterCourse.class)
public abstract class ChapterCourse implements Serializable {


    @Value.Parameter
    @JsonProperty(value = "Courses")
    public abstract UnitIndexCourse getCourses();
}
