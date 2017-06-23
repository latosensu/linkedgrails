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

    <!--&lt;!&ndash; Bootstrap Core CSS &ndash;&gt;-->
    <!--<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->

    <!--&lt;!&ndash; MetisMenu CSS &ndash;&gt;-->
    <!--<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">-->

    <!--&lt;!&ndash; Custom CSS &ndash;&gt;-->
    <!--<link href="../dist/css/sb-admin-2.css" rel="stylesheet">-->

    <!--&lt;!&ndash; Morris Charts CSS &ndash;&gt;-->
    <!--<link href="../vendor/morrisjs/morris.css" rel="stylesheet">-->

    <!--&lt;!&ndash; Custom Fonts &ndash;&gt;-->
    <!--<link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">-->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <g:render template="/sb2-admin/layout/cabecalho"/>
        <g:render template="/sb2-admin/layout/botoes-acao"/>
        <g:render template="/sb2-admin/layout/menu-lateral"/>
    </nav>

</div>
<!-- /#wrapper -->
<div id="page-wrapper">
    <g:layoutBody/>
</div>
<!-- /#page-wrapper -->

<asset:javascript src="sb2-admin.js"/>
<!-- jQuery -->
<!--<script src="../vendor/jquery/jquery.min.js"></script>-->

<!--&lt;!&ndash; Bootstrap Core JavaScript &ndash;&gt;-->
<!--<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>-->

<!--&lt;!&ndash; Metis Menu Plugin JavaScript &ndash;&gt;-->
<!--<script src="../vendor/metisMenu/metisMenu.min.js"></script>-->

<!--&lt;!&ndash; Morris Charts JavaScript &ndash;&gt;-->
<!--<script src="../vendor/raphael/raphael.min.js"></script>-->
<!--<script src="../vendor/morrisjs/morris.min.js"></script>-->
<!--<script src="../data/morris-data.js"></script>-->

<!-- Custom Theme JavaScript -->
<!--<script src="../dist/js/sb-admin-2.js"></script>-->

</body>

</html>
