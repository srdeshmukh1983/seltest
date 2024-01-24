package com.example;

import java.util.Scanner;

public class scan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan = new Scanner(System.in);
        
        int i = scan.nextInt();
        double  d = scan.nextDouble();
        String s = scan.nextLine();
        
        

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        scan.close();
	}

}
