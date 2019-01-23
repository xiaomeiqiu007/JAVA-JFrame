package pdsu.salary;

import pdsu.hrms.dao.DeptDao;
import pdsu.salary.Dao.PersonSalary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class panel20 extends JPanel implements ActionListener {

    //定义各种属性
    //定义面板
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    //定义中部所需组件；
    private JLabel lbPersonName;
    private JLabel lbBeforSalary;
    private JLabel lbAfterSalary;
    private JLabel lbpersonId;
    //定义底部所需组件

    private JButton btnTure;
    private JButton btnClear;
    private JTextField tfPersonName;
    private JTextField tfBeforSalary;
    private JTextField tfAfterSalary;
    private String[][] colValue ;
    private String[] colTitle;

    public panel20() {
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
        tfBeforSalary.setEditable(false);
        tfAfterSalary.setEditable(true);
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
                tfBeforSalary.setText(colValue[row][4]);

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


        lbBeforSalary = new JLabel("调整前的工资");
        tfBeforSalary = new JTextField(10);

        lbAfterSalary = new JLabel("调整后的工资");
        tfAfterSalary = new JTextField(10);
        pCenter.add(lbPersonName);
        pCenter.add(tfPersonName);
        pCenter.add(lbBeforSalary);
        pCenter.add(tfBeforSalary);
        pCenter.add(lbAfterSalary);
        pCenter.add(tfAfterSalary);

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
            PersonSalary.changeSalary("劳资分配",lbpersonId.getText(),tfBeforSalary.getText(),tfAfterSalary.getText());
            updateTable();
        }else if(e.getSource()==btnClear)
        tfAfterSalary.setText("");

    }
}
