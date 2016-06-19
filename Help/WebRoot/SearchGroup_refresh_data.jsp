<%@ page contentType="text/html; charset=UTF-8" language="java"%>

	<%
	    String place = request.getParameter("place");//获取输入框的值
	    int i = Integer.valueOf(place);
	    System.out.println(i);
	    System.out.println("11111");
	    System.out.println("11111");
	    System.out.println("11111");
	    System.out.println(cn.edu.zjut.global.GlobalInfo.team[i]);
	    System.out.println("11111");
	    String str = cn.edu.zjut.global.GlobalInfo.team[i];
	    out.print(str);
	%>