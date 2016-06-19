/* 头像 */
package cn.edu.zjut.po;

import java.io.File;

public class Photo {
	private String picurl;  //路径
	private File origin;   //原始照片
	private String idnum;  //路径id
	private int imageWidth;  //原始宽度
	private int imageHeight; //原始高度
	private int cutTop;  //裁剪高度
	private int cutLeft; //裁剪宽度
	private int dropWidth;//裁剪高度
	private int dropHeight;//裁剪宽度
	private float imageZoom;//放大倍数
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
