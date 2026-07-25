
document
    .getElementById("loginBtn")
    .addEventListener("click", function() {

        window.location.href = "index.html";

    });

const registerForm = document.getElementById("registerForm");

registerForm.addEventListener("submit", async function(event) {

    event.preventDefault();

    const name = document.getElementById("name").value.trim();

    const email = document.getElementById("email").value.trim();

    const phone = document.getElementById("phone").value.trim();

    const gender = document.getElementById("gender").value;

    const bloodGroup = document.getElementById("bloodGroup").value;

    const dob = document.getElementById("dob").value;

    const address = document.getElementById("address").value.trim();

    const password = document.getElementById("password").value.trim();

    const confirmPassword = document
        .getElementById("confirmPassword")
        .value
        .trim();

    if (
        name === "" ||
        email === "" ||
        phone === "" ||
        gender === "" ||
        bloodGroup === "" ||
        dob === "" ||
        address === "" ||
        password === "" ||
        confirmPassword === ""
    ) {

        alert("Please fill all fields.");

        return;
    }


    if (password !== confirmPassword) {

        alert("Password and Confirm Password do not match.");

        return;
    }

    const registerData = {

        name: name,

        email: email,

        password: password,

        phone: phone,

        gender: gender,

        bloodGroup: bloodGroup,

        address: address,

        dob: dob

    };

	  try {

        const response = await fetch("http://localhost:8080/patient/register", {

            method: "POST",

            headers: {

                "Content-Type": "application/json"

            },

            body: JSON.stringify(registerData)

        });

        if (response.ok) {

            alert("Registration Successful.");

            registerForm.reset();

            window.location.href = "index.html";

        }

        else {

            const errorMessage = await response.text();

            alert(errorMessage);

        }

    }

    catch (error) {

        console.error(error);

        alert("Server is not responding. Please try again later.");

    }

});