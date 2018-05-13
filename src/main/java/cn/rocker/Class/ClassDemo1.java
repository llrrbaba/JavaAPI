package cn.rocker.Class;

import cn.rocker.collection.list.ArrayListDemo1;
import org.junit.Test;

import java.util.Date;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/8 23:36
 */
public class ClassDemo1 {

    @Test
    public void test1() {
        Class integerClass = int.class;
        System.out.println(integerClass.getName());
        System.out.println(integerClass.getSimpleName());
        System.out.println(integerClass.getClassLoader());
        System.out.println("-----------------------------------------");

        Class arrayListDemo1Class = ArrayListDemo1.class;
        System.out.println(arrayListDemo1Class.getName());
        System.out.println(arrayListDemo1Class.getSimpleName());
        System.out.println(arrayListDemo1Class.getClassLoader());
        System.out.println("-----------------------------------------");


        String[] arr = {"a","b","c"};
        Class<? extends String[]> aClass = arr.getClass();
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getClassLoader());
        System.out.println("-----------------------------------------");


        ArrayListDemo1[] arr2 = {new ArrayListDemo1(),new ArrayListDemo1(),new ArrayListDemo1()};
        Class<? extends ArrayListDemo1[]> bClass = arr2.getClass();
        System.out.println(bClass.getName());
        System.out.println(bClass.getSimpleName());
        System.out.println(bClass.getClassLoader());
    }
}
