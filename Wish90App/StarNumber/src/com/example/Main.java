package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int givenNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number to verify");
        givenNumber = sc.nextInt();

        CheckStar c=new CheckStar(givenNumber);
        c.checker();

    }

}
