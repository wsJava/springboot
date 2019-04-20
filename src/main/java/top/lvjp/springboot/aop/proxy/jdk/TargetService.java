package top.lvjp.springboot.aop.proxy.jdk;

/**
 * @author lvjp
 * @date 2019/4/17
 */
public class TargetService implements Service {

    @Override
    public void save() {
        System.out.println("TargetService save");
    }
}
