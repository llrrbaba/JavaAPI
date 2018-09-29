package cn.rocker.designpattern.helloworld.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子超类
 * @date 2018/9/29 9:38
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void perforFly(){
        flyBehavior.fly();
    }
    public void perforQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float!!!");
    }

    //通过setter方法，灵活设置鸭子的某个行为的具体实现
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }

}
