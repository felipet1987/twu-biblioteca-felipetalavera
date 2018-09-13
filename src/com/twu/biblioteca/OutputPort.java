package com.twu.biblioteca;

import java.util.List;

public interface OutputPort {


    List<String> getOutput();

    void print(String menu);

    void exit();

    void newPage();

    void clear();
}
