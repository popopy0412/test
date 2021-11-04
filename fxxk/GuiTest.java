import java.awt.*;
import javax.swing.*;

public class GuiTest extends JFrame{
    public GuiTest(String title){
        super(title); // 제목 설정
        setSize(300, 200); // 프레임 사이즈 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane을 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자를 BorderLayout으로 설정

        JPanel[] panels = new JPanel[3]; // 각 패널을 3개로 선언
        String[] texts = {"이름", "학번", "전공", "연락처"}; // 각 라벨의 이름

        for(int i=0;i<3;i++) panels[i] = new JPanel(); // 각 패널을 생성
        
        panels[0].setLayout(new GridLayout(4, 1)); // Label이 들어갈 패널을 GridLayout으로 생성
        panels[1].setLayout(new GridLayout(4, 1)); // TextField가 들어갈 패널을 GridLayout으로 생성
        for(String s : texts) {
            panels[0].add(new JLabel(s)); // Label의 이름을 설정
            panels[1].add(new JTextField()); // TextField를 삽입
        }
        c.add(panels[0], BorderLayout.WEST); // 서쪽에 삽입
        c.add(panels[1], BorderLayout.CENTER); // 가운데에 삽입

        panels[2] = new JPanel(); // 마지막 버튼들을 넣을 패널을 생성
        panels[2].add(new JButton("확인"));
        panels[2].add(new JButton("취소")); // 버튼들을 삽입
        c.add(panels[2], BorderLayout.SOUTH); // 남쪽에 삽입

        setVisible(true); // 프레임을 보이게 설정
    }

    public static void main(String[] args){
        GuiTest frame = new GuiTest("GUI TEST");
    }
}
