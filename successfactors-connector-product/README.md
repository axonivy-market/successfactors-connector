# Successfactors Connector

SuccessFactors is a cloud-based Human Capital Management (HCM) software solution offered by SAP. It helps companies manage their employee processes, including talent management, employee development, performance evaluation, onboarding, compensation management, and succession planning. SuccessFactors provides a comprehensive HR platform focused on improving employee performance and retention and is known for its scalable, flexible, and globally deployable HR software solution.

This connector simplifies the integration of Successfactors into your processes by:

- leveraging REST web service technologies,
- providing access to sample Successfactors functionalities,
- and minimizing the integration effort through a demo implementation with example calls.

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
