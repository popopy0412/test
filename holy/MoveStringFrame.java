import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MoveStringFrame extends JFrame{
    public MoveStringFrame(String title){
        super(title); // 제목 설정
        setSize(300, 200); // 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane 가져오기
        c.setLayout(new FlowLayout()); // 배치 관리자 설정

        JLabel l = new JLabel("Love Java"); // 라벨 생성
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){ // 좌측 화살표 키가 눌리면
                    String str = l.getText().substring(1);
                    l.setText(str.concat(l.getText().substring(0, 1))); // 문자열 회전
                }
            }
        });

        c.add(l); // 라벨 컨테이너에 추가

        setVisible(true); // 프레임 보이게 설정
        c.setFocusable(true); // Component가 포커스를 받을 수 있도록 설정
        c.requestFocus(); // Component에 포커스 강제 설정
    }

    public static void main(String[] args){
        MoveStringFrame frame = new MoveStringFrame("Left 키로 문자열 옮기기"); // 프레임 생성
    }
}
