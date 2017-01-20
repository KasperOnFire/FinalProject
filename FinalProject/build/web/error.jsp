<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="description" content="Final Project">
        <meta name="author" content="Tjalfe Møller, David Carl & Kasper Ravn Breindal">
        <link rel="icon" href="img/favicon.png">
        <title>MusicProject</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="css/error.css">
    </head>

    <body>
        <div class="container main-div">
            <div class="top-div">
                <h1 class="text-center main-header changecolor">YourMusic!</h1>
                <h2 class="text-center changecolor"> for managing anything!</h2>
            </div>
            <div class="fancy">
                <p class="fancylead">Manage your <span class="typer"></span> collection.</p>
            </div>
            <div class="introMessage">
                <h1>ERROR</h1>
            </div>
            <div class="menu">
                <a href='index'>Click here to go to homepage!</a>
            </div>
            <div class="content">
                <p>${errorCode}</p>
            </div>
        </div>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js\typed.js\js\typed.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>