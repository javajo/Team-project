import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Book extends JFrame implements ActionListener, ItemListener {
	   private JTextField jtf;
	   private JTextField jtf1;
	   private JTextField jtf2;
	   Frame f;
	   public String si;
	   JComboBox jcb = new JComboBox();   //콤보 박스
	   ImagePanel imagePanel;

	   /*
	    * public static void main(String[] args) { Frame f = new Frame("환경 설정");
	    * f.setSize(300,300); f.setVisible(true);
	    * 
	    * }
	    */

	   public Book(String string) {
	      setTitle("\uCC45\uB4F1\uB85D");
	      setMinimumSize(new Dimension(450, 400)); // 프레임 크기조절
	      setPreferredSize(new Dimension(400, 120));

	      JPanel panel = new JPanel();
	      GroupLayout groupLayout = new GroupLayout(getContentPane());
	      groupLayout.setHorizontalGroup(
	         groupLayout.createParallelGroup(Alignment.TRAILING)
	            .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
	      );
	      groupLayout.setVerticalGroup(
	         groupLayout.createParallelGroup(Alignment.TRAILING)
	            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	      );

	      imagePanel = new ImagePanel();
	      //jl.setBackground(Color.RED);
	      //jl.setForeground(Color.RED);

	      JButton jb = new JButton("저장");   //저장 버튼

	      jtf = new JTextField();
	      jtf.setColumns(10);

	      jtf1 = new JTextField();
	      jtf1.setColumns(10);

	      jtf2 = new JTextField();
	      jtf2.setColumns(10);
	      jcb.setModel(new DefaultComboBoxModel(new String[] {
	            "선택하세요",
	            "읽고 싶은 책!",
	            "읽고 있는 중~",
	            "다 읽은 책!" }));
	      JButton jb2 = new JButton("취소");   //취소 버튼
	      jb2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            setVisible(false);
	         }
	      });
	      JButton jb1 = new JButton("이미지 찾기");   //이미지 찾기 버튼
	      jb1.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent arg0) {
	            /*Frame f = new Frame();
	            f.setSize(300, 200);

	            FileDialog fd = new FileDialog(f, "이미지찾기", FileDialog.LOAD);

	            // f.setVisible(true);
	            fd.setDirectory("");
	            fd.setVisible(true);

	            System.out.println(fd.getDirectory() + fd.getFile());*/
	            JFileChooser fc = new JFileChooser();// 파일 다이얼로그를 호출
	             int cm = fc.showOpenDialog(fc);// 파일 다이얼로그를 호출한다
	             File file = fc.getSelectedFile();// 선택을 한 파일로 해준다
	             imagePanel.setPath(file.toString());// 페널에 패스를 파일의 이름으로 해준다
	             imagePanel.setSize(130, 200);
	             imagePanel.repaint();// 이미지를 부르고 나서 다시 그려준다

	         }
	      });
	      JLabel jl1 = new JLabel("도서명");   // 도서명 라벨
	      JLabel jl2 = new JLabel("저자명");   // 저자명 라벨
	      JLabel jl3 = new JLabel("출판사"); // 출판사 라벨
	      GroupLayout gl_panel = new GroupLayout(panel);
	      gl_panel.setHorizontalGroup(
	         gl_panel.createParallelGroup(Alignment.LEADING)
	            .addGroup(gl_panel.createSequentialGroup()
	               .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	                  .addGroup(gl_panel.createSequentialGroup()
	                     .addContainerGap()
	                     .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
	                     .addGap(18)
	                     .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	                        .addGroup(gl_panel.createSequentialGroup()
	                           .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	                              .addComponent(jl3)
	                              .addComponent(jl2)
	                              .addComponent(jl1))
	                           .addPreferredGap(ComponentPlacement.RELATED)
	                           .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	                              .addComponent(jtf2, 142, 142, 142)
	                              .addComponent(jtf1, 142, 142, 142)
	                              .addComponent(jtf, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
	                        .addComponent(jcb, 0, 183, Short.MAX_VALUE)))
	                  .addGroup(gl_panel.createSequentialGroup()
	                     .addGap(148)
	                     .addComponent(jb)
	                     .addPreferredGap(ComponentPlacement.UNRELATED)
	                     .addComponent(jb2)))
	               .addGap(74))
	            .addGroup(gl_panel.createSequentialGroup()
	               .addGap(34)
	               .addComponent(jb1)
	               .addContainerGap(303, Short.MAX_VALUE))
	      );
	      gl_panel.setVerticalGroup(
	         gl_panel.createParallelGroup(Alignment.LEADING)
	            .addGroup(gl_panel.createSequentialGroup()
	               .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	                  .addGroup(gl_panel.createSequentialGroup()
	                     .addContainerGap()
	                     .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
	                  .addGroup(gl_panel.createSequentialGroup()
	                     .addGap(32)
	                     .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	                        .addComponent(jtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jl1))
	                     .addGap(18)
	                     .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	                        .addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jl2))
	                     .addGap(18)
	                     .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	                        .addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jl3))
	                     .addGap(18)
	                     .addComponent(jcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	               .addPreferredGap(ComponentPlacement.RELATED)
	               .addComponent(jb1)
	               .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
	               .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	                  .addComponent(jb)
	                  .addComponent(jb2))
	               .addGap(51))
	      );
	      panel.setLayout(gl_panel);
	      getContentPane().setLayout(groupLayout);
	      jb.addItemListener(this);
	      jb.addActionListener(this);

	      JTextField tf3;
	      this.pack();
	      this.setVisible(true);
	      JLabel jlb = new JLabel("");
	      
	   }

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      
	      DBManager dm = new DBManager();
	      dm.insert(jtf.getText(),jtf1.getText(), jtf2.getText());
	      f = new Frame();
	      f.setSize(300, 200);

	      Dialog dl = new Dialog(f, "", true);
	      dl.setSize(150, 110);
	      dl.setLocation(500, 300);
	      dl.setLayout(new FlowLayout());

	      Label msg = new Label("수정 완료", Label.CENTER);
	      JButton ok = new JButton("확인");

	      ok.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            // TODO Auto-generated method stub
	            f.setVisible(false);
	            setVisible(false);
	         }
	      });
	      dl.add(msg);
	      dl.add(ok);

	      // f.setVisible(true);
	      dl.setVisible(true);

	   }

	@Override
	public void itemStateChanged(ItemEvent arg0) {
	   DBManager dm = new DBManager();
	   if(arg0.getItem().toString().equals("읽고 싶은 책!")){   //콤보박스 선택에 따른 기능 추가
	      si="읽고 싶은 책!";
	   }
	   if(arg0.getItem().toString().equals("읽고 있는 중~")){   //콤보박스 선택에 따른 기능 추가
	      si="읽고 있는 중~";
	   }
	   if(arg0.getItem().toString().equals("다 읽은 책!")){   //콤보박스 선택에 따른 기능 추가
	      si="다 읽은 책!";
	   }
	   dm.insert(jtf.getText(),jtf1.getText(), jtf2.getText(),si);
	}
	}
	class ImagePanel extends JPanel {
	    Image image;     //이미지 객체 선언
	    Toolkit toolkit = getToolkit();   //toolkit객체를 반환
	    Point p = null;     //x,y좌표에서의 위치를 나타낸다
	    public ImagePanel()   //이미지이름을 받아온다.
	    {
	     p = new Point(0,0);    //x, y좌표를 0,0으로 초기화
	    }
	    void setPath(String path) {
	        image = toolkit.getImage(path);   //이미지 객체 생성
	    }
	    public void paint(Graphics g)  {
	        g.clearRect(0, 0, getWidth(), getHeight()); //화면에 있을지 모를 이미지를 지워준다
	        if (image != null)    //이미지 객체가 null값이 아닌경우
	        {
	            g.drawImage(image, this.p.x, this.p.y, getWidth(), getHeight(), this);
	     //이미지 객체에 들어있는 이미지를 현재의 x, y좌표부터 윈도우의 크기까지 이미지를 보여준다
	        }
	    }
	}