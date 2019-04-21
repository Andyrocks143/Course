package com.juraonline.Course.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Courses {

    private long id;

    private String courseId;
    private String courseTitle;
    private String parentUnitId;
    private String unitId;
    private String title;


    public Courses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "course_id", nullable = false)
    public String getCourseId() {
        return courseId;
    }

    @Column(name = "course_title")
    public String getCourseTitle() {
        return courseTitle;
    }

    @Column(name = "parent_unit_id")
    public String getParentUnitId() {
        return parentUnitId;
    }

    @Column(name = "unit_id")
    public String getUnitId() {
        return unitId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public Courses(final String courseId, final String courseTitle, final String parentUnitId, final String unitId, final String title) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.parentUnitId = parentUnitId;
        this.unitId = unitId;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Courses{" +
            "id=" + id +
            ", courseId='" + courseId + '\'' +
            ", courseTitle='" + courseTitle + '\'' +
            ", parentUnitId='" + parentUnitId + '\'' +
            ", unitId='" + unitId + '\'' +
            ", title='" + title + '\'' +
            '}';
    }

    public void setCourseId(final String courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(final String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setParentUnitId(final String parentUnitId) {
        this.parentUnitId = parentUnitId;
    }

    public void setUnitId(final String unitId) {
        this.unitId = unitId;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
