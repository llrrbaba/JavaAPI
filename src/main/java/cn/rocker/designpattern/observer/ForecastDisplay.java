package cn.rocker.designpattern.observer;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/9/29 15:11
 */
public class ForecastDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    //构造器需要 weatherData对象(也就是主题)，作为注册之用
    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    //当update被调用时，我们把温度、湿度、气压保存起来，然后调用display()
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Foracast:" + temperature + "F degrees and " + humidity + "% humidity");
    }
}
