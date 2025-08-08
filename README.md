# Jenkins Shared Library with GitHub Webhook Integration

## 📌 Overview
This project demonstrates how to use a **Jenkins Shared Library** to manage reusable pipeline code and integrate it with **GitHub Webhooks** for CI/CD automation.

---

## 📂 Project Structure
```
(root)
│
├── vars/
│   └── samplePipeline.groovy
│
├── src/
│   └── org/example/Utilities.groovy
│
└── README.md
```

- **`vars/`** → Contains pipeline entry points (Groovy scripts).
- **`src/`** → Contains helper classes and utility functions.
- **`README.md`** → Documentation file (this one).

---

## ⚙️ Jenkins Shared Library Setup

### 1️⃣ Create a Git Repository for the Shared Library
- Create a new GitHub repo (e.g., `jenkins-shared-library`).
- Push the `vars/` and `src/` folder to it.

### 2️⃣ Configure the Library in Jenkins
1. Navigate to **Manage Jenkins** → **Configure System**.
2. Scroll to **Global Pipeline Libraries**.
3. Add:
   - **Name:** `my-shared-library`
   - **Default Version:** `main`
   - **Source Code Management:** Git
   - **Project Repository:** `<your-repo-url>`

---

## 📜 Sample Shared Library Code

**`vars/samplePipeline.groovy`**
```groovy
def call(String name = 'Vijay') {
    pipeline {
        agent any
        stages {
            stage('Greet') {
                steps {
                    echo "Hello, ${name}! This is from the Shared Library."
                }
            }
        }
    }
}
```

---

## 🚀 Using the Shared Library in Jenkinsfile

**`Jenkinsfile`**
```groovy
@Library('my-shared-library') _
samplePipeline('Vijay')
```

---

## 🔔 GitHub Webhook Setup

1. Go to your **GitHub repository**.
2. Navigate to **Settings** → **Webhooks** → **Add webhook**.
3. Fill:
   - **Payload URL:** `http://<jenkins-server>/github-webhook/`
   - **Content type:** `application/json`
   - **Events:** Select **Just the push event**.
4. Click **Add Webhook**.

---

## ✅ Test the Setup
1. Commit and push changes to your GitHub repo.
2. Jenkins should automatically trigger the pipeline.

---

## 📝 Notes
- Make sure Jenkins has the **GitHub Integration Plugin** installed.
- Webhook URL must be publicly accessible (use **ngrok** if testing locally).
- Keep your library functions modular for reusability.

---

## 📄 License
This project is licensed under the Vijay Project License.
