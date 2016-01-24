/**
 * Filename: Message.java
 * Author: charles
 * Date: Jan 23, 2016
 */
package com.demo;

/**
 * @author charles
 *
 */
public class Message {

    private String name;
    private Handler target;

    public Message(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public Handler target() {
        return target;
    }

    public void setTarget(Handler target) {
        this.target = target;
    }
}
