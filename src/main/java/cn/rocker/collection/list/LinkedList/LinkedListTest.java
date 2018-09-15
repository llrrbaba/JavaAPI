package cn.rocker.collection.list.LinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author rocker
 * @version V1.0
 * @Description:    测试LinkedList
 * @date 2018/9/13 17:53
 */
public class LinkedListTest {


    /**
     * get(int)的时间复杂度：
     * 如果获取第一个元素或者最后一个元素，时间复杂度为O(1)
     * 如果获取的元素位于中间，时间复杂度为O(n)
     * 平均复杂度为O(n)
     */
    @Test
    public void tesGet(){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Integer integer = list.get(3);
    }


    /**
     * 如果我们希望从i角标连续插入10个元素，
     *
     * 对于顺序存储结构来说，
     * 意味着每次插入都要移动n-i个元素，每次的复杂度都是O(n)
     *
     * 而对于链表来说，我们只需要在第一次时找到角标为i的Node，此时为O(n),
     * 接下来再进行插入都是改变next,prev指针而已，时间复杂度为O(1)
     *
     * 显然，对于插入或者删除越频繁的操作，链表的优势越明显
     * addAll()方法，LinkedList是优于ArrayList的
     * 至于删除的，我还没想清楚
     */



    /**
     * add()时间复杂度：
     *  先遍历找到目标位置的Node，再执行插入
     *  时间复杂度为O(n)
     */
    @Test
    public void testAdd(){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3));

        //在LinkedList的末尾添加元素
//        boolean add = list.add(4);
//        Integer integer = list.get(4);

        //在指定位置添加元素
        list.add(4,5);
    }



    /**
     * add()时间复杂度：
     *  先遍历找到目标位置的Node，再执行删除
     *  时间复杂度为O(n)
     */
    @Test
    public void testRemove(){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3));

        Integer remove = list.remove(2);
    }

}
