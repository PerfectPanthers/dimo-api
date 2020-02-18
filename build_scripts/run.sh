docker build -t dimo-api --cache-from dimo-api ../.
docker run -d -p 80:8080 --name dimo-api dimo-api
