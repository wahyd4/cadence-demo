package com.afterpay.ds.cadence;

import com.uber.cadence.worker.Worker;
import com.uber.cadence.workflow.QueryMethod;
import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.Workflow;
import com.uber.cadence.workflow.WorkflowMethod;
import org.slf4j.Logger;

import java.time.Duration;

public class HelloCadence {

    private static Logger logger = Workflow.getLogger(HelloCadence.class);

    public static void main(String[] args) {
        Worker.Factory factory = new Worker.Factory("localhost",7933, "test-domain-au");
        Worker worker = factory.newWorker("aaa");
        worker.registerWorkflowImplementationTypes(HelloWorldImpl.class);
        factory.start();
    }

    public interface HelloWorld {
        @WorkflowMethod
        void sayHello(String name);

        @SignalMethod
        void updateGreeting(String greeting);

        @QueryMethod
        int getCount();
    }

    public static class HelloWorldImpl implements HelloWorld {

        private String greeting = "Hello";
        private int count = 0;

        @Override
        public void sayHello(String name) {
//            while (!"Bye".equals(greeting)) {
//                logger.info(++count + ": " + greeting + " " + name + "!");
//                String oldGreeting = greeting;
//                Workflow.await(() -> !Objects.equals(greeting, oldGreeting));
//            }
//            logger.info(++count + ": " + greeting + " " + name + "!");

            Workflow.sleep(Duration.ofSeconds(30));

            logger.info(++count + ": " + greeting + " " + name + "!");
        }

        @Override
        public void updateGreeting(String greeting) {
            this.greeting = greeting;
        }

        @Override
        public int getCount() {
            return this.count;
        }
    }
}
