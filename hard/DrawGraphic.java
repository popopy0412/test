import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGraphic extends JFrame{

    private int status = 0; // 그리는 도형의 모양
    private int i;
    private int x1, y1, x2, y2; // 마우스의 시작점, 끝점
    private Color color; // 그리는 도형의 색
    private MyPanel panel = new MyPanel(); // 도형이 그려지는 패널
    public DrawGraphic(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(500, 500); // 프레임 크기 설정

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자 설정

        String[] name = {"선", "삼각형", "사각형", "원", "색 선택"};
        JToolBar bar = new JToolBar("toolbar"); // 툴바
        JButton[] btn = new JButton[5];
        bar.add(new JLabel("도형"));
        for(i=0;i<5;i++){
            btn[i] = new JButton(name[i]);
            bar.add(btn[i]);
        }
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = 1;
            }
        });
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = 2;
            }
        });
        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = 3;
            }
        });
        btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = 4;
            }
        }); // 각 버튼마다 어떤 도형을 그릴지 저장해주는 액션 리스너
        btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // 색 선택
                color = JColorChooser.showDialog(null, "Color", Color.RED);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // 클릭했을 때 첫 좌표
                x1 = e.getX();
                y1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) { // 마우스를 뗐을 때 좌표
                x2 = e.getX();
                y2 = e.getY();
                panel.repaint();
            }
        });
        c.add(bar, BorderLayout.NORTH); // 툴바 추가
        c.add(panel, BorderLayout.CENTER); // 패널 추가
        setVisible(true); // 프레임 보이게 설정
    }

    class MyPanel extends JPanel{ // 그림 그리는 패널
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(color);
            int xmin = Math.min(x1, x2);
            int xmax = Math.max(x1, x2);
            int ymin = Math.min(y1, y2);
            int ymax = Math.max(y1, y2);
            int xdiff = Math.abs(x1-x2);
            int ydiff = Math.abs(y1-y2); // 도형 그리는데 필요한 좌표 활용 값들
            switch(status){
                case 1:{ // 선
                    g.drawLine(x1, y1, x2, y2);
                    break;
                }
                case 2:{ // 삼각형
                    int[] xPoints = {x1, x2, 2*xmin - xmax};
                    int[] yPoints = {y1, y2, ymax};
                    g.drawPolygon(xPoints, yPoints, 3);
                    break;
                }
                case 3:{ // 사각형
                    g.drawRect(xmin, ymin, xdiff, ydiff);
                    break;
                }
                case 4:{ // 원
                    g.drawOval(xmin, ymin, xdiff, ydiff);
                    break;
                }
                default: break;
            }
        }
    }
    public static void main(String[] args){
        DrawGraphic frame = new DrawGraphic("그래픽 그리기"); // 프레임 생성
    }
}
