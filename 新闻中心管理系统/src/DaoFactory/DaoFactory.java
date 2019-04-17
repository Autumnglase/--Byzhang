package DaoFactory;

import NewsdetailDao.NewsdetailDao;
import NewsdetailDaoImpl.NewsdetailDaoImpl;

public class DaoFactory {
	public static NewsdetailDao getNewsdetailDaoInstance(){
		return new NewsdetailDaoImpl();
	}
}
