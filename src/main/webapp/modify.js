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

