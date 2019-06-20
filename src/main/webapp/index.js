let url = "http://35.234.158.222:8888/MotoGPManager/start/"

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
    let searchURL = url + "Riders/GetRiders"

    poll("GET", searchURL)

        .then(res => {

            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;
         
            const tableRow = document.createElement("tr");
           // tableRow.setAttribute()
            const th1 = document.createElement("th").innerText("Rider ID");
            const th2 = document.createElement("th").innerText("Rider First Name");
            const th3 = document.createElement("th").innerText("Rider Last Name");
            const th4 = document.createElement("th").innerText("Rider Race Number");
            const th5 = document.createElement("th").innerText("Rider Team ID");
           
            tableRow.appendChild(th1);
            tableRow.appendChild(th2);
            tableRow.appendChild(th3);
            tableRow.appendChild(th4);
            tableRow.appendChild(th5);

            table1.appendChild(tableRow);


            /*
            <tr class="table-success text-dark">
                        <th>Rider ID</th>
                        <th>Rider First Name</th>
                        <th>Rider Last Name</th>
                        <th>Rider Race Number</th>
                        <th>Rider Team ID</th>
                    </tr>
*/
            for (let i = 0; i < length; i++) {
                
                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");

                td1.innerText = resParse[i].riderID;
                td2.innerText = resParse[i].firstName;
                td3.innerText = resParse[i].lastName;
                td4.innerText = resParse[i].riderNumber;
                td5.innerText = resParse[i].riderTeamID;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);

                table1.appendChild(tableRow);

            }
        })
}

function getAllTeams() {
    let searchURL = url + "Riders/GetTeams"

    poll("GET", searchURL)

        .then(res => {

            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;
         
            for (let i = 0; i < length; i++) {
                
                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");

                td1.innerText = resParse[i].riderID;
                td2.innerText = resParse[i].firstName;
                td3.innerText = resParse[i].lastName;
                td4.innerText = resParse[i].riderNumber;
                td5.innerText = resParse[i].riderTeamID;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);

                table1.appendChild(tableRow);

            }
        })
}