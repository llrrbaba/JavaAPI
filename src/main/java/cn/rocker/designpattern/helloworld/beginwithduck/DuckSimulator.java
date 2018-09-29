package cn.rocker.designpattern.helloworld.beginwithduck;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子模拟器   测试类
 * @date 2018/9/29 9:50
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckModel duckModel = new DuckModel();
        duckModel.perforQuack();
        duckModel.perforFly();
    }

}
