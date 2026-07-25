document.addEventListener("DOMContentLoaded", function() {

    const token = localStorage.getItem("jwtToken");

    if (!token) {
        alert("Please login first.");
        window.location.href = "/html/Auth/index.html";
        return;
    }

    fetch("/admin/dashboard", {

        method: "GET",

        headers: {
            "Authorization": "Bearer " + token
        }

    })

        .then(response => {

            if (!response.ok) {
                throw new Error("Unable to load dashboard");
            }

            return response.json();

        })

        .then(data => {

            document.getElementById("doctorCount").innerText = data.totalDoctors;

            document.getElementById("patientCount").innerText = data.totalPatients;

            document.getElementById("queryCount").innerText = data.totalQueries;

            document.getElementById("pendingCount").innerText = data.pendingQueries;

            document.getElementById("answeredCount").innerText = data.answeredQueries;

            document.getElementById("closedCount").innerText = data.closedQueries;

        })

        .catch(error => {

            console.error(error);

            alert("Failed to load dashboard.");

        });

    document.getElementById("logout").addEventListener("click", function() {

        localStorage.removeItem("jwtToken");

        window.location.href = "/html/Auth/index.html";

    });

});