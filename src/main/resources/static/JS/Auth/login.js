document.getElementById("registerBtn").addEventListener("click", function () {

    window.location.href = "register.html";

});

const loginForm = document.getElementById("loginForm");

loginForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    if (email === "" || password === "") {

        alert("Please fill all fields.");
        return;

    }

    const loginData = {

        email: email,
        password: password

    };

	
	
    try {

        const response = await fetch("http://localhost:8080/auth/login", {

            method: "POST",

            headers: {

                "Content-Type": "application/json"

            },

            body: JSON.stringify(loginData)

        });

        if (!response.ok) {

            throw new Error("Invalid Email or Password");

        }

        const token = await response.text();

      
        localStorage.setItem("jwtToken", token);

     
        const payload = JSON.parse(atob(token.split(".")[1]));

		
     
        const role = payload.roles[0];

        alert("Login Successful");

		
      
        if (role === "ROLE_ADMIN") {

            window.location.href = "../Admin/admin-dashboard.html";

        } else if (role === "ROLE_DOCTOR") {

            window.location.href = "../Doctor/doctor-dashboard.html";

        } else if (role === "ROLE_PATIENT") {

            window.location.href = "../Patient/patient-dashboard.html";

        } else {

            alert("Unknown Role");

        }

    }

    catch (error) {

        alert(error.message);

    }

});