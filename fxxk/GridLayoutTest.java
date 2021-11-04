import java.awt.*;
import javax.swing.*;

public class GridLayoutTest extends JFrame{
    public GridLayoutTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // COntentPane을 가져옴
        c.setLayout(new GridLayout()); // GridLayout으로 설정

        JButton[] b = new JButton[10]; // 버튼 10개를 만들기 위한 배열
        for(int i=0;i<10;i++){
            b[i] = new JButton(Integer.toString(i)); // 각 버튼의 이름을 설정
            b[i].setBackground(new Color(i*5, i*15, i*25)); // 버튼의 색을 설정
            c.add(b[i]); // 버튼을 ContentPane에 더해줌
        }

        setSize(500, 200); // 프레임의 사이즈를 설정
        setVisible(true); // 프레임을 보이게 함
    }

    public static void main(String[] args){
        GridLayoutTest frame = new GridLayoutTest("GridLayout Practice"); // 프레임 생성
    }
}
