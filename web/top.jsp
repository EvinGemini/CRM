<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2019/3/20
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
    <TITLE>顶部</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <STYLE type=text/css>
        BODY {
            PADDING-RIGHT: 0px;
            PADDING-LEFT: 0px;
            PADDING-BOTTOM: 0px;
            MARGIN: 0px;
            PADDING-TOP: 0px;
            BACKGROUND-COLOR: #2a8dc8
        }

        BODY {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }

        TD {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }

        DIV {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }

        P {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }
    </STYLE>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1 action="" method=post>
    <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
            <TD width=10><IMG src="images/new_001.jpg" border=0></TD>
            <TD background=images/new_002.jpg><FONT size=5><B>客户关系管理系统v1.0</B></FONT></TD>
            <TD background=images/new_002.jpg>
                <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                        <TD align=right height=35></TD>
                    </TR>
                    <TR>
                        <TD height=35 align="right">
                            当前用户：<s:property value="#session.loginUser.user_name"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <A href="#" target=_top><FONT color=red>修改密码</FONT></A>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <A href="#" target=_top><FONT color=red>安全退出</FONT></A>
                        </TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
            <TD width=10><IMG src="images/new_003.jpg" border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>