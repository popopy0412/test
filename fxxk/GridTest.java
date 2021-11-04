import java.awt.*;
import javax.swing.*;

public class GridTest extends JFrame {
    public GridTest(String title){
        super(title); // 제목을 설정
        setSize(400, 300); // 프레임 사이즈 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane을 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자를 BorderLayout으로 설정

        JPanel north = new JPanel(); // 제목을 넣을 패널
        north.add(new JLabel("학생 정보 입력")); // 패널에 텍스트 삽입
        c.add(north, BorderLayout.NORTH); // ContentPane의 북쪽에 삽입

        JPanel center = new JPanel(new GridLayout(5, 4, 3, 3)); // 정보를 넣을 패널
        String[] texts = {"이름", "학번", "학과", "연락처"}; // 각 text의 배열
        for(String s : texts) center.add(new JLabel(s)); // text를 각 GridLayout의 첫 줄에 삽입
        for(int i=0;i<16;i++) center.add(new JTextField()); // 나머지를 TextField로 채움
        c.add(center, BorderLayout.CENTER); // ContentPane의 중심에 삽입

        JPanel south = new JPanel(); // 버튼을 넣을 패널
        south.add(new JButton("확인"));
        south.add(new JButton("취소")); // 각 버튼을 삽입
        c.add(south, BorderLayout.SOUTH); // ContentPane의 남쪽에 삽입

        setVisible(true); // 프레임을 보이게 설정
    }

    public static void main(String[] args){
        GridTest frame = new GridTest("Grid TEST");
    }
}
