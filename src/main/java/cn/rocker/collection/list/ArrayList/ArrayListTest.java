package cn.rocker.collection.list.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rocker
 * @version V1.0
 * @Description:      ArrayList的每次grow(int)(扩容)和在add(int,E)(指定角标添加元素)都会涉及一次数组的copy
 *                      将原来数组的东西copy到新的数组
 *                      ArrayList的每次remove()(移除)也会涉及一次数组的copy
 * @date 2018/7/25 16:45
 */
public class ArrayListTest {

    /**
     * 测试ArrayList.add()方法
     */
    @Test
    public void testListAdd(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(6);
        integerList.add(2);
        integerList.add(7);
        integerList.add(5);
        integerList.add(1);
        integerList.add(9);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.remove(4);

        System.out.println(StringUtils.join(integerList));

        //添加
        integerList.add(3,8);

        System.out.println(StringUtils.join(integerList));
    }


    /**
     * 测试System.arrayCopy()
     */
    @Test
    public void testArrayCopy(){
        Integer[] src = {1,2,3,4,5};

        for (Integer integer : src) {
            System.out.print(integer);
        }

        System.out.println();

        System.arraycopy(src,3,src,2,1);

        for (Integer integer : src) {
            System.out.print(integer);
        }
    }

}
