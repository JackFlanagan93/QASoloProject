
function homePage(){
    window.location.href = "index.html"
}

function deleteRider() {
    let riderID = document.getElementById("DeleteRiderID").value;
    let searchURL = url + "Riders/DeleteRider/" + riderID

    poll("DELETE", searchURL)

        .then(res => {
            clearTable()
            const tableRow2 = document.createElement("tr");
            let table = document.getElementById("table");

            let resParse = JSON.parse(res);

            const headerRow2 = document.createElement("tr");
            const th1 = document.createElement("th");
            const th2 = document.createElement("th");
            const th3 = document.createElement("th");
            

            th1.innerHTML = "Team ID";
            th2.innerHTML = "Team Name";
            th3.innerHTML = "Motorcycle Brand";
            

            headerRow2.appendChild(th1);
            headerRow2.appendChild(th2);
            headerRow2.appendChild(th3);
            

            table.appendChild(headerRow2);

            const tableRow = document.createElement("tr");
            const td1 = document.createElement("td");
            const td2 = document.createElement("td");
            const td3 = document.createElement("td");
            
            td1.innerText = resParse.teamID;
            td2.innerText = resParse.teamName;
            td3.innerText = resParse.motorcycleBrand;
           

            tableRow.appendChild(td1);
            tableRow.appendChild(td2);
            tableRow.appendChild(td3);
            

            table.appendChild(tableRow);
        })
}
