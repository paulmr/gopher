/**
 * Copyright (c) 2014 Paul Roberts
 *
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
