//package top.lvjp.mybatisplus.controller;
//
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import top.lvjp.mybatisplus.service.IUserService;
//
//import java.util.List;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author lvjp
// * @since 2019-04-25
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private IUserService userService;
//
//    @PostMapping("/add")
//    public boolean addUser(User user){
//        return userService.save(user);
//    }
//
//    @PostMapping("/update")
//    public boolean updateUser(User user){
//        return userService.updateById(user);
//    }
//
//    @GetMapping("/get/{id}")
//    public String getUser(@PathVariable("id") Integer id){
//        User user = userService.getById(id);
//        return user.getUsername();
//    }
//
//    @GetMapping("/page")
//    public List<User> pageUser(int current, int size){
//        Page<User> page = new Page<>(current, size);
//        return userService.page(page).getRecords();
//    }
//
//    @DeleteMapping("/del")
//    public boolean delUser(@RequestParam("id") Integer id){
//        return userService.removeById(id);
//    }
//
//}
