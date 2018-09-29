package cn.rocker.designpattern.helloworld.beginwithduck;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子叫实现   吱吱
 * @date 2018/9/29 9:45
 */
public class Squeak implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Squeak!!!");
    }

}
