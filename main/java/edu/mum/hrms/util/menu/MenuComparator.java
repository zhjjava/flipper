package edu.mum.hrms.util.menu;

import java.util.Comparator;

public class MenuComparator implements Comparator<Menu> {

    public int compare(Menu menu1, Menu menu2) {
        int value1 = menu1.getOrder();
        int value2 = menu2.getOrder();
        return (value1 < value2 ? -1 : (value1 == value2 ? 0 : 1));
    }

}
