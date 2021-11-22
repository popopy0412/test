import java.awt.*;
import javax.swing.*;

public class DrawLineTest_1 extends JFrame{

    public DrawLineTest_1(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(300, 300); // 프레임 크기 설정
        
        Container c = getContentPane(); // ContentPane 가져옴
        
        setVisible(true); // 프레임 보이게 설정
    }
    public static void main(String[] args){
        DrawLineTest_1 frame = new DrawLineTest_1("격자 그리기"); // 프레임 생성
    }
}
