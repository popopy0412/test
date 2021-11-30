import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class ThreadEx extends JFrame{

    private MyThread thread = new MyThread(); // 스레드
    private boolean isEntered = false; // 마우스가 패널에 올라갔는지
    private int x, y, a, b; // 타원의 x, y좌표와 가로 세로 반경
    public ThreadEx(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setContentPane(thread.panel);
        setSize(500, 500); // 프레임 크기 설정

        thread.start();
        setVisible(true); // 프레임 보이게 설정
    }

    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            if(isEntered) { // 마우스가 올라가 있으면
                try {
                    Thread.sleep(300); // 기다렸다가
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Random rand = new Random();
                super.paintComponent(g);
                g.setColor(Color.MAGENTA);
                x = rand.nextInt(this.getWidth() - 100); // 랜덤 x좌표
                y = rand.nextInt(this.getHeight() - 100); // 랜덤 y좌표
                a = rand.nextInt(this.getWidth() / 2 - 150) + 50; // 랜덤 가로 반경
                b = rand.nextInt(this.getHeight() / 2 - 150) + 50; // 랜덤 세로 반경
                g.fillOval(x, y, a, b); // 타원 그림
            }
        }
    }

    class MyThread extends Thread{
        private MyPanel panel = new MyPanel(); // 타원이 들어갈 패널
        public MyThread(){
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) { // 마우스가 올라가면 true
                    isEntered = true;
                }

                @Override
                public void mouseExited(MouseEvent e) { // 내려가면 false
                    isEntered = false;
                }
            });
        }
        @Override
        public void run() {
            while(true){
                panel.repaint(); // 스레드 동작동안 repaint
            }
        }
    }
    public static void main(String[] args){
        ThreadEx frame = new ThreadEx("Make Drawing"); // 프레임 생성
    }
}
