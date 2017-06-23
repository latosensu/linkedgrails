<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="layout" content="sb2-admin"/>
    <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}"/>
    <title>
        <g:message code="default.create.label" args="[entityName]"/>
    </title>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            <g:message code="default.create.label" args="[entityName]"/>
        </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Detalhes
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">


                        <a class="btn btn-primary" href="\${createLink(uri: '/')}">
                            <g:message code="default.home.label"/>
                        </a>
                        <g:link class="btn btn-primary" action="index">
                            <g:message code="default.list.label" args="[entityName]"/>
                        </g:link>
                    </div>
                    <div id="create-${propertyName}" class="content scaffold-create" role="main">
                        <h1>
                            <g:message code="default.create.label" args="[entityName]"/>
                        </h1>
                        <g:if test="\${flash.message}">
                            <div class="message" role="status">\${flash.message}</div>
                        </g:if>
                        <g:hasErrors bean="\${this.${propertyName}}">
                            <ul class="errors" role="alert">
                                <g:eachError bean="\${this.${propertyName}}" var="error">
                                    <li
                                    <g:if test="\${error in org.springframework.validation.FieldError}">
                                        data-field-id="\${error.field}"
                                    </g:if>
                                    >
                                    <g:message error="\${error}"/>
                                    </li>
                                </g:eachError>
                            </ul>
                        </g:hasErrors>
                        <g:form resource="\${this.${propertyName}}" method="POST">
                            <fieldset class="form">
                                <f:all bean="${propertyName}"/>
                            </fieldset>
                            <fieldset class="buttons">
                                <g:submitButton name="create" class="save"
                                                value="\${message(code: 'default.button.create.label', default: 'Create')}"/>
                            </fieldset>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>