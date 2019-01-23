package pdsu.personchange.Dao;

import pdsu.hrms.dao.JDBCUtil;
import pdsu.salary.Dao.PersonSalary;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonChangeDao {
    public static String[][] getAllperson(){
        String[][] str = new String[100][100];
        String[] deptid = new String[100];
        int flag=0;
        try{
            String sql="select * from person";

            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                str[flag][0]=String.valueOf(rs.getInt("personId"));
                str[flag][1]=rs.getString("pName");
                str[flag][2]=rs.getString("sex");
                str[flag][4]=rs.getString("salary");
                str[flag][5]=rs.getString("assess");
                deptid[flag]=String.valueOf(rs.getInt("deptId"));
                flag=flag+1;
            }
            for(int i=0;i<deptid.length;i++){
                String sql1="select dept1Name,dept2Name from dept where deptId=";
                sql1=sql1+deptid[i];
                ResultSet rd =st.executeQuery(sql1);
                while (rd.next()){
                    str[i][3]=rd.getString("dept1Name")+"-"+rd.getString("dept2Name");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
    public static int getDeptId(String dept1Name,String dept2Name){
        int deptId=0;
        try {
            String sql="select deptId from Dept where dept1Name='"+dept1Name+"' and dept2Name='"+dept2Name+"'";
            System.out.println(sql);
            Statement st =JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                deptId=rs.getInt("deptId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return deptId;
    }
    public static String[] getHistId(String histype,String personId){
        String[] str=new String[100];
        str[0]="0";
        str[1]="0";
        try{
            String sql="select max(chgNum) as chgNum from history where histType='"+histype+"' and personId="+personId;
            String sql1="select max(histId) from history";
            Statement st =JDBCUtil.getConnection();
            System.out.print(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                str[0]=rs.getString("chgNum");
            }
            ResultSet rd = st.executeQuery(sql1);
            while (rd.next()){
                str[1]=String.valueOf(rd.getInt("max(histId)")+1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(str[0]==null){
            str[0]="1";
        }else {
            str[0]=String.valueOf(Integer.valueOf(str[0])+1);
        }
        return str;
    }
    public static int changeDept(String changeType, String personid, String polddept, String pnewdept){
        int flag=0;
        try{
            int poldDeptid=PersonChangeDao.getDeptId(polddept.substring(0,3),polddept.substring(4));
            String[] str =new String[100];


            str=PersonChangeDao.getHistId(changeType,personid);
            System.out.println(str[2]);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String sql ="update  person set deptId='"+pnewdept+"' where personId="+personid;
            String sql2="insert into history values("+str[1]+",'"+changeType+"','"+poldDeptid+"','"+pnewdept+"','"+df.format(new Date())+"','"+str[0]+"',"+personid+")";
            Statement st = JDBCUtil.getConnection();
            System.out.print(sql);
            flag=st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "修改成功", "人员调动成功", JOptionPane.WARNING_MESSAGE);
            try {
                System.out.print(sql2);
                st.executeUpdate(sql2);
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static String[][] getAllHistory(){
        String[][] str =new String[100][100];
        int flag=0;
        String[] str1 = new String[10];
        String[] str2 =new String[10];
        String[] str3 =new String[10];
        try{
            String sql ="select * from history where histType='人员调动'";
            Statement st =JDBCUtil.getConnection();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()){
                str[flag][0]=String.valueOf(rs.getInt("histid"));
                str1[flag]=rs.getString("personId");
                str2[flag]=rs.getString("oldInfo");
                str3[flag]=rs.getString("newInfo");
                str[flag][4]=rs.getString("chgNum");
                str[flag][5]=String.valueOf(rs.getString("chgDate"));
                flag=flag+1;
            }
            for(int i=0;i<str1.length;i++){
                String sql2 = "select pName from person where personid="+str1[i];
                String sql3 ="select dept1Name,dept2Name from Dept where deptId="+str2[i];
                String sql4 ="select dept1Name,dept2Name from Dept where deptId="+str3[i];
                ResultSet rd =st.executeQuery(sql2);
                while (rd.next()){
                    str[i][1]=rd.getString("pName");
                }
                ResultSet re =st.executeQuery(sql3);
                while (re.next()){
                    str[i][2]=re.getString("dept1Name")+"-"+re.getString("dept2Name");
                }
                ResultSet rf = st.executeQuery(sql4);
                while (rf.next()){
                    str[i][3]=rf.getString("dept1Name")+"-"+rf.getString("dept2Name");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
