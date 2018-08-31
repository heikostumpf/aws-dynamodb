# AWS DynamoDB 

This SpringBoot application was developed to interact with a local DynamoDB  instance as a preparation for the AWS Certified Developer – Associate certification.

It helps to understand the different concepts of capacity units, indexes and primary keys.

## Getting Started

To interact with the AWS DynamoDB clone this repository and install a the local version of DynamoDB or use a dockerized version of DynamoDB.
```
$ git clone https://github.com/heikostumpf/aws-docker-dynamodb
$ git clone https://github.com/heikostumpf/aws-dynamodb
```

To setup the dockerized DynamoDB environment please follow the instructions in the respective repository.

### Prerequisites

You need to have Java (at least Version 1.8), Docker, Maven and Git installed on your local development environment in order to compile and run the application.

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc



#AWS DynamoDB

## Install local DynamoDB for testing

Use the dynamoDB local Docker container in aws-docker-dynamodb project

## Create Table "User"

Create a table called "User" in your local DynamoDB instance.
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

## Display available tables
```
$ aws dynamodb list-tables \ 
    --endpoint-url http://localhost:8000
```
Result:
``` 
{
    "TableNames": [
        "User"
    ]
}

```

# Drop the table
````
aws dynamodb delete-table --endpoint-url http://localhost:8000 --table-name User
````

# Interacting with the REST endpoint

Send a PUT Request to http://localhost:8080/
```
{
    "userId": "1",
    "firstName": "Heiko",
    "lastName": "Stumpf"
}
```