package NewsdetailDao;

import java.util.List;
import Bean.*;

public interface NewsdetailDao {
	
		//��¼
		public boolean login(String adminname,String adminpass);
		//����
		public int add(Newsdetail newsdetail);
		//ɾ��
		public int delete(int id);
		//����
		public int update(int id,Newsdetail newsdetail);
		//����id��ѯ
		public Newsdetail findById(int id);
		//���ݹؼ�������
		public Newsdetail findByKeyword(String keyword);
		//��ѯȫ��
		public List<Newsdetail> findAll();	

}
