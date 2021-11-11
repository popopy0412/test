import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JTextField[] tf = new JTextField[4]; // 텍스트 필드 생성
        JButton b1 = new JButton("확인"); // 확인 버튼
        JButton b2 = new JButton("취소"); // 취소 버튼

        b1.addActionListener(new ActionListener() { // 확인 버튼에 액션리스너 추가
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<4;i++) System.out.print(tf[i].getText() + " ");
                System.out.println();
                for(int i=0;i<4;i++) tf[i].setText(""); // 각 정보를 출력해주고 텍스트 필드 초기화
            }
        });

        for(int i=0;i<3;i++) panels[i] = new JPanel(); // 각 패널을 생성

        panels[0].setLayout(new GridLayout(4, 1)); // Label이 들어갈 패널을 GridLayout으로 생성
        panels[1].setLayout(new GridLayout(4, 1)); // TextField가 들어갈 패널을 GridLayout으로 생성
        for(int i=0;i<4;i++) {
            tf[i] = new JTextField();
            panels[0].add(new JLabel(texts[i])); // Label의 이름을 설정
            panels[1].add(tf[i]); // TextField를 삽입
        }
        c.add(panels[0], BorderLayout.WEST); // 서쪽에 삽입
        c.add(panels[1], BorderLayout.CENTER); // 가운데에 삽입

        panels[2] = new JPanel(); // 마지막 버튼들을 넣을 패널을 생성
        panels[2].add(b1);
        panels[2].add(b2); // 버튼들을 삽입
        c.add(panels[2], BorderLayout.SOUTH); // 남쪽에 삽입

        setVisible(true); // 프레임을 보이게 설정
    }

    public static void main(String[] args){
        GuiTest frame = new GuiTest("GUI TEST");
    }
}