<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册个人信息页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">

        function submitData(){
            debugger;
            var nickName=$("#nickName").val();
            var sign=$("#sign").val();
            var password=$("#password").val();

            if(nickName==null || nickName==''){
                alert("请输入昵称！");
            }else if(password==null || password==''){
                alert("请输入密码！");
            }else if(sign==null || sign==''){
                alert("请输入个性签名！");
            }else if(imageFile==null || imageFile==''){
                alert("请设置头像！");
            }else if(pF==null || pF==''){
                alert("请设置签名！");
            }else{
                $('#form1').submit();
            }
        }
        $(function(){
            //得到焦点
            $("#password").focus(function(){
                $("#left_hand").animate({
                    left: "150",
                    top: " -38"
                },{step: function(){
                        if(parseInt($("#left_hand").css("left"))>140){
                            $("#left_hand").attr("class","left_hand");
                        }
                    }}, 2000);
                $("#right_hand").animate({
                    right: "-64",
                    top: "-38px"
                },{step: function(){
                        if(parseInt($("#right_hand").css("right"))> -70){
                            $("#right_hand").attr("class","right_hand");
                        }
                    }}, 2000);
            });
            //失去焦点
            $("#password").blur(function(){
                $("#left_hand").attr("class","initial_left_hand");
                $("#left_hand").attr("style","left:100px;top:-12px;");
                $("#right_hand").attr("class","initial_right_hand");
                $("#right_hand").attr("style","right:-112px;top:-12px");
            });
        });

    </script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="修改个人信息" style="padding: 10px">
    <form id="form1" action="${pageContext.request.contextPath}/registryBlogger.do" method="post" enctype="multipart/form-data">
        <table cellspacing="20px">
            <tr>
                <td width="80px">用户名：</td>
                <td>
                    <input type="text" id="userName" name="userName" style="width: 200px;" value=""/>
                </td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><input type="text" id="nickName" name="nickName"  style="width: 200px;"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><INPUT id="password" name="password" class="ipt"  type="password" placeholder="请输入密码" ></td>
            </tr>
            <tr>
                <td>个性签名：</td>
                <td><input type="text" id="sign" name="sign" style="width: 400px;"/></td>
            </tr>
            <tr>
                <td>个人头像：</td>
                <td><input type="file" id="imageFile" name="imageFile" style="width: 400px;"/></td>
            </tr>
            <tr>
                <td valign="top">个人简介：</td>
                <td>
                    <script id="proFile" type="text/plain" style="width:100%;height:500px;"></script>
                    <input type="text" id="pF" name="proFile"/>
                </td>
            </tr>
             <tr>
                 <td></td>
                  <td>
                   <a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">提交</a>
              </td>
             </tr>
            </table>
        </form>
    </div>
</body>
</html>