🧠 AI Quiz App

An intelligent quiz generation web application built with Spring Boot that uses the Groq AI API to generate multiple-choice quiz questions dynamically based on a user-provided topic. The application evaluates user answers, calculates the final score, and displays the result in a clean and interactive interface.

🚀 Features
🤖 AI-powered quiz generation using the Groq API
📝 Generate quizzes from any topic entered by the user
✅ Multiple-choice questions (MCQs)
📊 Automatic score calculation
🎯 Instant quiz result after submission
💾 Stores user and quiz data using MySQL
🌐 Responsive web interface built with Thymeleaf
🛠️ Technologies Used
Java
Spring Boot
Spring MVC
Thymeleaf
MySQL
Maven
Groq API
HTML
CSS
Bootstrap
📂 Project Structure
src
├── controller
├── service
├── repository
├── model
├── dto
├── resources
│   ├── templates
│   ├── static
│   └── application.properties
⚙️ How It Works
The user enters a quiz topic.
The application sends the topic to the Groq AI API.
The AI generates multiple-choice questions.
Questions are displayed on the webpage.
The user submits their answers.
The application compares the answers with the correct ones.
The final score is calculated and displayed.
📸 Screenshots

Add screenshots of:

Home Page
Topic Selection
Quiz Page
Result Page
▶️ Getting Started
Clone the repository
git clone https://github.com/your-username/AIQuizApp.git
Open the project in IntelliJ IDEA.
Configure MySQL and update application.properties.
Add your Groq API key as an environment variable:
groq.api.key=${GROQ_API_KEY}
Run the Spring Boot application.
Open your browser and visit:
http://localhost:8080
Future Improvements
User authentication (Login/Signup)
Quiz history
Leaderboard
Timer for each quiz
Difficulty selection (Easy, Medium, Hard)
Categories and topic filtering
Dashboard with quiz analytics
Author

Rajakumar B

GitHub: https://github.com/Techwebcoder
