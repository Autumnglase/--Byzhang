package Bean;

public class Newsdetail {
	private int id;
	private String title,content,author,time,type;
	
	//�޲ι���
		public Newsdetail(){		
		}
		//�вι����id
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
			return "���кţ�"+this.getId()+"\n���ű��⣺"+this.getTitle()+"\n�������ݣ�"+
		this.getContent()+"\n�������ߣ�"+this.getAuthor()+"\nʱ�䣺"+this.getTime()+"\n�������ͣ�"+this.getType();
			
		}

}
