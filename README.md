# Book Middle Service

Training project demonstrating creation of a REST Spring Boot microservice using Mongodb to persist data and AWS SQS to track the data changes.

## Introduction to MongoDB
MongoDB is an open-source document database that provides high performance, high availability, and automatic scaling. MongoDB obviates the need for an Object Relational Mapping (ORM) to facilitate development.

### Documents

A record in MongoDB is a document, which is a data structure composed of field and value pairs. MongoDB documents are similar to JSON objects. The values of fields may include other documents, arrays, and arrays of documents.

```json
{
   "_id" : ObjectId("54c955492b7c8eb21818bd09"),
   "address" : {
      "street" : "2 Avenue",
      "zipcode" : "10075",
      "building" : "1480",
      "coord" : [ -73.9557413, 40.7720266 ]
   },
   "borough" : "Manhattan",
   "cuisine" : "Italian",
   "grades" : [
      {
         "date" : ISODate("2014-10-01T00:00:00Z"),
         "grade" : "A",
         "score" : 11
      },
      {
         "date" : ISODate("2014-01-16T00:00:00Z"),
         "grade" : "B",
         "score" : 17
      }
   ],
   "name" : "Vella",
   "restaurant_id" : "41704620"
}
```

### Collections

MongoDB stores documents in collections. Collections are analogous to tables in relational databases. Unlike a table, however, a collection does not require its documents to have the same schema.

In MongoDB, documents stored in a collection must have a unique **_id** field that acts as a **primary key**.

### Install MongoDB

For more information on installation, including supported platforms and installation tutorials for MongoDB Enterprise, see [Installation](https://docs.mongodb.com/manual/installation/ "Installation") in the MongoDB manual.

[Install MongoDB Community Edition on Linux](https://docs.mongodb.com/getting-started/shell/tutorial/install-on-linux/)

[Install MongoDB Community Edition on OS X](https://docs.mongodb.com/getting-started/shell/tutorial/install-mongodb-on-os-x/)

[Install MongoDB Community Edition on Windows](https://docs.mongodb.com/getting-started/shell/tutorial/install-mongodb-on-windows/)


## Amazon Simple Queue Service
Amazon Simple Queue Service (Amazon SQS) is a fully managed message queuing service that makes it easy to decouple and scale microservices, distributed systems, and serverless applications. Amazon SQS moves data between distributed application components and helps you decouple these components. For more information about see [SQS Documentation](https://aws.amazon.com/pt/documentation/sqs/)


## Bookmiddle Project
This project was based on [platform.training.bookmiddle](https://github.com/EBSCOIS/platform.training.bookmiddle) developed by [Michael Panson](https://github.com/mp-ebsco). The original project was changed to support data persistence in mongodb as well as a trace of each operation that modifies the data of each document to record those changes in a FIFO queue using AWS SQS.

## Set up

### AWS Credentials
The application uses your **default** credential profile by reading from the credentials file located at (~/.aws/credentials).
For more information about see [Configuration and Credential Files](http://docs.aws.amazon.com/cli/latest/userguide/cli-config-files.html)

## Build

`$ gradle build`

## Run (local profile is optional)

`$ gradle [-Dspring.profiles.active=local] bootRun`

## Explore

Go to http://localhost:8080/books from a browser or Postman.
