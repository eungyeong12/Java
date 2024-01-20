const http = require('http');
const os = require('os');
var handler = function (request, response) {
    console.log("Received request from " + request.connection.remoreAddress);
    response.writeHead(200);
    response.end("Container Hostname: " + os.hostname() + "\n");
};
var www = http.createServer(handler);
www.listen(8080);