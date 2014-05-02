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

import java.net.Socket;
import javax.net.SocketFactory;

import java.io.IOException;
import java.io.*;

public class GopherConnection {
	public static int DEFAULT_PORT = 70;

	public String host;
	public int    port;

	public Socket sock = null;

	public BufferedReader in;
	public PrintWriter    out;

	public GopherConnection(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public GopherConnection(String host) {
		this(host, DEFAULT_PORT);
	}

	public GopherConnection(Socket sock) {
		this.sock = sock;
	}

	public void connect() throws IOException {
		if (sock == null) {
			sock = SocketFactory.getDefault().createSocket(host, port);
		}
		in  = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream());
	}

	public GopherMenu readMenu() throws IOException {
		GopherMenu menu = new GopherMenu();
		String line;

		while(((line = in.readLine()) != null) &&
			(!GopherMenu.isEnd(line))) {
			
			menu.add(line);
		}

		return menu;
	}

	public GopherMenu get(String path) throws IOException {
		out.print(path + "\r\n");
		out.flush();
		return readMenu();
	}		
}
