import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Book extends JFrame implements ActionListener, ItemListener {
   private JTextField jtf;
   private JTextField jtf1;
   private JTextField jtf2;
   Frame f;
   public String si;
   JComboBox jcb = new JComboBox();

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
      groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
            Alignment.LEADING).addGroup(
            Alignment.TRAILING,
            groupLayout
                  .createSequentialGroup()
                  .addComponent(panel, GroupLayout.DEFAULT_SIZE, 605,
                        Short.MAX_VALUE).addContainerGap()));
      groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
            Alignment.TRAILING).addComponent(panel,
            GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE));

      JLabel jl = new JLabel("                \uC0AC\uC9C4");
      jl.setBackground(Color.RED);
      jl.setForeground(Color.RED);

      JButton jb = new JButton("\uC800\uC7A5");

      jtf = new JTextField();
      jtf.setText("\uB3C4\uC11C\uBA85");
      jtf.setColumns(20);

      jtf1 = new JTextField();
      jtf1.setText("\uC800\uC790\uBA85");
      jtf1.setColumns(20);

      jtf2 = new JTextField();
      jtf2.setText("\uCD9C\uD310\uC0AC");
      jtf2.setColumns(20);
      jcb.setModel(new DefaultComboBoxModel(new String[] {
            "\uC120\uD0DD\uD558\uC138\uC694",
            "\uC77D\uACE0 \uC2F6\uC740 \uCC45!",
            "\uC77D\uACE0 \uC788\uB294 \uC911~",
            "\uB2E4 \uC77D\uC740 \uCC45!" }));
      JButton jb2 = new JButton("\uCDE8\uC18C");
      jb2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
         }
      });
      JButton jb1 = new JButton("\uC774\uBBF8\uC9C0 \uCC3E\uAE30");
      jb1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            Frame f = new Frame();
            f.setSize(300, 200);

            FileDialog fd = new FileDialog(f, "이미지찾기", FileDialog.LOAD);

            // f.setVisible(true);
            fd.setDirectory("");
            fd.setVisible(true);

            System.out.println(fd.getDirectory() + fd.getFile());

         }
      });
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(gl_panel
            .createParallelGroup(Alignment.LEADING)
            .addGroup(
                  gl_panel.createSequentialGroup()
                        .addGroup(
                              gl_panel.createParallelGroup(
                                    Alignment.LEADING)
                                    .addGroup(
                                          gl_panel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(
                                                      jl,
                                                      GroupLayout.PREFERRED_SIZE,
                                                      147,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addGroup(
                                                      gl_panel.createParallelGroup(
                                                            Alignment.LEADING)
                                                            .addComponent(
                                                                  jcb,
                                                                  0,
                                                                  GroupLayout.DEFAULT_SIZE,
                                                                  Short.MAX_VALUE)
                                                            .addGroup(
                                                                  gl_panel.createParallelGroup(
                                                                        Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(
                                                                              jtf2)
                                                                        .addComponent(
                                                                              jtf1)
                                                                        .addComponent(
                                                                              jtf))))
                                    .addGroup(
                                          gl_panel.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(
                                                      jb1))
                                    .addGroup(
                                          gl_panel.createSequentialGroup()
                                                .addGap(148)
                                                .addComponent(
                                                      jb)
                                                .addPreferredGap(
                                                      ComponentPlacement.UNRELATED)
                                                .addComponent(
                                                      jb2)))
                        .addContainerGap(19, Short.MAX_VALUE)));
      gl_panel.setVerticalGroup(gl_panel
            .createParallelGroup(Alignment.LEADING)
            .addGroup(
                  gl_panel.createSequentialGroup()
                        .addGroup(
                              gl_panel.createParallelGroup(
                                    Alignment.LEADING)
                                    .addGroup(
                                          gl_panel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(
                                                      jl,
                                                      GroupLayout.PREFERRED_SIZE,
                                                      196,
                                                      GroupLayout.PREFERRED_SIZE))
                                    .addGroup(
                                          gl_panel.createSequentialGroup()
                                                .addGap(32)
                                                .addComponent(
                                                      jtf,
                                                      GroupLayout.PREFERRED_SIZE,
                                                      GroupLayout.DEFAULT_SIZE,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(
                                                      jtf1,
                                                      GroupLayout.PREFERRED_SIZE,
                                                      GroupLayout.DEFAULT_SIZE,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(
                                                      jtf2,
                                                      GroupLayout.PREFERRED_SIZE,
                                                      GroupLayout.DEFAULT_SIZE,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(
                                                      jcb,
                                                      GroupLayout.PREFERRED_SIZE,
                                                      GroupLayout.DEFAULT_SIZE,
                                                      GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jb1)
                        .addPreferredGap(ComponentPlacement.RELATED,
                              53, Short.MAX_VALUE)
                        .addGroup(
                              gl_panel.createParallelGroup(
                                    Alignment.BASELINE)
                                    .addComponent(jb)
                                    .addComponent(jb2)).addGap(51)));
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
	if(arg0.getItem().toString().equals("읽고 싶은 책!")){	//콤보박스 선택에 따른 기능 추가
		si="읽고 싶은 책!";
	}
	if(arg0.getItem().toString().equals("읽고 있는 중~")){	//콤보박스 선택에 따른 기능 추가
		si="읽고 있는 중~";
	}
	if(arg0.getItem().toString().equals("다 읽은 책!")){	//콤보박스 선택에 따른 기능 추가
		si="다 읽은 책!";
	}
	dm.insert(jtf.getText(),jtf1.getText(), jtf2.getText(),si);
}
}