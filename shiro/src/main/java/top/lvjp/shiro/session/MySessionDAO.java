package top.lvjp.shiro.session;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.hibernate.dialect.identity.Chache71IdentityColumnSupport;
import top.lvjp.shiro.cache.MyShiroCache;

import java.io.Serializable;
import java.util.Collection;

@Slf4j
public class MySessionDAO extends AbstractSessionDAO {

    private Cache<Serializable, Session> cache;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        cache.put(sessionId, session);
        log.info("doCreate");
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null){
            return null;
        }
        Session session = cache.get(sessionId);
        log.info("doReadSession");
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()){
            return;
        }
        log.info("update");
        cache.put(session.getId(), session);
    }

    @Override
    public void delete(Session session) {
        cache.remove(session.getId());
        log.info("delete");
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return cache.values();
    }

    public void setCache(MyShiroCache myShiroCache){
        cache = myShiroCache.getSessionCache();
    }
}
