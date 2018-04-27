package com.tania.sobes.compare;
/**
 * В первом объекты не создаются, а берутся из pool и классы-обёртки имеют одну ссылку.
 * В третьем же создаётся два объекта, * потому что 200 не входит
 * в диапазон Integer pool (-128..127), то есть у них разные ссылки.
 * */
public class AutoboxingAndUnboxingMain {
    public static void main(String[] args) {
        Integer iOb1 = 100;
        Integer iOb2 = 100;
        System.out.println(iOb1 == iOb2);

        Integer a = 120;
        Integer b = 120;
        System.out.println(a == b);

        Integer iOb3 = new Integer(120);
        Integer iOb4 = new Integer(120);
        System.out.println(iOb3 == iOb4);

        Integer iOb5 = 200;
        Integer iOb6 = 200;
        System.out.println(iOb5 == iOb6);
    }
}
