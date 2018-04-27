package com.tania.pass_obj_and_change;


import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        ChangingObject changingObject = new ChangingObject("start", 0);
        System.out.println(changingObject);
        changeObj(changingObject);
        System.out.println(changingObject);

        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        changeLink(changingObject);

        System.out.println("create link");
        changingObject = createLink(changingObject);

        System.out.println("CompareStrings end");
        System.out.println(changingObject);
    }

    private static void changeObj(ChangingObject changingObject) {
        changingObject.setString("end");
        changingObject.setNumber(1);
    }

    private static void changeLink(ChangingObject changingObject) {
        changingObject = new ChangingObject("changeLink", 3);
        System.out.println(changingObject);
    }
    private static ChangingObject createLink(ChangingObject changingObject) {
        return new ChangingObject("createdLink", 3);
    }

}