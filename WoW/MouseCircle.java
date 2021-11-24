import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;

public class MouseCircle extends JFrame{

    public Vector<Circle> v = new Vector<>();
    public int x1, y1, x2, y2; // 시작 좌표, 끝 좌표
    public MyPanel panel = new MyPanel(); // 원을 그릴 패널
    public Container c; // ContentPane
    public MouseCircle(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(700, 700); // 프레임 크기 설정
        setContentPane(panel); // 원을 그릴 패널을 ContentPane으로 설정

        panel.addMouseListener(new MyMouseAdapter()); // 패널에 마우스리스너 추가

        setVisible(true); // 프레임 보이게 설정
    }
    class Circle{
        public int x1, y1, x2, y2; // 마우스 첫 클릭 좌표와 마우스를 뗐을 때 좌표
        public Circle(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    class MyPanel extends JPanel{ // 원들이 그려질 패널
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            for(Circle c : v){
                int r = Math.max(Math.abs(c.x1-c.x2), Math.abs(c.y1-c.y2))*2; // 원의 지름
                int x = Math.min(c.x1, c.x2) - r/2; // 원의 중심의 x좌표
                int y = Math.min(c.y1, c.y2) - r/2; // 원의 중심의 y좌표
                g.drawArc(x, y, r, r, 0, 360); // 위 정보를 토대로 원을 그림
            }
        }
    }
    class MyMouseAdapter extends MouseAdapter{
        public void mousePressed(MouseEvent e) { // 마우스를 눌렀을 때
            Point p = e.getLocationOnScreen();
            x1 = p.x;
            y1 = p.y; // 그 지점의 x좌표와 y좌표를 저장
        }
        public void mouseReleased(MouseEvent e) { // 마우스를 뗐을 때
            Point p = e.getLocationOnScreen();
            x2 = p.x;
            y2 = p.y; // 그 지점의 x좌표와 y좌표를 저장하고
            v.add(new Circle(x1, y1, x2, y2)); // 그 정보를 저장하는 Circle 객체 생성 후 벡터에 저장
            panel.repaint(); // 그리고 그려질 패널을 repaint
        }
    }
    public static void main(String[] args){
        MouseCircle frame = new MouseCircle("마우스로 원 그리기"); // 프레임 생성
    }
}