/*商家注册controller，实现了商家注册，上传营业执照，卫生许可证，更新等方法*/
package cn.edu.zjut.service;
import java.io.*;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.dao.IMerchantDAO;

public class MerchantRegisterController implements IMerchantRegisterController {
	private IMerchantDAO merchantDAO = null;

	public MerchantRegisterController(){
	}
	public void setMerchantDAO(IMerchantDAO merchantDAO) {
		this.merchantDAO = merchantDAO;
	}
	public boolean register(Merchant merchant) {  
		ActionContext ctx= ActionContext.getContext();
		Map<String, Object> session = (Map) ctx.getSession();
        Map<String, Object> request = (Map) ctx.get("request");
		int age;
		Calendar c = Calendar.getInstance(); 
		String birth=merchant.getMerchantIDNum().substring(6, 14);
		int birthyear=Integer.parseInt(birth.substring(0, 4));
		int nowyear=c.get(Calendar.YEAR);
		int birthmonth=Integer.parseInt(birth.substring(4, 6));
		int nowmonth=c.get(Calendar.MONTH);
		int birthdate=Integer.parseInt(birth.substring(6,8));
		int nowdate=c.get(Calendar.DATE);
		if(birthmonth>nowmonth){age=nowyear-birthyear;}
		else if(birthdate>nowdate){age=nowyear-birthyear;}
		else {age=nowyear-birthyear+1;}
		merchant.setMerchantAge(age);     
		merchant.setMerchantIMG("Merchant/MerchantIMG/"+merchant.getMerchantID()+"/head.jpg"); 
		System.out.println(merchant.getMerchantIMG());
		 if (merchantDAO.find(merchant.getMerchantID()) != null) {
	            request.put("tip", "鐢ㄦ埛宸插瓨鍦�");
	            return false;
	        } else {
	    			 session.put("merchant", merchant);
	            request.put("tip", "娉ㄥ唽鎴愬姛");
	            return merchantDAO.save(merchant);
	        }
		
	}

	public boolean uploadBusinessLicence(Merchant merchant) { 
		File pic =merchant.getMerchantBusinessLicence();
		String path=ServletActionContext.getServletContext().getRealPath("/");
		try {
			
			InputStream in = new FileInputStream(pic);
			String dir = path+"Merchant/MerchantIMG/" + merchant.getMerchantID() +"/";
			File fileLocation = new File(dir);
			if (!fileLocation.exists()) fileLocation.mkdirs();
			String fileName = "MerchantBusinesslicence.jpg";
			File uploadFile = new File(dir, fileName);
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("upload face failed");
			return false;
		}
	}
	public boolean uploadSecurityLicence(Merchant merchant) { 	
		File pic = merchant.getMerchantSecurityLicence();
		String path=ServletActionContext.getServletContext().getRealPath("/");
		try {
			System.out.println(pic);
			InputStream in = new FileInputStream(pic);
			String dir = path+"Merchant/MerchantIMG/"+merchant.getMerchantID()+"/";
			try
			{File fileLocation = new File(dir);
			if (!fileLocation.exists()) fileLocation.mkdirs();
			}catch(Exception e){
				e.printStackTrace();
			}
			String fileName = "MerchantSecurityLicence.jpg";
			File uploadFile = new File(dir, fileName);
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("upload back failed");
			return false;
		}
	}

	public boolean update(Merchant merchant){
		if(merchantDAO.update(merchant))
			return true;
		else return false;
	}
}


