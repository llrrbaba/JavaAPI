package cn.rocker.designpattern.observer;

/**
 * @author rocker
 * @version V1.0
 * @Description:    观察者接口
 * @date 2018/9/29 14:53
 */
public interface Observer {

    //观察者的更新方法
    void update(float temp, float humidity, float pressure);

}
