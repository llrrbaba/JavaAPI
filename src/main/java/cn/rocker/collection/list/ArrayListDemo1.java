package cn.rocker.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/7 21:01
 */
public class ArrayListDemo1 {
    @Test
    /**
     * @Description:    ArrayList转换成数组
     * @auther: rocker
     * @date: 2018/5/7 21:20
     */
    public void test1(){
        List<Object> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(7);
        list.add(4);
        //list转成数组
        Object[] objects = list.toArray();
        //对转换后的数组进行排序
        Arrays.sort(objects);
        System.out.println(Arrays.toString(objects));
    }

    @Test
    /**
     * @Description:    数组转换成List,
     *                    需要注意的是asList(arr)的参数arr的元素不能为基本类型
     *                    short|int|long|float|double|byte|char|boolean
     * @auther: rocker
     * @date: 2018/5/7 21:20
     */
    public void test2(){
        int[] arr1 = {1,2,3};
        List<int[]> list = Arrays.asList(arr1);
        System.out.println(list.size());

        char[] arr2 = {'a','b','c'};
        List<char[]> chars = Arrays.asList(arr2);
        System.out.println(chars.size());

        String[] arr3 = {"d","e","f"};
        System.out.println(arr3[2]);
        List<String> strings = Arrays.asList(arr3);
        strings.set(2,"g");
        System.out.println(strings.size());
        System.out.println(arr3[2]);
    }
}
