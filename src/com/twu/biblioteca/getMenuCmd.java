package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class getMenuCmd {
    private String[] menuView;



    private List<String> setMenuOptions() {
        List<String> menu = new ArrayList<String>();
        menu.add("List Books");
        return menu;
    }

    private void menuToView(List<String> menu) {
        menuView = new String[menu.size()];
        for (int i = 0; i < menu.size(); i++) {
            menuView[i] = menu.get(i);
        }
    }

    public String[] execute() {

        List<String> menu = setMenuOptions();
        menuToView(menu);

        return this.menuView;

    }
}
