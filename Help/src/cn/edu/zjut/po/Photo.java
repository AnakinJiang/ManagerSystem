/* ͷ�� */
package cn.edu.zjut.po;

import java.io.File;

public class Photo {
	private String picurl;  //·��
	private File origin;   //ԭʼ��Ƭ
	private String idnum;  //·��id
	private int imageWidth;  //ԭʼ���
	private int imageHeight; //ԭʼ�߶�
	private int cutTop;  //�ü��߶�
	private int cutLeft; //�ü����
	private int dropWidth;//�ü��߶�
	private int dropHeight;//�ü����
	private float imageZoom;//�Ŵ���
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public int getCutTop() {
		return cutTop;
	}
	public void setCutTop(int cutTop) {
		this.cutTop = cutTop;
	}
	public int getCutLeft() {
		return cutLeft;
	}
	public void setCutLeft(int cutLeft) {
		this.cutLeft = cutLeft;
	}
	public int getDropWidth() {
		return dropWidth;
	}
	public void setDropWidth(int dropWidth) {
		this.dropWidth = dropWidth;
	}
	public int getDropHeight() {
		return dropHeight;
	}
	public void setDropHeight(int dropHeight) {
		this.dropHeight = dropHeight;
	}
	public float getImageZoom() {
		return imageZoom;
	}
	public void setImageZoom(float imageZoom) {
		this.imageZoom = imageZoom;
	}
	public File getOrigin() {
		return origin;
	}
	public void setOrigin(File origin) {
		this.origin = origin;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
}
