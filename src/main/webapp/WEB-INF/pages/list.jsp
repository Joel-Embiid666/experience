<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/pages/Head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saber</title>
<style type="text/css">
    *{
	     margin:0;
	     padding:0;	 
	     
	}
	.jia{
	     height:1340px;
	     width:420px; 
	     margin:0 auto;
		 position:relative;
		     		 
	}
	.jia p{
		 border:1px solid #999999;
         border-radius:10px 10px;
         text-align:center;
         font-family:"华文行楷";
		 font-size:24px;
		 font-weight:bold;
		 color:#0000CD;
	}
	.jia .jia_head{
		 height:105px;
		 border-bottom:3px solid #ff0000; 
		 background:url("https://i1.mifile.cn/a4/xmad_15221454912161_bsGRM.jpg");
		 repeat-x;
		 background-size:100% 100%;
		 border-style: outset;
	}	
    .tb{  
         height:990px;
         width:420px;        
         border-collapse:collapse;     
    }
    .n{ 
         height:35px;
    }
    .m{
         height:50px;
    }
    .tb th,.tb td{
         border:1px solid #ccc;
         padding:3px 15px;
    }

</style>
</head>
<body>
    <div class="jia"><p>手机类型</p>
	    <a href="${basePath }/add.do">添加</a>
	    <div class="jia_head"></div>
	    <table class="tb">       
	       <thead>
	          <tr>
	             <th class="n">品牌</th>
	             <th class="n">机型</th>
	             <th class="n">Logo</th>
	             <th class="n">购物车</th>
	          </tr>
	       </thead>
	       <tbody>
	           <c:forEach items="${phones }" var="phone">
	               <tr>
	                   <td class="m">${phone.name }</td>
	                   <td class="m">${phone.description }</td>
	                   <td class="m"><img height="80" width="80" src="${imgServer }/${phone.imgurl }" ></td>
	                   <td class="m"><a href="${basePath }/update.do?id=${phone.id}">修改</a>&nbsp;
	                                 <a href="${basePath }/del.do?id=${phone.id}">删除</a>
	                   </td>
	               
	               </tr>
	           </c:forEach>
	       </tbody>
	    
	    </table>
    </div>
    <script type="text/javascript" src="${basePath }/resource/js/jquery.min.js"></script>
    
    
   
</body>
</html>