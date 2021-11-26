import java.awt.*;
import javax.swing.*;

public class DrawFillTest extends JFrame{

    private int X, Y; // 너비와 높이
    public DrawFillTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(900, 300); // 프레임 크기 설정
        X = getWidth(); Y = getHeight();

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new GridLayout(1, 4));

        MyPanel[] panels = new MyPanel[3]; // 패널들 설정
        panels[0] = new RecPanel();
        panels[1] = new CirPanel();
        panels[2] = new StarPanel();
        for(MyPanel p : panels) c.add(p);

        setVisible(true); // 프레임 보이게 설정
    }
    class MyPanel extends JPanel{ // 각 클래스의 부모 클래스(전체 틀)
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRoundRect(20, 20, X/3-70, Y-80, 10, 10); // 둘레 그리기
        }
    }
    class RecPanel extends MyPanel{ // 사각형 그리는 패널 클래스
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(60, 60, 20, 150);
            g.setColor(Color.BLUE);
            g.fillRect(100, 80, 20, 130);
            g.setColor(Color.GREEN);
            g.fillRect(140, 100, 20, 110);
            g.setColor(Color.YELLOW);
            g.fillRect(180, 120, 20, 90); // 사각형 그리기
        }
    }
    class CirPanel extends MyPanel{ // 원 그리는 패널 클래스
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillArc(90, 80, 100, 100, 0, 50);
            g.setColor(Color.GREEN);
            g.fillArc(90, 80, 100, 100, 50, 90);
            g.setColor(Color.BLUE);
            g.fillArc(90, 80, 100, 100, 140, 140);
            g.setColor(Color.YELLOW);
            g.fillArc(90, 80, 100, 100, 280, 80); // 원 그리기
        }
    }
    class StarPanel extends MyPanel{ // 별 그리는 패널
        public void paintComponent(Graphics g){
            int[] x = {140, 120, 80, 110, 100, 140, 180, 170, 200, 160};
            int[] y = {80, 120, 120, 140, 180, 150, 180, 140, 120, 120}; // 별의 각 좌표
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            g.fillPolygon(x, y, 10); // 별 그리기
        }
    }
    public static void main(String[] args){
        DrawFillTest frame = new DrawFillTest("Draw Fill 사용 예제"); // 프레임 생성
    }
}