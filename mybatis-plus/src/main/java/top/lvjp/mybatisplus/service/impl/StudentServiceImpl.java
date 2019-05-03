package top.lvjp.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import top.lvjp.mybatisplus.entity.Student;
import top.lvjp.mybatisplus.entity.User;
import top.lvjp.mybatisplus.mapper.StudentMapper;
import top.lvjp.mybatisplus.mapper.UserMapper;
import top.lvjp.mybatisplus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lvjp
 * @since 2019-04-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void test() {
        Map<String, Object> params = new HashMap<>();
        params.put("sex", 0);
        params.put("major", "信息管理与信息系统");
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>().allEq(params).gt("age", 18);
        System.out.println(studentMapper.selectList(wrapper));

        List<Student> students = studentMapper.selectList(new QueryWrapper<Student>().lambda().eq(Student::getAcademy, "学院"));
        System.out.println(students);
    }

}
