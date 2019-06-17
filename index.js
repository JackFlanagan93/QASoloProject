let url = "http://localhost:8080/MotoGPManager/start/"

const poll = (url, method, body) => {

    return new Promise(
        function (res, rej) {
            const req = new XMLHttpRequest();
            req.onload = () => {
                if (req.status === 200) {
                    res(req.response);
                } else {
                    const reason = new Error('Rejected');
                    rej(reason);
                }
            }
            req.open(url, method)
            req.send(body);
        }
    );
}

function getAllRiders() {

    poll("GET", "http://localhost:8080/MotoGPManager/start/Riders/GetRiders")

        .then(res => {

            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let x = JSON.parse(res);

            let i = 0;
            for (i = 0; i < 50; i++) {
                console.log(i);
                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");

                td1.innerText = x[i].riderID;
                td2.innerText = x[i].firstName;
                td3.innerText = x[i].lastName;
                td4.innerText = x[i].riderNumber;
                td5.innerText = x[i].riderTeamID;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);

                table1.appendChild(tableRow);

            }
        })
}