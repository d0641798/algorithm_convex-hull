
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*; //���Jjava.awt���Ҧ�����M��k�C�]�t�Ω�ЫبϥΪ̤����Mø�s �ϧιϹ����������O�C
import javax.swing.*; //���Jjavax.swing���Ҧ�����M��k�C���Ѥ@�աu���q�šv�� JAVA����A�ɶq���o�Ǥ���b�Ҧ����O�W���u�@�覡���ۦP�C
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
		btn.addActionListener(frm); // �Nfrm�]��btn���ƥ��ť��

		txa.addTextListener(frm); // �Nfrm�]��txa���ƥ��ť��
		frm.addMouseMotionListener(frm);
		frm.setLayout(null); // ���ϥΪ����t�m
		frm.setTitle("Convex Hull"); // �]�w�����W��
		btn.setBounds(425, 500, 75, 50); // �w�q���s�榡
		txa.setBounds(200, 500, 225, 50); // �w�q��r����榡
		lab1.setBounds(100, 30, 300, 40); // �w�q��r����榡
		lab.setBounds(30, 500, 190, 50);
//txa1.setEditable(false); //�� txa1 �]�����i�s��
		frm.setSize(800, 600); // �]�w�����j�p
		frm.add(btn); // �[�J���s
		frm.add(txa); // �[�J��r���
		frm.add(lab1); // �[�Jlabel
		frm.add(lab); // �[�Jlabel
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
	 
	 
	 //for(int i = 0; i < points.length; i++){ //convexhull �M�ť��]��0
	 
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
	 
	 for(int i = 0; i < points.length; i++){ //��̤p��X�y��
		 if(points[i].getX()<Xmin) {
			 Xmin=points[i].getX();
			 convexhull[0].setX(points[i].getX()); 
		 }
	 
	 }
	 for(int i = 0; i < points.length; i++){ //���p����ӬۦPXmin�y�СA����̤pY�Ȭ�Ymin
		 if(points[i].getX()==convexhull[0].getX()) {
			 if(points[i].getY()<Ymin) {
				 Ymin=points[i].getY();
				 convexhull[0].setY(points[i].getY()); 
			 } 
		 } 
	 }
 //convexhull[0].setX(Xmin); //convexhull�Ĥ@�I
 //convexhull[0].setY(Ymin);
 
	double slope=10000; //�ײv
	for(int i = 0; i < points.length; i++){ //��ĤG���I �ós���Ĥ@���u
		if(points[i].getX()-convexhull[0].getX()!=0)
		{
			double temp=(double)(points[i].getY()-
					convexhull[0].getY())/(points[i].getX()-convexhull[0].getX());//��ײv 
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
 
	int count=2;//�Ĥ@�� �ĤG���I �w�g���F
	for(int i =count;i<convexhull.length;i++) {
		
		double anglemax=0;
		double vector1length=Math.sqrt( 
				Math.pow(convexhull[i-2].getX()-convexhull[i-1].getX(),2)+
				Math.pow(convexhull[i-2].getY()-convexhull[i-1].getY(),2)
				);//�Ĥ@�ӦV�q����
 
		double vector1X=convexhull[i-2].getX()-convexhull[i-1].getX();//�Ĥ@�ӦV�qX
		double vector1Y=convexhull[i-2].getY()-convexhull[i-1].getY();//�Ĥ@�ӦV�qY
		for(int j = 0; j < points.length; j++){
 
			double vector2length=Math.sqrt(
					Math.pow(convexhull[i-1].getX()-
							points[j].getX(),2)+
					Math.pow(convexhull[i-1].getY()-
							points[j].getY(),2));
 
			double vector2X=points[j].getX()-convexhull[i-1].getX();//�ĤG�ӦV�qX
			double vector2Y=points[j].getY()-convexhull[i-1].getY();//�ĤG�ӦV�qY
			double dot=vector1X*vector2X+vector1Y*vector2Y;//�V�q���n
			double cos=dot/(vector1length*vector2length); 
			//cos=�V�q���n/�V�q�@����*�V�q�G����
			double arccos=Math.toDegrees(Math.acos(cos));//��X�L������ �A�ন����
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
			flag=1;//�p�G�w�g�s�^�Ĥ@���I �N��᭱�����I�]���Ĥ@���I
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
		//�ХX�y���I
		for (int i = 0; i < amount; i++) {
			//x y�ѶüƲ���
			temp[i] = new Point();
			x[i] = (int) (Math.random() * 450) + 30;
			y[i] = (int) (Math.random() * 405) + 75;
			temp[i].setX(x[i]);
			temp[i].setY(y[i]);
			//g.setColor(Color.red); //�]�w�I���C�⬰����
			g.fillOval(temp[i].getX(), temp[i].getY(), 5, 5); // �e�X�üƮy���I
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
		lab.setText("�y�СG(" + arg0.getX() + "," + arg0.getY() + ")");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		lab.setText("�y�СG(" + arg0.getX() + "," + arg0.getY() + ")");
	}

	@Override
	public void textValueChanged(TextEvent arg0) {
		amount = Integer.valueOf(txa.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();
		update(g);
		// ���M�ŵe����A�I�spaint�禡
	}
}
