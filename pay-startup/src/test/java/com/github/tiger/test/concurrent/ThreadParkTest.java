package com.github.tiger.test.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试 LockSupport
 */
public class ThreadParkTest {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();

        Thread go = new Thread(() -> {
            try {
                Thread.sleep(6 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(main);
        });
        go.start();

        LockSupport.park();

        System.out.println("main thread end ...");
    }
}
