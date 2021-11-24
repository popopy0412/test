import java.awt.*;
import javax.swing.*;

public class ImageTest extends JFrame{

    public ImageIcon icon = new ImageIcon("image.jpg"); // 이미지 가져옴
    public Image image = icon.getImage(); // 이미지 가져옴
    public MyPanel panel = new MyPanel(); // 그림을 그릴 패널
    public ImageTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(810, 543); // 프레임 크기 설정
        setContentPane(panel); // ContentPane을 panel로 설정
        setVisible(true); // 프레임 보이게 설정
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image, 0, 0, 400, 266, 0, 0, 400, 266, this);
            g.drawImage(image, 410, 0, 810, 266, 400, 0, 800, 266, this);
            g.drawImage(image, 0, 276, 400, 543, 0, 266, 400, 533, this);
            g.drawImage(image, 410, 276, 810, 543, 400, 266, 800, 533, this); // 사진 그리기
        }
    }
    public static void main(String[] args){
        ImageTest frame = new ImageTest("그래픽 이미지 연습"); // 프레임 생성
    }
}