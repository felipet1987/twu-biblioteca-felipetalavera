package com.twu.biblioteca.io;


import com.twu.biblioteca.InputPort;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements InputPort {

    @Override
    public void setInput(List<String> data) {

    }

    @Override
    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
