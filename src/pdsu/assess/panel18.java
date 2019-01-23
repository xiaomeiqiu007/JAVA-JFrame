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

    //定义各种属性
    //定义面板
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    //定义中部所需组件；
    private JLabel lbPersonName;
    private JLabel lbBeforAccess;
    private JLabel lbAfterAccess;
    private JLabel lbpersonId;
    //定义底部所需组件
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
        //设置为边界布局
        setLayout(new BorderLayout());
        initTop();
        initCenter();
        initBottom();
        //事件处理利用的是对应的借口，必须重写其中的抽象方法

        btnTure.addActionListener(this);
        btnClear.addActionListener(this);
        tfPersonName.setEditable(false);  //设置id不可编辑
        //设置按钮不可编辑
        btnTure.setEnabled(false);
        tfBeforAccess.setEditable(false);
        lbpersonId=new JLabel();

    }

    //初始化上部
    public void initTop() {
        colTitle = new String[] {"工号","性别","姓名","部门","薪酬","考核信息"};
        colValue = PersonSalary.getAllperson();
        table = new JTable(colValue,colTitle);
        pTop =new JPanel();
        //创建空表格
        //设置表格的默认大小

        table.setPreferredScrollableViewportSize(new Dimension(430, 300));
        table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //获取选中行
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

    //定义上部面板
    public void initCenter() {
        pCenter = new JPanel();
        lbPersonName = new JLabel("姓名");
        tfPersonName = new JTextField(10);


        lbBeforAccess = new JLabel("上次考核");
        lbAfterAccess = new JLabel("本次考核");
        tfBeforAccess = new JTextField(10);

        access[0]="优秀";
        access[1]="合格";
        access[2]="不合格";
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
        btnTure = new JButton("确定");
        btnClear = new JButton("清空");
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
            AccessDao.changeSalary("人员考核",lbpersonId.getText(), tfBeforAccess.getText(), combo.getSelectedItem().toString());
            updateTable();
        }else if(e.getSource()==btnClear){
            tfAfterAccess.setText("");
            btnTure.setEnabled(false);
        }


    }
}
