package com.afterpay.ds.cadence;

import com.afterpay.ds.cadence.HelloCadence.HelloWorld;
import com.uber.cadence.WorkflowExecution;
import com.uber.cadence.client.WorkflowClient;

public class StartWorkflow {
    public static void main(String[] args) throws InterruptedException {
        WorkflowClient workflowClient = WorkflowClient.newInstance("192.168.0.249", 7933, "domain");

        for (int i = 0; i < 100; i++) {

            // Create a workflow stub.
            HelloWorld workflow = workflowClient.newWorkflowStub(HelloWorld.class);

            // Returns as soon as the workflow starts.
            WorkflowExecution workflowExecution = WorkflowClient.start(workflow::sayHello, args[0] + i);

            System.out.println("Started process file workflow with workflowId=\"" + workflowExecution.getWorkflowId() + "\" and runId=\"" + workflowExecution.getRunId() + "\"");
        }

        System.exit(0);
    }

}
