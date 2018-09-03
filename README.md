# AWS DynamoDB 
This SpringBoot application demonstrates various features of DynamoDB and helps to understand the concepts of capacity units, indexes (global and secondary) and primary keys (hash and composite).

The available REST-endpoints provide interfaces to interact with DynamoDB independent from the underlying infrastructure.

## Getting Started

To interact with DynamoDB clone this repository and install DynamoDB either as a local, a dockerized or DynamoDB on AWS.

* [github AWS Docker DynamoDB](http://github.com/heikostumpf/aws-docker-dynamodb)
* [github AWS DynamoDB](http://github.com/heikostumpf/aws-dynamodb)

To setup the dockerized DynamoDB environment please follow the instructions in the respective repository.

### Prerequisites

You need to have Java (at least Version 1.8), Docker, Maven and Git installed on your local development environment in order to compile and run the application.

## Installation

## Create Table "User"

Create the table "User" containg a Partition Key (UserID).
```
$ aws dynamodb create-table \
    --endpoint-url http://localhost:8000/ \
    --table-name User \
    --attribute-definitions \
        AttributeName=UserId,AttributeType=S \
    --key-schema \
        AttributeName=UserId,KeyType=HASH \
    --provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5
```

## Create Table "Thread"
Create the table "Thread" in DynamoDB containing a composite partition key (ForumName and Subject).
```
$ aws dynamodb create-table \
    --endpoint-url http://localhost:8000/ \
    --table-name User \
    --attribute-definitions \
        AttributeName=UserId,AttributeType=S \
    --key-schema \
        AttributeName=UserId,KeyType=HASH \
    --provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5```

### Display available tables
Use the AWS CLI to list all available tables.
```
$ aws dynamodb list-tables \ 
    --endpoint-url http://localhost:8000
```

### Drop the table
Use the AWS CLI to delete a specific table.
```
aws dynamodb delete-table --endpoint-url http://localhost:8000 --table-name User
```

## Deployment
## Testing

# Interacting with the REST endpoint

Send a PUT Request to http://localhost:8080/
```
{
    "firstName": "Heiko",
    "lastName": "Stumpf"
}
```

Send a GET Request to http://localhost:8080/users
```
{
    
}
```

## Build With
* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds 

## Authors

* **Heiko Stumpf** - *Initial work* - [AWS DynamoDB](https://github.com/heikostumpf/aws-dynamoDB)