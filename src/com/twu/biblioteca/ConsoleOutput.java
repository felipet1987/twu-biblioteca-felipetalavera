package com.twu.biblioteca;

public class ConsoleOutput implements OutputPort {
    @Override
    public void print(String message) {
        System.out.println(message);

    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
