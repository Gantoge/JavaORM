
<h1 align="center">🎓 Educational Platform</h1>

<p align="center">
Платформа для онлайн-обучения, созданная для демонстрации возможностей <b>ORM и Hibernate</b>.<br>
Проект реализует систему управления курсами с использованием <b>JPA/Hibernate</b>, <b>Spring Boot</b> и <b>PostgreSQL</b>.
</p>

<h2>📚 Основные возможности</h2>
<ul>
  <li><b>Управление ролями пользователей</b>: студент, преподаватель, администратор</li>
  <li><b>Каталог курсов</b>: добавление, редактирование и публикация курсов</li>
  <li><b>Структура контента</b>: модули, уроки, практические задания</li>
  <li><b>Тестирование и оценка знаний</b>: викторины и автоматическая проверка</li>
  <li><b>Регистрация студентов</b>: связь Many-to-Many между пользователями и курсами</li>
  <li><b>Система оценивания</b>: хранение результатов, комментариев и оценок</li>
  <li><b>Отзывы и рейтинг</b>: обратная связь от участников курсов</li>
</ul>

<h2>🧩 Архитектура приложения</h2>
<ul>
  <li><b>Entity</b> — JPA-сущности и их связи</li>
  <li><b>Repository</b> — репозитории Spring Data JPA</li>
  <li><b>Service</b> — бизнес-логика и транзакции</li>
  <li><b>Controller</b> — REST API</li>
  <li><b>Config</b> — конфигурация приложения</li>
</ul>

<h2>⚙️ Технологический стек</h2>
<table>
  <tr><td>Язык</td><td><b>Java 17</b></td></tr>
  <tr><td>Фреймворк</td><td>Spring Boot 3.2.0</td></tr>
  <tr><td>ORM</td><td>Hibernate, Spring Data JPA</td></tr>
  <tr><td>База данных</td><td>PostgreSQL</td></tr>
  <tr><td>Тестирование</td><td>JUnit, Testcontainers</td></tr>
  <tr><td>Сборщик</td><td>Gradle</td></tr>
</table>

<h2>🗃️ Структура данных</h2>

<p>Проект содержит более 17 сущностей с различными связями:</p>

<table>
  <tr><th>Таблица</th><th>Описание</th></tr>
  <tr><td><b>User</b></td><td>Пользователи системы</td></tr>
  <tr><td><b>Profile</b></td><td>Профиль пользователя (OneToOne)</td></tr>
  <tr><td><b>Category</b></td><td>Категории курсов</td></tr>
  <tr><td><b>Course</b></td><td>Описание курсов</td></tr>
  <tr><td><b>Enrollment</b></td><td>Регистрация студентов (ManyToMany)</td></tr>
  <tr><td><b>Module</b></td><td>Разделы курса</td></tr>
  <tr><td><b>Lesson</b></td><td>Отдельные уроки</td></tr>
  <tr><td><b>Assignment</b></td><td>Домашние задания</td></tr>
  <tr><td><b>Submission</b></td><td>Отправленные решения</td></tr>
  <tr><td><b>Quiz</b></td><td>Тесты</td></tr>
  <tr><td><b>Question</b></td><td>Вопросы</td></tr>
  <tr><td><b>AnswerOption</b></td><td>Варианты ответов</td></tr>
  <tr><td><b>QuizSubmission</b></td><td>Результаты тестов</td></tr>
  <tr><td><b>CourseReview</b></td><td>Отзывы и оценки</td></tr>
  <tr><td><b>Tag</b></td><td>Теги курсов (ManyToMany)</td></tr>
</table>

<h2>🚀 Запуск проекта</h2>

<h3>1. Требования</h3>
<ul>
  <li>Java 17+</li>
  <li>Gradle (или wrapper)</li>
</ul>

<h3>2. Быстрый старт</h3>

<h4>H2 (встроенная база)</h4>
<pre><code>./gradlew bootRun --args='--spring.profiles.active=h2'</code></pre>

<h4>PostgreSQL (основной вариант)</h4>

<pre><code>docker-compose up -d</code></pre>

<p>Или вручную:</p>

<pre><code>CREATE DATABASE education_platform;
CREATE USER postgres WITH PASSWORD 'postgres';
GRANT ALL PRIVILEGES ON DATABASE education_platform TO postgres;
</code></pre>

<h4>Запуск приложения</h4>
<pre><code>./gradlew bootRun</code></pre>
<p>Приложение доступно по адресу: <a href="http://localhost:8080">http://localhost:8080</a></p>

<h3>3. Сборка и тестирование</h3>
<pre><code>./gradlew build
./gradlew test
./gradlew clean build
</code></pre>

<h2>🧠 H2 Console</h2>

<table>
  <tr><td>URL</td><td><code>http://localhost:8080/h2-console</code></td></tr>
  <tr><td>JDBC</td><td><code>jdbc:h2:mem:testdb</code></td></tr>
  <tr><td>Username</td><td><code>sa</code></td></tr>
  <tr><td>Password</td><td><i>(пусто)</i></td></tr>
</table>

<h2>📡 Основные API-запросы</h2>

<h3>Курсы</h3>
<pre><code>POST /api/courses?title=Java Basics&description=Learn Java&categoryId=1&teacherId=1
GET /api/courses/{id}
GET /api/courses/{id}/with-modules
GET /api/courses
GET /api/courses/category/{categoryId}
GET /api/courses/teacher/{teacherId}
POST /api/courses/{courseId}/modules?title=Module 1&orderIndex=1
</code></pre>

<h3>Регистрация студентов</h3>
<pre><code>POST /api/enrollments?courseId=1&studentId=1
DELETE /api/enrollments?courseId=1&studentId=1
GET /api/enrollments/student/{studentId}/courses
</code></pre>

<h3>Задания</h3>
<pre><code>POST /api/assignments?lessonId=1&title=Homework&description=Task&dueDate=2024-12-31&maxScore=100
POST /api/assignments/{assignmentId}/submit?studentId=1&content=Solution
PUT /api/assignments/submissions/{submissionId}/grade?score=95&feedback=Good work!
</code></pre>

<h3>Тесты</h3>
<pre><code>POST /api/quizzes?moduleId=1&title=Quiz&timeLimit=30
POST /api/quizzes/{quizId}/questions?text=Question&type=SINGLE_CHOICE
POST /api/quizzes/questions/{questionId}/options?text=Answer&isCorrect=true
POST /api/quizzes/{quizId}/take?studentId=1
</code></pre>

<h2>🧪 Демонстрационные данные</h2>
<ul>
  <li>1 преподаватель и 2 студента</li>
  <li>Категории: <b>Programming</b>, <b>Databases</b></li>
  <li>Курсы с модулями и уроками</li>
  <li>Примеры заданий, тестов и отзывов</li>
</ul>

<h2>🧱 Тестирование</h2>
<pre><code>./gradlew test</code></pre>

<p>Включает интеграционные тесты на основе <b>Testcontainers</b>, проверяющие работу ORM, связей и миграций.</p>

<h2>🧭 Структура каталогов</h2>
<pre><code>src/main/java/ru/vasmarfas/educationplatform/
├── entity/
├── repository/
├── service/
├── controller/
└── config/
</code></pre>

<h2>🐳 Docker</h2>
<pre><code>docker-compose up -d
docker-compose down
</code></pre>

<h2>🤖 CI/CD</h2>
<p>GitHub Actions обеспечивает автоматическую сборку, тестирование и проверку кода.</p>

<h2>📊 Тестовое покрытие</h2>
<ul>
  <li><b>Unit-тесты</b> — проверка сервисов и логики</li>
  <li><b>Integration-тесты</b> — сценарии end-to-end</li>
  <li>Всего более <b>20 тестов</b></li>
</ul>

<hr>
<p align="center">
Полноценная система обучения с REST API, Docker, автоматическим тестированием и ORM на Spring Boot.
</p>


