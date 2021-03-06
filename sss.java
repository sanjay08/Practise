import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class sss{
	public static void main(String[] args) {
		FontFrame frame=new FontFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class FontFrame extends JFrame{
	public FontFrame(){
		setTitle("FontTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		FontPanel panel=new FontPanel();
		add(panel);
	}
	int DEFAULT_WIDTH=300;
	int DEFAULT_HEIGHT=200;
}
class FontPanel extends JPanel{
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		String message="Hello World";
		Font f=new Font("Serif",Font.BOLD,36);
		g2.setFont(f);
		FontRenderContext context=g2.getFontRenderContext();
		Rectangle2D bounds=f.getStringBounds(message,context);
		double x=(getWidth()-bounds.getWidth())/2;
		double y=(getHeight()-bounds.getHeight())/2;
		double ascent=-bounds.getY();
		double baseY=y+ascent;
		g2.drawString(message,(int)x,(int)baseY);
		g2.setPaint(Color.GRAY);
		g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
		Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		g2.draw(rect);
	}
}