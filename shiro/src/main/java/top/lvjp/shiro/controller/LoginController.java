package top.lvjp.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;

@RestController
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public String validate(@RequestParam("username") String username,@RequestParam("password") String password,
                           @RequestParam(value = "rememberMe", required = false, defaultValue = "false")
                                   boolean remember){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(remember);
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null){
            return "当前已存在用户, 请勿重复登录";
        }
        try {
            subject.login(token);
//            subject.getSession().setAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY, subject.getPrincipal());
        } catch (AuthenticationException e) {
            return "账号或密码错误";
        }
        return "success";
    }

    @RequiresAuthentication
    @GetMapping("/index")
    public String index(){
        log.info("active session: {}", ((DefaultWebSessionManager)((DefaultWebSecurityManager)SecurityUtils.getSecurityManager()).getSessionManager()).getSessionDAO().getActiveSessions());
        return "index";
    }

    @GetMapping("/no")
    public String no(){
        log.info("active session: {}", ((DefaultWebSessionManager)((DefaultWebSecurityManager)SecurityUtils.getSecurityManager()).getSessionManager()).getSessionDAO().getActiveSessions());
        return "no";
    }

    @GetMapping("kicked")
    public String kicked(){
        return "账号在其他设备登录, 如非本人操作请尽快修改密码";
    }
}
