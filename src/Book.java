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
	   JComboBox jcb = new JComboBox();   //�޺� �ڽ�
	   ImagePanel imagePanel;

	   /*
	    * public static void main(String[] args) { Frame f = new Frame("ȯ�� ����");
	    * f.setSize(300,300); f.setVisible(true);
	    * 
	    * }
	    */

	   public Book(String string) {
	      setTitle("\uCC45\uB4F1\uB85D");
	      setMinimumSize(new Dimension(450, 400)); // ������ ũ������
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

	      JButton jb = new JButton("����");   //���� ��ư

	      jtf = new JTextField();
	      jtf.setColumns(10);

	      jtf1 = new JTextField();
	      jtf1.setColumns(10);

	      jtf2 = new JTextField();
	      jtf2.setColumns(10);
	      jcb.setModel(new DefaultComboBoxModel(new String[] {
	            "�����ϼ���",
	            "�а� ���� å!",
	            "�а� �ִ� ��~",
	            "�� ���� å!" }));
	      JButton jb2 = new JButton("���");   //��� ��ư
	      jb2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            setVisible(false);
	         }
	      });
	      JButton jb1 = new JButton("�̹��� ã��");   //�̹��� ã�� ��ư
	      jb1.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent arg0) {
	            /*Frame f = new Frame();
	            f.setSize(300, 200);

	            FileDialog fd = new FileDialog(f, "�̹���ã��", FileDialog.LOAD);

	            // f.setVisible(true);
	            fd.setDirectory("");
	            fd.setVisible(true);

	            System.out.println(fd.getDirectory() + fd.getFile());*/
	            JFileChooser fc = new JFileChooser();// ���� ���̾�α׸� ȣ��
	             int cm = fc.showOpenDialog(fc);// ���� ���̾�α׸� ȣ���Ѵ�
	             File file = fc.getSelectedFile();// ������ �� ���Ϸ� ���ش�
	             imagePanel.setPath(file.toString());// ��ο� �н��� ������ �̸����� ���ش�
	             imagePanel.setSize(130, 200);
	             imagePanel.repaint();// �̹����� �θ��� ���� �ٽ� �׷��ش�

	         }
	      });
	      JLabel jl1 = new JLabel("������");   // ������ ��
	      JLabel jl2 = new JLabel("���ڸ�");   // ���ڸ� ��
	      JLabel jl3 = new JLabel("���ǻ�"); // ���ǻ� ��
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

	      Label msg = new Label("���� �Ϸ�", Label.CENTER);
	      JButton ok = new JButton("Ȯ��");

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
	   if(arg0.getItem().toString().equals("�а� ���� å!")){   //�޺��ڽ� ���ÿ� ���� ��� �߰�
	      si="�а� ���� å!";
	   }
	   if(arg0.getItem().toString().equals("�а� �ִ� ��~")){   //�޺��ڽ� ���ÿ� ���� ��� �߰�
	      si="�а� �ִ� ��~";
	   }
	   if(arg0.getItem().toString().equals("�� ���� å!")){   //�޺��ڽ� ���ÿ� ���� ��� �߰�
	      si="�� ���� å!";
	   }
	   dm.insert(jtf.getText(),jtf1.getText(), jtf2.getText(),si);
	}
	}
	class ImagePanel extends JPanel {
	    Image image;     //�̹��� ��ü ����
	    Toolkit toolkit = getToolkit();   //toolkit��ü�� ��ȯ
	    Point p = null;     //x,y��ǥ������ ��ġ�� ��Ÿ����
	    public ImagePanel()   //�̹����̸��� �޾ƿ´�.
	    {
	     p = new Point(0,0);    //x, y��ǥ�� 0,0���� �ʱ�ȭ
	    }
	    void setPath(String path) {
	        image = toolkit.getImage(path);   //�̹��� ��ü ����
	    }
	    public void paint(Graphics g)  {
	        g.clearRect(0, 0, getWidth(), getHeight()); //ȭ�鿡 ������ �� �̹����� �����ش�
	        if (image != null)    //�̹��� ��ü�� null���� �ƴѰ��
	        {
	            g.drawImage(image, this.p.x, this.p.y, getWidth(), getHeight(), this);
	     //�̹��� ��ü�� ����ִ� �̹����� ������ x, y��ǥ���� �������� ũ����� �̹����� �����ش�
	        }
	    }
	}