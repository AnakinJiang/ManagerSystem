/*商家DAO实现类，实现了登录，查询ID，注册，更新，保存等方法*/
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
	//根据商家ID查找商家
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean findByIDNum(Merchant merchant){//验证身份证号是否被使用
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
				request.put("tip", "注册失败，该身份证号已被使用");
				return false;
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			request.put("tip", "注册失败，服务器发生异常");
			return false;
		}
		getSession().close();
		return true;
	}

    //实现：修改某商家信息
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean update(Merchant merchant) {//商家信息更新
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
			request.put("updateTip", "信息修改成功！");
			session.put("merchant", merchant);
		} catch (RuntimeException re) {
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	//根据id查找用户
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

	public boolean login(Merchant merchant) {//登录
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
				request.put("tip", "用户名或密码错误，请核对！");
				return false;
			}
/*			else */
			else{
				merchant=(Merchant)list.get(0);
				session.put("merchant", merchant);
				System.out.println( merchant.getMerchantID());
				System.out.println( merchant.getMerchantUsername());
				System.out.println( merchant.getMerchantIMG());
				request.put("tip", "登录成功！");	
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			return false;
		}
		getSession().close();
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean register(Merchant merchant) {//注册
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
			request.put("tip", "注册成功");
		} catch (RuntimeException re) {
			re.printStackTrace();
			if(tran != null) tran.rollback();
			request.put("tip", "注册失败，该手机号已被使用");
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
}
	

	



