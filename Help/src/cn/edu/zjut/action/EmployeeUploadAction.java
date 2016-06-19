/*受雇者上传头像Action*/
package cn.edu.zjut.action;

import java.awt.Rectangle;
import java.io.*;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.teetaa.util.ImageHepler;

import cn.edu.zjut.po.Photo;

public class EmployeeUploadAction {
	private Photo photo;
	
	public Photo getPhoto(){
		return photo;
	}
	public void setPhoto(Photo photo){
		this.photo=photo;
	}
	
	
	public String upload(){     //上传
		if(upload(photo)){
			return "success";
		} 
		return "failed";
	}
	
	public String zoom() throws IOException{    //裁剪
		if(zoom(photo)){
			return "success";
		}
		
		return "success";
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean upload(Photo photo){     //上传
		Map session=ActionContext.getContext().getSession();
		String path=ServletActionContext.getServletContext().getRealPath("/");
		try {
			InputStream in = new FileInputStream(photo.getOrigin());
			String dir = path+"Employee/EmployeeIMG/" + photo.getIdnum() +"/";
			String dirt ="Employee/EmployeeIMG/" + photo.getIdnum() +"/";
			File fileLocation = new File(dir);
			if (!fileLocation.exists()) fileLocation.mkdirs();
			String fileName = "temp.jpg";
			File uploadFile = new File(dir, fileName);
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
			session.put("step", "2");
			session.put("Picurl", dirt+fileName);
			session.put("photo", photo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
			return false;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean zoom(Photo photo) throws IOException{    //裁剪
		Map session=ActionContext.getContext().getSession();
		String path=ServletActionContext.getServletContext().getRealPath("/");
		try{
		String dir=path+"Employee/EmployeeIMG/" + photo.getIdnum() +"/";
		String dirt="Employee/EmployeeIMG/" + photo.getIdnum() +"/";
		File photofile = new File(dir+"head.jpg");
		Rectangle rec = new Rectangle(photo.getCutLeft(),photo.getCutTop(),photo.getDropWidth(),photo.getDropHeight());
		ImageHepler.cut(new File(dir+"temp.jpg"), photofile, photo.getImageWidth(), photo.getImageHeight(), rec);
		session.put("step","3");
		session.put("Picurl", dirt+"head.jpg");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
