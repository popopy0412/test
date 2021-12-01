import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTest extends JFrame{

    private JFileChooser ch = new JFileChooser();
    private JLabel label = new JLabel("text");
    public SwingTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(300, 300); // 프레임 크기 설정

        MyDialog d = new MyDialog(this,"폰트");
        d.setVisible(false);
        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자 설정

        label.setToolTipText("편집에 따라 변경될 영역입니다."); // 툴팁
        label.setHorizontalAlignment(JLabel.HORIZONTAL); // 가운데 정렬

        c.add(label, BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar(); // 메뉴가 들어갈 메뉴바

        JMenu[] menus = new JMenu[3]; // 메뉴 3개 생성
        JMenuItem[][] item = new JMenuItem[3][];
        int[] num = {3, 3, 1};
        String[] str = {"파일", "편집", "도움말"};
        String[][] mstr = {{"열기", "저장", "종료"}, {"색 선택", "폰트", "텍스트 변경"}, {"버전 정보"}}; // 메뉴 아이템과 그 정보들

        for(int i=0;i<3;i++){
            menus[i] = new JMenu(str[i]);
            item[i] = new JMenuItem[num[i]];
            for(int j=0;j<num[i];j++){
                item[i][j] = new JMenuItem(mstr[i][j]);
                if(i == 0 && j == 2) menus[i].addSeparator();
                menus[i].add(item[i][j]);
            }
            bar.add(menus[i]); // 메뉴 생성 후 메뉴바에 추가
        }

        item[0][0].addActionListener(new ActionListener() { // '파일 - 열기' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = ch.showOpenDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION){
                    String pathName = ch.getSelectedFile().getPath();
                    label.setText(pathName + " 파일이 선택되었습니다.");
                }
            }
        });

        item[0][1].addActionListener(new ActionListener() { // '파일 - 저장' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = ch.showSaveDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION){
                    String pathName = ch.getSelectedFile().getPath();
                    label.setText(pathName + " 파일에 저장되었습니다.");
                }
            }
        });

        item[0][2].addActionListener(new ActionListener() { // '파일 - 종료' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(c, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        item[1][0].addActionListener(new ActionListener() { // '편집 - 색 선택' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "색상 선택", Color.RED);
                label.setForeground(color);
            }
        });

        item[1][1].addActionListener(new ActionListener() { // '편집 - 폰트' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(true);

            }
        });

        item[1][2].addActionListener(new ActionListener() { // '편집 - 텍스트 변경' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = JOptionPane.showInputDialog(c, "변경할 텍스트를 입력하세요", "입력", JOptionPane.QUESTION_MESSAGE);
                if(content != null){
                    label.setText(content);
                }
            }
        });

        item[2][0].addActionListener(new ActionListener() { // '도움말 - 버전 정보' 메뉴
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(c, "테스트 v1.0", "버전 정보", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        c.add(bar, BorderLayout.NORTH);
        for(int i=0;i<3;i++){

        }



        setVisible(true); // 프레임 보이게 설정
    }

    class MyDialog extends JDialog{
        private int st = 0; // 폰트 스타일
        public MyDialog(JFrame frame, String title){
            super(frame, title, true); // 제목 설정(모달)
            setSize(250, 200); // 프레임 사이즈 설정

            Container c = getContentPane(); // ContentPane 가져옴
            c.setLayout(new BorderLayout()); // 배치 관리자 설정

            String[] w = {"폰트 종류", "폰트 스타일", "폰트 크기"};
            String[] font = {"굴림", "돋움", "고딕", "명조"};
            String[] style = {"BOLD", "ITALIC"};
            JPanel west = new JPanel(new GridLayout(3, 1));
            JPanel center = new JPanel(new GridLayout(3, 1));
            JButton btn = new JButton("확인");
            JComboBox<String> cb = new JComboBox<>();
            JPanel c1 = new JPanel();
            JPanel c2 = new JPanel();
            JTextField tf = new JTextField();
            JCheckBox[] check = new JCheckBox[2]; // 다이얼로그를 구성하는 컴포넌트들

            for(String str : font) cb.addItem(str);
            for(String str : w) west.add(new JLabel(str));

            center.add(cb);
            for(int i=0;i<2;i++){
                check[i] = new JCheckBox(style[i]);
                c2.add(check[i]);
                check[i].addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) { // 각 체크박스가 선택되었을 때 폰트 스타일 변경
                        JCheckBox temp = (JCheckBox) e.getItem();
                        if(temp.isSelected()){
                            if(temp.getText().equals("BOLD")) st += Font.BOLD;
                            if(temp.getText().equals("ITALIC")) st += Font.ITALIC;
                        }
                        else{
                            if(temp.getText().equals("BOLD")) st -= Font.BOLD;
                            if(temp.getText().equals("ITALIC")) st -= Font.ITALIC;
                        }
                    }
                });
            }
            center.add(c2);
            center.add(tf);

            c1.add(btn);
            c.add(west, BorderLayout.WEST);
            c.add(center, BorderLayout.CENTER);
            c.add(c1, BorderLayout.SOUTH);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { // 확인 버튼을 눌렀을 때 입력한 값들로 폰트 설정 후 종료
                    String ft = (String)cb.getSelectedItem();
                    label.setFont(label.getFont().deriveFont(st));
                    float size = Float.parseFloat(tf.getText());
                    label.setFont(label.getFont().deriveFont(size));
                    setVisible(false);
                }
            });
        }
    }
    public static void main(String[] args){
        SwingTest frame = new SwingTest("Menu 만들기 예제"); // 프레임 생성
    }
}
