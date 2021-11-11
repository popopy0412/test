import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame{
    public ClickPracticeFrame(String title){
        super(title); // 제목 설정
        setSize(400, 400); // 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane 가져오기
        c.setLayout(null); // 배치 관리자 없앰

        JLabel l = new JLabel("C");
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // 마우스 클릭 시
                Random random = new Random();
                l.setLocation(random.nextInt(300), random.nextInt(300)); // 랜덤 위치 설정
            }
        });
        l.setBounds(100, 100, 10, 10); // 초기 위치 설정
        c.add(l); // 컨테이너에 추가

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String args[]){
        ClickPracticeFrame frame = new ClickPracticeFrame("클릭 연습용 응용프로그램"); // 프레임 생성
    }
}
