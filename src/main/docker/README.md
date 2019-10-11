# Building and running a Jenkins master with Docker

This Jenkins master is configured with a `DefaultCrumbIssuer`


Build the image
```bash
docker build -t jenkins-rest/jenkins .
```

Run the jenkins master container
```bash
docker run -d --rm -p 8080:8080 --name jenkins-rest jenkins-rest/jenkins
```