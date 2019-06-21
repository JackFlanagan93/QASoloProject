let url = "http://35.246.189.98:8888/MotoGPManager/start/"

const poll = (url, method, body) => {

    return new Promise(
        function (res, rej) {
            const req = new XMLHttpRequest();
            req.onload = () => {
                if (req.status === 200) {
                    res(req.response);
                } else {
                    const reason = new Error('Rejected');
                    window.alert("Failure, please try again")
                    rej(reason);
                }
            }
            req.open(url, method)
            req.send(body);
        }
    );
}

function homePage() {
    window.location.href = "index.html"
}

function deleteRider() {
    let riderID = document.getElementById("deleteRiderBox").value;
    let searchURL = url + "Riders/DeleteRider/" + riderID

    poll("DELETE", searchURL)

        .then(res => {
            window.alert(res)

        })
}

function deleteTeam() {
    let teamID = document.getElementById("deleteTeamBox").value;
    let searchURL = url + "Teams/DeleteTeam/" + teamID

    poll("DELETE", searchURL)

        .then(res => {
            window.alert(res)

        })
}

function deleteRaceLogEntry() {
    let raceLogEntryID = document.getElementById("deleteRaceLogEntryBox").value;
    let searchURL = url + "RaceLog/DeleteRaceLogEntry/" + raceLogEntryID

    poll("DELETE", searchURL)

        .then(res => {
            window.alert(res)

        })
}

function clearTable() {
    if (table.rows.length > 1) {

        let tableSize = table.rows.length;
        for (i = tableSize; i > 0; i--) {
            table.deleteRow(i - 1);
        }
    }
}
