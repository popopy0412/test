import java.awt.*;
import javax.swing.*;

public class DrawLineTest_1 extends JFrame{

    private MyPanel panel = new MyPanel();
    public int X, Y; // 프레임의 가로 세로 길이
    public DrawLineTest_1(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(500, 300); // 프레임 크기 설정
        X = getWidth(); Y = getHeight();
        setSize(X+20, Y+40); // 오차 수정
        setContentPane(panel); // 선 그리기
        setVisible(true); // 프레임 보이게 설정
    }
    class MyPanel extends JPanel{ // 선을 그리기 위한 내부 클래스
        public void paintComponent(Graphics g){ // 그림 그리는 함수 오버라이드
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            for(int i=1;i<10;i++) g.drawLine(X*i/10, 0, X*i/10, Y); // 세로줄
            for(int i=1;i<10;i++) g.drawLine(0, Y*i/10, X, Y*i/10); // 가로줄
        }
    }
    public static void main(String[] args){
        DrawLineTest_1 frame = new DrawLineTest_1("격자 그리기"); // 프레임 생성
    }
}
