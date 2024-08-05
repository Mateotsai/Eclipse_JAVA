package tw.mateo0805;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class lesson04_GuessNumber extends JFrame implements ActionListener{
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private String answer;
	private int counter; //局數計數器
	
	//建構式，製作頁面框架
	public lesson04_GuessNumber(){
		super("猜數字遊戲"); //引用父類別JFRAME預設的方法
		
		input = new JTextField(); //輸入欄
		guess = new JButton("猜猜看"); //點選欄
		log = new JTextArea(); //數字顯示視窗
		
		input.setFont(new Font(null, Font.BOLD|Font.ITALIC,36));
		
		setLayout(new BorderLayout());
		//配置上方panel的輸入欄和點選欄
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess,BorderLayout.EAST);
		top.add(input,BorderLayout.CENTER);
		//配置上下兩方欄位
		add(top,BorderLayout.NORTH);
		add(log,BorderLayout.CENTER);
		//網頁框架本體
		this.setSize(640,480);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		init();//呼叫內部處理事件(產生謎底)
		initEvent(); //呼叫內部處理事件(按鈕)
	}
	
	private void init() {
		answer = createAnswer(4);  //一局猜幾個數字
		counter = 0; //局數計數器歸零
		System.out.println(answer);  //是否能從後台看的到答案
	};
	
	//內部處理事件(按鈕)
	private void initEvent() {
		guess.addActionListener(this);
	}
	
	//產生謎底
	private static String createAnswer(int d) {
		final int nums = 10;
		int[] poker = new int[nums];
		for(int i=0; i<poker.length;i++) poker[i] = i;
		for(int i=nums-1; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
	
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<d; i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
}
	
	//執行main
	public static void main(String[] args) {
	new lesson04_GuessNumber();

	}

	@Override //按下按鈕的addActionListener會執行的動作
	public void actionPerformed(ActionEvent e) {
		counter++;
		String g = input.getText();
		String result = checkAB(g,answer);	
		log.append(String.format("第%d局. %s => %s\n",counter, g, result));//保留前幾次猜的
		input.setText(""); //按下按鈕時，輸入框內的數字會清空
		
		//勝負判斷彈跳式視窗 
		if(result.equals("4A0B")) {
			JOptionPane.showMessageDialog(null, "Winner!");
		}else if (counter == 10) {
			JOptionPane.showMessageDialog(null, "Loser!答案是:" + answer);
		}
		
	}
	//幾A幾B邏輯判斷
	private static String checkAB(String g, String a) {
		int A = 0; int B = 0 ;
		
		for(int i=0; i<a.length(); i++) {
			if(g.charAt(i) == a.charAt(i)) {
				A++;
			}else if(a.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		
		return String.format("%dA%dB",A,B);
	};
	
}
