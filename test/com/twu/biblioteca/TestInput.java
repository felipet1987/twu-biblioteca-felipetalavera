package com.twu.biblioteca;

class TestInput implements InputPort {
    private int data;


    TestInput() {

    }

    void setInput(int data) {
        this.data = data;
    }

    @Override
    public int getInt() {
        return data;
    }
}