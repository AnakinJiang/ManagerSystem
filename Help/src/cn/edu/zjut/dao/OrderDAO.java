/*订单DAO实现类，定义类接受订单，查询订单，更新订单等方法*/
package cn.edu.zjut.dao;

import java.text.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.QuerySyntaxException;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.*;

public class OrderDAO extends BaseHibernateDAO implements IOrderDAO{
	private Map<String, Object> request, session;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean accept(Order order,Employee employee,String releaseTime){ //接受招募
		ActionContext ctx= ActionContext.getContext();
		request=(Map) ctx.get("request");
		session=(Map) ctx.get("session");
		Transaction tran=null;
		Session osession=getSession();
		//找到order
		System.out.println("寻找招募数据条目");
		String merchantID=order.getMerchant().getMerchantID();
		System.out.println(merchantID);
		System.out.println(order.getOrderID());
		String hql="from Order as o where o.merchant.merchantID='" + merchantID + "' and o.releaseTime='" + releaseTime +
				"' and o.employee is null";
		try {
			String queryString = hql;
			Query queryObject = osession.createQuery(queryString);
			System.out.println(1);
			List list=queryObject.list();
			System.out.println(2);
			if (list.isEmpty()){
				request.put("tip", "没这回事");
				return false;
			}
			else{
				order=(Order)list.get(0);
				System.out.println("找到了"+order.getOrderID());
				order.setEmployee(employee);
				order.setAcceptTime(new Date());
			}
		}catch (RuntimeException re) {
			//System.out.println(re);
			request.put("tip", "数据库出错");
			return false;
		}
		//更新order
		System.out.println("更新招募数据条目");
		try{
			tran = osession.beginTransaction();
			osession.update(order);
			tran.commit();
			request.put("tip", "接受招募成功");
			session.put("order", order);
			System.out.println(order.getStartTime());
			osession.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			request.put("tip", "手慢了，商家招募人员已满");
			return false;
		}
		return true;
	}

	@SuppressWarnings({ "rawtypes" })
	public List findByHql(String hql) { //查询
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		}catch(QuerySyntaxException qe){
			System.out.println(qe.getMessage());
			return null;
		}catch (RuntimeException re) {
			System.out.println(re);
			return null;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean update(Order order) { //更新
		Transaction tran=null;
		Session osession=getSession();
		try{
			tran = osession.beginTransaction();
			osession.update(order);
			tran.commit();
			session.put("order", order);
			osession.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	@Override
	public boolean merge(Order order) { //更新
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.get("session");
		Transaction tran=null;
		Session osession=getSession();
		try{
			tran = osession.beginTransaction();
			osession.merge(order);
			tran.commit();
			session.put("order", order);
			osession.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Override
    public boolean save(Order order) {	//添加信息
		try{
			Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.save(order);
            ts.commit();
            session.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	@Override
    public List findALL() {
        try {
            Session session = getSession();
            Query query = session.createQuery("from Order");
            List list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List findUnfinished(Merchant merchant) {
        try {
            Session session = getSession();
            String merchantID=merchant.getMerchantID();
            String hql="from Order as o where o.merchant.merchantID='"+merchantID+"'"+" and o.ifFinish='0'";
            Query query = session.createQuery(hql);
            List list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List findFinished(Merchant merchant) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            String merchantID=merchant.getMerchantID();
            String hql="from Order as o where o.merchant.merchantID='"+merchantID+"'"+" and o.ifFinish='1'";
            Query query = session.createQuery(hql);
            ts.commit();
            List list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public long findtwoOrder() {
		try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Order as o where o.acceptTime is not null ");
            List list = query.list();
            Random random = new Random();
            int rand=random.nextInt(100);
            if(list.size()<=2)
            {
            	System.out.println("rand:"+rand);
            	return 60*20+rand;
            }
            Order order1=(Order)list.get(list.size()-1);
            Order order2=(Order)list.get(list.size()-2);
            double time1=order1.getAcceptTime().getTime()-order1.getReleaseTime().getTime();
            double time2=order2.getAcceptTime().getTime()-order2.getReleaseTime().getTime();

            long timefinal=(long) (0.3*time1+0.7*time2)/1000+rand;
            System.out.println("time:"+timefinal);
            return timefinal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null;
		return 0;
	}

	@Override
	public List findPayed(Merchant merchant) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            String merchantID=merchant.getMerchantID();
            String hql="from Order as o where o.merchant.merchantID='"+merchantID+"'"+" and o.ifPay='1' and o.ifFinish='1'  and o.employee is not null";
            Query query = session.createQuery(hql);
            List list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List findUnpayed(Merchant merchant) {
		 try {
	            Session session = getSession();
	            Transaction ts = session.beginTransaction();
	            String merchantID=merchant.getMerchantID();
	            String hql="from Order as o where o.merchant.merchantID='"+merchantID+"'"+" and o.ifPay='0' and o.employee is not null";
	            Query query = session.createQuery(hql);
	            List list = query.list();
	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}
}
