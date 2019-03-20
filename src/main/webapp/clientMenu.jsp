<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client</title>
    <style type="text/css">
        .block1 {
            width: 200px;
            background: #ccc;
            padding: 5px;
            padding-right: 20px;
            border: solid 1px #282828;
            float: left;
        }
    </style>
</head>
<body>
<div class="block1">
    <center><h1>Client</h1></center>
    <a href="addNewClient.jsp" >1. Create client</a><br>
    <a href="/clients">2. Clients list</a>
    <form action="/clients" method="get">2. List all clients</form>
</div>
</body>
</html>