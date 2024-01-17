const express = require('express')
const app = express()
const port = 3000
app.get('/', (req, res) => {
    res.send('Hello World!! (a response by express using port 3000)')
})
app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})
app.get('/about', (req, res) => {
    res.send('about')
})
app.get('/ab?cd', (req, res) => {
    res.send('ab?cd')
})
app.get('/ab+cd', (req, res) => {
    res.send('ab+cd')
})
app.get('/ab*cd', (req, res) => {
    res.send('ab*cd')
})
app.get('/ab(cd)?e', (req, res) => {
    res.send('ab(cd)?e')
})
app.post('/', (req, res) => {
    res.send('Got a POST request')
})
app.put('/user', (req, res) => {
    res.send('Got a PUT request at /user')
})
app.delete('/user', (req, res) => {
    res.send('Got a DELETE request at /user')
})