package org.stelo.gopher;

import java.io.IOException;

public class GopherClient {

    public static void main(String args[]) {

	GopherConnection c = null;
	GopherMenu menu    = null;
	try {
	    c = new GopherConnection(args[0]);
	    c.connect();
	    menu = c.get(args[1]);
	} catch(IOException e) {
	    System.out.println("IO Error: " + e.toString());
	    System.exit(1);
	}

	int i = 1;
	for(GopherMenuItem item : menu) {
	    System.out.println((i++) + ": " + item.getDisplayName());
	}
	
    }

}
