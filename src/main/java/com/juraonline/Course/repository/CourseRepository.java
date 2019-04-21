package com.juraonline.Course.repository;

import com.juraonline.Course.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository  extends JpaRepository<Courses, Long> {

    @Query("select count(distinct course_id) from Courses")
    int totalChapters();

    @Query("select title from Courses where course_id = ':course_id' AND parent_unit_id = ':parent_unit_id' AND unit_id = ':unit_id'")
    String getTitle(@Param("course_id") String course_id, @Param("parent_unit_id") String parent_unit_id, @Param("unit_id") String unit_id);

    @Query("select unit_id from Courses where course_id = ':course_id' and parent_unit_id = ':parent_unit_id'")
    List<String> getUnitIdList(@Param("course_id") String course_id, @Param("parent_unit_id") String parent_unit_id);

    @Query("select count(*) from Courses where parent_unit_id = ':parent_unit_id' and course_id = ':course_id'")
    int unitCount(@Param("course_id") String course_id, @Param("parent_unit_id") String parent_unit_id);
}
