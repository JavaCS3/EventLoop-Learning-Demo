/**
 * Filename: Handler.java
 * Author: charles
 * Date: Jan 23, 2016
 */
package com.demo;

/**
 * @author charles
 *
 */
public class Handler {

    private EventLooper loop;
    private MessageQueue messageQueue;

    public Handler() {
        loop = EventLooper.myEventLooper();
        if (loop == null) {
            throw new RuntimeException("Can't not use eventLoop for non-Eventloop.prepared() thread");
        }
        messageQueue = loop.getMessageQueue();
    }

    public void handlerMessage(Message msg) {
    }

    public void sendMessage(Message msg) {
        if (msg == null) throw new RuntimeException("Message should not be null");
        msg.setTarget(this);
        messageQueue.put(msg);
    }

}
