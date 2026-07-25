// ==========================================
// Login Button Navigation
// ==========================================

document
    .getElementById("loginBtn")
    .addEventListener("click", function() {

        window.location.href = "index.html";

    });


// ==========================================
// Register Form
// ==========================================

const registerForm = document.getElementById("registerForm");

registerForm.addEventListener("submit", async function(event) {

    event.preventDefault();

    // ============================
    // Get Form Values
    // ============================

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


    // ============================
    // Validation
    // ============================

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


    // ============================
    // JSON Object
    // ============================

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


    // ============================
    // API Call
    // ============================

    try {

        const response = await fetch("http://localhost:8080/patient/register", {

            method: "POST",

            headers: {

                "Content-Type": "application/json"

            },

            body: JSON.stringify(registerData)

        });


        // ============================
        // Success
        // ============================

        if (response.ok) {

            alert("Registration Successful.");

            registerForm.reset();

            window.location.href = "index.html";

        }

        // ============================
        // Error
        // ============================

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