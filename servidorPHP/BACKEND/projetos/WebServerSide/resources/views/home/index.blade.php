<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h4>Homepage</h4>
    <ul>
        <a href="{{ route('home.welcome') }}">
            <li>Welcome</li>
        </a>
        <a href="{{ route('home.hello') }}">
            <li>Hello</li>
        </a>
        <a href="{{ route('users.all') }}">
            <li>Users</li>
        </a>
        <a href="{{ route('user.profile', 1) }}">
            <li>Perfil user 1</li>
        </a>
    </ul>
</body>
</html>
