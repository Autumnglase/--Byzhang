package DbConnection;

import java.util.List;
import Bean.Newsdetail;
import DaoFactory.DaoFactory;


public class test {
	public static void main(String[] args) {
		List<Newsdetail> list = DaoFactory.getNewsdetailDaoInstance().findAll();
		for(Newsdetail newsdetail:list){
			System.out.println(newsdetail);
			System.out.println(newsdetail.getTitle());
		}
	}


}
