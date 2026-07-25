document.addEventListener("DOMContentLoaded", function() {

    const token = localStorage.getItem("jwtToken");

    if (!token) {

        alert("Please login first.");

        window.location.href = "../Auth/index.html";

        return;
    }

    fetch("http://localhost:8080/admin/doctors", {

        method: "GET",

        headers: {

            "Authorization": "Bearer " + token

        }

    })

        .then(response => {

            if (!response.ok) {

                throw new Error("Unable to load doctors.");

            }

            return response.json();

        })

        .then(doctors => {

            const tableBody = document.getElementById("doctorTableBody");

            tableBody.innerHTML = "";

            doctors.forEach(doctor => {

                tableBody.innerHTML += `

                <tr>

                    <td>${doctor.id}</td>
                    <td>${doctor.name}</td>

                    <td>${doctor.email}</td>

                    <td>${doctor.phone}</td>

                    <td>${doctor.gender}</td>

                    <td>${doctor.specialization}</td>

                    <td>${doctor.qualification}</td>

                    <td>${doctor.experience} Years</td>

                </tr>

            `;

            });

        })

        .catch(error => {

            console.error(error);

            alert("Failed to load doctors.");

        });

});