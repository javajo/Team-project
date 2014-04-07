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
	JPanel back = new JPanel(); // 전체 패널들이 올라갈 가장 밑에 깔릴 패널
	JPanel upside = new JPanel(); // 윗쪽 패널(동준이가 만들 부분 올라갈 패널)
	JPanel downside = new JPanel(); // 아랫쪽 왼쪽 오른쪽 큰패널(나, 선주부분 각각 나눠질 부분)
	JPanel leftside = new JPanel(); // 아랫쪽 왼쪽 패널(내꺼 올라갈 부분)
	JPanel rightside = new JPanel(); // 아랫쪽 오른쪽 패널(선주꺼 올라갈 부분)
	
	JPanel pan = new JPanel();
	JLabel userName = new JLabel("사용자 이름 : ", JLabel.RIGHT);
	JLabel oneLine = new JLabel("한 줄 글쓰기 : ", JLabel.RIGHT);
	JLabel userName_f = new JLabel();		//동준위 이름라벨
	JLabel oneLine_f = new JLabel("어쩐지 오늘은 운수가 좋더라니만");		//동준위
	
	// 윗쪽 패널 재료
	BorderLayout bl3 = new BorderLayout();
	JButton register_bt = new JButton("책등록"); // 책등록
	JButton setting_bt = new JButton(""); // 환경설정 이미지
	// 윗쪽 패널 재료 끝

	// 아래 오른쪽 패널 재
	JPanel rightside_Center, rightside_West, rightside_South; // 아래오른쪽패널에 포함될
																// 패널들
	Image ima = null;

	FileDialog fopen;
	JButton image_seach = new JButton("이미지 변경");
	JTextField title = new JTextField("도서명을 입력해주세요", 20);

	JTextField author = new JTextField("저자명을 입력해주세요", 20);
	JTextField publisher = new JTextField("출판사명을 입력해주세요", 20);
	JTextField page = new JTextField("페이지수를 입력해주세요", 15);
	String[] sorts = { "읽고 싶은 책!", "읽고 있는 중~", "다 읽은 책!" };
	JComboBox sortbx = new JComboBox(sorts);
	
	JTextArea memo = new JTextArea("메모");
	JButton cancel = new JButton("수정");
	JButton register = new JButton("삭제");
	JTable jt1 = new JTable();
	
	ImageIcon icon,icon1;
	GridLayout gl1 = new GridLayout(1, 2); // 아랫쪽 두 패널 나누기 위한 레이아웃
	FlowLayout fl = new FlowLayout(); // 아랫쪽 왼쪽 하단부의 콤보박스, 검색 텍스트라인 들아갈 패널레이아웃

	BorderLayout bl0 = new BorderLayout(); // 가장 밑에 깔릴 패널은 보더레이아웃,
	BorderLayout bl1 = new BorderLayout(); // 왼쪽 하단부 전체 레이아웃
	BorderLayout bl2 = new BorderLayout(); // 아랫쪽 왼쪽 패널은 보더 레이아웃으로 구성

	JPanel jp1 = new JPanel(); // 전체 패널 위에 올라갈 분류, 검색부분 있을 패널
	JPanel jp2 = new JPanel(); // 그냥 하단부
	JPanel center = new JPanel(); // 중앙 패널(책 사진, 정보들이 올라갈 패널)
	
	JButton all = new JButton("전체");
	JButton wish = new JButton("WISH");
	JButton ing = new JButton("읽는중");
	JButton ed = new JButton("다 읽음");
	
	//String[] sort = { "전체도서", "읽고 싶은 책!", "읽고 있는 중~", "다 읽은 책!" }; // 콤보박스에 들어갈
	//JComboBox cb = new JComboBox(sort); // 콤보박스

	JTextField jtf = new JTextField(10); // 검색어 입력할 필드
	
	
	    JPanel cardPan = new JPanel();
		JPanel cardPan1 = new JPanel();
		JPanel cardPan2 = new JPanel();
		JPanel cardPan3 = new JPanel();
		
		CardLayout card = new CardLayout();
		
		
		
// 아랫쪽 패널 재료 끝
//메서드 시작////////////////////////////////////////////////////////////////////////
	TeamProject() {
		super("북매니저");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//안현준 시작
		back.setLayout(bl0);
		back.setBackground(Color.gray);

		upside.setBackground(Color.black);
		downside.setBackground(Color.white);
		downside.setLayout(gl1);
		leftside.setBackground(Color.LIGHT_GRAY);
		rightside.setLayout(bl1);

		leftside.setLayout(bl2); // 왼쪽 하단 전체 패널의 레이아웃=border레이아웃
		leftside.setBackground(Color.white); // 뒷배경은 화이트
		jp1.setBackground(Color.black); // 패널 상단은 블랙
		jp2.setBackground(Color.black); // 패널 하단은 블랙
		center.setBackground(Color.orange);
		
		jp1.setLayout(fl); // 콤보박스 있는 패널
		
		jp1.add(all);// 콤보박스 붙임
		jp1.add(wish);
		jp1.add(ing);
		jp1.add(ed);
		jp1.add(jtf);// 검색필드 붙임
		JButton jb1;
		icon = new ImageIcon(getClass().getResource("/images/search.jpg"));
		jb1 = new JButton(icon);
		jp1.add(jb1);// 검색버튼 붙임

	
		
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
            	JOptionPane.showMessageDialog(all,"등록된 모든 책들을 보겠습니다.");
            	card.show(center, "1");
            	rightside_Center.setBackground(Color.orange);
            	rightside_West.setBackground(Color.orange);
            	rightside_South.setBackground(Color.orange);
            	
			}
		});
		wish.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(wish,"읽고 싶은 책들을 보겠습니다.");
            	card.show(center, "2");
            	rightside_Center.setBackground(Color.lightGray);
            	rightside_West.setBackground(Color.lightGray);
            	rightside_South.setBackground(Color.lightGray);
            }
		});
		ing.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ing,"현재 읽고 있는 책을 보겠습니다.");
            	card.show(center, "3");
            	rightside_Center.setBackground(Color.CYAN);
            	rightside_West.setBackground(Color.CYAN);
            	rightside_South.setBackground(Color.CYAN);
			}
		});
		ed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(ed,"완독한 책을 보겠습니다.");
            	card.show(center, "4");
            	rightside_Center.setBackground(Color.white);
            	rightside_West.setBackground(Color.white);
            	rightside_South.setBackground(Color.white);
			}
		});
	    //안현준 끝

		// 동준
		icon1 = new ImageIcon(getClass().getResource("images/bt.png"));
		setting_bt.setIcon(icon1);
		setting_bt.setPreferredSize(new Dimension(50, 40)); // 아이콘 크기조정

		
		upside.setLayout(bl3);
		upside.add(pan);
	
		pan.add(userName);
		pan.add(userName_f);
		pan.add(new JLabel("                   "));
		pan.add(oneLine);
		pan.add(oneLine_f);
		pan.add(new JLabel("                   "));
		pan.add(register_bt); // 책등록 버튼
		pan.add(new JLabel("            "));
		pan.add(setting_bt); // 환경설정 버튼
		
		// 동준

		// 선주

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
			File sourceimage = new File("C:\\쓸개.jpg");
			ima = ImageIO.read(sourceimage);

		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel img = new JLabel(new ImageIcon(ima));
		rightside_West = new JPanel();
		rightside_West.setPreferredSize(new Dimension(150, 435));
		rightside_West.setLayout(new FlowLayout());
		rightside_West.add(img);

		fopen = new FileDialog(this, "파일 열기", FileDialog.LOAD);
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
		if (e.equals("이미지 변경")) {
			try {
				
				fopen.setVisible(true);
				String filenname = fopen.getDirectory() + "\\"
						+ fopen.getFile();
				FileReader reader = new FileReader(filenname);
				BufferedReader br = new BufferedReader(reader); // 한줄씩 읽어오기위해

				String y = null; // 데이터가 있는지 확인하기 위해
				while ((y = br.readLine()) != null) {
					// area.append(s+"\n");
					y = br.readLine();
				}

				reader.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (s.equals("책등록")) {
			Book bIn;
			bIn = new Book(e.getActionCommand() + "책등록");
		} else if (s.equals("")) {
			How H;
			H = new How(e.getActionCommand() + "제목");// 그리고 이 부분은 제목보여주는 부분

		}
	}

}