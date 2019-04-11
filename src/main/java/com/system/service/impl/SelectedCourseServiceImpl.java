package com.system.service.impl;

import com.system.dao.SelectedcourseMapper;
import com.system.dao.StudentMapper;
import com.system.entity.*;
import com.system.service.SelectedCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 8:36 PM
 * @description：
 */
@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<SelectedCourseCustom> findByCourseID(Integer id) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);
        List<SelectedCourseCustom> secList = new ArrayList<>();
        for(Selectedcourse s : list){
            SelectedCourseCustom sec = new SelectedCourseCustom();
            BeanUtils.copyProperties(s, sec);
            //判断是否完成该类课程
            if(sec.getMark() != null){
                sec.setOver(true);
            }
            Student student = studentMapper.selectByPrimaryKey(sec.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sec.setStudentCustom(studentCustom);
            secList.add(sec);
        }
        return secList;
    }

    @Override
    public List<SelectedCourseCustom> findByCourseIDPaging(Integer page, Integer id) throws Exception {
        return null;
    }

    @Override
    public Integer countByCourseID(Integer id) throws Exception {
        //获取课程学生数
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);

        return selectedcourseMapper.countByExample(example);
    }

    @Override
    public SelectedCourseCustom findOne(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);


        if (list.size() > 0) {
            SelectedCourseCustom sc = new SelectedCourseCustom();
            BeanUtils.copyProperties(list.get(0), sc);

            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sc.setStudentCustom(studentCustom);

            return sc;
        }

        return null;
    }

    @Override
    public void updateOne(SelectedCourseCustom selectedCourseCustom) throws Exception {

        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.updateByExample(selectedCourseCustom, example);

    }

    public void save(SelectedCourseCustom selectedCourseCustom) throws Exception {
        selectedcourseMapper.insert(selectedCourseCustom);
    }

    public List<SelectedCourseCustom> findByStudentID(Integer id) throws Exception {
        return null;
    }

    public void remove(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.deleteByExample(example);
    }
}
