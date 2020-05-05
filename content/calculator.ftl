<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>

<div class="login-container">
    <h1>Welcome to calculator</h1>
    <form method="post">
        <input type="number" placeholder="Enter value 1" class="textbox" name="value1">
        <select class="selectbox" name="operation">
            <option disabled selected>Select your operation</option>
            <option value="add">+</option>
            <option value="sub">-</option>
            <option value="mul">x</option>
            <option value="div">/</option>
        </select>
        <input type="number" placeholder="Enter value 2" class="textbox" name="value2">
        <input type="submit" value="Calculate" class="buttonbox">
        <input type="reset" value="Clear" class="buttonbox">
        <a href="/logout" class="back">Log out</a>
    </form>

</div>

</body>
</html>