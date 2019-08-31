<%@page language="java" import="java.util.*,javax.servlet.ServletContext" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + path + "/";%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        ocr
    </title>
    <link type="text/css" href="<%=basePath%>amazeui/amazeui.min.css"  rel="stylesheet">
    <link type="text/css" href="<%=basePath%>amazeui/amazeui.cropper.css"  rel="stylesheet">
    <link type="text/css" href="<%=basePath%>amazeui/custom_up_img.css"  rel="stylesheet">
    <link type="text/css" href="<%=basePath%>amazeui/font-awesome.4.6.0.css"  rel="stylesheet">


    <script type="text/javascript" src="<%=basePath%>amazeui/jquery-3.1.1.min.js"></script>
    <script type="application/javascript"  src="<%=basePath%>amazeui/amazeui.min.js"></script>
    <script type="application/javascript"  src="<%=basePath%>amazeui/cropper.min.js"></script>
    <script type="application/javascript"  src="<%=basePath%>amazeui/custom_up_img.js"></script>
</head>

<body class="pace-done">
<form>
    <input type="hidden" name="base" class="form-text" id="base" />
</form>
<center>
    <div class="up-img-cover"  id="up-img-touch" >
        <img class="am-circle" alt="点击图片上传" src="<%=basePath%>amazeui/hu.jpg" data-am-popover="{content: '点击上传', trigger: 'hover focus'}" >
    </div>
</center>
<div><a style="text-align: center; display: block;"  id="pic"></a></div>

<div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="doc-modal-1">
    <div class="am-modal-dialog up-frame-parent up-frame-radius">
        <div class="am-modal-hd up-frame-header">
            <label>上传图片</label>
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd  up-frame-body">
            <div class="am-g am-fl">
                <div class="am-form-group am-form-file">
                    <div class="am-fl">
                        <button type="button" class="am-btn am-btn-default am-btn-sm">
                            <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                    </div>
                    <input type="file" name="file" id="inputImage">
                </div>
            </div>
            <div class="am-g am-fl" >
                <div class="up-pre-before up-frame-radius">
                    <img alt="" src="" id="image" >
                </div>
                <div class="up-pre-after up-frame-radius">
                </div>
            </div>
            <div class="am-g am-fl">
                <div class="up-control-btns">
                    <span class="am-icon-rotate-left"  onclick="rotateimgleft()"></span>
                    <span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
                    <span class="am-icon-check" id="up-btn-ok" url="/upload"></span>
                </div>
            </div>

        </div>
    </div>
</div>

<!--加载框-->
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">正在上传...</div>
        <div class="am-modal-bd">
            <span class="am-icon-spinner am-icon-spin"></span>
        </div>
    </div>
</div>

<!--警告框-->
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">信息</div>
        <div class="am-modal-bd"  id="alert_content">
            成功了
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>

</body>

</html>
