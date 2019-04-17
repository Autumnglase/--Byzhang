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
		}else if("list".equals(action)){//��ѯȫ��
			list(request,response);
		}
	}
	
	//��¼
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminname = request.getParameter("adminname");
		String adminpass = request.getParameter("adminpass");
		System.out.println("--------��¼ϵͳ-------"+adminname+adminpass);//��ӡ�ɹ�
		boolean result = DaoFactory.getNewsdetailDaoInstance().login(adminname, adminpass);
		if(result){
			response.sendRedirect("LoginSuccess.jsp");
		}else{
			response.sendRedirect("homepage.jsp");
		}
	}
	

	//��������ѯ����
	public void showdetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf((request.getParameter("id")));
		Newsdetail newsdetail = DaoFactory.getNewsdetailDaoInstance().findById(id);
		System.out.println(newsdetail);
		request.setAttribute("newsdetail", newsdetail);
		//��Ϊrequest���������ݡ������Ҫͨ������ױ���ķ�ʽ��ת���ض���ᶪʧrequest���е�����
		//pageContext<request<session<application��ԽСԽ��ռ����Դ  
		request.getRequestDispatcher("NewsDetail.jsp").forward(request, response);;
	}
	
	//��������
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------�������-------");
		Newsdetail newsdetail=new Newsdetail();
		//��ȡϵͳʱ��
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
			System.out.println("��ӳɹ�");
			response.sendRedirect("AddSuccess.jsp");
			}
		else{
			System.out.println("���ʧ��");
			response.sendRedirect("AddNews.jsp");
		}

	}
	
	
	//ɾ��
		public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("----------ɾ��---------");
			int id=Integer.valueOf((request.getParameter("id")));
			System.out.println("---�ҵ�id�أ�---"+id);
			int rs= DaoFactory.getNewsdetailDaoInstance().delete(id);
			if(rs>0){
				System.out.println("ɾ���ɹ�");
				response.sendRedirect("DeleteSuccess.jsp");
			}else{
				System.out.println("ɾ��ʧ��");
				response.sendRedirect("AllNewsMan.jsp");
			}
		}
	
	
	//����
		public void updatecontent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("-------------����ҳ���ȡ���ݿ�����----------------");
			int id=Integer.valueOf(request.getParameter("id"));
			NewsdetailDao newsdeaildao=DaoFactory.getNewsdetailDaoInstance();
			Newsdetail newsdetail=newsdeaildao.findById(id);
			HttpSession session=request.getSession();
			session.setAttribute("newsdetail", newsdetail);
			response.sendRedirect("UpdateNews.jsp");
		}
		
	
	
	//����
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------����----------------");
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		System.out.println("-------------����--------id-----"+id+"----title"+title);
		Newsdetail newsdetail=new Newsdetail();	
		//��ȡϵͳʱ��
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
			System.out.println("���³ɹ�");
			response.sendRedirect("UpdateSuccess.jsp");

		}else{
			System.out.println("����ʧ��");
			response.sendRedirect("UpdateNews.jsp");
			
		}
	}
	
	//�û�������Keyword��ѯ
	public void findByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----�û�������Keyword��ѯ-----");
		String keyword=request.getParameter("keyword");
		Newsdetail newsdetail=DaoFactory.getNewsdetailDaoInstance().findByKeyword(keyword);
		System.out.print(newsdetail);
		request.setAttribute("newsdetail", newsdetail);
		request.getRequestDispatcher("QueryByKWSucc.jsp").forward(request, response);;
	}
	
	//����Ա������Keyword��ѯ
		public void findByKeywordMan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("----����Ա������Keyword��ѯ-----");
			String keyword=request.getParameter("keyword");
			Newsdetail newsdetail=DaoFactory.getNewsdetailDaoInstance().findByKeyword(keyword);
			System.out.print(newsdetail);
			request.setAttribute("newsdetail", newsdetail);
			request.getRequestDispatcher("QueryByKWSuccMan.jsp").forward(request, response);;
		}
	
	
	//��ѯȫ��
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Newsdetail> lists = DaoFactory.getNewsdetailDaoInstance().findAll();
		System.out.println(lists);
		request.setAttribute("lists", lists);
		//��Ϊrequest���������ݡ������Ҫͨ������ױ���ķ�ʽ��ת���ض���ᶪʧrequest���е�����
		//pageContext<request<session<application��ԽСԽ��ռ����Դ  
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
