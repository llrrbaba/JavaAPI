package cn.rocker.designpattern.factory;

/**
 * @author rocker
 * @version V1.0
 * @Description:    具体如何生产一个产品的对象，是由具体的工厂类实现的
 * @date 2018/5/6 17:33
 */
public class ConcreteCreator extends Creator{
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)product;
    }
}
