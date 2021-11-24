import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TrafficTest extends JFrame{

    public int on = 0; // 어떤 신호등이 켜지는지 나타내는 변수
    public MyPanel panel = new MyPanel(); // 신호등 패널
    public TrafficTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(300, 600); // 프레임 크기 설정

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자 설정

        JButton btn = new JButton("traffic light turn on"); // 버튼 생성
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                on++;
                on%=3; // 신호등 불을 다음 불로 바꿈
                panel.repaint(); // 패널 상태 갱신
            }
        });

        c.add(panel, BorderLayout.CENTER); // 신호등 패널 추가
        c.add(btn, BorderLayout.SOUTH); // 버튼 추가
        setVisible(true); // 프레임 보이게 설정
    }
    class MyPanel extends JPanel{ // 신호등 패널
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for(int i=0;i<3;i++){
                if(on == i) {
                    if(on == 0) g.setColor(Color.RED);
                    else if(on == 1) g.setColor(Color.GREEN);
                    else if(on == 2) g.setColor(Color.YELLOW); // on의 상태에 따라 신호등 색 결정
                    g.fillOval(80, 50+(140*i), 140, 140); // 켜진 신호등 추가
                }
                else {
                    g.setColor(Color.BLACK);
                    g.drawOval(80, 50+(140*i), 140, 140); // 꺼진 신호등 추가
                }
            }

        }
    }
    public static void main(String[] args){
        TrafficTest frame = new TrafficTest("신호등"); // 프레임 생성
    }
}