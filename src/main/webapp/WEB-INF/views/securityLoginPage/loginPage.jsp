<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
    <link rel='stylesheet' href='/webjars/bootstrap/4.5.2/css/bootstrap.min.css'>
</head>
<body>
<style>
    .form-signing{
        text-align: center;
        align-content: center;
        padding: 6px;
    }
</style>
<div class="container">
    <form class="form-signing" method="post" action="/login/page">
        <p>
            <input  type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        </p>
        <p>
            <input  type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
    </form>
</div>
</body>
</html>
