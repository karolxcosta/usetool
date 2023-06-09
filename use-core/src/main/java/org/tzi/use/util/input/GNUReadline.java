/*
 * USE - UML based specification environment
 * Copyright (C) 1999-2004 Mark Richters, University of Bremen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.tzi.use.util.input;

import java.io.IOException;

/**
 * Native wrapper for the GNU Readline Library. 
 *
 * Don't use this directly since it may no be available on all
 * platforms. Use LineInput.getReadline() to get an appropriate
 * implementation instead.
 * 
 * @author      Mark Richters 
 */
public class GNUReadline implements Readline {

    static {
        System.loadLibrary("natGNUReadline");
    }
    
    public native String readline(String prompt);
    public native void usingHistory();
    public native void readHistory(String filename) throws IOException;
    public native void writeHistory(String filename) throws IOException;
    public native void close();
    public boolean doEcho() {
        return false;
    }
}
