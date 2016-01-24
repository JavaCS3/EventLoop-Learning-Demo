/**
 * Filename: Main.java
 * Author: charles
 * Date: Jan 23, 2016
 */
package com.demo;

/**
 * @author charles
 *
 */
public class Main {
    public static void main(String[] args) {
        EventLooper.prepare();
        Handler handler = new Handler() {
            int count = 0;

            @Override
            public void handlerMessage(Message msg) {
                System.out.println("echo handle message: " + msg.name());
            }

        };
        handler.sendMessage(new Message("shit"));
        Thread.currentThread().setName("Main loop");
        Thread worker = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                for (;;) {
                    handler.sendMessage(new Message("From " + Thread.currentThread() + " Hello " + ++count));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        worker.setName("Worker thread");
        worker.start();
        EventLooper.loop();
    }
}
