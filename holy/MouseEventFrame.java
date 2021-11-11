import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseEventFrame extends JFrame{
    public MouseEventFrame(String title){
        super(title); // 제목 설정
        setSize(300, 200); // 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane 가져오기
        c.setLayout(new FlowLayout()); // 배치 관리자 설정

        JLabel l = new JLabel("사랑해"); // 라벨 생성
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 위에 있을 때
                l.setText("Love Java");
            }

            @Override
            public void mouseExited(MouseEvent e) { // 마우스가 위에 없을 때
                l.setText("사랑해");
            }
        });

        c.add(l); // 라벨 컴포넌트에 추가

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String[] args){
        MouseEventFrame frame = new MouseEventFrame("마우스 올리기 내리기"); // 프레임 생성
    }
}
