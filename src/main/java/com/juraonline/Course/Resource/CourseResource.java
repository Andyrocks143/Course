package com.juraonline.Course.Resource;

import com.juraonline.Course.Controller.CourseController;
import com.juraonline.Course.api.response.ChapterCourse;
import com.juraonline.Course.model.Courses;
import com.juraonline.Course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/juraonline")
public class CourseResource {

    @Autowired
    private CourseRepository courseRepository;

    protected CourseController courseController;

    @GetMapping("/courseOutine")
    public Response getCourseOutline() {

        ChapterCourse chapterCourse = courseController.getOutline();

        System.out.println(courseRepository.totalChapters());

        return Response.ok(chapterCourse).build();
    }
}
