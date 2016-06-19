/*�̼�DAOʵ���࣬ʵ���˵�¼����ѯID��ע�ᣬ���£�����ȷ���*/
package cn.edu.zjut.dao;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Merchant;

public class MerchantDAO extends BaseHibernateDAO implements IMerchantDAO{
	private Map<String, Object> request, session;
	
    public boolean save(Merchant merchant) {
    	ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Transaction tran = null;
		Session esession = null; 
        try {
            esession = getSession();
            tran = esession.beginTransaction();
            esession.save(merchant);
			tran.commit();
			session.put("merchant", merchant);
		} catch (RuntimeException re) {
			re.printStackTrace();

			if(tran != null) tran.rollback();
			return false;
		} finally {
			getSession().close();
		}
		return true;
    }
	//�����̼�ID�����̼�
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean findByIDNum(Merchant merchant){//��֤���֤���Ƿ�ʹ��
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String merchantIDNum = merchant.getMerchantIDNum();
		String hql = "from Merchant as emp where merchantIDNum='" + merchantIDNum+ "'";
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			List list=queryObject.list();
			if (!list.isEmpty()){
				request.put("tip", "ע��ʧ�ܣ������֤���ѱ�ʹ��");
				return false;
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			request.put("tip", "ע��ʧ�ܣ������������쳣");
			return false;
		}
		getSession().close();
		return true;
	}

    //ʵ�֣��޸�ĳ�̼���Ϣ
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean update(Merchant merchant) {//�̼���Ϣ����
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		Transaction tran = null;
		Session esession = null;
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.update(merchant);
			tran.commit();
			request.put("updateTip", "��Ϣ�޸ĳɹ���");
			session.put("merchant", merchant);
		} catch (RuntimeException re) {
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	//����id�����û�
	public Merchant find(String merchantID) {
        try {
            Session session=getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Merchant where merchantID = '"+ merchantID +"'");
            //query.setParameter(0, merchantID);
            query.setMaxResults(1);
            Merchant merchant = (Merchant)query.uniqueResult();
            ts.commit();
            session.clear();
            return merchant;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public boolean login(Merchant merchant) {//��¼
		ActionContext ctx= ActionContext.getContext();
	
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String merchantID = merchant.getMerchantID();
		String merchantPassword = merchant.getMerchantPassword();
		Boolean merchantState=merchant.getMerchantState();
		System.out.println( merchantID);
		System.out.println( merchantPassword);
		System.out.println(merchantState);
		String hql = "from Merchant as emp where merchantID='" + merchantID
				+ "' and merchantPassword='" + merchantPassword + "'";
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			List list=queryObject.list();
			if (list.isEmpty()){
				request.put("tip", "�û��������������˶ԣ�");
				return false;
			}
/*			else */
			else{
				merchant=(Merchant)list.get(0);
				session.put("merchant", merchant);
				System.out.println( merchant.getMerchantID());
				System.out.println( merchant.getMerchantUsername());
				System.out.println( merchant.getMerchantIMG());
				request.put("tip", "��¼�ɹ���");	
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			return false;
		}
		getSession().close();
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean register(Merchant merchant) {//ע��
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		Transaction tran = null;
		Session esession = null; 
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.save(merchant);
			tran.commit();
			session.put("merchant", merchant);
			request.put("tip", "ע��ɹ�");
		} catch (RuntimeException re) {
			re.printStackTrace();
			if(tran != null) tran.rollback();
			request.put("tip", "ע��ʧ�ܣ����ֻ����ѱ�ʹ��");
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
}
	

	



