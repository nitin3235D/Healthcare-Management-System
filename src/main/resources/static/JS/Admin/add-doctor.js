const doctorForm = document.getElementById("doctorForm");

doctorForm.addEventListener("submit", async function(event) {

    event.preventDefault();

    const doctor = {

        name: document.getElementById("doctorName").value.trim(),

        email: document.getElementById("email").value.trim(),

        password: document.getElementById("password").value.trim(),

        phone: document.getElementById("phone").value.trim(),

        gender: document.getElementById("gender").value,

        specialization: document.getElementById("specialization").value.trim(),

        qualification: document.getElementById("qualification").value.trim(),

        experience: parseInt(document.getElementById("experience").value),

        address: document.getElementById("address").value.trim()

    };

    try {

        const token = localStorage.getItem("jwtToken");

        const response = await fetch("http://localhost:8080/admin/add-doctor", {

            method: "POST",

            headers: {

                "Content-Type": "application/json",

                "Authorization": "Bearer " + token

            },

            body: JSON.stringify(doctor)

        });

        if (response.ok) {

            alert("Doctor Registered Successfully.");

            doctorForm.reset();

        } else {

            const errorMessage = await response.text();

            alert(errorMessage);

        }

    } catch (error) {

        console.error(error);

        alert("Server Error");

    }

});