package com.twu.biblioteca.io;


import com.twu.biblioteca.InputPort;

import java.util.Scanner;

public class ConsoleInput implements InputPort {
    @Override
    public int getInt() {


        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        return i;
    }
}
