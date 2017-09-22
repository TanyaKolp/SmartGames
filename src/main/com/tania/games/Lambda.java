package com.tania.games;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tanya on 10.08.17.
 */
public class Lambda {
    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        numbers.forEach(vakue -> System.out.println(vakue));
        double rounf = 100.00;
        double nor = 100.1199999999;

        double rubRo = Math.floor(rounf);
        double rubD = Math.floor(nor);
//        long rubD = Math.round(nor * 100) / 100;

        double pennyROund = Math.round((rounf - rubRo) * 100);
        double pennyD = ((nor - rubD));

        BigDecimal total = BigDecimal.valueOf(nor);
        BigDecimal ruble1 = total.setScale(0, RoundingMode.DOWN);
        BigDecimal round = total.setScale(2, RoundingMode.DOWN);
        System.out.println(round);
        System.out.println(total+" - "+total.setScale(0, RoundingMode.DOWN));
        System.out.println(round+" - "+round.setScale(0, RoundingMode.DOWN));
        System.out.println(round +" - "+total.setScale(0, RoundingMode.DOWN) +"=");
        System.out.println(round.subtract(total.setScale(0, RoundingMode.DOWN)));
        System.out.println(round.subtract(total.setScale(0, RoundingMode.DOWN)).unscaledValue());
        int i1 = round.subtract(total.setScale(0, RoundingMode.DOWN)).unscaledValue().intValue();

        BigDecimal t = BigDecimal.valueOf(rounf);
        BigDecimal r = t.setScale(0, RoundingMode.DOWN);
        int p = r.subtract(t.setScale(0, RoundingMode.DOWN)).unscaledValue().intValue();

        System.out.println("RUb round = "+r);
        System.out.println("penny  round = "+p);
        System.out.println("RUb = "+ruble1);
        System.out.println("penny = "+i1);

    }
}
