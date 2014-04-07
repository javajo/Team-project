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
    * �ε� ����
    */
   boolean connect() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:orcl";
         con = DriverManager.getConnection(url, "reader", "1111"); // ip�ּ�,
         stmt = null; // ip
         System.out.println("���Ӽ���"); // pw,
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
    * db�ݴ� �޼ҵ�
    */
   private void close() {
      try {
         if (con != null) {
            con.close();
         }
      }
      catch (Exception e) {
         System.out.println("���ܻ���:" + e.getMessage());
      }
   }
   
   /*
    * ��� ���ڵ� ��ȸ
    */
	public void userSelectAll(DefaultTableModel t_model) {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery("select * from TB_USERLIST order by id");
			// DefaultTableModel�� �ִ� ���� ������ �����
			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			while (result.next()) {
				Object data[] = { result.getString(1), result.getString(2),
						result.getInt(3), result.getString(4) };
				t_model.addRow(data); // DefaultTableModel�� ���ڵ� �߰�
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
      System.out.println("���̺� ����");
      String _CREATE2 = "create table " + _TABLENAME2 + "(" + _ID
            + " integer primary key autoincrement, " + title
            + " text not null , " + writer + " text not null , "
            + publishing + " text not null , " + image + " text);";
      close();
   }
   /*

	public MenuJTabaleExam() {

		super("GUI ȸ���������α׷� - DB����");

		// �޴��������� �޴��� �߰�
		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(quit);
		// �޴��� �޴��ٿ� �߰�

		mb.add(m);

		// �����쿡 �޴��� ����
		setJMenuBar(mb);

		// South����
		p.setBackground(Color.yellow);
		p.add(combo);
		p.add(jtf);
		p.add(serach);
		add(jsp, "Center");
		add(p, "South");

		setSize(500, 400);
		setVisible(true);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �̺�Ʈ���
		insert.addActionListener(this);

		update.addActionListener(this);
		delete.addActionListener(this);
		quit.addActionListener(this);
		serach.addActionListener(this);
		// ��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
		dao.userSelectAll(dt);
		// ù���� ����.
		if (dt.getRowCount() > 0)
			jt.setRowSelectionInterval(0, 0);
	}// �����ڳ�
*/
   
   //������ ����

public void insert(String t, String w, String p,String s) {
	   
	   connect();
	   String sql=null;
	   if(s.equals("�а� ���� å!"))
		   sql = "Insert into wish (title, writer, publishing) values('" +t +"' , '" +w +"' , '" +p +"')";
	   else if(s.equals("�а� �ִ� ��~")){
		   sql = "Insert into ing (title, writer, publishing) values('" +t +"' , '" +w +"' , '" +p +"')";
	   }
	   else if(s.equals("�� ���� å!")){
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
		}//������Ʈ�� ������Ѵ�.
	   
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
		}//������Ʈ�� ������Ѵ�.
	   
	   close();
}
   
   
   //������ ����
   public void delect(String t) {
	   connect();
	   
	   try{
	   String sql = "delete from wish where title = " + "'" + t + "'";
	   System.out.println(sql);
	   
	   stmt = con.createStatement();
	   stmt.executeUpdate(sql);
	   }
	   catch(SQLException err){
			System.out.println("SQL���� : " + err);
		}
	   close();
   }

}