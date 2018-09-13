package com.twu.biblioteca.mocks;

import com.twu.biblioteca.InputPort;

import java.util.List;

public class TestInput implements InputPort {


    private int index;
    private List<String> data;

    public TestInput() {

        this.index = 0;

    }


    @Override
    public void setInput(List<String> data) {
        this.data = data;
    }

    @Override
    public String getInput() {

        String result = data.get(index);
        index++;
        return result;
    }
}
