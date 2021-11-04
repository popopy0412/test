import java.awt.*;
import javax.swing.*;

public class StoryTest extends JFrame{
    public StoryTest(String title){
        super(title); // 제목을 설정
        setSize(400, 300); // 프레임 사이즈 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane을 가져옴
        c.setLayout(null); // 배치 관리자를 없앰

        JLabel l1 = new JLabel("SM Story");
        l1.setBounds(40, 40, 70, 20); // 첫 라벨 위치와 크기 설정

        JLabel l2 = new JLabel("가을은");
        l2.setBounds(120, 100, 50, 20); // 두 번째 라벨 위치와 크기 설정

        JTextField t = new JTextField(10);
        t.setBounds(200, 160, 50, 20); // 세 번째 텍스트 필드의 위치와 크기 설정

        JLabel l3 = new JLabel("이다");
        l3.setBounds(280, 220, 50, 20); // 네 번째 라벨 위치와 크기 설정

        c.add(l1);
        c.add(l2);
        c.add(t);
        c.add(l3); // 모두 ContentPane에 삽입

        setVisible(true); // 프레임을 보이게 설정
    }

    public static void main(String[] args){
        StoryTest frame = new StoryTest("SM Story");
    }
}
