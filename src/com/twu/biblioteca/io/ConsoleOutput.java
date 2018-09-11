package com.twu.biblioteca.io;

import com.twu.biblioteca.OutputPort;

import java.util.List;

public class ConsoleOutput implements OutputPort {
    @Override
    public List<String> getOutput() {
        return null;
    }

    @Override
    public void print(String message) {
        System.out.println(message);

    }


}
