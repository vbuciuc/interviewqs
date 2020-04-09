package com.axway.itrvw;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
    private int counter = 0;

    @Test
    public void threadingTest() throws  ExecutionException, InterruptedException {
        // start an executor service with 4 threads
        ExecutorService exec = Executors.newFixedThreadPool(4);

        // submit task 4 times
        for (int k = 0; k < 4; k++) {
            exec.submit(() -> {
                    for (int i = 0; i < 10000; i++) {
                        counter++;
                    }
                });
        }
        
        exec.shutdown();
        exec.awaitTermination(800, TimeUnit.MILLISECONDS);
        
        System.out.printf("Final counter value=%d", counter);
        
    }
    
}
