def call(String url, String branch){
  echo "Docker Hub will clone the image"
  git url: "${url}", branch: "${branch}"
  echo "Code clone successfully"
}
