## idfinance-api ##

#### This application is a test task from [IDFinance](https://idfinance.com/).

There's support for the following features:

* Viewing the list of available cryptocurrencies.
* View the current price for the specified cryptocurrency.
* Notification of the user in the journal about the change in the price of the cryptocurrency by more than 1% from the moment of its registration.

## How to run this?
```bash

$ Create a postgresql database:
    name: idfinance_api_db
    username: postgres
    password: postgres
Or run with docker: docker run --name idfinance_api_db -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=idfinance_api_db -p 5432:5432 -d postgres

$ git clone https://github.com/EvgenyLeshevich/idfinance-api.git
$ cd idfinance-api
$ ./gradlew bootRun
```


## Swagger Docs ##

The project has been configured with a Swagger docket that exposes the APIs with the schema

Accessible at `http://localhost:8080/swagger-ui/index.html` once the app is running.

![image](https://user-images.githubusercontent.com/73518823/179189259-b29948b0-039b-442d-8a2d-c150e144e3ca.png)
