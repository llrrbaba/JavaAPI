package cn.rocker.designpattern.proxy;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/6 19:01
 */
public class Proxy implements Subject{

    private Subject subject = null;
    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    @Override
    public void request2() {

    }

    private void before() {
        //前处理
        System.out.println("i am the preHandler of the object...");
    }

    private void after() {
        //后处理
        System.out.println("i am the postHandler of the object...");
    }
}
