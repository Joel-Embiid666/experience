<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	if(request.getServerPort()==80){
		url=request.getScheme()+"://"+request.getServerName()+request.getContextPath();
	}
	pageContext.setAttribute("basePath", url);
	pageContext.setAttribute("imgServer", "http://192.168.118.132/static/resource/img");
%>