/*
 * BestLoanRates.java
 *
 *  Copyright (c) 2021 NetNumber, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of NetNumber,Inc.
 * Use is subject to license terms.
 *
 * Created on Jul 26, 2021 12:18:13 PM
 */
package com.h2;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Roman Ganchin
 */
public class BestLoanRates {

    public static final Map<Integer, Float> bestRates = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your name");
            String name = scanner.nextLine();
            
            System.out.println("Hello " + name);
            
            System.out.println("Enter the loan term (in years)");
            int loanTermInYears = scanner.nextInt();
            float bestRate = getRates(loanTermInYears);
            if (Float.compare(bestRate, 0.0f) == 0) {
                System.out.println("No available rates for term: " + loanTermInYears + " years");
            } else {
                System.out.println("Best Available Rate: " + getRates(loanTermInYears) + "%");
            }
        }
    }

    public static float getRates(int loanTermInYears) {
        if (bestRates.containsKey(loanTermInYears)) {
            return bestRates.get(loanTermInYears);
        }
        return 0.0f;
    }

}
