package com.system.entity;

import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 9/4/2019 11:14 PM
 * @description：student的扩展类
 */

public class StudentCustom extends Student{

    //  所属院系名
    private String collegeName;

    // 选课列表
    private List<SelectedCourseCustom> selectedCourseCustoms;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<SelectedCourseCustom> getSelectedCourseCustoms() {
        return selectedCourseCustoms;
    }

    public void setSelectedCourseCustoms(List<SelectedCourseCustom> selectedCourseCustoms) {
        this.selectedCourseCustoms = selectedCourseCustoms;
    }
}
