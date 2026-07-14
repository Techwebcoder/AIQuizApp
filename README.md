# 🧠 AI Quiz App

An intelligent quiz generation web application built using **Spring Boot** and the **Groq AI API**. The application generates AI-powered multiple-choice quiz questions based on a user-provided topic, evaluates user responses, calculates the final score, and displays the results through an interactive web interface.

---

## 🚀 Features

- 🤖 AI-powered quiz generation using the Groq API
- 📝 Generate quizzes on any topic
- ✅ Multiple Choice Questions (MCQs)
- 📊 Automatic score calculation
- 🎯 Instant result after quiz submission
- 💾 MySQL database integration
- 🌐 Responsive UI using Thymeleaf

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- MySQL
- Maven
- Groq API
- HTML5
- CSS3
- Bootstrap

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── model
├── dto
└── resources
    ├── templates
    ├── static
    └── application.properties
```

---

## ⚙️ How It Works

1. Enter a quiz topic.
2. The application sends the topic to the Groq AI API.
3. AI generates multiple-choice questions.
4. Questions are displayed to the user.
5. User submits the answers.
6. The application evaluates the responses.
7. The final score is displayed.

---

---

## ▶️ Getting Started

### Clone the Repository

```bash
git clone https://github.com/Techwebcoder/AIQuizApp.git
```

### Open the Project

Open the project using **IntelliJ IDEA** or **Spring Tool Suite**.

### Configure Database

Update your MySQL configuration in:

```properties
src/main/resources/application.properties
```

### Configure Groq API Key

Use an environment variable instead of storing the API key in the project.

```properties
groq.api.key=${GROQ_API_KEY}
```

### Run the Application

Start the Spring Boot application and open:

```
http://localhost:8080
```

---

## 🔮 Future Improvements

- 🔐 User Authentication (Login & Signup)
- 📜 Quiz History
- 🏆 Leaderboard
- ⏱️ Timer for each quiz
- 🎯 Difficulty Levels
- 📚 Multiple Quiz Categories
- 📈 Dashboard & Analytics

---

## 👨‍💻 Author

**Rajakumar B**

- GitHub: https://github.com/Techwebcoder

---

⭐ If you found this project useful, consider giving it a **Star** on GitHub!
