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
            case 2 -> displayCDChoice(input);
            case 3 -> displayPresentValuechoice(input);
        }
    }

    public static void displayInterestChoice(Scanner input) {
        System.out.print("\nPlease enter your principal: ");
        float principal = input.nextFloat();
        System.out.print("Enter your interest rate: ");
        float interestRate = input.nextFloat();
        System.out.print("Enter your loan length in years: ");
        float loanLength = input.nextFloat();
        displayInterest(principal, interestRate, loanLength);
    }

    public static void displayCDChoice(Scanner input) {
        System.out.print("\nPlease enter your deposit: ");
        float deposit = input.nextFloat();
        System.out.print("Enter your interest rate: ");
        float interestRateCD = input.nextFloat();
        System.out.print("Enter your loan length in years: ");
        float depositLength = input.nextFloat();
        displayCD(deposit,interestRateCD,depositLength);
    }

    public static void displayPresentValuechoice(Scanner input) {
        System.out.print("\nPlease enter your expected monthly payout: ");
        float monthlyPayout = input.nextFloat();
        System.out.print("Enter your expected interest rate: ");
        float interestRateAnnuity = input.nextFloat();
        System.out.print("Enter years to pay out: ");
        float yearPayOut = input.nextFloat();
        displayPresentValue(monthlyPayout, interestRateAnnuity, yearPayOut);
    }
    public static void displayInterest(float principal, float interestRate, float loanLength) {
        double interest = calculateInterest(principal, interestRate, loanLength);
        System.out.printf("%nTotal interest is: $%.2f%n", interest);
        System.out.printf("Your monthly payment is $%.2f", (interest + principal) / (loanLength * 12));
    }

    public static void displayCD(float deposit, float interestRateCD, float depositLength){
        double futureValue = calculateCD( deposit, interestRateCD, depositLength);
        System.out.printf("%nYour future value is: $%.2f%n", futureValue);
        System.out.printf("Your interest earn: $%.2f", futureValue - deposit);
    }

    public static void displayPresentValue(float monthlyPayOut, float interestRateAnnuity, float yearPayOut){
        double presentValue = calculatePresentValue( monthlyPayOut, interestRateAnnuity, yearPayOut);
        System.out.printf("%nYour present value need to invest today is $%.2f%n", presentValue);
    }
    public static double calculateInterest(double p, double rate, double year) {
        double n = year * 12;
        double r = rate / 100;
        double i = r / 12;
        double m = p * (i * Math.pow((1 + i), n) / (Math.pow((1 + i), n) - 1));
        return (m * n) - p;
    }

    public static double calculateCD(double p, double rate, double t){
        double r = rate / 100;
        return p * Math.pow(1+r/365,365*t);
    }
    public static double calculatePresentValue(double pMT, double rate, double t){
        double i = rate/100/12;
        double n = t * 12;
        return pMT *(1-Math.pow(1+i,-n))/i;
    }
}

