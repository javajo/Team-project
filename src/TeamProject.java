import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TeamProject extends JFrame implements ActionListener {
	JPanel back = new JPanel(); // ��ü �гε��� �ö� ���� �ؿ� �� �г�
	JPanel upside = new JPanel(); // ���� �г�(�����̰� ���� �κ� �ö� �г�)
	JPanel downside = new JPanel(); // �Ʒ��� ���� ������ ū�г�(��, ���ֺκ� ���� ������ �κ�)
	JPanel leftside = new JPanel(); // �Ʒ��� ���� �г�(���� �ö� �κ�)
	JPanel rightside = new JPanel(); // �Ʒ��� ������ �г�(���ֲ� �ö� �κ�)
	
	JPanel pan = new JPanel();
	JLabel userName = new JLabel("����� �̸� : ", JLabel.RIGHT);
	JLabel oneLine = new JLabel("�� �� �۾��� : ", JLabel.RIGHT);
	JLabel userName_f = new JLabel();		//������ �̸���
	JLabel oneLine_f = new JLabel("��¾�� ������ ����� ������ϸ�");		//������
	
	// ���� �г� ���
	BorderLayout bl3 = new BorderLayout();
	JButton register_bt = new JButton("å���"); // å���
	JButton setting_bt = new JButton(""); // ȯ�漳�� �̹���
	// ���� �г� ��� ��

	// �Ʒ� ������ �г� ��
	JPanel rightside_Center, rightside_West, rightside_South; // �Ʒ��������гο� ���Ե�
																// �гε�
	Image ima = null;

	FileDialog fopen;
	JButton image_seach = new JButton("�̹��� ����");
	JTextField title = new JTextField("�������� �Է����ּ���", 20);

	JTextField author = new JTextField("���ڸ��� �Է����ּ���", 20);
	JTextField publisher = new JTextField("���ǻ���� �Է����ּ���", 20);
	JTextField page = new JTextField("���������� �Է����ּ���", 15);
	String[] sorts = { "�а� ���� å!", "�а� �ִ� ��~", "�� ���� å!" };
	JComboBox sortbx = new JComboBox(sorts);
	
	JTextArea memo = new JTextArea("�޸�");
	JButton cancel = new JButton("����");
	JButton register = new JButton("����");
	JTable jt1 = new JTable();
	
	ImageIcon icon,icon1;
	GridLayout gl1 = new GridLayout(1, 2); // �Ʒ��� �� �г� ������ ���� ���̾ƿ�
	FlowLayout fl = new FlowLayout(); // �Ʒ��� ���� �ϴܺ��� �޺��ڽ�, �˻� �ؽ�Ʈ���� ��ư� �гη��̾ƿ�

	BorderLayout bl0 = new BorderLayout(); // ���� �ؿ� �� �г��� �������̾ƿ�,
	BorderLayout bl1 = new BorderLayout(); // ���� �ϴܺ� ��ü ���̾ƿ�
	BorderLayout bl2 = new BorderLayout(); // �Ʒ��� ���� �г��� ���� ���̾ƿ����� ����

	JPanel jp1 = new JPanel(); // ��ü �г� ���� �ö� �з�, �˻��κ� ���� �г�
	JPanel jp2 = new JPanel(); // �׳� �ϴܺ�
	JPanel center = new JPanel(); // �߾� �г�(å ����, �������� �ö� �г�)
	
	JButton all = new JButton("��ü");
	JButton wish = new JButton("WISH");
	JButton ing = new JButton("�д���");
	JButton ed = new JButton("�� ����");
	
	//String[] sort = { "��ü����", "�а� ���� å!", "�а� �ִ� ��~", "�� ���� å!" }; // �޺��ڽ��� ��
	//JComboBox cb = new JComboBox(sort); // �޺��ڽ�

	JTextField jtf = new JTextField(10); // �˻��� �Է��� �ʵ�
	
	
	    JPanel cardPan = new JPanel();
		JPanel cardPan1 = new JPanel();
		JPanel cardPan2 = new JPanel();
		JPanel cardPan3 = new JPanel();
		
		CardLayout card = new CardLayout();
		
		
		
// �Ʒ��� �г� ��� ��
//�޼��� ����////////////////////////////////////////////////////////////////////////
	TeamProject() {
		super("�ϸŴ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������ ����
		back.setLayout(bl0);
		back.setBackground(Color.gray);

		upside.setBackground(Color.black);
		downside.setBackground(Color.white);
		downside.setLayout(gl1);
		leftside.setBackground(Color.LIGHT_GRAY);
		rightside.setLayout(bl1);

		leftside.setLayout(bl2); // ���� �ϴ� ��ü �г��� ���̾ƿ�=border���̾ƿ�
		leftside.setBackground(Color.white); // �޹���� ȭ��Ʈ
		jp1.setBackground(Color.black); // �г� ����� ��
		jp2.setBackground(Color.black); // �г� �ϴ��� ��
		center.setBackground(Color.orange);
		
		jp1.setLayout(fl); // �޺��ڽ� �ִ� �г�
		
		jp1.add(all);// �޺��ڽ� ����
		jp1.add(wish);
		jp1.add(ing);
		jp1.add(ed);
		jp1.add(jtf);// �˻��ʵ� ����
		JButton jb1;
		icon = new ImageIcon(getClass().getResource("/images/search.jpg"));
		jb1 = new JButton(icon);
		jp1.add(jb1);// �˻���ư ����

	
		
		leftside.add("North", jp1);
		leftside.add("Center", center);
		leftside.add("South", jp2);

        
		center.setLayout(card);
		
	    cardPan.setLayout(new GridLayout(4,4));
	    cardPan1.setLayout(new GridLayout(4,4));
	    cardPan2.setLayout(new GridLayout(4,4));
	    cardPan3.setLayout(new GridLayout(4,4));
	    
		cardPan.setBackground(Color.red);
		cardPan1.setBackground(Color.gray);
		cardPan2.setBackground(Color.blue);
		cardPan3.setBackground(Color.green);
		
		JPanel allpan[];
		JButton allmini[];
		JTextField alltext[];
		allpan = new JPanel[20];
		allmini = new JButton[20];
		alltext = new JTextField[20];
		ImageIcon[] bookimage = new ImageIcon[20];
		
		for(int i=0; i<allmini.length; i++){
			
			allpan[i] = new JPanel();
			allpan[i].setLayout(new BorderLayout());
		    bookimage[i] = new ImageIcon(getClass().getResource( "/all/["+i+"].jpg"));
		    allmini[i] = new JButton(bookimage[i]);
		    alltext[i] = new JTextField(10);
		    cardPan.add(allpan[i]);
		    allpan[i].add("Center",allmini[i]);
		    allpan[i].add("South",alltext[i]);
		}
		
		for(int i=0; i<allmini.length; i++){
			allpan[i] = new JPanel();
			allpan[i].setLayout(new BorderLayout());
			bookimage[i] = new ImageIcon(getClass().getResource( "/wish/["+i+"].jpg"));
		    allmini[i] = new JButton(bookimage[i]);
			alltext[i] = new JTextField(10);
			cardPan1.add(allpan[i]);
			allpan[i].add("Center",allmini[i]);
			allpan[i].add("South",alltext[i]);
			}
		
		for(int i=0; i<allmini.length; i++){
			allpan[i] = new JPanel();
			allpan[i].setLayout(new BorderLayout());
			bookimage[i] = new ImageIcon(getClass().getResource( "/ing/["+i+"].jpg"));
		    allmini[i] = new JButton(bookimage[i]);
			alltext[i] = new JTextField(10);
			cardPan2.add(allpan[i]);
			allpan[i].add("Center",allmini[i]);
			allpan[i].add("South",alltext[i]);
			}	
		
		for(int i=0; i<allmini.length; i++){
			allpan[i] = new JPanel();
			allpan[i].setLayout(new BorderLayout());
			bookimage[i] = new ImageIcon(getClass().getResource( "/ed/["+i+"].jpg"));
		    allmini[i] = new JButton(bookimage[i]);
			alltext[i] = new JTextField(10);
			cardPan3.add(allpan[i]);
			allpan[i].add("Center",allmini[i]);
			allpan[i].add("South",alltext[i]);
			}	
		
		center.add(cardPan,"1");
		center.add(cardPan1,"2");
		center.add(cardPan2,"3");
		center.add(cardPan3,"4");	
		
		all.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(all,"��ϵ� ��� å���� ���ڽ��ϴ�.");
            	card.show(center, "1");
            	rightside_Center.setBackground(Color.orange);
            	rightside_West.setBackground(Color.orange);
            	rightside_South.setBackground(Color.orange);
            	
			}
		});
		wish.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(wish,"�а� ���� å���� ���ڽ��ϴ�.");
            	card.show(center, "2");
            	rightside_Center.setBackground(Color.lightGray);
            	rightside_West.setBackground(Color.lightGray);
            	rightside_South.setBackground(Color.lightGray);
            }
		});
		ing.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ing,"���� �а� �ִ� å�� ���ڽ��ϴ�.");
            	card.show(center, "3");
            	rightside_Center.setBackground(Color.CYAN);
            	rightside_West.setBackground(Color.CYAN);
            	rightside_South.setBackground(Color.CYAN);
			}
		});
		ed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ed,"�ϵ��� å�� ���ڽ��ϴ�.");
            	card.show(center, "4");
            	rightside_Center.setBackground(Color.white);
            	rightside_West.setBackground(Color.white);
            	rightside_South.setBackground(Color.white);
			}
		});
	    //������ ��

		// ����
		icon1 = new ImageIcon(getClass().getResource("images/bt.png"));
		setting_bt.setIcon(icon1);
		setting_bt.setPreferredSize(new Dimension(50, 40)); // ������ ũ������

		
		upside.setLayout(bl3);
		upside.add(pan);
	
		pan.add(userName);
		pan.add(userName_f);
		pan.add(new JLabel("                   "));
		pan.add(oneLine);
		pan.add(oneLine_f);
		pan.add(new JLabel("                   "));
		pan.add(register_bt); // å��� ��ư
		pan.add(new JLabel("            "));
		pan.add(setting_bt); // ȯ�漳�� ��ư
		
		// ����

		// ����

		rightside.setPreferredSize(new Dimension(500, 635));
		rightside_Center = new JPanel();
		rightside_Center.setPreferredSize(new Dimension(250, 435));
		rightside_Center.setLayout(new FlowLayout(6, 80, 20));
		
		//memo.setPreferredSize(new Dimension(220, 100));
		jt1.setPreferredSize(new Dimension(220, 100));
		rightside_Center.add(title);
		rightside_Center.add(author);
		rightside_Center.add(publisher);
		rightside_Center.add(page);
		rightside_Center.add(sortbx);
		rightside_Center.add(jt1);

		
		
		
		try {
			File sourceimage = new File("C:\\����.jpg");
			ima = ImageIO.read(sourceimage);

		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel img = new JLabel(new ImageIcon(ima));
		rightside_West = new JPanel();
		rightside_West.setPreferredSize(new Dimension(150, 435));
		rightside_West.setLayout(new FlowLayout());
		rightside_West.add(img);

		fopen = new FileDialog(this, "���� ����", FileDialog.LOAD);
		rightside_West.add(image_seach);

		rightside_South = new JPanel();
		rightside_South.setPreferredSize(new Dimension(500, 200));
		rightside_South.add(cancel);
		rightside_South.add(register);

		rightside.add("Center", rightside_Center);
		rightside.add("South", rightside_South);
		rightside.add("West", rightside_West);

		downside.add(leftside);
		downside.add(rightside);
		back.add("North", upside);
		back.add(downside);

		add(back);

		image_seach.addActionListener(this);
		register_bt.addActionListener(this);
		setting_bt.addActionListener(this);
	}
	 
		   
		  
	@Override
	public void actionPerformed(ActionEvent e) {
     	String s = e.getActionCommand();	    
		if (e.equals("�̹��� ����")) {
			try {
				
				fopen.setVisible(true);
				String filenname = fopen.getDirectory() + "\\"
						+ fopen.getFile();
				FileReader reader = new FileReader(filenname);
				BufferedReader br = new BufferedReader(reader); // ���پ� �о��������

				String y = null; // �����Ͱ� �ִ��� Ȯ���ϱ� ����
				while ((y = br.readLine()) != null) {
					// area.append(s+"\n");
					y = br.readLine();
				}

				reader.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (s.equals("å���")) {
			Book bIn;
			bIn = new Book(e.getActionCommand() + "å���");
		} else if (s.equals("")) {
			How H;
			H = new How(e.getActionCommand() + "����");// �׸��� �� �κ��� ���񺸿��ִ� �κ�

		}
	}

}