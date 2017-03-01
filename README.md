Robo-Insta [![Build Status](https://travis-ci.org/Cinderpup/RoboInsta.svg?branch=master)](https://travis-ci.org/Cinderpup/RoboInsta)
===

##Running Locally

###Prerequisites

To be able to run locally we'll need a DynamoDB instance.
You'll either need an amazon account, or be able to deploy a local docker container

####Deploying a local docker container
```
docker run -d --name dynamodb -p 127.0.0.1:8000:8000 qkyrie/dynamodb:latest
```
