package top.lvjp.redis.simple.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

    @Test
        public void test(){
            Jedis jedis = new Jedis("192.168.239.140", 6379);
            jedis.set("name", "lvjp");

            System.out.println(jedis.get("name"));
            jedis.close();
        }


        @Test
        public void testPool(){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(30);
            config.setMaxIdle(10);

            JedisPool jedisPool = new JedisPool(config, "192.168.239.140", 6379);


        try (Jedis jedis = jedisPool.getResource()){
            jedis.set("object", "wyc");
            System.out.println(jedis.get("object"));
        }
        jedisPool.close();
    }
}