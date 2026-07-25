# 🏥 Healthcare Management System

A secure Hospital Management System Backend developed using **Java**, **Spring Boot**, **Spring Security**, **JWT Authentication**, **Spring Data JPA**, **Hibernate**, and **MySQL**.

---

## 🚀 Features

- 🔐 JWT Authentication
- 👨‍⚕️ Role-Based Authorization (Admin, Doctor, Patient)
- 👤 User Registration & Login
- 🩺 Doctor Management
- 🧑‍🤝‍🧑 Patient Management
- 📅 Appointment Management
- 💊 Prescription Management
- ❓ Patient Query Management
- ✅ Bean Validation
- ⚠️ Global Exception Handling
- 🔒 BCrypt Password Encryption

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

---

## 📂 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── config
├── security
├── exception
└── resources
```

---

## ⚙️ Installation

1. Clone the repository

```bash
git clone https://github.com/nitin3235D/hospital-management-system-backend.git
```

2. Configure MySQL in `application.properties`.

3. Run the Spring Boot application.

4. Test APIs using Postman.

---

## 🔐 Authentication

This project uses **JWT (JSON Web Token)** for secure authentication and **Role-Based Access Control**.

### Roles

- ADMIN
- DOCTOR
- PATIENT

---

## 📮 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register Patient |
| POST | `/auth/login` | Login |
| GET | `/admin/**` | Admin APIs |
| GET | `/doctor/**` | Doctor APIs |
| GET | `/patient/**` | Patient APIs |

---

## 📸 Screenshots

### Login

login_page.png

### Dashboard

admin_dashboard.png



---

## 👨‍💻 Author

**Nitin Bisht**

GitHub: https://github.com/nitin3235D
