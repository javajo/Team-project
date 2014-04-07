import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class How extends JFrame {
	   private JTextField jt;
	   private JTextField jt1;
	   Frame f;

	   /*
	    * public static void main(String[] args) { Frame f = new Frame("환경 설정");
	    * f.setSize(300,300); f.setVisible(true);
	    * 
	    * }
	    */

	   public How(String string) {
	      setPreferredSize(new Dimension(400, 120));
	      setMinimumSize(new Dimension(450, 200));
	      setAlwaysOnTop(true);
	      setTitle("환경설정");
	      setLocation(80, 80);

	      JPanel p = new JPanel(); //전체 패널
	      GroupLayout groupLayout = new GroupLayout(getContentPane());
	      groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
	            Alignment.LEADING).addComponent(p, GroupLayout.DEFAULT_SIZE,
	            434, Short.MAX_VALUE));
	      groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
	            Alignment.LEADING).addComponent(p, Alignment.TRAILING,
	            GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE));

	      JLabel jl = new JLabel("사용자 이름");   //사용자 이름 라벨

	      jt = new JTextField(); // 사용자 이름 텍스트필드
	      jt.setColumns(20);

	      JButton jb = new JButton("수정"); // 수정버튼
	      jb.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            f = new Frame();
	            f.setSize(300, 200);

	            Dialog info = new Dialog(f, "", true);
	            info.setSize(150, 110);
	            info.setLocation(500, 300);
	            info.setLayout(new FlowLayout());

	            Label msg = new Label("수정 완료", Label.CENTER);
	            JButton ok = new JButton("확인");

	            ok.addActionListener(new ActionListener() {

	               @Override
	               public void actionPerformed(ActionEvent e) {
	                  // TODO Auto-generated method stub
	                  f.setVisible(false);
	                  setVisible(false);
	               }
	            });
	            info.add(msg);
	            info.add(ok);

	            // f.setVisible(true);
	            info.setVisible(true);
	         }

	      });

	      jt1 = new JTextField();    //한줄 글쓰기 텍스트필드
	      jt1.setColumns(20);

	      JLabel jl1 = new JLabel("한 줄 글쓰기");   //한줄글쓰기 라벨

	      JButton jb1 = new JButton("취소");   //취소버튼
	      jb1.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent arg0) {
	            setVisible(false);
	         }
	      });
	      jb1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {

	         }
	      });

	      JLabel jl2 = new JLabel("배경바탕"); //배경바탕 라벨

	      JComboBox jcb = new JComboBox(); // 바탕색상 콤보박스
	      jcb.setModel(new DefaultComboBoxModel(new String[] { "선택하세요",
	            "빨강", "주황", "노랑", "초록", "파랑", "남색", "보라" }));

	      GroupLayout gl_p = new GroupLayout(p);
	      gl_p.setHorizontalGroup(gl_p
	            .createParallelGroup(Alignment.TRAILING)
	            .addGroup(
	                  gl_p.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jl1, GroupLayout.DEFAULT_SIZE,
	                              74, Short.MAX_VALUE)
	                        .addPreferredGap(ComponentPlacement.RELATED)
	                        .addComponent(jt1, GroupLayout.PREFERRED_SIZE,
	                              GroupLayout.DEFAULT_SIZE,
	                              GroupLayout.PREFERRED_SIZE).addGap(117))
	            .addGroup(
	                  gl_p.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jl)
	                        .addPreferredGap(ComponentPlacement.RELATED,
	                              15, Short.MAX_VALUE)
	                        .addComponent(jt, GroupLayout.PREFERRED_SIZE,
	                              GroupLayout.DEFAULT_SIZE,
	                              GroupLayout.PREFERRED_SIZE).addGap(117))
	            .addGroup(
	                  Alignment.LEADING,
	                  gl_p.createSequentialGroup()
	                        .addGap(114)
	                        .addComponent(jb, GroupLayout.PREFERRED_SIZE,
	                              70, GroupLayout.PREFERRED_SIZE)
	                        .addGap(40)
	                        .addComponent(jb1, GroupLayout.PREFERRED_SIZE,
	                              70, GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap(140, Short.MAX_VALUE))
	            .addGroup(
	                  Alignment.LEADING,
	                  gl_p.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jl2, GroupLayout.DEFAULT_SIZE,
	                              74, Short.MAX_VALUE)
	                        .addPreferredGap(ComponentPlacement.RELATED)
	                        .addComponent(jcb,
	                              GroupLayout.PREFERRED_SIZE, 226,
	                              GroupLayout.PREFERRED_SIZE).addGap(117)));
	      gl_p.setVerticalGroup(gl_p
	            .createParallelGroup(Alignment.LEADING)
	            .addGroup(
	                  gl_p.createSequentialGroup()
	                        .addGap(16)
	                        .addGroup(
	                              gl_p.createParallelGroup(
	                                    Alignment.BASELINE)
	                                    .addComponent(
	                                          jt,
	                                          GroupLayout.PREFERRED_SIZE,
	                                          GroupLayout.DEFAULT_SIZE,
	                                          GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jl))
	                        .addPreferredGap(ComponentPlacement.UNRELATED)
	                        .addGroup(
	                              gl_p.createParallelGroup(
	                                    Alignment.BASELINE)
	                                    .addComponent(
	                                          jt1,
	                                          GroupLayout.PREFERRED_SIZE,
	                                          GroupLayout.DEFAULT_SIZE,
	                                          GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jl1))
	                        .addPreferredGap(ComponentPlacement.UNRELATED)
	                        .addGroup(
	                              gl_p.createParallelGroup(
	                                    Alignment.BASELINE)
	                                    .addComponent(jl2)
	                                    .addComponent(
	                                          jcb,
	                                          GroupLayout.PREFERRED_SIZE,
	                                          GroupLayout.DEFAULT_SIZE,
	                                          GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(
	                              gl_p.createParallelGroup(
	                                    Alignment.BASELINE)
	                                    .addComponent(jb1)
	                                    .addComponent(
	                                          jb,
	                                          GroupLayout.DEFAULT_SIZE,
	                                          GroupLayout.DEFAULT_SIZE,
	                                          Short.MAX_VALUE))
	                        .addGap(28)));
	      p.setLayout(gl_p);
	      getContentPane().setLayout(groupLayout);
	      this.pack();
	      this.setVisible(true);
	   }

	}