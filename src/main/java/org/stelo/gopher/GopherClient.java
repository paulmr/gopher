package org.stelo.gopher;

import java.io.IOException;

public class GopherClient {

    public static void main(String args[]) {

	GopherConnection c = null;
	try {
	    c = new GopherConnection(args[0]);
	    c.connect();
	    c.get(args[1]);
	} catch(IOException e) {
	    System.out.println("IO Error: " + e.toString());
	}
    }

}
