package me.justgame.test;

/**
 * Created by xcl on 2017-02-23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test(){
        int i = 0;
        try {
            throw new RuntimeException("ceshiyixia");
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        } finally {
            System.out.print(i);
        }

        System.out.println(i);
    }
}
