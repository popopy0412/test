import java.awt.*;
import javax.swing.*;

public class ColorFontTest extends JFrame{

    public ColorFontTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(600, 300); // 프레임 크기 설정

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new GridLayout(4, 1)); // 배치 관리자 설정

        JLabel[] labels = new JLabel[4]; // 라벨 선언
        String[] texts = {"국적: 대한민국(나눔명조 폰트)", "주소: 서울시 노원구(맑은 고딕 폰트)", "성명: 천소현(함초롬바탕 폰트)", "학번: 1714112(함초롬돋움 폰트)"};
        String[] fonts = {"나눔명조", "맑은 고딕", "함초롬바탕", "함초롬돋움"};
        Color[] colors = {Color.RED, Color.CYAN, Color.BLUE, Color.GREEN};
        int[] sizes = {20, 35, 30, 15}; // 표시할 문구들의 글꼴, 색, 크기

        for(int i=0;i<4;i++){
            labels[i] = new JLabel(texts[i]);
            labels[i].setFont(new Font(fonts[i], Font.PLAIN, sizes[i]));
            labels[i].setForeground(colors[i]);
            c.add(labels[i]); // 각 문구들의 폰트를 설정하고 프레임에 추가
        }

        setVisible(true); // 프레임 보이게 설정
    }
    public static void main(String[] args){
        ColorFontTest frame = new ColorFontTest("Color, Font 사용 예제"); // 프레임 생성
    }
}
