/*�̼ҳ־û��࣬�������̼ҵĸ�������*/
package cn.edu.zjut.po;
import java.io.File;

public class Merchant  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String merchantID;//�˺�
	private String merchantUsername;//�ǳ�
	private String merchantPassword;//����
	private String confirmPassword;
	private String merchantIDNum;//���֤
	private String merchantName;//����
	private Integer merchantAge;//����
	private File merchantBusinessLicence;//Ӫҵִ��
	private File merchantSecurityLicence;//�������
	private Integer shopID;//���
	private String shopName;//����
	private String shopAddress;//��ַ
	private Float merchantGrade;//�̼ҵȼ�
	private Integer merchantGradeNumber;//�̼�
	private Boolean merchantSex;//�̼��Ա�
	private String merchantIMG;//ͷ��
	private Boolean merchantState;//�̼�״̬
	private String merchantSignature;//�̼�ǩ��
	private int merchantAgreement;//�Ķ�ͬ��

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