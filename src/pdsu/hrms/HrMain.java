package pdsu.hrms;

import pdsu.assess.panel18;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class HrMain extends JFrame implements TreeSelectionListener{
	//����ָ����
	public static JSplitPane splitPane; 
	//���˵�
	private JTree tree;
	private DefaultMutableTreeNode root;
	JPanel pWelcome;
	public  HrMain(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�ʱ�˳�
		setSize(700,450);//��С
		setLocationRelativeTo(null);//����
		setResizable(false);//���ɵ���С
		setTitle("���¹���");
		//����ͼ��
		//1���ҵ��ļ�λ��
		URL url =getClass().getClassLoader().getResource("1.PNG");
		//2������ͼƬ������
		Image image=Toolkit.getDefaultToolkit().getImage(url);
		//3��ͼƬ����Ϊ����ͼ��
		setIconImage(image);
		init();//���ó�ʼ������
		
		
		setVisible(true);
	}
	public void init() {
		//��ʼ�����
		splitPane =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(150);//�ָ���λ�����150
		splitPane.setContinuousLayout(true);//�ָ��������䶯
		splitPane.setDividerSize(2);//�ָ������
		//��Ӳ����õ����
		splitPane.setLeftComponent(new Button("left"));
		splitPane.setRightComponent(new Button("��ӭ�������¹���ϵͳ"));
		
		//��ʼ�����˵�DefaultMutableTreeNode
		root =new DefaultMutableTreeNode("���¹���ϵͳ");
		DefaultMutableTreeNode node1=
				new DefaultMutableTreeNode("������Ϣ����");
		DefaultMutableTreeNode node2=
				new DefaultMutableTreeNode("��Ա��������");
		DefaultMutableTreeNode node3=
				new DefaultMutableTreeNode("��Ա���˹���");
		DefaultMutableTreeNode node4=
				new DefaultMutableTreeNode("���ʹ���");
		
		DefaultMutableTreeNode leafNode= null;
		//��ӻ�����Ϣ
		//DefaultMutableTreeNode leafNode= null;
		node1.add(new DefaultMutableTreeNode("�����Ա��Ϣ"));
		node1.add(new DefaultMutableTreeNode("ɾ����Ա��Ϣ"));
		node1.add(new DefaultMutableTreeNode("�޸���Ա��Ϣ"));
		node1.add(new DefaultMutableTreeNode("��ѯ��Ա��Ϣ"));
		node1.add(new DefaultMutableTreeNode("���Ź���"));
		
		node2.add(new DefaultMutableTreeNode("��Ա����"));
		node2.add(new DefaultMutableTreeNode("������ʷ��ѯ"));
		
		node3.add(new DefaultMutableTreeNode("��Ա����"));
		node3.add(new DefaultMutableTreeNode("������ʷ��ѯ"));
		
		node4.add(new DefaultMutableTreeNode("���ʷ������"));
		node4.add(new DefaultMutableTreeNode("������ʷ��ѯ"));
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		
		//�����˵���ӵ�������
		tree =new JTree(root);
		tree.addTreeSelectionListener(this);
		//splitPane.setLeftComponent(new JScrollPane(tree));
		//������ͨ��壬����ӹ������
		JPanel pLeft =new JPanel();
		JScrollPane js= new JScrollPane(tree);
		js.setPreferredSize(new Dimension(140,410));
		pLeft.add(js);
		
		splitPane.setLeftComponent(pLeft);
		//���뵽������
		//�Ҳ໶ӭ����
		pWelcome= new JPanel();
		JLabel lbWecome=new JLabel("��ӭʹ�����¹���ϵͳ");
		lbWecome.setFont(new Font("����", Font.PLAIN,16));
	
		
		add(splitPane);
		
	}
	public static void main(String[] args) {
		//�޸ĳ������
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new HrMain();
	}
	//�����˵������¼�����
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getPath());
		//System.out.println(e.getPath().getLastPathComponent());
		String menuStr=e.getPath().getLastPathComponent().toString();
		//System.out.println(menuStr);
		switch(menuStr) {
		//������ڵ�
		case"���¹���ϵͳ": break;
		case"��Ա��������":break;
		case"��Ա���˹���":break;
		case"�����Ա��Ϣ": splitPane.setRightComponent(new panel11());break;
		case "�޸���Ա��Ϣ":splitPane.setRightComponent(new panel12());break;
		case "ɾ����Ա��Ϣ": splitPane.setRightComponent(new panel13());break;
		case "��ѯ��Ա��Ϣ": splitPane.setRightComponent(new pdsu.hrms.panel14());break;
		case"���Ź���": splitPane.setRightComponent(new pdsu.hrms.panel15());break;
		case "���ʷ������": splitPane.setRightComponent(new pdsu.salary.panel20());break;
		case"������ʷ��ѯ": splitPane.setRightComponent(new pdsu.salary.panel21());break;
		case "��Ա����": splitPane.setRightComponent(new pdsu.assess.panel18());break;
		case "������ʷ��ѯ":splitPane.setRightComponent(new pdsu.assess.panel19());break;
		case "��Ա����":splitPane.setRightComponent(new pdsu.personchange.panl16());break;
		case "������ʷ��ѯ":splitPane.setRightComponent(new pdsu.personchange.panl17());break;
		}
	
	}

}
