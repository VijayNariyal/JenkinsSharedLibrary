def call(String url, String branch){
  echo "Docker Hub will clone the image"
  git branch: 'main', url: 'https://github.com/LondheShubham153/django-notes-app.git'
  echo "Code clone successfully"
}
