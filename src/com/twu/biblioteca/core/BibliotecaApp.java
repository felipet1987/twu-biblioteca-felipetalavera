package com.twu.biblioteca.core;

import com.twu.biblioteca.ConsoleInput;
import com.twu.biblioteca.ConsoleOutput;
import com.twu.biblioteca.ListMenu;
import com.twu.biblioteca.MemoryBookRepository;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookRepository repo = new MemoryBookRepository();
        //AppMenu menu = new ListMenu(repo);
        InputPort input = new ConsoleInput();
        OutputPort output = new ConsoleOutput();
        //MenuController controller = new MenuController(menu, input, output);

        //controller.showMenu();
        //controller.gotoOption();

    }
}
