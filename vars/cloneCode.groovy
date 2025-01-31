def call(String url, String branch){
  echo "Docker Hub will clone the image"
  git branch: "${branch}", url: "${url}"
  echo "Code clone successfully"
}
