# DAM2, a better DAM
### Requirements
- Docker 19.03.9 and up
- Docker Compose 1.25.0 and up

### Startup DAM2 Staging Environment
Ensure `docker-compose.yml` is in your directory, then run
```$xslt
$ docker-compose up
```
This will create the `database` folder in your directory

### Startup DAM2 Production Environment
The images must be first built, then pushed to Docker Hub. To build the images, run:
```$xslt
docker-compose build
```
Then push the images with
```$xslt
docker push decimelli/dam2-listener
docker push decimelli/dam2-frontend
```
In the production environment, ensure `docker-compose.yml` is in your directory, then run
```$xslt
docker login -u decimelli
docker-compose -f dam2-production.yml up
```

