/**
 * Filename: MessageQueue.java
 * Author: charles
 * Date: Jan 23, 2016
 */
package com.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author charles
 *
 */
public class MessageQueue {

    private BlockingQueue<Message> queue;

    public MessageQueue() {
        queue = new LinkedBlockingQueue<Message>(100);
    }

    public void put(Message msg) {
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Message next() {
        Message ret = null;
        try {
            ret = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    public static void main(String[] args) {
        MessageQueue mq = new MessageQueue();
        mq.put(new Message("Hello"));
        mq.next();
        System.out.println("out");
    }

}
