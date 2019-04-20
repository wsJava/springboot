package top.lvjp.shiro.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import top.lvjp.shiro.entity.SysPermission;
import top.lvjp.shiro.entity.SysRole;
import top.lvjp.shiro.entity.UserInfo;
import top.lvjp.shiro.filter.SessionFilter;
import top.lvjp.shiro.repository.UserRepository;

import javax.activity.ActivityCompletedException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    /**
     * 在线用户
     */
    private Map<String, Session> activeUser = new ConcurrentHashMap<>();

    /**
     * 获取授权信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermission()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 获取身份认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserInfo userInfo = userRepository.findByUsername(username);
        if (userInfo == null) {
            return null;
        }
        // 踢出之前登录的用户
        if (activeUser.containsKey(username)){
            Session session = activeUser.get(username);
            try {
                session.setAttribute(SessionFilter.IS_KICK, Boolean.TRUE);
            } catch (InvalidSessionException e) {
                log.warn("session 过期, 将其从 activeUser 中移除");
                activeUser.remove(username);
            }
            log.warn("用户 {} 异地登录, 将之前用户踢出", username);
        }
        Subject subject = SecurityUtils.getSubject();
        activeUser.put(username, subject.getSession());

        System.out.println(userInfo.toString());
        // userInfo 作为用户凭证, ByteSource.Util.bytes(userInfo.getSalt())
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), getName());
        return authenticationInfo;
    }
}
