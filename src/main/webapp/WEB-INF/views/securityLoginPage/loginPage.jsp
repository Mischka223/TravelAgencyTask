<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>

</head>
<body>
<style>
    .container {
        text-align: center;
        align-content: center;
        padding: 6px;
        margin-top: 200px;
    }

</style>

<div class="container">
    <h1> Please sign in</h1>
    <form class="form-signing" method="post" action="/login/page">
        <p>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        </p>
        <p>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>
