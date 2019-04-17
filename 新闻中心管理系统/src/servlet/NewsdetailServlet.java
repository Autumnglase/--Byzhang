package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.Newsdetail;
import DaoFactory.DaoFactory;
import NewsdetailDao.NewsdetailDao;

public class NewsdetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public NewsdetailServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); 
	}

	public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("method");
		if("add".equals(action)){
			add(request,response);
		}else if("showdetail".equals(action)){
			showdetail(request,response);
		}else if("login".equals(action)){
			login(request,response);
		}else if("delete".equals(action)){
			delete(request,response);
		}else if("update".equals(action)){
			update(request,response);
		}else if("updatecontent".equals(action)){
			updatecontent(request,response);	
		}else if("findByKeyword".equals(action)){
			findByKeyword(request,response);
		}else if("findByKeywordMan".equals(action)){
			System.out.println("---------findByKeywordMan--------");
			findByKeywordMan(request,response);
		}else if("list".equals(action)){//查询全部
			list(request,response);
		}
	}
	
	//登录
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminname = request.getParameter("adminname");
		String adminpass = request.getParameter("adminpass");
		System.out.println("--------登录系统-------"+adminname+adminpass);//打印成功
		boolean result = DaoFactory.getNewsdetailDaoInstance().login(adminname, adminpass);
		if(result){
			response.sendRedirect("LoginSuccess.jsp");
		}else{
			response.sendRedirect("homepage.jsp");
		}
	}
	

	//点击标题查询新闻
	public void showdetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf((request.getParameter("id")));
		Newsdetail newsdetail = DaoFactory.getNewsdetailDaoInstance().findById(id);
		System.out.println(newsdetail);
		request.setAttribute("newsdetail", newsdetail);
		//因为request域中有数据。因此需要通过请求妆发的方式跳转，重定向会丢失request域中的数据
		//pageContext<request<session<application，越小越不占用资源  
		request.getRequestDispatcher("NewsDetail.jsp").forward(request, response);;
	}
	
	//增加新闻
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------添加新闻-------");
		Newsdetail newsdetail=new Newsdetail();
		//获取系统时间
		Date currDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(currDate);
		newsdetail.setTitle(request.getParameter("title"));
		newsdetail.setContent(request.getParameter("content"));
		newsdetail.setAuthor(request.getParameter("author"));
		newsdetail.setTime(time);
		newsdetail.setType(request.getParameter("type"));

		NewsdetailDao newsdetailDao=DaoFactory.getNewsdetailDaoInstance();
		int rs= newsdetailDao.add(newsdetail);
		if(rs>0){			
			System.out.println("添加成功");
			response.sendRedirect("AddSuccess.jsp");
			}
		else{
			System.out.println("添加失败");
			response.sendRedirect("AddNews.jsp");
		}

	}
	
	
	//删除
		public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("----------删除---------");
			int id=Integer.valueOf((request.getParameter("id")));
			System.out.println("---我的id呢？---"+id);
			int rs= DaoFactory.getNewsdetailDaoInstance().delete(id);
			if(rs>0){
				System.out.println("删除成功");
				response.sendRedirect("DeleteSuccess.jsp");
			}else{
				System.out.println("删除失败");
				response.sendRedirect("AllNewsMan.jsp");
			}
		}
	
	
	//更新
		public void updatecontent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("-------------更新页面获取数据库内容----------------");
			int id=Integer.valueOf(request.getParameter("id"));
			NewsdetailDao newsdeaildao=DaoFactory.getNewsdetailDaoInstance();
			Newsdetail newsdetail=newsdeaildao.findById(id);
			HttpSession session=request.getSession();
			session.setAttribute("newsdetail", newsdetail);
			response.sendRedirect("UpdateNews.jsp");
		}
		
	
	
	//更新
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------更新----------------");
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		System.out.println("-------------更新--------id-----"+id+"----title"+title);
		Newsdetail newsdetail=new Newsdetail();	
		//获取系统时间
				Date currDate = Calendar.getInstance().getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(currDate);
				newsdetail.setTitle(request.getParameter("title"));
				newsdetail.setContent(request.getParameter("content"));
				newsdetail.setAuthor(request.getParameter("author"));
				newsdetail.setTime(time);
				newsdetail.setType(request.getParameter("type"));
				
		NewsdetailDao newsdetailDao=DaoFactory.getNewsdetailDaoInstance();		
		int rs=newsdetailDao.update(id,newsdetail);
		System.out.println("-----------------");
		if(rs>0){
			System.out.println("更新成功");
			response.sendRedirect("UpdateSuccess.jsp");

		}else{
			System.out.println("更新失败");
			response.sendRedirect("UpdateNews.jsp");
			
		}
	}
	
	//用户：根据Keyword查询
	public void findByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----用户：根据Keyword查询-----");
		String keyword=request.getParameter("keyword");
		Newsdetail newsdetail=DaoFactory.getNewsdetailDaoInstance().findByKeyword(keyword);
		System.out.print(newsdetail);
		request.setAttribute("newsdetail", newsdetail);
		request.getRequestDispatcher("QueryByKWSucc.jsp").forward(request, response);;
	}
	
	//管理员：根据Keyword查询
		public void findByKeywordMan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("----管理员：根据Keyword查询-----");
			String keyword=request.getParameter("keyword");
			Newsdetail newsdetail=DaoFactory.getNewsdetailDaoInstance().findByKeyword(keyword);
			System.out.print(newsdetail);
			request.setAttribute("newsdetail", newsdetail);
			request.getRequestDispatcher("QueryByKWSuccMan.jsp").forward(request, response);;
		}
	
	
	//查询全部
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Newsdetail> lists = DaoFactory.getNewsdetailDaoInstance().findAll();
		System.out.println(lists);
		request.setAttribute("lists", lists);
		//因为request域中有数据。因此需要通过请求妆发的方式跳转，重定向会丢失request域中的数据
		//pageContext<request<session<application，越小越不占用资源  
		request.getRequestDispatcher("AllNews.jsp").forward(request, response);;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		action(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		action(request,response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
