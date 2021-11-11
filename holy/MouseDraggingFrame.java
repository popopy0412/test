import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseDraggingFrame extends JFrame{
    public MouseDraggingFrame(String title){
        super(title); // 제목 설정
        setSize(300, 300); // 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane 가져오기
        c.setBackground(Color.GREEN); // 초기 배경색 초록색으로 설정
        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { // 마우스 드래그 중이면
                c.setBackground(Color.YELLOW); // 색깔 노란색으로 바꿈
            }
        });
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { // 마우스 드래그가 끝나면
                c.setBackground(Color.GREEN); // 다시 초록색으로 설정
            }
        });

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String[] args){
        MouseDraggingFrame frame = new MouseDraggingFrame("드래깅동안 YELLOW"); // 프레임 생성
    }
}
