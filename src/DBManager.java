import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DBManager {
   static int _ID = 1;
   Statement stmt;
   Connection con;
   ResultSet result;

   /*
    * 로드 연결
    */
   boolean connect() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:orcl";
         con = DriverManager.getConnection(url, "reader", "1111"); // ip주소,
         stmt = null; // ip
         System.out.println("접속성공"); // pw,
         return true;
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      }

   }
   
   /*
    * db닫는 메소드
    */
   private void close() {
      try {
         if (con != null) {
            con.close();
         }
      }
      catch (Exception e) {
         System.out.println("예외사항:" + e.getMessage());
      }
   }
   
   /*
    * 모든 레코드 조회
    */
	public void userSelectAll(DefaultTableModel t_model) {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery("select * from TB_USERLIST order by id");
			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			while (result.next()) {
				Object data[] = { result.getString(1), result.getString(2),
						result.getInt(3), result.getString(4) };
				t_model.addRow(data); // DefaultTableModel에 레코드 추가
			}
		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {
			close();
		}
	}



   public void creat_table() {
	  connect();
      String title = "title";
      String writer = "writer";
      String publishing = "publishing";
      String image = "image";
      String _TABLENAME1 = "wish";
      String _TABLENAME2 = "finish";
      String _TABLENAME3 = "ing";

      String _CREATE1 = "create table " + _TABLENAME1 + "(" + _ID
            + " integer primary key autoincrement, " + title
            + " text not null , " + writer + " text not null , "
            + publishing + " text not null , " + image + " text);";
      try {
         stmt = con.createStatement();
         result = stmt.executeQuery(_CREATE1);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      _ID++;
      System.out.println("테이블 생성");
      String _CREATE2 = "create table " + _TABLENAME2 + "(" + _ID
            + " integer primary key autoincrement, " + title
            + " text not null , " + writer + " text not null , "
            + publishing + " text not null , " + image + " text);";
      close();
   }
   /*

	public MenuJTabaleExam() {

		super("GUI 회원관리프로그램 - DB연동");

		// 메뉴아이템을 메뉴에 추가
		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(quit);
		// 메뉴를 메뉴바에 추가

		mb.add(m);

		// 윈도우에 메뉴바 세팅
		setJMenuBar(mb);

		// South영역
		p.setBackground(Color.yellow);
		p.add(combo);
		p.add(jtf);
		p.add(serach);
		add(jsp, "Center");
		add(p, "South");

		setSize(500, 400);
		setVisible(true);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트등록
		insert.addActionListener(this);

		update.addActionListener(this);
		delete.addActionListener(this);
		quit.addActionListener(this);
		serach.addActionListener(this);
		// 모든레코드를 검색하여 DefaultTableModle에 올리기
		dao.userSelectAll(dt);
		// 첫번행 선택.
		if (dt.getRowCount() > 0)
			jt.setRowSelectionInterval(0, 0);
	}// 생성자끝
*/
   
   //데이터 삽입

public void insert(String t, String w, String p,String s) {
	   
	   connect();
	   String sql=null;
	   if(s.equals("읽고 싶은 책!"))
		   sql = "Insert into wish (title, writer, publishing) values('" +t +"' , '" +w +"' , '" +p +"')";
	   else if(s.equals("읽고 있는 중~")){
		   sql = "Insert into ing (title, writer, publishing) values('" +t +"' , '" +w +"' , '" +p +"')";
	   }
	   else if(s.equals("다 읽은 책!")){
		   sql = "Insert into done (title, writer, publishing) values('" +t +"' , '" +w +"' , '" +p +"')";
	   }
	
		System.out.println(sql);
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//업데이트를 해줘야한다.
	   
	   close();
}
public void insert(String t, String w, String p) {
	   
	   connect();
	   String sql=null;
		   sql = "Insert into done (title, writer, publishing) values('" +t +"' , '" +w +"' , '" +p +"')";
	
		System.out.println(sql);
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//업데이트를 해줘야한다.
	   
	   close();
}
   
   
   //데이터 삭제
   public void delect(String t) {
	   connect();
	   
	   try{
	   String sql = "delete from wish where title = " + "'" + t + "'";
	   System.out.println(sql);
	   
	   stmt = con.createStatement();
	   stmt.executeUpdate(sql);
	   }
	   catch(SQLException err){
			System.out.println("SQL에러 : " + err);
		}
	   close();
   }

}