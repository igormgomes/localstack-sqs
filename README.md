# LocalStack SQS
### Running Localstack
```
at /localstack
docker-compose -d 
```

### For test queue list
```
aws sqs list-queues --endpoint-url=http://localhost:4576 --region=us-east-1
```

### Running app
```
mvn clean install
java -jar target/localstack-sqs-1.0.0.jar
```
