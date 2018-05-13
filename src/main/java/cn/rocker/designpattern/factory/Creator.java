package cn.rocker.designpattern.factory;

/**
 * @author rocker
 * @version V1.0
 * @Description:    创建一个产品对象，其实如参数类型可以自行设置
 *                    通常为String、Enum、Class等，当然也可以为空
 * @date 2018/5/6 17:13
 */
public abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
