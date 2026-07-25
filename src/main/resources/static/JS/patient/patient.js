document.addEventListener("DOMContentLoaded", loadPatientProfile);

function loadPatientProfile() {
	
    const token = localStorage.getItem("jwtToken");

    if (!token) {

        alert("Please Login First");

        window.location.href = "/html/Auth/index.html";

        return;
    }

    fetch("/patient/profile", {

        method: "GET",

        headers: {

            "Authorization": "Bearer " + token,

            "Content-Type": "application/json"

        }

    })

        .then(response => {

            if (!response.ok) {

                throw new Error("Unauthorized");

            }

            return response.json();

        })

        .then(data => {

            document.getElementById("welcomeText").innerText =
                "Welcome " + data.name;

            document.getElementById("name").innerText =
                data.name;

            document.getElementById("email").innerText =
                data.email;

            document.getElementById("phone").innerText =
                data.phone;

            document.getElementById("gender").innerText =
                data.gender;

            document.getElementById("bloodGroup").innerText =
                data.bloodGroup;

            document.getElementById("address").innerText =
                data.address;

            document.getElementById("dob").innerText =
                data.dob;

            document.getElementById("status").innerText =
                data.active ? "Active" : "Inactive";

            document.getElementById("createdAt").innerText =
                data.createdAt;

        })

        .catch(error => {

            console.log(error);

            alert("Session Expired. Please Login Again.");

            localStorage.removeItem("token");

            window.location.href = "/html/Auth/index.html";

        });

}


/* Logout */

document.getElementById("logoutBtn").addEventListener("click", function() {

    localStorage.removeItem("token");

    window.location.href = "/html/Auth/index.html";

});