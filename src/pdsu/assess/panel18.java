package pdsu.assess;

import pdsu.assess.Dao.AccessDao;
import pdsu.salary.Dao.PersonSalary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class panel18 extends JPanel implements ActionListener {

    //�����������
    //�������
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    //�����в����������
    private JLabel lbPersonName;
    private JLabel lbBeforAccess;
    private JLabel lbAfterAccess;
    private JLabel lbpersonId;
    //����ײ��������
    private JComboBox combo;
    private JButton btnTure;
    private JButton btnClear;
    private JTextField tfPersonName;
    private JTextField tfBeforAccess;
    private JTextField tfAfterAccess;
    private String[][] colValue ;
    private String[] colTitle;
    private String[] access =new String[4];

    public panel18() {
        //����Ϊ�߽粼��
        setLayout(new BorderLayout());
        initTop();
        initCenter();
        initBottom();
        //�¼��������õ��Ƕ�Ӧ�Ľ�ڣ�������д���еĳ��󷽷�

        btnTure.addActionListener(this);
        btnClear.addActionListener(this);
        tfPersonName.setEditable(false);  //����id���ɱ༭
        //���ð�ť���ɱ༭
        btnTure.setEnabled(false);
        tfBeforAccess.setEditable(false);
        lbpersonId=new JLabel();

    }

    //��ʼ���ϲ�
    public void initTop() {
        colTitle = new String[] {"����","�Ա�","����","����","н��","������Ϣ"};
        colValue = PersonSalary.getAllperson();
        table = new JTable(colValue,colTitle);
        pTop =new JPanel();
        //�����ձ��
        //���ñ���Ĭ�ϴ�С

        table.setPreferredScrollableViewportSize(new Dimension(430, 300));
        table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //��ȡѡ����
                btnTure.setEnabled(true);
                int row = table.getSelectedRow();
                lbpersonId.setText(colValue[row][0]);
                System.out.println(lbpersonId.getText());
                tfPersonName.setText(colValue[row][1]);
                tfBeforAccess.setText(colValue[row][5]);

            }
        });
        js = new JScrollPane(table);
        js.setPreferredSize(new Dimension(480, 300));
        pTop.add(js);
        add(pTop,BorderLayout.NORTH);
    }

    //�����ϲ����
    public void initCenter() {
        pCenter = new JPanel();
        lbPersonName = new JLabel("����");
        tfPersonName = new JTextField(10);


        lbBeforAccess = new JLabel("�ϴο���");
        lbAfterAccess = new JLabel("���ο���");
        tfBeforAccess = new JTextField(10);

        access[0]="����";
        access[1]="�ϸ�";
        access[2]="���ϸ�";
        combo = new JComboBox(access);
        pCenter.add(lbPersonName);
        pCenter.add(tfPersonName);
        pCenter.add(lbBeforAccess);
        pCenter.add(tfBeforAccess);
        pCenter.add(lbAfterAccess);
        pCenter.add(combo);

        add(pCenter,BorderLayout.CENTER);
    }
    public void initBottom() {
        pBottom = new JPanel();
        btnTure = new JButton("ȷ��");
        btnClear = new JButton("���");
        pBottom.add(btnTure);
        pBottom.add(btnClear);
        add(pBottom, BorderLayout.SOUTH);
    }
    public void updateTable(){
        colValue = PersonSalary.getAllperson();
        DefaultTableModel tableModel = new DefaultTableModel(colValue,colTitle);
        table.setModel(tableModel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnTure){
            AccessDao.changeSalary("��Ա����",lbpersonId.getText(), tfBeforAccess.getText(), combo.getSelectedItem().toString());
            updateTable();
        }else if(e.getSource()==btnClear){
            tfAfterAccess.setText("");
            btnTure.setEnabled(false);
        }


    }
}
