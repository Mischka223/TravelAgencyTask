<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
</head>
<body>
<div class="container">
    <form class="form-signing" method="post" action="/login/page">
        <p>
            <label for="username">Username</label>
            <input  type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        </p>
        <p>
            <label for="password">Password</label>
            <input  type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
    </form>
</div>
</body>
</html>