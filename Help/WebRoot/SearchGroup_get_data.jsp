<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*"%>
<%@ page import="java.util.*"%>
<html>
<style>
em{font-style:normal;color:#C03;text-decoration:underline;}
</style>
<body>
<%! int jam=0; %>
	<%
	    jam++;
	    int i = 0;
	    String gname = request.getParameter("gname");//获取输入框的值
	    
	    gname = gname.trim();//去两边空格
	    gname = gname.replace(" ", "");//去中间空格
	    gname = gname.replaceAll(" ", "");//去中间空格
	    System.out.println(gname + " ---------");
	    System.out.println(jam);
	    /* for(int index = 0;index < 10;index++){
	        cn.edu.zjut.global.GlobalInfo.team[index] = "";
	    } */
	    if(gname.length() == 0){
	        return;
	    }
	    Set<String> set = new HashSet<String>();
	    for(int index = 0;index < gname.length();index++){//去除重复
	        set.add(gname.substring(index, index+1));
	    }
	    
	    Iterator<String> it=set.iterator();//获取迭代器
	    
	    Random random = new Random();//随机数,为下面的算法做准备
	    String search = "";//查找方案1
	    while(it.hasNext()){
	        search += it.next();
	    }
	    it = set.iterator();
	    
	    String search2 = search;//查找方案二
	    for(int index = 0;index < 5;index++){//乱序算法
	        int m = Math.abs(random.nextInt())%(set.size());
	        int n = Math.abs(random.nextInt())%(set.size());
	        if(m > n){
	           int t = m;
	           m = n;
	           n = t;
	        }
	        
	        String mtemp = search2.substring(m, m+1);
	        String ntemp = search2.substring(n, n+1);
	        //交换字符
	        search2 = search2.replaceFirst(ntemp, mtemp);
	        search2 = search2.replaceFirst(mtemp, ntemp);
	    }
	    
	    String searchIntent = "";//目标查询方案一
	    for(int index = 0;index < search.length();index ++){
	        searchIntent += (search.charAt(index)+"%");
	    }
	    
	    String searchIntent2 = "";//目标查询方案二
	    for(int index = 0;index < search.length();index ++){
	        searchIntent2 += (search2.charAt(index)+"%");
	    }
	    
	    
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("驱动类未找到，注意：驱动包是否导入了" + e.getMessage());
		}
		Connection con = java.sql.DriverManager.getConnection(
				"jdbc:mysql://localhost/helpdb", "root", "root");
		Statement stmt = con.createStatement();
		//ResultSet rst = stmt.executeQuery("select * from igroup where groupName like '"+gname+"%'");//模糊搜索
		
		ResultSet rst = stmt.executeQuery("select * from igroup where groupName like '%"+searchIntent+"%'");//模糊搜索
		
		Set<String> setIntent = new HashSet<String>();//放查询结果
		
		while (rst.next()) {
			//out.println("<li>"+rst.getString("groupName")+"</li>");
			setIntent.add(rst.getString("groupName"));
		}
		
		rst = stmt.executeQuery("select * from igroup where groupName like '%"+searchIntent2+"%'");//模糊搜索
		
		while (rst.next()) {
			//out.println("<li>"+rst.getString("groupName")+"</li>");
			setIntent.add(rst.getString("groupName"));
		}
		
		Iterator<String> itIntent=setIntent.iterator();//获取迭代器
		
		
		//下面开始放入资源到合适的位置
		while(itIntent.hasNext()){
		    String intent = itIntent.next();
		    cn.edu.zjut.global.GlobalInfo.team[i] = intent;
		    System.out.println(cn.edu.zjut.global.GlobalInfo.team[i] + " 全局数据" + " " + i);
		    int length = intent.length();
		    while(it.hasNext()){
		        String sear = it.next();
		        if(intent.indexOf(sear) >= 0){
		            intent = intent.replaceAll(sear, "<em>"+sear+"</em>");
		        }
		    }
		    String output = "<label onclick='aaa("+ i +")'>"+intent+"</label>";
		    //String output = "<label onclick='aaa("+cn.edu.zjut.global.GlobalInfo.team[i]+")'>"+intent+"</label>";
		    System.out.println(output);
		    out.println(output);
		    it = set.iterator();
		    i++;
		}
		/* out.println("<label onclick='aaa("+1+")'>"+"你好"+"</label>");
		cn.edu.zjut.global.GlobalInfo.team[1] = "你好";
		System.out.println(cn.edu.zjut.global.GlobalInfo.team[1]);
		out.println("<label onclick='aaa("+2+")'>"+"加油"+"</label>");
		cn.edu.zjut.global.GlobalInfo.team[2] = "加油";
		System.out.println(cn.edu.zjut.global.GlobalInfo.team[2]); */
		
		/* int i = 0;
		while (rst.next()) {
			//out.println("<li>"+rst.getString("groupName")+"</li>");
			String keyword = rst.getString("groupName");
			String output = "<label onclick='aaa("+i+")'><em>"+rst.getString("groupName")+"</em></label>";
			System.out.println(output);
			//out.println("<label onclick='aaa("+q+")'><em>"+rst.getString("groupName")+"</em></label>");
			out.println(output);
			cn.edu.zjut.global.GlobalInfo.team[i] = rst.getString("groupName");
			i++;
			//System.out.println(rst.getString("groupID"));
		} */
		//关闭连接、释放资源
		rst.close();
		stmt.close();
		con.close();
	%>

</body>
</html>