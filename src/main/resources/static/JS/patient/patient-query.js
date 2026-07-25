document.addEventListener("DOMContentLoaded", loadMyQueries);

// Load Patient Queries
function loadMyQueries() {

    const token = localStorage.getItem("jwtToken");

    if (!token) {

        alert("Please Login First");

        window.location.href = "/html/Auth/index.html";

        return;
    }

    fetch("/patient/query", {

        method: "GET",

        headers: {

            "Authorization": "Bearer " + token,
            "Content-Type": "application/json"

        }

    })

        .then(response => {

            if (!response.ok) {

                throw new Error("Unable to load queries");

            }

            return response.json();

        })

        .then(data => {

            const tableBody = document.getElementById("queryTableBody");

            tableBody.innerHTML = "";

            data.forEach(query => {

                let statusClass = "";

                if (query.status === "PENDING") {

                    statusClass = "status-pending";

                } else if (query.status === "ANSWERED") {

                    statusClass = "status-answered";

                } else if (query.status === "CLOSED") {

                    statusClass = "status-closed";

                }

                tableBody.innerHTML += `

                    <tr>

                        <td>${query.subject}</td>

                        <td>${query.description}</td>

                        <td class="${statusClass}">
                            ${query.status}
                        </td>

                        <td>${query.doctorReply == null ? "-" : query.doctorReply}</td>

                        <td>${query.createdAt}</td>

                    </tr>

                `;

            });

        })

        .catch(error => {

            console.log(error);

            alert("Session Expired. Please Login Again.");

            localStorage.removeItem("jwtToken");

            window.location.href = "/html/Auth/index.html";

        });

}

// Logout
document.getElementById("logoutBtn").addEventListener("click", function() {

    localStorage.removeItem("jwtToken");

    window.location.href = "/html/Auth/index.html";

});