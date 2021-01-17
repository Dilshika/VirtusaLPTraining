package com.virtusa.Exception.CheckedNUncheckedException.BillingSystem;

import com.virtusa.Exception.CheckedNUncheckedException.CheckedException.PrinterNotFoundException;
import com.virtusa.Exception.CheckedNUncheckedException.UncheckedException.DividebyZeroException;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bill amount");
        int billAmount = scanner.nextInt();
        System.out.println("Enter tax rate");
        int taxRate = scanner.nextInt();

        BillPayment billPayment = new BillPayment(billAmount, taxRate);
        try {
            billPayment.calculateAmount();
        } catch ( DividebyZeroException exception ) {
            System.err.println("Tax Rate must be greater than zero");   //unchecked Exception
        }

        System.out.println("Do you want to print bill(if true:true else:false)");
        boolean isPrint = scanner.nextBoolean();

        if (isPrint) {
            PrintBill bill = new PrintBill();
            try {
                bill.printBill();
            } catch ( PrinterNotFoundException exception ) {
                System.err.println("Check whether printer is connected");   //checked Exception
            }

        }
    }
}