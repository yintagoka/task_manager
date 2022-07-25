
# task_manager

### How to start the task_manager application

1. Run `mvn clean package` to build your application
1. Start application with `java -jar target/task_manager-1.0-SNAPSHOT.jar server`
1. To check that your application is running enter url `http://localhost:8080`

---

### Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`

---

### Docker


#### Localhost

Build Image:  
```docker build -t sin.ocir.io/axxinayytj1b/task_manager_api_image D:/projects/oracle-interview/task-manager```  

Run Container:  
```docker run -d -p 8080:8080 -p 8081:8081 --name task_manager_api sin.ocir.io/axxinayytj1b/task_manager_api_image```  

Run this as part of bigger application:  
This will run both the task_manager_api and task_manager_ui(react application that interact with this api)
```
cd D:/projects/oracle-interview
docker compose up -d
```

To run the application:  
```http://localhost:8080/task```  


#### Oracle Cloud:

To push images to container registry:  
```docker push sin.ocir.io/axxinayytj1b/task_manager_api_image:latest```

Connect to instance in oracle cloud:  
```ssh -i D:/projects/oracle-interview/ssh-key-2022-07-22.key opc@138.2.89.23```

Pull image to oracle instance:  
```sudo docker pull sin.ocir.io/axxinayytj1b/task_manager_api_image:latest```

Run Container:  
```sudo docker run -d -p 8080:8080 -p 8081:8081 --name task_manager_api sin.ocir.io/axxinayytj1b/task_manager_api_image```  

To run this as part of bigger application:
This will run both the task_manager_api and task_manager_ui(react application that interact with this api)
```
cd /home/opc
sudo docker compose up -d
```

To run the application:  
```http://138.2.89.23:8080/task```

---