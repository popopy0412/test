import java.awt.*;
import javax.swing.*;

public class JLabelRandomTest extends JFrame {
    public JLabelRandomTest(String title){
        super(title); // 제목 설정
        setSize(300, 300); // 프레임 사이즈 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane을 가져옴
        c.setLayout(null); // 배치 관리자를 없앰

        for(int i=0;i<20;i++) {
            JLabel label = new JLabel();
            int x = (int) (Math.random() * 200) + 50; // 랜덤 x좌표
            int y = (int) (Math.random() * 200) + 50; // 랜덤 y좌표
            label.setOpaque(true);
            label.setBackground(Color.BLUE); // 색을 파란색으로 설정
            label.setSize(10, 10); // 크기 설정
            label.setLocation(x, y); // x, y 위치에 label을 위치
            c.add(label);
        }

        setVisible(true);
    }
    public static void main(String[] args){
        JLabelRandomTest frame = new JLabelRandomTest("Random Labels");
    }
}
