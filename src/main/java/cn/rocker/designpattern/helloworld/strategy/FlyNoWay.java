package cn.rocker.designpattern.helloworld.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:    飞行动作实现  不能飞行
 * @date 2018/9/29 9:41
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly(){
        System.out.println("I can not fly!!!");
    }

}
