import java.awt.*;
import javax.swing.*;

public class ImageTest extends JFrame{

    private ImageIcon icon = new ImageIcon("image.jpg"); // 이미지 가져옴
    private Image image = icon.getImage(); // 이미지 가져옴
    private MyPanel panel = new MyPanel(); // 그림을 그릴 패널
    private int X, Y; // 사진의 너비와 높이
    public ImageTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setContentPane(panel); // ContentPane을 panel로 설정
        X = icon.getIconWidth(); Y = icon.getIconHeight();
        setSize(X+10, Y+10); // 프레임 크기 설정
        setVisible(true); // 프레임 보이게 설정
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image, 0, 0, X/2, Y/2, 0, 0, X/2, Y/2, this);
            g.drawImage(image, X/2+10, 0, X+10, Y/2, X/2, 0, X, Y/2, this);
            g.drawImage(image, 0, Y/2+10, X/2, Y+10, 0, Y/2, X/2, Y, this);
            g.drawImage(image, X/2+10, Y/2+10, X+10, Y+10, X/2, Y/2, X, Y, this); // 사진 그리기
        }
    }
    public static void main(String[] args){
        ImageTest frame = new ImageTest("그래픽 이미지 연습"); // 프레임 생성
    }
}