<%--
  Created by IntelliJ IDEA.
  User: zhaojian
  Date: 2018/5/31
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/validForm/style.css" type="text/css"/>
</head>
<body>

    <div>
        <form id="sform" method="post">
            <table>
                <tr>
                    <td>input:</td>
                    <td><input id="demo" type="text" name="" value="" datatype="*1-2" errormsg="test" /></td>
                </tr>
            </table>
        </form>
    </div>

    <script type="text/javascript" src="../js/common/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../js/validForm/Validform_v5.3.2.js"></script>
    <script>
        $(function () {
            $("#sform").Validform();
        })
    </script>
</body>
</html>
