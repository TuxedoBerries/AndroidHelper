/*
 * Copyright (C) 2016 Juan Silva <juanssl@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tuxedoberries.process.interfaces;

/**
 *
 * @author Juan Silva
 */
public interface IProcessStats {
    
    /**
     * Determines if the current process is running.
     * @return true if is running, false otherwise.
     */
    public boolean isRunning();
    
    /**
     * Get the current process in execution if any
     * @return 
     */
    public String getCurrentProcess();
    
    /**
     * Get the last process executed if any
     * @return 
     */
    public String getLastProcess();
}
