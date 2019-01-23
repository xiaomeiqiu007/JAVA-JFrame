package pdsu.hrms.dao;

import pdsu.hrms.model.Person;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao {
    public static int getNextId(){
        int flag=0;
        try{
            String sql="select max(personId) from person";
            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                flag=rs.getInt("max(personId)");
            }
        }catch (Exception e){
            System.out.print("执行出错");
        }
        return flag+1;
    }
    public static String[] getAllPersonName(){
        String[] str = new String[100];
        int flag=0;
        try{
            String sql="select pName from person";
            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                str[flag]=String.valueOf(flag+1)+"-"+rs.getString("pName");
                flag=flag+1;
            }
        }catch (Exception e){
            System.out.print("执行出错");
        }
        return str;
    }
    public static String[] getAllDeptInfo(){
        String[] str = new String[100];
        int flag=0;
        try{
            String sql="select deptId,dept1Name,dept2Name from dept";
            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                str[flag]=rs.getInt("deptId")+"-"+rs.getString("dept1Name")+"-"+rs.getString("dept2Name");
                flag=flag+1;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("查询dept失败");
        }
        return str;
    }
    public static int addPerson(String personid, String pname, String sex, String nat, String address, String birth, String deptid,String other){
        int flag=0;
        try{
            int personId = Integer.valueOf(personid);
            int deptId = Integer.valueOf(deptid.substring(0,1));

            String sql="insert into person(personId,pName,sex,birth,nat,address,deptId,other) values("+personId+",'"+pname+"','"+sex+"','"+birth+"','"+nat+"','"+address+"',"+deptId+",'"+other+"')";
            System.out.print(sql);
            Statement st=JDBCUtil.getConnection();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "数据添加成功", JOptionPane.WARNING_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("数据添加失败");
        }

        return flag;
    }
    //获取人员信息
    public static String[] getAllPerson(String personid){
        String[] str = new String[100];
        int flag=0;
        try {
            int personId = Integer.valueOf(personid);
            String sql="select pName,sex,birth,nat,address,other from person where personId="+personId;
            System.out.print(sql);
            Statement st = JDBCUtil.getConnection();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                str[0]=rs.getString("pName");
                str[1]=rs.getString("sex");
                str[2]=rs.getString("birth");
                str[3]=rs.getString("nat");
                str[4]=rs.getString("address");
                str[5]=rs.getString("other");
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.print("输出失败");
        }
        return str;
    }
    public static int updatePerson(String personid,String pName,String sex,String birth,String nat,String address,String other){
        int flag=0;
        try{
            int personId=Integer.valueOf(personid);
            String sql="update person set pName='"+pName+"',sex='"+sex+"',birth='"+birth+"',nat='"+nat+"',address='"+address+"',other='"+other+"' where personId="+personId;
            System.out.print(sql);
            Statement st = JDBCUtil.getConnection();
            flag=st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "数据修改成功", JOptionPane.WARNING_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
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
                str[flag][2]=rs.getString("birth");
                str[flag][3]=rs.getString("nat");
                str[flag][4]=rs.getString("address");
                deptid[flag]=String.valueOf(rs.getInt("deptId"));
                flag=flag+1;
            }
            for(int i=0;i<deptid.length;i++){
                String sql1="select dept1Name from dept where deptId=";
                sql1=sql1+deptid[i];
                System.out.print(sql1);
                ResultSet rd =st.executeQuery(sql1);
                while (rd.next()){
                     str[i][5]=rd.getString("dept1Name");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
    public static int deletePerson(String personid){
        int flag=0;
        try{
            int personId=Integer.valueOf(personid);
            String sql="delete from person where personId="+personId;
            Statement st =JDBCUtil.getConnection();
            flag  =st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "数据删除成功", JOptionPane.WARNING_MESSAGE);
        }catch (Exception e){

        }
        return flag;
    }
}
