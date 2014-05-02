package org.stelo.gopher;

import java.util.ArrayList;

public class GopherMenu extends ArrayList<GopherMenuItem> {

    public static boolean isEnd(String line) {
	return line.equals(".");
    }

    public GopherMenu() {
	super();
    }

    public void add(String itemString) {
	System.out.println("ITEM: " + itemString);
	GopherMenuItem item = new GopherMenuItem(itemString);
    }
}
