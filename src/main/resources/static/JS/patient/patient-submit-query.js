document.addEventListener("DOMContentLoaded", function() {

    const token = localStorage.getItem("jwtToken");

    if (!token) {

        alert("Please Login First");

        window.location.href = "/html/Auth/index.html";

        return;
    }

    const form = document.getElementById("queryForm");

    form.addEventListener("submit", function(event) {

        event.preventDefault();

        const subject = document.getElementById("subject").value.trim();

        const description = document.getElementById("description").value.trim();

        if (subject === "" || description === "") {

            alert("Please fill all fields.");

            return;

        }

        fetch("/patient/query", {

            method: "POST",

            headers: {

                "Content-Type": "application/json",
                "Authorization": "Bearer " + token

            },

            body: JSON.stringify({

                subject: subject,
                description: description

            })

        })

            .then(response => {

                if (!response.ok) {

                    throw new Error("Unable to submit query");

                }

                return response.text();

            })

            .then(message => {

                alert(message);

                window.location.href = "/html/Patient/patient-query.html";

            })

            .catch(error => {

                console.log(error);

                alert("Something went wrong.");

            });

    });


    document.getElementById("logoutBtn").addEventListener("click", function() {

        localStorage.removeItem("jwtToken");

        window.location.href = "/html/Auth/index.html";

    });

});
