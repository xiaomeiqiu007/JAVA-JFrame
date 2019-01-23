package pdsu.hrms;

import pdsu.hrms.dao.PersonDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class panel12 extends JPanel implements ActionListener {
    //JPanel pTitle;  //标题区域面板
    JPanel pTop;  //添加人员信息内容区域面板
    JPanel pCenter;
    JPanel pBottom;
    JPanel pContent;

    JScrollPane js;   //添加人员信息所在的滚动面板

    JTextField tfPersonId;  //人员编号
    JTextField tfName;  //姓名
    JTextField tfSex;   //性别
    JTextField tfBirth;  //出生日期
    JTextField tfNat;    //民族
    JTextField tfAddress; //地址
    JTextField tfOther;   //其他说明

    private JComboBox<String> comboPname;  //人员信息

    JButton btnUpdate;  //增加
    JButton btnClear; //清空
    private int nextPersonId;
    private String personInfo[] =PersonDao.getAllPersonName();

    public panel12() {
        //ptop设置为网格包布局
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints cons = null;
        setLayout(gridBag);

        //添加标题
        JLabel lbTitle = new JLabel("修改人员信息");
        lbTitle.setFont(new Font("宋体",0,15));
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        gridBag.setConstraints(lbTitle, cons);
        add(lbTitle);

        //添加内容区域
        initContent();  //初始化添加人员信息区域
        js = new JScrollPane(pTop);
        js.setPreferredSize(new Dimension(510, 390));
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        gridBag.setConstraints(js, cons);
        add(js);
        //添加监听
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        comboPname.addActionListener(this);
        //设置人员信息
        nextPersonId=PersonDao.getNextId();
        tfPersonId.setText(String.valueOf(nextPersonId));
        //设置默认显示模式
        intitView();
    }
    public void  intitView(){
        btnUpdate.setEnabled(false);
        tfPersonId.setText("请查询人员编号");
        tfPersonId.setEditable(false);
        tfName.setEditable(false);
        tfSex.setEditable(false);
        tfBirth.setEditable(false);
        tfNat.setEditable(false);
        tfAddress.setEditable(false);
        tfOther.setEditable(false);
    }
    public void initContent() {
        //创建内容面板并设置布局方式
        pTop = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        pTop.setLayout(layout);

        GridBagConstraints cons = null;

        //添加第1行组件（人员编号标签、人员编号文本框、人员姓名标签、人员姓名文本框）
        //人员编号标签
        JLabel lbPersonId = new JLabel("人员编号");
        //lbPersonId.setFont(new Font("宋体",0,12));
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.insets = new Insets(10,10,10,1);//上左下右间距
        layout.setConstraints(lbPersonId, cons);
        pTop.add(lbPersonId);
        //人员编号文本框
        tfPersonId = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.insets = new Insets(10,1,10,15);
        layout.setConstraints(tfPersonId, cons);
        pTop.add(tfPersonId);
        //人员姓名标签
        JLabel lbName = new JLabel("人员姓名");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbName, cons);
        pTop.add(lbName);
        //人员姓名文本框
        tfName = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 0;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfName, cons);
        pTop.add(tfName);

        //添加第2行组件（性别标签、性别文本框、出生年月标签、出生年月文本框）
        //性别标签
        JLabel lbSex = new JLabel("性  别");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.insets = new Insets(10,10,10,1);
        layout.setConstraints(lbSex, cons);
        pTop.add(lbSex);
        //性别文本框
        tfSex = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.insets = new Insets(10,1,10,15);
        cons.gridwidth  = 3;
        cons.anchor = GridBagConstraints.WEST;
        layout.setConstraints(tfSex, cons);
        pTop.add(tfSex);
        //出生年月标签
        JLabel lbBirth = new JLabel("出生年月");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 1;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbBirth, cons);
        pTop.add(lbBirth);
        //出生年月文本框
        tfBirth = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 1;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfBirth, cons);
        pTop.add(tfBirth);

        //添加第3行组件（民族标签、民族文本框、地址标签、地址文本框）
        //民族标签
        JLabel lbNat = new JLabel("民  族");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.insets = new Insets(10,10,10,1);
        layout.setConstraints(lbNat, cons);
        pTop.add(lbNat);
        //民族文本框
        tfNat = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.insets = new Insets(10,1,10,15);
        layout.setConstraints(tfNat, cons);
        pTop.add(tfNat);
        //地址标签
        JLabel lbAddress = new JLabel("地  址");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 2;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbAddress, cons);
        pTop.add(lbAddress);
        //地址文本框
        tfAddress = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 2;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfAddress, cons);
        pTop.add(tfAddress);

        //添加第4行组件（其他标签、其他文本框）

        //其他标签
        JLabel lbOther = new JLabel("其  他");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbOther, cons);
        pTop.add(lbOther);
        //其他文本框
        tfOther = new JTextField(30);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfOther, cons);
        pTop.add(tfOther);

        //添加第5行组件（选择人员信息，选择人员下拉按钮，增加按钮、清空按钮）
        //选择人员信息
        JLabel lbSelect = new JLabel("选择人员信息");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbSelect, cons);
        pTop.add(lbSelect);
        //选择人员信息combox
        comboPname = new JComboBox<String>(personInfo);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth=2;
        cons.insets = new Insets(10,1,10,100);
        layout.setConstraints(comboPname, cons);
        pTop.add(comboPname);
        //修改按钮
        btnUpdate = new JButton("修改");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.insets = new Insets(10,10,10,10);
        layout.setConstraints(btnUpdate, cons);
        pTop.add(btnUpdate);
        //清空
        btnClear = new JButton("清空");
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.insets = new Insets(10,10,10,10);
        layout.setConstraints(btnClear, cons);
        pTop.add(btnClear);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnUpdate){
            PersonDao.updatePerson(tfPersonId.getText(),tfName.getText(),tfSex.getText(),tfBirth.getText(),tfNat.getText(),tfAddress.getText(),tfOther.getText());
        }else if (e.getSource()==btnClear){
            tfAddress.setText("");
            tfBirth.setText("");
            tfName.setText("");
            tfNat.setText("");
            tfOther.setText("");
            tfSex.setText("");
        }else if(e.getSource()==comboPname){
            //设置点击时获取输入框的内容
            String[] str = new  String[110];
            str=PersonDao.getAllPerson(comboPname.getSelectedItem().toString().substring(0,1));
            tfName.setText(str[0]);
            tfSex.setText(str[1]);
            tfBirth.setText(str[2]);
            tfNat.setText(str[3]);
            tfAddress.setText(str[4]);
            tfOther.setText(str[5]);
            //设置默认按钮显示
            tfPersonId.setText(comboPname.getSelectedItem().toString().substring(0,1));
            tfName.setEditable(true);
            tfSex.setEditable(true);
            tfBirth.setEditable(true);
            tfNat.setEditable(true);
            tfAddress.setEditable(true);
            tfOther.setEditable(true);
            btnUpdate.setEnabled(true);
        }else if(e.getSource()==btnClear){
            intitView();
        }
    }
}
