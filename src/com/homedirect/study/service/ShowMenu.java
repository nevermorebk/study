package com.homedirect.study.service;

public interface ShowMenu {

    static void showOption() {

        System.out.println("$==== Option Account ========$");
        System.out.println("$                            $");
        System.out.println("$      1.Deposit             $");
        System.out.println("$      2.Withdraw            $");
        System.out.println("$      3.Transfer            $");
        System.out.println("$      4.History             $");
        System.out.println("$      5.Change Password     $");
        System.out.println("$      6.Information Account $");
        System.out.println("$      7.Exit Program!       $");
        System.out.println("$============================$");
    }

    static void showMenu() {
        System.out.println("$======= Menu =========$");
        System.out.println("$                      $");
        System.out.println("$     1.Create account $");
        System.out.println("$     2.Sign In        $");
        System.out.println("$     3.Exit           $");
        System.out.println("$======================$");
    }
}