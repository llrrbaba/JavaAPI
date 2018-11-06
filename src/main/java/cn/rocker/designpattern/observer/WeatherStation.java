package cn.rocker.designpattern.observer;

import org.junit.Test;

/**
 * @author rocker
 * @version V1.0
 * @Description:    气象站 测试类
 * @date 2018/9/29 15:20
 */
public class WeatherStation {

    @Test
    public void test(){
        //首先建立一个 weatherData 对象
        WeatherData weatherData = new WeatherData();

        //创建 CurrentConditionDisplay 对象
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMessurements(80,65,30.4f);
    }

}
