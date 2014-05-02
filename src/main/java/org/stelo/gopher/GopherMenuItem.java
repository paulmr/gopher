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
