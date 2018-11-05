package cn.rocker.collection.list.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rocker
 * @version V1.0
 * @Description:      ArrayList的每次grow(int)(扩容)和在add(int,E)(指定角标添加元素)都会涉及一次数组的copy
 *                      将原来数组的东西copy到新的数组
 *                      ArrayList的每次remove()(移除)也会涉及一次数组的copy
 *
 *                      关于时间复杂度:
 *                      最好的情况：如果插入或者删除的元素正好位于ArrayList的最后一位，则不需要copy数组，时间复杂度为O(1)
 *                      最坏的情况：如果插入或者删除的元素正好位于ArrayList的第一位，那就意味着所有的元素要向前或向后移动
 *                                  这个时间复杂度为O(n)
 *                      平均情况：O((n+1)/2)
 *                      平均情况复杂度简化后：O(n)
 *
 *                      结论：
 *                      ArrayList 是线性表的线性存储结构（数组）
 *                      get() 直接读取第几个下标，复杂度 O(1)
 *                      add(E) 添加元素，直接在后面添加，复杂度O（1）
 *                      add(index, E) 添加元素，在第几个元素后面插入，后面的元素需要向后移动，复杂度O（n）
 *                      remove（）删除元素，后面的元素需要逐个移动，复杂度O（n）
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
