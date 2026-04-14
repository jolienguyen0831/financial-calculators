package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Let us help you to calculate your interest!");

        System.out.println("\t1. Interest Calculation");
        System.out.println("\t2. Future value of CD");
        System.out.println("\t3. Present value of ordinary annuity");
        System.out.print("Please choose what you want to do:");

        byte userChoice = input.nextByte();
        switch (userChoice) {
            case 1 -> displayInterestChoice(input);
//            case 2 -> displayCDChoice(input);

        }
    }
//    public static void displayCDChoice(Scanner input) {
//        System.out.print("Please enter your deposit: ");
//        float deposit = input.nextFloat();
//        System.out.print("Enter your interest rate: ");
//        float interestRateCD = input.nextFloat();
//        System.out.print("Enter your loan length in years: ");
//        float depositLength = input.nextFloat();
//        displayCD(deposit,interestRateCD,depositLength);

//    }

    public static void displayInterestChoice(Scanner input) {
        System.out.print("Please enter your principal: ");
        float principal = input.nextFloat();
        System.out.print("Enter your interest rate: ");
        float interestRate = input.nextFloat();
        System.out.print("Enter your loan length in years: ");
        float loanLength = input.nextFloat();
        displayInterest(principal, interestRate, loanLength);
    }

    public static void displayInterest(float principal, float interestRate, float loanLength) {
        double interest = calculateInterest(principal, interestRate, loanLength);
        System.out.printf("Total interest is: $%.2f%n", interest);
        System.out.printf("Your monthly payment is $%.2f", (interest + principal) / (loanLength * 12));
    }
//    public static void displayCD(float deposit, float interestRateCD, float depositLength){
//        double futureValue = calculateInterest( deposit, interestRateCD, depositLength);
//        System.out.printf("Your future value is: $%.2f", futureValue);
//        System.out.printf("Your interest earn: $%.2f", futureValue - deposit);

    //    }
    public static double calculateInterest(double p, double rate, double year) {

        double n = year * 12;
        double r = rate / 100;
        double i = r / 12;
        double m = p * (i * Math.pow((1 + i), n) / (Math.pow((1 + i), n) - 1));
        return (m * n) - p;
    }

//    public static double calculateCD(double p, double rate, double t){
//
//        double r = rate / 100;
//        double fv = p*Math.pow((1+(r/365)),(365*t));
//        return fv;
//    }
}

