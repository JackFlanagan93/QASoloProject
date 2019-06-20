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
         
            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");

            th1.innerHTML = "Rider ID";
            th2.innerHTML = "First Name";
            th3.innerHTML = "Last Name";
            th4.innerHTML = "Rider Number";
            th5.innerHTML = "Rider Team ID";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);
            headerRow.appendChild(th4);
            headerRow.appendChild(th5);

            table.appendChild(headerRow);


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

                table.appendChild(tableRow);

            }
        })
}

function getTeams() {
    let searchURL = url + "Teams/GetTeams"

    poll("GET", searchURL)

        .then(res => {

            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;
         
            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");

            th1.innerHTML = "Team ID";
            th2.innerHTML = "Team name";
            th3.innerHTML = "Last Name";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);

            table.appendChild(headerRow);

            for (let i = 0; i < length; i++) {
                
                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");

                td1.innerText = resParse[i].teamID;
                td2.innerText = resParse[i].teamName;
                td3.innerText = resParse[i].motorcycleBrand;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);

                table.appendChild(tableRow);

            }
        })
}

function getRaceLog() {
    let searchURL = url + "RaceLog/GetRaceLog"

    poll("GET", searchURL)

        .then(res => {

            const tableRow = document.createElement("tr");
            let table1 = document.getElementById("table");

            let resParse = JSON.parse(res);
            let length = resParse.length;
         
            const headerRow = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            const th4 = document.createElement("th");
            const th5 = document.createElement("th");
            const th6 = document.createElement("th");
            const th7 = document.createElement("th");

            th1.innerHTML = "Entry ID";
            th2.innerHTML = "Race Number";
            th3.innerHTML = "Race Location";
            th4.innerHTML = "Rider ID";
            th5.innerHTML = "Team ID";
            th6.innerHTML = "Race Position";
            th7.innerHTML = "Race Points";

            headerRow.appendChild(th1);
            headerRow.appendChild(th2);
            headerRow.appendChild(th3);

            table.appendChild(headerRow);

            for (let i = 0; i < length; i++) {
                
                const tableRow = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");
                const td6 = document.createElement("td");
                const td7 = document.createElement("td");

                td1.innerText = resParse[i].entryID;
                td2.innerText = resParse[i].raceNumber;
                td3.innerText = resParse[i].raceLocation;
                td4.innerText = resParse[i].riderID;
                td5.innerText = resParse[i].teamID;
                td6.innerText = resParse[i].racePosition;
                td7.innerText = resParse[i].racePoints;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);
                tableRow.appendChild(td5);
                tableRow.appendChild(td6);
                tableRow.appendChild(td7);

                table.appendChild(tableRow);

            }
        })
}

function getChampionship() {
    let searchURL = url + "Championship/GetChampionship"

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

                td1.innerText = resParse[i].championshipPosition;
                td2.innerText = resParse[i].riderTotalPoints;
                td3.innerText = resParse[i].riderID;
                td4.innerText = resParse[i].teamID;

                tableRow.appendChild(td1);
                tableRow.appendChild(td2);
                tableRow.appendChild(td3);
                tableRow.appendChild(td4);

                table.appendChild(tableRow);

            }
        })
}