# Cadence demo

## How to run

```
export CADENCE_URL=<to be your cadence host>
export CADENCE_DOMAIN=<to be the cadence domain>

# run the application

./gradlew run

# Schedule a simple job to cadence

cadence --ad <your-cadence-domain>:7933 --do ds-test  workflow start --tasklist helloWorldTaskList  --workflow_type HelloWorld::sayHello --execution_timeout 3600 --input \"World\"

```

You should expect console prints out "Hello World" in `10` seconds 