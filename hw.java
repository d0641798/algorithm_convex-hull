
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*; //載入java.awt的所有物件和方法。包含用於創建使用者介面和繪製 圖形圖像的全部類別。
import javax.swing.*; //載入javax.swing的所有物件和方法。提供一組「輕量級」的 JAVA元件，盡量讓這些元件在所有平臺上的工作方式都相同。
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.List;

public class hw extends Frame implements ActionListener, TextListener, MouseMotionListener {
	static hw frm = new hw();
	static Button btn = new Button("Send");
	static TextArea txa = new TextArea();
	static Label lab = new Label();
	static Label lab1 = new Label("Convex Hull");
	int amount;

	public static void main(String[] args) {
		// convexhull();
		Point temp = new Point();
		btn.addActionListener(frm); // 將frm設為btn的事件傾聽者

		txa.addTextListener(frm); // 將frm設為txa的事件傾聽者
		frm.addMouseMotionListener(frm);
		frm.setLayout(null); // 不使用版面配置
		frm.setTitle("Convex Hull"); // 設定視窗名稱
		btn.setBounds(425, 500, 75, 50); // 定義按鈕格式
		txa.setBounds(200, 500, 225, 50); // 定義文字方塊格式
		lab1.setBounds(100, 30, 300, 40); // 定義文字方塊格式
		lab.setBounds(30, 500, 190, 50);
//txa1.setEditable(false); //把 txa1 設為不可編輯
		frm.setSize(800, 600); // 設定視窗大小
		frm.add(btn); // 加入按鈕
		frm.add(txa); // 加入文字方塊
		frm.add(lab1); // 加入label
		frm.add(lab); // 加入label
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm.dispose();
			}
		});
	}

public static Point[] convexhull(Point[] points) {
	int Xmin=10000;
	int Ymin=10000;
	//Point points[] = new Point[20];
	Point convexhull[]=new Point[points.length];
	//System.out.println(Math.toDegrees(Math.acos(0.5)));
	 
	 
	 //for(int i = 0; i < points.length; i++){ //convexhull 清空全設為0
	 
	// convexhull[i].setX(0);
	// convexhull[i].setY(0);
	// System.out.println(convexhull[i].toString());
	// }
	 for(int i = 0; i < points.length; i++){
		 System.out.println(points[i]);
	 }
	 for(int i = 0; i < points.length; i++){
		 convexhull[i] = new Point();
	 }
	 
	 for(int i = 0; i < points.length; i++){ //找最小的X座標
		 if(points[i].getX()<Xmin) {
			 Xmin=points[i].getX();
			 convexhull[0].setX(points[i].getX()); 
		 }
	 
	 }
	 for(int i = 0; i < points.length; i++){ //假如有兩個相同Xmin座標，比較最小Y值為Ymin
		 if(points[i].getX()==convexhull[0].getX()) {
			 if(points[i].getY()<Ymin) {
				 Ymin=points[i].getY();
				 convexhull[0].setY(points[i].getY()); 
			 } 
		 } 
	 }
 //convexhull[0].setX(Xmin); //convexhull第一點
 //convexhull[0].setY(Ymin);
 
	double slope=10000; //斜率
	for(int i = 0; i < points.length; i++){ //找第二個點 並連成第一條線
		if(points[i].getX()-convexhull[0].getX()!=0)
		{
			double temp=(double)(points[i].getY()-
					convexhull[0].getY())/(points[i].getX()-convexhull[0].getX());//算斜率 
			if(temp<=slope)
			{
				slope=temp;
				convexhull[1].setX(points[i].getX());
				convexhull[1].setY(points[i].getY());
			}
	 
		}
	}
 //System.out.println(Xmin);
 //System.out.println(Ymin);
 //System.out.println(convexhull[0]);
 //System.out.println(convexhull[1]);
 
	int count=2;//第一個 第二個點 已經找到了
	for(int i =count;i<convexhull.length;i++) {
		
		double anglemax=0;
		double vector1length=Math.sqrt( 
				Math.pow(convexhull[i-2].getX()-convexhull[i-1].getX(),2)+
				Math.pow(convexhull[i-2].getY()-convexhull[i-1].getY(),2)
				);//第一個向量長度
 
		double vector1X=convexhull[i-2].getX()-convexhull[i-1].getX();//第一個向量X
		double vector1Y=convexhull[i-2].getY()-convexhull[i-1].getY();//第一個向量Y
		for(int j = 0; j < points.length; j++){
 
			double vector2length=Math.sqrt(
					Math.pow(convexhull[i-1].getX()-
							points[j].getX(),2)+
					Math.pow(convexhull[i-1].getY()-
							points[j].getY(),2));
 
			double vector2X=points[j].getX()-convexhull[i-1].getX();//第二個向量X
			double vector2Y=points[j].getY()-convexhull[i-1].getY();//第二個向量Y
			double dot=vector1X*vector2X+vector1Y*vector2Y;//向量內積
			double cos=dot/(vector1length*vector2length); 
			//cos=向量內積/向量一長度*向量二長度
			double arccos=Math.toDegrees(Math.acos(cos));//算出他的弧度 再轉成角度
			//System.out.println(arccos+"-------------cos"+cos);
			if(arccos<=180&&arccos>0)
			{
				if(arccos>anglemax)
				{
					anglemax=arccos;
 
					convexhull[i].setX(points[j].getX());
					convexhull[i].setY(points[j].getY());
				}
			}
			// System.out.println(anglemax);
		}
 
	}
	int flag=0;
	for(int i=1;i<convexhull.length; i++) {
		
		if(convexhull[i].getX()==convexhull[0].getX()&&convexhull[i].getY()==convexhull[0].getY())
		{
			flag=1;//如果已經連回第一個點 就把後面全部點設為第一個點
		}
		if(flag==1)
		{
			convexhull[i].setX(convexhull[0].getX());
			convexhull[i].setY(convexhull[0].getY());
		}
	}
 
 
	for(int j = 0; j < convexhull.length; j++){
		System.out.println("convexhull"+convexhull[j]);
	}
	return convexhull;
 
 
 
	}

	public void paint(Graphics g) {
		Point temp[] = new Point[amount];
		int x[] = new int[amount];
		int y[] = new int[amount];
		//Point[] polygon= new Point[amount];
		System.out.println(amount);
		//標出座標點
		for (int i = 0; i < amount; i++) {
			//x y由亂數產生
			temp[i] = new Point();
			x[i] = (int) (Math.random() * 450) + 30;
			y[i] = (int) (Math.random() * 405) + 75;
			temp[i].setX(x[i]);
			temp[i].setY(y[i]);
			//g.setColor(Color.red); //設定點的顏色為紅色
			g.fillOval(temp[i].getX(), temp[i].getY(), 5, 5); // 畫出亂數座標點
		}
		Point[] polygon = convexhull(temp);
		for (int i = 1; i < polygon.length; i++) {
			//polygon[i] = new Point();
			//Point[] polygon =convexhull(temp);
			System.out.println(polygon[i-1].toString() + "888888888888888888888888888888");
			g.drawLine(polygon[i - 1].getX(), polygon[i - 1].getY(), polygon[i].getX(), polygon[i].getY());
			g.setColor(Color.black);

		}
		g.setColor(Color.black);
		g.drawLine(polygon[0].getX(), polygon[0].getY(), polygon[(polygon.length) - 1].getX(),
				polygon[(polygon.length) - 1].getY());
		g.setColor(Color.black);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		lab.setText("座標：(" + arg0.getX() + "," + arg0.getY() + ")");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		lab.setText("座標：(" + arg0.getX() + "," + arg0.getY() + ")");
	}

	@Override
	public void textValueChanged(TextEvent arg0) {
		amount = Integer.valueOf(txa.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();
		update(g);
		// 先清空畫面後再呼叫paint函式
	}
}
