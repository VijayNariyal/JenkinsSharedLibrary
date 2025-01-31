def call(String ProjectName, String ImageTag, String DockerHubUser){
  echo "Docker Hub will build and test the image"
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
}
