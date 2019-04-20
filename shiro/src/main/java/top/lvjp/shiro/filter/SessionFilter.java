package top.lvjp.shiro.filter;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import top.lvjp.shiro.entity.UserInfo;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SessionFilter extends AccessControlFilter {

    public final static String IS_KICK = "is_kicked_session";

    /**
     * 检查 session 是否被踢
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        if (subject.getPrincipal() != null){
            System.out.println("session: " + ((UserInfo)subject.getPrincipal()).getUsername());
        }
        if (null != session.getAttribute(IS_KICK) && session.getAttribute(IS_KICK).equals(Boolean.TRUE)){
            session.setTimeout(0);
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, "/kicked");
        return false;
    }
}
