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
package com.tuxedoberries.process;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Silva
 */
public class CommandQueue implements Runnable {
    
    private Queue<CommandData> commandQueue;
    private IExecute executor;
    private Logger logger;
    
    public CommandQueue () {
        commandQueue = new LinkedList<>();
        createLogger();
    }
    
    public synchronized void enqueue (CommandData data) {
        commandQueue.add(data);
    }
    
    public void setCommandReceiver (IExecute executor) {
        this.executor = executor;
    }
    
    public synchronized void clear () {
        commandQueue.clear();
    }
    
    private synchronized CommandData dequeue () {
        return commandQueue.remove();
    }
    
    private synchronized int queueSize () {
        return commandQueue.size();
    }
    
    @Override
    public void run () {
        while(true) {
            if(Thread.interrupted())
                return;
            
            if(executor == null) {
                sleepMe();
                continue;
            }
            
            if(executor.isRunning()) {
                sleepMe();
                continue;
            }
            
            if(queueSize() <= 0) {
                sleepMe();
                continue;
            }
            
            CommandData data = dequeue();
            executor.execute(data);
        }
    }
    
    private void sleepMe () {
        try {
            Thread.sleep(33);
        } catch (InterruptedException ex) {
            //logger.log(Level.SEVERE, "Threas is interrupted", ex);
        }
    }
    
    private void createLogger () {
        if(logger == null) {
            String loggerName = String.format("[%d]%s", this.hashCode(), ProcessController.class.getName());
            logger = Logger.getLogger(loggerName);
        }
    }
}
