# DAM2, a better DAM
### Requirements
- Docker 19.03.9 and up
- Docker Compose 1.25.0 and up

### Startup DAM2 Testing Environment
Have a running DB session with:
```$xslt
docker-compose -f docker-compose.dev.yml up
```
Then run your listener microservices session in the dam2-listener folder
```$xslt
mvn -DskipTests=true clean quarkus:dev -Ddebug=5010
```
hen run your runner microservices session in the dam2-listener folder
```$xslt
mvn -DskipTests=true clean quarkus:dev -Ddebug=5020
```
Then start your frontend dev server session in dam2-frontend:
```$xslt
npm run start
```

### Startup DAM2 Staging Environment
First package the microservices:
```$xslt
mvn -DskipTests=true package
```
Ensure `docker-compose.stage.yml` is in your directory, then run
```$xslt
$ docker-compose up
```
This will create the `database` folder in your directory

### Startup DAM2 Production Environment
First package the microservices:
```$xslt
mvn -DskipTests=true package
```
The images must be first built, then pushed to Docker Hub. To build the images, run:
```$xslt
docker-compose -f docker-compose.stage.yml build
```
Then push the images with
```$xslt
docker push decimelli/dam2-listener
docker push decimelli/dam2-frontend
```
In the production environment, ensure `docker-compose.prod.yml` is in your directory, then run
```$xslt
docker login -u decimelli
docker-compose -f docker-compose.produciton.yml up
```

