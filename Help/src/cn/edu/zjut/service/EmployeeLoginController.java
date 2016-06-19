/*EmployeeRegisterController.java
 *ʵ���ܹ��ߵĵ�¼����*/
package cn.edu.zjut.service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.teetaa.util.FaceAlignment;
import com.teetaa.util.Facerecognition;

import cn.edu.zjut.dao.IEmployeeDAO;
import cn.edu.zjut.po.Employee;

public class EmployeeLoginController implements IEmployeeLoginController{
	private IEmployeeDAO employeeDAO;
	private Map<String, Object> session;
	
	public EmployeeLoginController(){//���췽��
	}
	
	public IEmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public boolean login(Employee employee) {//�ܹ��ߵ�¼���ɹ�����true��ʧ�ܷ���false
		System.out.println("execute --login()-- method.");
		if(employeeDAO.login(employee)){//�������ݿ��Ƿ��и��ܹ��ߵ���Ϣ
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean face(File face) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
        String srcImgPath = face.getAbsolutePath();
        String path="H:\\tomcat8 86\\apache-tomcat-8.0.33\\EmployeeHeadIMG\\tmp.jpg";
		FaceAlignment ni = new FaceAlignment();
		System.out.println("run dll");
		int ans=0;
		try{
			System.out.println(1);
			ans = ni.cutface(srcImgPath, path);
			System.out.println("ans:"+ans);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("ͼƬ�������");
		
		int i=0;
		File file =new File("H:\\tomcat8 86\\apache-tomcat-8.0.33\\EmployeeHeadIMG\\libface_lfw.txt");
		String hql="from Employee as employee";
		List<Employee> lists=employeeDAO.findByHQL(hql);
		try{
			
		
		
		  if(!file.exists()){
		       file.createNewFile();
		      }
		  FileWriter fileWritter = new FileWriter(file);

		  
		  for(i=0;i<lists.size();i++)
		  {
			  System.out.println("�û�ID:"+lists.get(i).getEmployeeID());
			  String pname = lists.get(i).getEmployeeID();
			  String data=pname+".jpg "+i+"\r\n";
			  fileWritter.write(data);
			  System.out.println("����أ�"+lists.get(i).getPool());
			 
		  }
		  String data="tmp.jpg"+" "+i;
		  fileWritter.write(data);
		  fileWritter.flush();
		  fileWritter.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("�ɹ�д�����ݣ�");
		Facerecognition face1=new Facerecognition();
		ans=face1.recFace(i, "test", "H:\\config\\netv8_2_deploy_lfw_0107.prototxt", "H:\\config\\recog0107_iter_2840000.caffemodel", i+1);
		Employee employee=new Employee();
		employee=lists.get(ans);
		session.put("employee",employee);
		return true;
		
		
	}

}
