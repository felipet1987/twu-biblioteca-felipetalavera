package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class TestOutput implements OutputPort {

    private List<String> data;
    private int exitStatus;


    TestOutput() {
        data = new ArrayList<String>();
    }

    public List<String> getData() {

        return this.data;
    }


    @Override
    public void print(String message) {
        this.data.add(message);
    }

    @Override
    public void exit() {
        exitStatus = -1;
    }

    @Override
    public void clearScreen() {

    }

    public int getExitStatus() {
        return exitStatus;
    }
}
