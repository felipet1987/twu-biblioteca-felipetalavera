package com.twu.biblioteca.app;

public class MainController {


    private  AppMenu menu;

    public MainController(AppMenu menu) {
        this.menu = menu;
    }


    public void start() {
        if (menu.login()) {
            menu.showWelcome();
            menu.showMenu();
        }else{
            start();
        }
    }

    public void nextOption() {
        String option = menu.waitForUser();
        menu.executeOption(option);

    }

    public boolean isExited() {
        return menu.isExited();
    }
}