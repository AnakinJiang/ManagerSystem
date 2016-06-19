/*商家持久化类，定义了商家的各类属性*/
package cn.edu.zjut.po;
import java.io.File;

public class Merchant  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String merchantID;//账号
	private String merchantUsername;//昵称
	private String merchantPassword;//密码
	private String confirmPassword;
	private String merchantIDNum;//身份证
	private String merchantName;//姓名
	private Integer merchantAge;//年龄
	private File merchantBusinessLicence;//营业执照
	private File merchantSecurityLicence;//卫生许可
	private Integer shopID;//店号
	private String shopName;//店名
	private String shopAddress;//地址
	private Float merchantGrade;//商家等级
	private Integer merchantGradeNumber;//商家
	private Boolean merchantSex;//商家性别
	private String merchantIMG;//头像
	private Boolean merchantState;//商家状态
	private String merchantSignature;//商家签名
	private int merchantAgreement;//阅读同意

	// Constructors
    public int getAgreement() {
		return merchantAgreement;
	}

	public void setAgreement(int merchantAgreement) {
		this.merchantAgreement = merchantAgreement;
	}

	/** default constructor */
    public Merchant() {
    }

	/** minimal constructor */
    public Merchant(String merchantID) {
        this.merchantID = merchantID;
    }
    
    /** full constructor */
    public Merchant(String merchantID, String merchantUsername, String merchantPassword, String merchantIDNum, String merchantName, Integer merchantAge, File merchantBusinessLicence, File merchantSecurityLince,  String shopName, String shopAddress, Float merchantGrade,  Boolean merchantSex, String merchantIMG, Boolean merchantState,String merchantSignature,Integer merchantAgreement) {
        this.merchantID = merchantID;
        this.merchantUsername = merchantUsername;
        this.merchantPassword = merchantPassword;
        this.merchantIDNum = merchantIDNum;
        this.merchantName = merchantName;
        this.merchantAge = merchantAge;
        this.merchantBusinessLicence = merchantBusinessLicence;
        this.merchantSecurityLicence = merchantSecurityLince;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.merchantGrade = merchantGrade;
        this.merchantSex = merchantSex;
        this.merchantIMG = merchantIMG;
        this.merchantState = merchantState;
        this.merchantSignature=merchantSignature;
        this.merchantAgreement=merchantAgreement;
    }
  
    // Property accessors
    public String getMerchantID() {
        return this.merchantID;
    }
    
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getMerchantUsername() {
        return this.merchantUsername;
    }
    
    public void setMerchantUsername(String merchantUsername) {
        this.merchantUsername = merchantUsername;
    }

    public String getMerchantPassword() {
        return this.merchantPassword;
    }
    
    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getMerchantIDNum() {
        return this.merchantIDNum;
    }
    
    public void setMerchantIDNum(String merchantIDNum) {
        this.merchantIDNum = merchantIDNum;
    }

    public String getMerchantName() {
        return this.merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Integer getMerchantAge() {
        return this.merchantAge;
    }
    
    public void setMerchantAge(Integer merchantAge) {
        this.merchantAge = merchantAge;
    }


    public File getMerchantBusinessLicence() {
        return this.merchantBusinessLicence;
    }
    
    public void setMerchantBusinessLicence(File merchantBusinessLicence) {
        this.merchantBusinessLicence = merchantBusinessLicence;
    }

    public File getMerchantSecurityLicence() {
        return this.merchantSecurityLicence;
    }
    
    public void setMerchantSecurityLicence(File merchantSecurityLicence) {
        this.merchantSecurityLicence = merchantSecurityLicence;
    }

    public Integer getShopID() {
        return this.shopID;
    }
    
    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return this.shopName;
    }
    
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return this.shopAddress;
    }
    
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Float getMerchantGrade() {
        return this.merchantGrade;
    }
    
    public void setMerchantGrade(Float merchantGrade) {
        this.merchantGrade = merchantGrade;
    }

    public Integer getMerchantGradeNumber() {
        return this.merchantGradeNumber;
    }
    
    public void setMerchantGradeNumber(Integer merchantGradeNumber) {
        this.merchantGradeNumber = merchantGradeNumber;
    }



    public Boolean getMerchantSex() {
        return this.merchantSex;
    }
    
    public void setMerchantSex(Boolean merchantSex) {
        this.merchantSex = merchantSex;
    }

    public String getMerchantIMG() {
        return this.merchantIMG;
    }
    
    public void setMerchantIMG(String merchantIMG) {
        this.merchantIMG = merchantIMG;
    }

    public Boolean getMerchantState() {
        return this.merchantState;
    }
    
    public void setMerchantState(Boolean merchantState) {
        this.merchantState = merchantState;
    }
    public String getMerchantSignature() {
		return merchantSignature;
	}

	public void setMerchantSignature(String merchantSignature) {
		this.merchantSignature = merchantSignature;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getMerchantAgreement() {
		return merchantAgreement;
	}

	public void setMerchantAgreement(int merchantAgreement) {
		this.merchantAgreement = merchantAgreement;
	}
}