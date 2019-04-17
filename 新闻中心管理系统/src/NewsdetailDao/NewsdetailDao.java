package NewsdetailDao;

import java.util.List;
import Bean.*;

public interface NewsdetailDao {
	
		//登录
		public boolean login(String adminname,String adminpass);
		//增加
		public int add(Newsdetail newsdetail);
		//删除
		public int delete(int id);
		//更新
		public int update(int id,Newsdetail newsdetail);
		//根据id查询
		public Newsdetail findById(int id);
		//根据关键词搜索
		public Newsdetail findByKeyword(String keyword);
		//查询全部
		public List<Newsdetail> findAll();	

}
