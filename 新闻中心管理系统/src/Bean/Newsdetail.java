package Bean;

public class Newsdetail {
	private int id;
	private String title,content,author,time,type;
	
	//无参构造
		public Newsdetail(){		
		}
		//有参构造带id
				public Newsdetail(int id,String title,String content, String author,String time,String type){
					this.id=id;
					this.title=title;
					this.content=content;
					this.author=author;
					this.time=time;
					this.type=type;
				}
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		public String toString(){
			return "序列号："+this.getId()+"\n新闻标题："+this.getTitle()+"\n新闻内容："+
		this.getContent()+"\n新闻作者："+this.getAuthor()+"\n时间："+this.getTime()+"\n新闻类型："+this.getType();
			
		}

}
