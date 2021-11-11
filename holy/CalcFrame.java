import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalcFrame extends JFrame{
    public CalcFrame(String title){
        super(title); // 제목 설정
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new FlowLayout()); // 배치 관리자 설정

        JTextField num1 = new JTextField(5); // 첫 번째 텍스트 필드
        JTextField num2 = new JTextField(5); // 두 번째 텍스트 필드
        JTextField result = new JTextField(5); // 세 번째 텍스트 필드
        JButton btn = new JButton("=");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(Integer.toString(Integer.parseInt(num1.getText()) * Integer.parseInt(num2.getText()))); // 계산
            }
        });

        c.add(num1); c.add(new JLabel("X")); c.add(num2); c.add(btn); c.add(result); // 각 컴포넌트들을 삽입

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String[] args){
        CalcFrame frame = new CalcFrame("계산기"); // 프레임 생성
    }
}
