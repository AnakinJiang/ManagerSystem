package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.TeamMessage;

public class ChatDAO  extends BaseHibernateDAO implements IChatDAO{

	@Override
	public boolean sendMessage(TeamMessage teamMessage) {
		Transaction tran = null;
		Session session = null; 
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.save(teamMessage);
			tran.commit();
		} catch (RuntimeException re) {
			if(tran != null) tran.rollback();
			System.out.println("ÃÌº”–≈œ¢ ß∞‹");
			return false;
		} finally {
			getSession().close();
		}
		System.out.println("messageSender is "+teamMessage.getMessageSender());
		System.out.println("messageContent is "+teamMessage.getMessageContent());
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List receiveMessage(String groupID) {
		Session session = null; 
		try{
			String hql="from TeamMessage as t where t.chatTeamID='"+groupID+"'";
			session=getSession();
			//System.out.println("receiving...");
			Query query=session.createQuery(hql);
			List list=query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
    
}
