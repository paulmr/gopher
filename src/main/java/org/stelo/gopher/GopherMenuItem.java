package org.stelo.gopher;

public class GopherMenuItem {

    public static char PLAIN_TEXT = '0';
    public static char DIRECTORY  = '1';

    public char type;

    protected String displayName, selector, host, port;

    public GopherMenuItem(String itemString) {
	parse(itemString);
    }

    public void parse(String menuString) {
	String[] parts;
	this.type = menuString.charAt(0);
	parts     = menuString.substring(1).split("\t");
	this.displayName = parts[0];
	this.selector    = parts[1];
	this.host        = parts[2];
	this.port        = parts[3];
    }

    public String getDisplayName() {
	return displayName;
    }

}
