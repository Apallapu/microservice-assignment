# microservice-assignment
This is the repository contain the micro service assignment part one

How to start the first Microservice assignment project;
<hr>

eureka-server::
 Start the eureka server with below command
  mvn spring-boot:run
  
  <hr>
  config-server::
 Start the config server with below command
  mvn spring-boot:run
  
   <hr>
   
  zuul-server::
<hr>
 Start the zuul server with below command
  mvn spring-boot:run
  
   <hr>
   zipkin-server::
 Download and Start the zipkin server with below command
 curl -sSL https://zipkin.io/quickstart.sh | bash -s
  java -jar zipkin.jar
  
   <hr>
order-service::
<hr>
 Start the order service with below command
  mvn spring-boot:run
   <hr>
  order-item-service::
 Start the order-item-service with below command
  mvn spring-boot:run
  
   <hr>
  
 
 open the zuul gate way swagger url of order service and order-item-service
 
 
 http://localhost:8089/order/swagger-ui.html
 
 http://localhost:8089/order-item/swagger-ui.html
 
 
  
  
  
  
  
