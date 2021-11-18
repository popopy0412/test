import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame{

    int idx = -1;
    public ListTest(String title){
        super(title); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 조건 설정
        setSize(400, 300); // 사이즈 설정

        Container c = getContentPane(); // ContentPane 가져옴
        c.setLayout(new BorderLayout()); // 배치 관리자 설정

        Vector<String> v = new Vector<>(); // JList에 저장할 벡터
        JTextField text = new JTextField(); // String을 입력할 텍스트 필드
        JList<String> list = new JList<>(v); // 입력한 값들을 저장할 JList
        JTextField mod = new JTextField(20); // 수정 및 삭제시 사용할 텍스트 필드
        JButton b1 = new JButton("수정");
        JButton b2 = new JButton("삭제"); // 버튼들
        JPanel panel = new JPanel(); // mod, b1, b2를 담을 패널
        panel.add(mod); panel.add(b1); panel.add(b2); // 패널에 컴포넌트들 추가

        c.add(text, BorderLayout.NORTH);
        c.add(list, BorderLayout.CENTER);
        c.add(panel, BorderLayout.SOUTH); // 컴포넌트들 추가
        c.add(new JScrollPane(list));
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // 텍스트 필드에 값 입력시
                String s = (String)e.getActionCommand();
                v.add(s);
                list.setListData(v); // 리스트에 문자열 추가
                text.setText(""); // 문자열 초기화

            }
        });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 하나만 선택될 수 있도록
        b1.addActionListener(new ActionListener() { // 수정 버튼 입력 시
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idx != -1) {
                    v.set(idx, mod.getText());
                    list.setListData(v); // 바꾼 값으로 수정
                }
            }
        });
        b2.addActionListener(new ActionListener() { // 삭제 버튼 입력 시
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idx != -1) {
                    v.remove(idx);
                    v.trimToSize();
                    list.setListData(v); // 값 삭제
                }
            }
        });
        class ListListener implements ListSelectionListener {
            @Override
            public void valueChanged(ListSelectionEvent e) { // 리스트에서 선택했을 때
                String name = (String) list.getSelectedValue(); // 선택된 문자열
                idx = list.getSelectedIndex(); // 선택된 문자열의 인덱스
                if(idx != -1){
                    mod.requestFocus(); // 수정하는 텍스트 필드로 포커스를 옮김
                    mod.setText(name); // 선택한 문자열로 텍스트 필드 초기화
                }
            }
        }
        list.addListSelectionListener(new ListListener()); // ListSelectionListener 추가

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String[] args){
        ListTest frame = new ListTest("리스트 테스트"); // 프레임 생성
    }

}
