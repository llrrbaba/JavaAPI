package cn.rocker.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/23 17:53
 */
public class SortList {
    @Test
    public void sort(){
        List<String> list = new ArrayList();
        list.add("a");
        list.add("r");
        list.add("g");
        list.add("j");
        list.add("q");
        list.add("b");
        for(String str: list){
            System.out.print(str);
        }

        System.out.println();

        Collections.sort(list);
        for(String str: list){
            System.out.print(str);
        }

    }
}
