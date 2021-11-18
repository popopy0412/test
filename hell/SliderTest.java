import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SliderTest extends JFrame {
    public SliderTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(300, 200); // 사이즈 설정

        Container c = getContentPane(); // ContentPane() 가져옴
        c.setLayout(new BorderLayout());

        JTextArea text = new JTextArea();
        text.setLineWrap(true); // 자동 줄바꿈 처리
        JSlider slider = new JSlider(0, 100, 0); // JSlider 생성
        slider.setOrientation(JSlider.HORIZONTAL);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5); // JSlider 기초 세팅

        text.addKeyListener(new KeyAdapter() { // TextArea에 입력했을 때
            @Override
            public void keyTyped(KeyEvent e) {
                if(text.getText().length() > 100){ // 입력한 글자가 100글자가 넘으면 안되게 처리
                    text.setText(text.getText().substring(0, 100));
                }
                if(text.getText().length() > slider.getValue()){ // 입력된 글자 수가 현재 Slider에 저장되어있는 수보다 커지지 않도록 함
                    slider.setValue(text.getText().length());
                }
            }
        });
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(text.getText().length() > slider.getValue()){ // 입력된 글자 수가 현재 Slider에 저장되어있는 수보다 커지면 그만큼 TextArea에서 삭제
                    text.setText(text.getText().substring(0, slider.getValue()));
                }
            }
        });
        c.add(text, BorderLayout.CENTER);
        c.add(slider, BorderLayout.SOUTH); // 프레임에 추가

        setVisible(true); // 프레임 보이게 설정
    }
    public static void main(String[] args){
        SliderTest frame = new SliderTest("TextArea Practice Frame"); // 프레임 설정
    }
}
