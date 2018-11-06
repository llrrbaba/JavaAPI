package cn.rocker.designpattern.observer;

/**
 * @author rocker
 * @version V1.0
 * @Description:    主题接口
 * @date 2018/9/29 14:51
 */
public interface Subject {

    //注册观察者
    void registerObserver(Observer o);

    //移除观察者
    void removeObserver(Observer o);

    //通知所有观察者
    void notifyObserver();

}
