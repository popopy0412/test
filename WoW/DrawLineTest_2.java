import java.awt.*;
import javax.swing.*;

public class DrawLineTest_2 extends JFrame{

    private MyPanel panel = new MyPanel();
    public int X, Y; // 패널의 가로 세로 길이
    public DrawLineTest_2(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setContentPane(panel); // 패널로 ContentPane 변경
        setSize(500, 1000); // 패널 크기 설정
        setVisible(true); // 프레임 보이게 설정
    }
    class MyPanel extends JPanel{ // 선을 그리기 위한 내부 클래스
        public void paintComponent(Graphics g){ // 그림 그리는 함수 오버라이드
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            X = getWidth(); Y = getHeight();
            for(int i=1;i<=10;i++) {
                g.drawLine(X / 2, (i - 1) * 10, (i - 1) * 10, Y / 2);
                g.drawLine((i - 1) * 10, Y / 2, X / 2, Y - (i - 1) * 10);
                g.drawLine(X - (i - 1) * 10, Y / 2, X / 2, Y - (i - 1) * 10);
                g.drawLine(X / 2, (i - 1) * 10, X - (i - 1) * 10, Y / 2); // 마름모 그리기
            }
        }
    }
    public static void main(String[] args){
        DrawLineTest_2 frame = new DrawLineTest_2("격자 그리기"); // 프레임 생성
    }
}