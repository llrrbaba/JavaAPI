package cn.rocker.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/9/29 14:59
 */
public class WeatherData implements Subject{

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    //注册
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    //移除
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i > 0){
            observers.remove(o);
        }
    }

    //通知
    @Override
    public void notifyObserver() {
        for(int i=0; i<observers.size(); i++){
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    //指标发生变化，气象站调用此方法
    public void messurementsChanged(){
        notifyObserver();
    }

    //模拟获取气象站的数据，并触发 messurementsChanged 方法
    public void setMessurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        messurementsChanged();
    }

}
