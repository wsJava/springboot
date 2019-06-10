package top.lvjp.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lvjp.redis.annotation.ApiIdempotent;
import top.lvjp.redis.util.TokenUtil;

@RestController
public class TestController {

    private final TokenUtil tokenUtil;

    @Autowired
    public TestController(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @GetMapping("/get")
    public String getToken(){
        System.out.println("====================");
        return tokenUtil.createToken();
    }


    // 幂等性接口
    @ApiIdempotent
    @PostMapping("/test")
    public String register(){
        System.out.println("success");
        return "success";
    }
}
