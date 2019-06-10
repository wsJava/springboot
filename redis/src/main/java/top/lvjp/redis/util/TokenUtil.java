package top.lvjp.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static top.lvjp.redis.constant.RedisConstant.REDIS_TOKEN_PREFIX;

/**
 * @author lvjp
 * @date 2019/6/9
 */
@Component
public class TokenUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final static int TIME_OUT_MINUTES = 5;

    private final String TOKEN_HEADER = "token";


    public String createToken(){
        String uuid = UUID.randomUUID().toString();

        String token = REDIS_TOKEN_PREFIX + uuid;

        stringRedisTemplate.opsForValue().set(token, token, TIME_OUT_MINUTES, TimeUnit.MINUTES);

        return token;
    }

    public boolean checkToken(HttpServletRequest request){
        String token = request.getHeader(TOKEN_HEADER);

        if (StringUtils.isEmpty(token)){
            token = request.getParameter(TOKEN_HEADER);
            if (StringUtils.isEmpty(token)){
                return false;
            }
        }

        String tokenValue = stringRedisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(tokenValue)){
            return false;
        }

        // 可能存在并发, 只有成功删除的那个线程才能通过
        Boolean success = stringRedisTemplate.delete(token);
        return success;
    }
}
