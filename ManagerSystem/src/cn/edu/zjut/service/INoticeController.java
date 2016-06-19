package cn.edu.zjut.service;

import cn.edu.zjut.po.Notice;

public interface INoticeController {

	void insert(Notice transientInstance);
	void delete(Notice transientInstance);
	void find();
}
