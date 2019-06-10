package top.lvjp.redis.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.lvjp.redis.annotation.ApiIdempotent;
import top.lvjp.redis.util.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * @author lvjp
 * @date 2019/6/9
 */
public class ApiIdempotentInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ApiIdempotent annotation = method.getAnnotation(ApiIdempotent.class);
        if (annotation != null) {
            boolean success = tokenUtil.checkToken(request);
            if (!success) {
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().write("请不要重复提交!");
                System.out.println("请求 " + request.getRequestURI() + " 重复提交, 已被拦截");
            }
            return true;
        }
        return true;
    }

}
