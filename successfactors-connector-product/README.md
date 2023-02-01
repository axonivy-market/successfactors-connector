# Successfactors Connector
Axon Ivy’s Successfactors connector helps you accelerate your process automation initiatives by integrating Successfactors with your process application in the shortest possible time.

This connector:

-	Is based on REST webservice technologies.
-	Gives you access to sample Successfactors functionality
-	reduces the integration effort to a minimum: Use the demo implementation, there you will find examples for the calls

## Demo

1. Call test process. It returns test data in log to you.

## Setup

Before any interactions between the Axon Ivy Engine and Successfactors services can be run, they have to be introducted to each other. This can be done as follows:

1. Get a Successfactors account `host-name`, `user-name` and `password` to use.

1. Override the variables for `host-name`, `user-name` and `password` in the demo project as shown in the example below.

```
Variables:
  
  successfactors-connector:
  
    host: <myhost>
    
    username: <myuser>
  
    # [password]
    password: <mypass>
```