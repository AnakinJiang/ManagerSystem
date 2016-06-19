package cn.edu.zjut.service;

import java.util.List;

public interface IChatGroupController {

	String create(String senderID, String receiverID);

	List findAll(String senderID);

}
