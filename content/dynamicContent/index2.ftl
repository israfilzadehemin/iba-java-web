<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h1 style="width: 500px; margin: 0 auto; font-family: Arial; font-size: 35px; font-weight: bold;">Hello, ${name}!</h1>
<table border="1" style="border-collapse: collapse; width: 500px; margin: 0 auto; font-family: Arial; font-size: 15px">
    <thead>
    <th>
        <td>Name in upper</td>
        <td>Age</td>
        <td>Group</td>
    </th>
    </thead>
    <tbody>
    <#list students as student>
        <tr>
            <td>${student.name}</td>
            <td>${student.upperName()}</td>
            <td>${student.age}</td>
            <td>${student.group}</td>
        </tr>
    </#list>

    </tbody>
</table>
<h1 style="width: 500px; margin: 0 auto; font-family: Arial; font-size: 15px;">Total count of students: ${count}</h1>

</body>
</html>