package com.juraonline.Course.Controller;

import com.juraonline.Course.api.response.ChapterCourse;
import com.juraonline.Course.api.response.ImmutableChapterCourse;
import com.juraonline.Course.api.response.ImmutableUnitCourse;
import com.juraonline.Course.api.response.ImmutableUnitIndexCourse;
import com.juraonline.Course.api.response.UnitCourse;
import com.juraonline.Course.api.response.UnitIndexCourse;
import com.juraonline.Course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    public UnitCourse getOulineForCourse(String courseId, String parentUnitId, String unitId ) {

        String title = courseRepository.getTitle(courseId, parentUnitId, unitId);
        final ImmutableUnitCourse.Builder builder = ImmutableUnitCourse.builder()
            .title(title);

        if(courseRepository.unitCount(courseId, parentUnitId) > 0) {
            Map<String, UnitCourse> unitlist = new HashMap<>();
            for(String idUnit : courseRepository.getUnitIdList(courseId, parentUnitId)) {
                int i = 0;
                unitlist.put("\"" + i + "\"", getOulineForCourse(courseId, parentUnitId, idUnit));
                i++;
            }
            UnitIndexCourse unitIndexCourse = ImmutableUnitIndexCourse.builder()
                .putAllIndex(unitlist)
                .build();

            builder.children(unitIndexCourse);
        }
        else {
            builder.children(null);
        }

        return builder.build();
    }

    public ChapterCourse getOutline() {

        ChapterCourse chapterCourse;
        Map<String, UnitCourse> courses = new HashMap<>();
        int totalChapters = courseRepository.totalChapters();

        for( int i =0; i<totalChapters; i++) {
            final String idCourse = "\'" + i + "\'";
            for (String unitId : courseRepository.getUnitIdList(idCourse, "Null")) {
                courses.put(idCourse, getOulineForCourse(idCourse, "Null", unitId));
            }
        }
        UnitIndexCourse unitIndexCourse = ImmutableUnitIndexCourse.builder()
            .putAllIndex(courses)
            .build();

        chapterCourse = ImmutableChapterCourse.builder()
            .courses(unitIndexCourse)
            .build();

        return chapterCourse;
    }

}
