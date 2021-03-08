cd ..
cd restful-api
docker build -t backend:1.0 .
cd ..
cd rest-client
docker build -t frontend:1.0 .
cd ..
docker-compose up -d