# microservice-assignment
This is the repository contain the micro service assignment part one


This Microservice assignment covered below features:

1.eureka

2.config server

3.zuul server

4.zipkin server

5.hystrix dashboard 

6.spring cloud bus with rabbit mq.

How to start the first Microservice assignment project;
<hr>

eureka-server::
 Start the eureka server with below command :
  mvn spring-boot:run
  
  <hr>
  config-server::
 Start the config server with below command :
  mvn spring-boot:run
  
   <hr>
   
  zuul-server::
<hr>
 Start the zuul server with below command :
  mvn spring-boot:run
  
   <hr>
   zipkin-server::
 Download and Start the zipkin server with below command  ::
 curl -sSL https://zipkin.io/quickstart.sh | bash -s
  java -jar zipkin.jar
  
  zipkin url  : http://localhost:9411/
  
   <hr>
order-service::
<hr>
 Start the order service with below command :
  mvn spring-boot:run
  
   <hr>
  order-item-service::
 Start the order-item-service with below command :
  mvn spring-boot:run
  
   <hr>
   
   install the rabbit mq in local sytem
   
   run the rabbit mq server local system with below command 
   
   Within the rabbitmq_server-3.8.5\sbin directory are some scripts which run commands to control the RabbitMQ server.

The RabbitMQ server can be run as either an application or service (not both).

rabbitmq-server.bat starts the broker as an application
rabbitmq-service.bat manages the service and starts the broker
rabbitmqctl.bat manages a running broker
  
 
 open the zuul gate way swagger url of order service and order-item-service
 
 
 http://localhost:8089/order/swagger-ui.html
 
 http://localhost:8089/order-item/swagger-ui.html
 
 
  
  
  
  
  
