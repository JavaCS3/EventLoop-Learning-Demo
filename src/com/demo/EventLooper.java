/**
 * Filename: EventLooper.java
 * Author: charles
 * Date: Jan 23, 2016
 */
package com.demo;

/**
 * @author charles
 *
 */
public class EventLooper {
    private static final ThreadLocal<EventLooper> slooper = new ThreadLocal<EventLooper>();
    private MessageQueue messageQueue;
    private Thread currentThread;

    private EventLooper() {
        messageQueue = new MessageQueue();
        currentThread = Thread.currentThread();
    }

    MessageQueue getMessageQueue() {
        return messageQueue;
    }

    public static void prepare() {
        EventLooper looper = slooper.get();
        if (looper != null) {
            throw new RuntimeException("A thread can only have one looper");
        }
        slooper.set(new EventLooper());
    }

    public static void loop() {
        EventLooper looper = myEventLooper();
        if (looper == null) return;
        MessageQueue mq = looper.messageQueue;
        while (true) {
            Message m = mq.next();
            if (m == null || m.target() == null) {
                return;
            }
            m.target().handlerMessage(m);

            System.out.printf("Thread: %s, Message: %s\n", looper.currentThread, m.name());
        }
    }
    
    public static EventLooper myEventLooper() {
        return slooper.get();
    }

}
