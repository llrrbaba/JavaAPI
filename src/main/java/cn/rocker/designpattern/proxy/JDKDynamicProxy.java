package cn.rocker.designpattern.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/6 19:59
 */
public class JDKDynamicProxy {
    @Test
    public void test() {
        //获得动态代理对象---在运行时，在内存中，动态地为RealRequest创建一个代理对象
        Subject proxy = (Subject) Proxy.newProxyInstance(
                RealRequest.class.getClassLoader(),/*与目标对象相同的类加载器*/
                new RealRequest().getClass().getInterfaces()/*动态代理对象实现的接口的Class数组*/,
                new InvocationHandler() {
                    @Override
                    /**
                     * proxy    生成的代理对象，此处为RealRequest的代理对象;cn.rocker.designpattern.proxy.RealRequest@6d65d417
                     *                                                      cn.rocker.designpattern.proxy.RealRequest@1f2eb71e
                     * method   目标对象的方法，此处为RealRequest的方法:public abstract void cn.rocker.designpattern.proxy.Subject.request()
                     *                                                  public abstract void cn.rocker.designpattern.proxy.Subject.request2()
                     * args     目标对象方法的参数，此处为:null
                     *                                     null
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //目标对象的前处理
                        System.out.println("i am the preHandler of the object...");

                        //这里通过反射来执行目标对象的方法
                        Object invoke = method.invoke(new RealRequest(), args);

                        //目标对象的后处理
                        System.out.println("i am the postHandler of the object...");
                        return invoke;
                    }
                });

        //动态生成的代理对象执行目标对象的相应方法(已经做了相应的前后处理)
        proxy.request();
        proxy.request2();
    }
}
