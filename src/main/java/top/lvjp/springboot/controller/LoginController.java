package top.lvjp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lvjp
 * @date 2019/4/19
 */
@Controller
public class LoginController {

    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            VerificationCode randomValidateCode = new VerificationCode(VerificationCode.CodeTypeEnum.EQUATION);
            randomValidateCode.setHttpVerificationCode(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("验证码出错");
        }
    }

}
