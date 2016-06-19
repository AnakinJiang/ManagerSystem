package cn.edu.zjut.po;

public class Notice implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String number;   private int yearr;         
	private int monthh;    private int datee;
	private String content;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getYearr() {
		return yearr;
	}

	public void setYearr(int yearr) {
		this.yearr = yearr;
	}

	public int getMonthh() {
		return monthh;
	}

	public void setMonthh(int monthh) {
		this.monthh = monthh;
	}

	public int getDatee() {
		return datee;
	}

	public void setDatee(int datee) {
		this.datee = datee;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		content = content.trim();
		this.content = content;
	}

	public Notice() {
	}

	public Notice(String number) {
		this.number=number;
	}

	public Notice(String number,int yearr,         
	              int monthh,int datee,String content) {
		this.number = number;
		this.yearr = yearr;
		this.monthh = monthh;
		this.datee = datee;
		this.content = content;
	}
}