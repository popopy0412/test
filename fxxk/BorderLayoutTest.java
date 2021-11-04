import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest extends JFrame{ // JFrame을 상속
    public BorderLayoutTest(String title) {
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 조건 설정

        Container contentPane = getContentPane(); // ContentPane을 받음
        contentPane.setLayout(new BorderLayout(7, 5)); // 버튼 간 간격을 설정

        contentPane.add(new JButton("North"), BorderLayout.NORTH);
        contentPane.add(new JButton("West"), BorderLayout.WEST);
        contentPane.add(new JButton("Center"), BorderLayout.CENTER);
        contentPane.add(new JButton("East"), BorderLayout.EAST);
        contentPane.add(new JButton("South"), BorderLayout.SOUTH); // 각 버튼의 위치와 이름을 설정

        setSize(400, 200); // 프레임의 크기를 설정
        setVisible(true); // 프레임이 보이게 함
    }

    public static void main(String args[]){
        BorderLayoutTest frame = new BorderLayoutTest("BorderLayout Practice"); // 프레임 생성
    }
}
