import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame{

    public FontTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(300, 300); // 프레임 사이즈 설정

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자 설정

        String[] w = {"Font 설정", "Style 설정", "Size 설정", "Text 내용"};
        String[] font = {"굴림", "돋움", "궁서"};
        String[] style = {"BOLD", "ITALIC"};
        JPanel west = new JPanel(new GridLayout(4, 1));
        JPanel center = new JPanel(new GridLayout(4, 1));
        JPanel south = new JPanel();
        JPanel c1 = new JPanel();
        JPanel c2 = new JPanel();
        JRadioButton[] radio = new JRadioButton[3];
        JCheckBox[] check = new JCheckBox[2];
        JLabel result = new JLabel("Hello World!");
        result.setFont(new Font(font[0], Font.PLAIN, 20));

        JTextField size = new JTextField(), text = new JTextField();
        size.setFocusable(true); text.setFocusable(true);
        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setFont(result.getFont().deriveFont(Float.parseFloat(size.getText())));
            }
        });

        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(text.getText());
            }
        });
        ButtonGroup fonts = new ButtonGroup();

        for(String str : w) west.add(new JLabel(str));
        for(int i=0;i<3;i++) {
            radio[i] = new JRadioButton(font[i]);
            c1.add(radio[i]);
            fonts.add(radio[i]);
            radio[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = e.getActionCommand();
                    for(int i=0;i<3;i++) {
                        if (s.equals(radio[i].getText())) {
                            result.setFont(new Font(radio[i].getText(), result.getFont().getStyle(), result.getFont().getSize()));
                        }
                    }
                }
            });
            if(i == 0) radio[i].setSelected(true);
        }
        center.add(c1);
        for(int i=0;i<2;i++){
            check[i] = new JCheckBox(style[i]);
            c2.add(check[i]);
            check[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JCheckBox temp = (JCheckBox) e.getItem();
                    if(temp.isSelected()){
                        if(temp.getText().equals("BOLD")) result.setFont(new Font(result.getFont().getFontName(), result.getFont().getStyle() + Font.BOLD, result.getFont().getSize()));
                        if(temp.getText().equals("ITALIC")) result.setFont(new Font(result.getFont().getFontName(), result.getFont().getStyle() + Font.ITALIC, result.getFont().getSize()));
                    }
                    else{
                        if(temp.getText().equals("BOLD")) result.setFont(new Font(result.getFont().getFontName(), result.getFont().getStyle() - Font.BOLD, result.getFont().getSize()));
                        if(temp.getText().equals("ITALIC")) result.setFont(new Font(result.getFont().getFontName(), result.getFont().getStyle() - Font.ITALIC, result.getFont().getSize()));
                    }
                }
            });
        }
        center.add(c2);
        center.add(size); center.add(text);

        Border resultBorder = BorderFactory.createTitledBorder("Font 설정 결과");
        south.setBorder(resultBorder);

        south.add(result);

        c.add(west, BorderLayout.WEST);
        c.add(center, BorderLayout.CENTER);
        c.add(south, BorderLayout.SOUTH);


        setVisible(true);
    }

    public static void main(String[] args){
        FontTest frame = new FontTest("Font 설정"); // 프레임 생성
    }
}
