<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <asset:stylesheet src="sb2-admin"/>
    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">


                    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" role="form" autocomplete="off">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="${usernameParameter ?: 'username'}" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="${passwordParameter ?: 'password'}" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="${rememberMeParameter ?: 'remember-me'}" type="checkbox" value="Remember Me" <g:if test='${hasCookie}'>checked="checked"</g:if>>Remember Me
                                </label>
                            </div>
                            <input class="btn btn-success btn-large  btn-block" type="submit" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
                            <g:link controller="cadastro" class="btn btn-primary btn-large btn-block">Novo Cadastro</g:link>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>
