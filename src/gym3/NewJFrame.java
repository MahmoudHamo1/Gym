/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym3;

//import com.mysql.cj.protocol.Resultset;
//import com.oracle.jrockit.jfr.DataType;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.sql.*;
import java.math.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;    
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.stage.FileChooser;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javax.swing.UIManager;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import keeptoo.Drag;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author USER
 */
class department {

    int number;
    String name;
    int ecount, pcount, mcount;

    public department(int num, String name1/*,int ecount,int pcount,int mcount*/) {
        this.number = num;
        this.name = name1;
        /*this.ecount=ecount;
    this.pcount=pcount;
    this.mcount=mcount;*/

    }

    public String getname() {
        return this.name;
    }

    public int getnumber() {
        return this.number;
    }

    public int getecount() {
        return this.ecount;
    }

    public int getpcount() {
        return this.pcount;
    }

    public int getmcount() {
        return this.mcount;
    }
}

class employee {

    String fname,lname, address, date, ssn, ph,gender;
    int salary, wh, eid, dn;
   public employee(String fname,String lname,String address,String date,String ssn,String ph,String gender,int salary,int wh,int eid,int dn){
       this.fname=fname;
       this.lname=lname;
       this.address=address;
       this.date=date;
       this.ssn=ssn;
       this.ph=ph;
       this.salary=salary;
       this.wh=wh;
       this.eid=eid;
       this.dn=dn;
       this.gender=gender;
   }
public String getfname(){
    return this.fname;
}
public String getlname(){
    return this.lname;
}
public String getdate(){
    return this.date;
}
public String getssn(){
    return this.ssn;
}
public String getaddress(){
    return this.address;
}
public String getgender(){
    return this.gender;
}
public String getphone(){
    return this.ph;
}
public int getsalary(){
    return this.salary;
}
public int getwh(){
    return this.wh;
}
public int geteid(){
    return this.eid;
}
public int getdn(){
    return this.dn;
}
}
class participants{
    String edate,sdate,ssn,name,phone,id,date,gender,state,address;
    int d_number,weight,height;
    
    public participants(String edate,String sdate,String ssn,String name,String phone,String id,String date,String gender,String address,int dnumber,int weight,int height){
   this.edate=edate;
   this.address=address;
   this.sdate=sdate;
   this.ssn=ssn;
   this.name=name;
   this.phone=phone;
   this.id=id;
   this.gender=gender;
   this.date=date;
   this.d_number=dnumber;
   this.weight=weight;
   this.height=height;
   String mon[]={"January",
"February",
"March",
"Abril"
,"May"
,"June",
"July",
"August",
"September",
"October",
"November",
"Decmber"};
  String e[]=edate.split("-");
    //JOptionPane.showMessageDialog(null,"receive 1");

  /*JOptionPane.showMessageDialog(null,e[0]);
    JOptionPane.showMessageDialog(null,e[1]);
  JOptionPane.showMessageDialog(null,e[2]);*/
  int em=1;
  for(int i=0;i<12;i++){
      if(e[1].equals(mon[i])){em=i+1;break;}
  }
int ey=Integer.parseInt(e[0]);
int ed=Integer.parseInt(e[2]);

DateTimeFormatter dat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
  //  JOptionPane.showMessageDialog(null,now.toString());

    String s[]=now.toString().split("-");
    /*JOptionPane.showMessageDialog(null,s[0]);
    JOptionPane.showMessageDialog(null,s[1]);
  JOptionPane.showMessageDialog(null,s[2]);*/
    int cy=Integer.parseInt(s[0]);
int cm=Integer.parseInt(s[1]);
String cu[]=s[2].split("T");
int cd=Integer.parseInt(cu[0]);
 //JOptionPane.showMessageDialog(null,cd+" "+cm+" "+cy);
 //JOptionPane.showMessageDialog(null,ed+" "+em+" "+ey);

if(ey<cy)
    this.state="Stopped";
    else if(ey==cy&&cm>em){
            this.state="Stopped";
            }
    else if(ey==cy&&cm==em&&cd>ed){
        this.state="Stopped";
    }
    else this.state="Active";
    }
    public String getaddress(){
        return address;
    }
    public String getstate(){
        return this.state;
    }
    public String getedate(){
        return this.edate;
    }
     public String getsdate(){
        return this.sdate;
    }
      public String getssn(){
        return this.ssn;
    }
       public String getname(){
        return this.name;
    }
        public String getphone(){
        return this.phone;
    }
         public String getid(){
        return this.id;
    }
          public String getdate(){
        return this.date;
    }
           public String getgender(){
        return this.gender;
    }
     public int getdnumber(){
         return this.d_number;
     }
      public int getweight(){
         return this.weight;
     }
       public int getheight(){
         return this.height;
     }
        }
class machine{
  String id,name;
  int dnumber;
  public machine(String id,String name,int dnumber){
      this.id=id;
      this.name=name;
      this.dnumber=dnumber;
  }
  public String getid (){
     return this.id;
  }
  public String getname (){
     return this.name;
  }
  public int getdnumber(){
     return this.dnumber;
  }
    
}
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Boolean prf1, prf2, prf3, prf4, prf5, prf6, prf7;

    public NewJFrame() {
        initComponents();
        /*UIManager.LookAndFeelInfo looks[];
		looks=UIManager.getInstalledLookAndFeels() ;
                try {
					UIManager.setLookAndFeel(looks[0].getClassName());
					SwingUtilities.updateComponentTreeUI(this);
					validate();
					revalidate();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
        prf1 = true;

        prf2 = prf3 = prf4 = prf5 = prf6 = prf7 = false;
        //  tablelist.setBackground(new Color(0,0,21,10));
        tablepanel.setBackground(new Color(255, 255, 255, 250));
        pregpanel.setVisible(true);
        infpage.setVisible(false);
        reglist.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        closepan6.setBackground(new Color(0, 0, 0, 0));
        partable.setVisible(false);
        profile_page.setVisible(false);
        list1 = true;
        list2 = false;
        list3 = false;
        getdnumber();
        // this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        listpanel = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kButton2 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        kButton4 = new keeptoo.KButton();
        kButton5 = new keeptoo.KButton();
        pregpanel = new javax.swing.JPanel();
        reglist = new keeptoo.KGradientPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        machlabel = new javax.swing.JLabel();
        parlabel = new javax.swing.JLabel();
        emplabel = new javax.swing.JLabel();
        deplabel = new javax.swing.JLabel();
        fnametxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lnametxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ssntxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnumbertxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        streettxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        daybox = new javax.swing.JComboBox<>();
        yearbox = new javax.swing.JComboBox<>();
        monthbox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        genderbox = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kButton1 = new keeptoo.KButton();
        closepan1 = new javax.swing.JPanel();
        closeleb = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        wtxt = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        ltxt = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        sdaybox = new javax.swing.JComboBox<>();
        smonthbox = new javax.swing.JComboBox<>();
        syearbox = new javax.swing.JComboBox<>();
        edaybox = new javax.swing.JComboBox<>();
        eyearbox = new javax.swing.JComboBox<>();
        emonthbox = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        registerbut5 = new keeptoo.KButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        dnumber = new javax.swing.JComboBox<>();
        citybox = new javax.swing.JComboBox<>();
        eregpanel = new javax.swing.JPanel();
        reglist1 = new keeptoo.KGradientPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        machlabel1 = new javax.swing.JLabel();
        parlabel1 = new javax.swing.JLabel();
        emplabel1 = new javax.swing.JLabel();
        deplabel1 = new javax.swing.JLabel();
        fnametxt1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lnametxt1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        ssntxt1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnumbertxt1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        streettxt1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        daybox1 = new javax.swing.JComboBox<>();
        yearbox1 = new javax.swing.JComboBox<>();
        dnumber1 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        genderbox1 = new javax.swing.JComboBox<>();
        salarytxt = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        work_hourstxt = new javax.swing.JTextField();
        closepan5 = new javax.swing.JPanel();
        closeleb4 = new javax.swing.JLabel();
        is_coach = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        exptxt = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        kButton8 = new keeptoo.KButton();
        registerbut4 = new keeptoo.KButton();
        monthbox4 = new javax.swing.JComboBox<>();
        citybox1 = new javax.swing.JComboBox<>();
        deppanel = new javax.swing.JPanel();
        reglist3 = new keeptoo.KGradientPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        deplabel2 = new javax.swing.JLabel();
        parlabel3 = new javax.swing.JLabel();
        emplabel3 = new javax.swing.JLabel();
        machlabel4 = new javax.swing.JLabel();
        dnumbertxt = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        kButton7 = new keeptoo.KButton();
        closepan7 = new javax.swing.JPanel();
        closeleb6 = new javax.swing.JLabel();
        registerbut7 = new keeptoo.KButton();
        dnametxt = new javax.swing.JTextField();
        mregpanel = new javax.swing.JPanel();
        reglist2 = new keeptoo.KGradientPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        machlabel2 = new javax.swing.JLabel();
        parlabel2 = new javax.swing.JLabel();
        emplabel2 = new javax.swing.JLabel();
        deplabel3 = new javax.swing.JLabel();
        nametxt2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        id_machinetxt = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        closepan6 = new javax.swing.JPanel();
        closeleb5 = new javax.swing.JLabel();
        registerbut3 = new keeptoo.KButton();
        jLabel78 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        kButton9 = new keeptoo.KButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        eprofile_page = new javax.swing.JPanel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jPanel15 = new javax.swing.JPanel();
        profileimage1 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        pename = new javax.swing.JLabel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        pefname = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        pelname = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        pestreet = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        peday = new javax.swing.JComboBox<>();
        peyear = new javax.swing.JComboBox<>();
        pemonth = new javax.swing.JComboBox<>();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        pesalary = new javax.swing.JTextField();
        pework = new javax.swing.JTextField();
        pepnumber = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        pegender = new javax.swing.JComboBox<>();
        registerbut8 = new keeptoo.KButton();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        pecity = new javax.swing.JComboBox<>();
        pednumber = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        peid = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        infpage = new javax.swing.JPanel();
        closepan2 = new javax.swing.JPanel();
        closeleb1 = new javax.swing.JLabel();
        listinf = new javax.swing.JLabel();
        tablepanel = new javax.swing.JPanel();
        tablelist = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        emplist_labe = new javax.swing.JLabel();
        sellist1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        parlist_labe = new javax.swing.JLabel();
        sellist2 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        machlist_labe = new javax.swing.JLabel();
        sellist3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        deplist_labe = new javax.swing.JLabel();
        sellist4 = new javax.swing.JPanel();
        emptable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        partable = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        machtable = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        kButton6 = new keeptoo.KButton();
        searchtxt1 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        deptable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        machinepage = new javax.swing.JPanel();
        closepan3 = new javax.swing.JPanel();
        closeleb2 = new javax.swing.JLabel();
        notepage = new javax.swing.JPanel();
        closepan4 = new javax.swing.JPanel();
        closeleb3 = new javax.swing.JLabel();
        profile_page = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        profileimage = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        daybox3 = new javax.swing.JComboBox<>();
        yearbox3 = new javax.swing.JComboBox<>();
        monthbox3 = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        daybox4 = new javax.swing.JComboBox<>();
        registerbut6 = new keeptoo.KButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mprofile_page = new javax.swing.JPanel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jPanel20 = new javax.swing.JPanel();
        profileimage2 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        daybox7 = new javax.swing.JComboBox<>();
        yearbox5 = new javax.swing.JComboBox<>();
        monthbox6 = new javax.swing.JComboBox<>();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        daybox8 = new javax.swing.JComboBox<>();
        registerbut9 = new keeptoo.KButton();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        dprofile_page = new javax.swing.JPanel();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jPanel25 = new javax.swing.JPanel();
        profileimage3 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        kGradientPanel13 = new keeptoo.KGradientPanel();
        jLabel149 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        daybox9 = new javax.swing.JComboBox<>();
        yearbox6 = new javax.swing.JComboBox<>();
        monthbox7 = new javax.swing.JComboBox<>();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        daybox10 = new javax.swing.JComboBox<>();
        registerbut10 = new keeptoo.KButton();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        kGradientPanel3.setBackground(new java.awt.Color(0, 0, 0));
        kGradientPanel3.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(204, 204, 204));
        kGradientPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel3MouseDragged(evt);
            }
        });
        kGradientPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kGradientPanel3MouseReleased(evt);
            }
        });
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listpanel.setBackground(new java.awt.Color(204, 204, 204));
        listpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        listpanel.setkEndColor(new java.awt.Color(255, 255, 153));
        listpanel.setkStartColor(new java.awt.Color(153, 0, 153));
        listpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                listpanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                listpanelMouseMoved(evt);
            }
        });
        listpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listpanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listpanelMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Gym");

        jLabel3.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Dynamic");

        jLabel4.setFont(new java.awt.Font("Broadway", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("2021");

        kButton2.setBackground(new java.awt.Color(153, 153, 255));
        kButton2.setForeground(new java.awt.Color(0, 204, 204));
        kButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_View_Details_26px.png"))); // NOI18N
        kButton2.setText("Notes");
        kButton2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        kButton2.setIconTextGap(115);
        kButton2.setInheritsPopupMenu(true);
        kButton2.setkBackGroundColor(new java.awt.Color(51, 51, 51));
        kButton2.setkBorderRadius(0);
        kButton2.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton2.setkFillButton(false);
        kButton2.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverColor(new java.awt.Color(153, 0, 51));
        kButton2.setkHoverEndColor(new java.awt.Color(0, 0, 102));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton2.setkIndicatorThickness(7);
        kButton2.setkPressedColor(new java.awt.Color(255, 0, 51));
        kButton2.setkSelectedColor(new java.awt.Color(204, 204, 0));
        kButton2.setkStartColor(new java.awt.Color(153, 0, 0));
        kButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton2MouseClicked(evt);
            }
        });
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setBackground(new java.awt.Color(153, 153, 255));
        kButton3.setForeground(new java.awt.Color(0, 204, 204));
        kButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Info_26px.png"))); // NOI18N
        kButton3.setText("Information");
        kButton3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        kButton3.setIconTextGap(80);
        kButton3.setkBackGroundColor(new java.awt.Color(51, 51, 51));
        kButton3.setkBorderRadius(0);
        kButton3.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton3.setkFillButton(false);
        kButton3.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverColor(new java.awt.Color(153, 0, 51));
        kButton3.setkHoverEndColor(new java.awt.Color(0, 0, 102));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton3.setkIndicatorThickness(7);
        kButton3.setkPressedColor(new java.awt.Color(255, 0, 51));
        kButton3.setkSelectedColor(new java.awt.Color(204, 204, 0));
        kButton3.setkStartColor(new java.awt.Color(153, 0, 0));
        kButton3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kButton3MouseMoved(evt);
            }
        });
        kButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton3MouseClicked(evt);
            }
        });
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton4.setBackground(new java.awt.Color(153, 153, 255));
        kButton4.setForeground(new java.awt.Color(0, 204, 204));
        kButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_26px.png"))); // NOI18N
        kButton4.setActionCommand("Registration");
        kButton4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        kButton4.setIconTextGap(80);
        kButton4.setkBackGroundColor(new java.awt.Color(51, 51, 51));
        kButton4.setkBorderRadius(0);
        kButton4.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton4.setkFillButton(false);
        kButton4.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverColor(new java.awt.Color(153, 0, 51));
        kButton4.setkHoverEndColor(new java.awt.Color(0, 0, 102));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton4.setkIndicatorThickness(7);
        kButton4.setkPressedColor(new java.awt.Color(255, 0, 51));
        kButton4.setkSelectedColor(new java.awt.Color(204, 204, 0));
        kButton4.setkStartColor(new java.awt.Color(153, 0, 0));
        kButton4.setLabel("Registration");
        kButton4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kButton4MouseMoved(evt);
            }
        });
        kButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton4MouseClicked(evt);
            }
        });
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setBackground(new java.awt.Color(153, 153, 255));
        kButton5.setForeground(new java.awt.Color(0, 204, 204));
        kButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Dumbbell_26px.png"))); // NOI18N
        kButton5.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        kButton5.setIconTextGap(100);
        kButton5.setkBackGroundColor(new java.awt.Color(51, 51, 51));
        kButton5.setkBorderRadius(0);
        kButton5.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton5.setkFillButton(false);
        kButton5.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverColor(new java.awt.Color(153, 0, 51));
        kButton5.setkHoverEndColor(new java.awt.Color(0, 0, 102));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton5.setkIndicatorThickness(7);
        kButton5.setkPressedColor(new java.awt.Color(255, 0, 51));
        kButton5.setkSelectedColor(new java.awt.Color(204, 204, 0));
        kButton5.setkStartColor(new java.awt.Color(153, 0, 0));
        kButton5.setLabel("Machine");
        kButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton5MouseClicked(evt);
            }
        });
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listpanelLayout = new javax.swing.GroupLayout(listpanel);
        listpanel.setLayout(listpanelLayout);
        listpanelLayout.setHorizontalGroup(
            listpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(listpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listpanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listpanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
            .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(listpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listpanelLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(114, Short.MAX_VALUE)))
        );
        listpanelLayout.setVerticalGroup(
            listpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listpanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(listpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listpanelLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(857, Short.MAX_VALUE)))
        );

        kGradientPanel3.add(listpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 1000));

        pregpanel.setBackground(new java.awt.Color(255, 255, 255));

        pregpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pregpanelMouseMoved(evt);
            }
        });
        pregpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pregpanelMouseEntered(evt);
            }
        });
        pregpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reglist.setBackground(new java.awt.Color(255, 255, 255));
        reglist.setkEndColor(new java.awt.Color(255, 255, 255));
        reglist.setkStartColor(new java.awt.Color(255, 255, 255));
        reglist.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                reglistMouseMoved(evt);
            }
        });
        reglist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 0, 0)));
        kGradientPanel4.setkStartColor(new java.awt.Color(255, 0, 204));
        kGradientPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel4MouseMoved(evt);
            }
        });
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        machlabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        machlabel.setForeground(new java.awt.Color(255, 255, 255));
        machlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Barbell_25px.png"))); // NOI18N
        machlabel.setText("Machine");
        machlabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                machlabelMouseMoved(evt);
            }
        });
        machlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                machlabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                machlabelMouseExited(evt);
            }
        });
        kGradientPanel4.add(machlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, 50));

        parlabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        parlabel.setForeground(new java.awt.Color(255, 255, 255));
        parlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Weightlifting_25px.png"))); // NOI18N
        parlabel.setText(" Participant");
        parlabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                parlabelMouseMoved(evt);
            }
        });
        parlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parlabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parlabelMouseExited(evt);
            }
        });
        kGradientPanel4.add(parlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 48));

        emplabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        emplabel.setForeground(new java.awt.Color(255, 255, 255));
        emplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Employee_25px_3.png"))); // NOI18N
        emplabel.setText(" Employee");
        emplabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                emplabelMouseMoved(evt);
            }
        });
        emplabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emplabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emplabelMouseExited(evt);
            }
        });
        kGradientPanel4.add(emplabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 48));

        deplabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        deplabel.setForeground(new java.awt.Color(255, 255, 255));
        deplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Department_25px_1.png"))); // NOI18N
        deplabel.setText("Department");
        deplabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deplabelMouseMoved(evt);
            }
        });
        deplabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deplabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deplabelMouseExited(evt);
            }
        });
        kGradientPanel4.add(deplabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, 50));

        reglist.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 248, 200));

        pregpanel.add(reglist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, -1));

        fnametxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        fnametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        fnametxt.setOpaque(false);
        fnametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fnametxtMouseClicked(evt);
            }
        });
        fnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxtActionPerformed(evt);
            }
        });
        pregpanel.add(fnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 145, 43));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("First Name");
        pregpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 38));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, 28));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Last Name");
        pregpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, 38));

        lnametxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        lnametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        lnametxt.setOpaque(false);
        lnametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lnametxtMouseClicked(evt);
            }
        });
        lnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnametxtActionPerformed(evt);
            }
        });
        pregpanel.add(lnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 161, 43));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Social Security Number(SSN)");
        pregpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, 38));

        ssntxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        ssntxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        ssntxt.setOpaque(false);
        ssntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ssntxtMouseClicked(evt);
            }
        });
        ssntxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssntxtActionPerformed(evt);
            }
        });
        pregpanel.add(ssntxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 324, 43));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 28));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Phone-Number");
        pregpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, 38));

        pnumbertxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        pnumbertxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        pnumbertxt.setOpaque(false);
        pnumbertxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnumbertxtMouseClicked(evt);
            }
        });
        pnumbertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnumbertxtActionPerformed(evt);
            }
        });
        pregpanel.add(pnumbertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 331, 43));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 28));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("City");
        pregpanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, 38));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, 28));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Street Number");
        pregpanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, 38));

        streettxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        streettxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        streettxt.setOpaque(false);
        streettxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                streettxtMouseClicked(evt);
            }
        });
        streettxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streettxtActionPerformed(evt);
            }
        });
        pregpanel.add(streettxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 145, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Day");
        pregpanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 720, -1, 38));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Month");
        pregpanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 720, -1, 38));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Year");
        pregpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 720, -1, 38));

        daybox.setMaximumRowCount(5);
        daybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        daybox.setLightWeightPopupEnabled(false);
        daybox.setOpaque(false);
        pregpanel.add(daybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 770, 74, -1));

        yearbox.setMaximumRowCount(5);
        yearbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003" }));
        yearbox.setLightWeightPopupEnabled(false);
        yearbox.setOpaque(false);
        pregpanel.add(yearbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 770, 64, -1));

        monthbox.setMaximumRowCount(5);
        monthbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        monthbox.setLightWeightPopupEnabled(false);
        monthbox.setOpaque(false);
        pregpanel.add(monthbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 770, 102, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Gender");
        pregpanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 800, -1, 38));

        genderbox.setMaximumRowCount(5);
        genderbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderbox.setLightWeightPopupEnabled(false);
        genderbox.setOpaque(false);
        pregpanel.add(genderbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 840, 74, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Start-Date");
        pregpanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, 38));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, 28));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("End-Date");
        pregpanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, 38));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(0, 51, 51)));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/download.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_25px_2.png"))); // NOI18N
        jLabel24.setText("egestration  ");
        jLabel24.setIconTextGap(0);

        jLabel20.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("participants");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_30px_3.png"))); // NOI18N

        kButton1.setkBackGroundColor(new java.awt.Color(0, 102, 153));
        kButton1.setkBorderRadius(80);
        kButton1.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton1.setkHoverEndColor(new java.awt.Color(51, 51, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton1.setkIndicatorColor(new java.awt.Color(153, 153, 153));
        kButton1.setkPressedColor(new java.awt.Color(0, 102, 102));
        kButton1.setkSelectedColor(new java.awt.Color(0, 153, 153));
        kButton1.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton1.setName(""); // NOI18N
        kButton1.setPreferredSize(new java.awt.Dimension(185, 7));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel20)))))
                .addGap(293, 293, 293)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addGap(5, 5, 5)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pregpanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 330, 340));

        closepan1.setBackground(new java.awt.Color(255, 255, 255));
        closepan1.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb.setBackground(new java.awt.Color(255, 255, 255));
        closeleb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closelebMouseMoved(evt);
            }
        });
        closeleb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closelebMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closepan1Layout = new javax.swing.GroupLayout(closepan1);
        closepan1.setLayout(closepan1Layout);
        closepan1Layout.setHorizontalGroup(
            closepan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closepan1Layout.setVerticalGroup(
            closepan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeleb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pregpanel.add(closepan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 3, -1, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("Wieght");
        pregpanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, -1, 38));

        wtxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        wtxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        wtxt.setOpaque(false);
        wtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wtxtMouseClicked(evt);
            }
        });
        wtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtxtActionPerformed(evt);
            }
        });
        pregpanel.add(wtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, 149, 43));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("Length");
        pregpanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, 38));

        ltxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        ltxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        ltxt.setOpaque(false);
        ltxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltxtMouseClicked(evt);
            }
        });
        ltxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ltxtActionPerformed(evt);
            }
        });
        pregpanel.add(ltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 145, 43));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 680, -1, 28));

        sdaybox.setMaximumRowCount(5);
        sdaybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        sdaybox.setLightWeightPopupEnabled(false);
        sdaybox.setOpaque(false);
        pregpanel.add(sdaybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 74, -1));

        smonthbox.setMaximumRowCount(5);
        smonthbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        smonthbox.setLightWeightPopupEnabled(false);
        smonthbox.setOpaque(false);
        pregpanel.add(smonthbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 102, -1));

        syearbox.setMaximumRowCount(5);
        syearbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));
        syearbox.setSelectedIndex(17);
        syearbox.setSelectedItem(2018);
        syearbox.setLightWeightPopupEnabled(false);
        syearbox.setOpaque(false);
        pregpanel.add(syearbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 64, -1));

        edaybox.setMaximumRowCount(5);
        edaybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        edaybox.setLightWeightPopupEnabled(false);
        edaybox.setOpaque(false);
        pregpanel.add(edaybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 74, -1));

        eyearbox.setMaximumRowCount(5);
        eyearbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
        eyearbox.setSelectedIndex(18);
        eyearbox.setSelectedItem(2019);
        eyearbox.setLightWeightPopupEnabled(false);
        eyearbox.setOpaque(false);
        eyearbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyearboxActionPerformed(evt);
            }
        });
        pregpanel.add(eyearbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 64, -1));

        emonthbox.setMaximumRowCount(5);
        emonthbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        emonthbox.setLightWeightPopupEnabled(false);
        emonthbox.setOpaque(false);
        emonthbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emonthboxActionPerformed(evt);
            }
        });
        pregpanel.add(emonthbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 102, -1));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, 28));

        registerbut5.setText("Register");
        registerbut5.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut5.setkEndColor(new java.awt.Color(153, 0, 0));
        registerbut5.setkHoverEndColor(new java.awt.Color(153, 0, 0));
        registerbut5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut5.setkHoverStartColor(new java.awt.Color(153, 0, 0));
        registerbut5.setkIndicatorThickness(0);
        registerbut5.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut5.setkSelectedColor(new java.awt.Color(204, 0, 0));
        registerbut5.setkStartColor(new java.awt.Color(204, 0, 0));
        registerbut5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut5ActionPerformed(evt);
            }
        });
        pregpanel.add(registerbut5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 880, 325, 50));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(102, 102, 102));
        jLabel68.setText("Department Name");
        pregpanel.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, -1, 38));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        pregpanel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, -1, 28));

        dnumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dnumberMouseClicked(evt);
            }
        });
        dnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnumberActionPerformed(evt);
            }
        });
        pregpanel.add(dnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 666, 330, 40));

        citybox.setMaximumRowCount(5);
        citybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenin", "Ramallah", "Nablus", "Tullkarem", "Tobas", "Hebron", "Bethlehem", " " }));
        citybox.setLightWeightPopupEnabled(false);
        citybox.setOpaque(false);
        citybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityboxActionPerformed(evt);
            }
        });
        pregpanel.add(citybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 150, 40));

        kGradientPanel3.add(pregpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 870, 1000));

        eregpanel.setBackground(new java.awt.Color(255, 255, 255));
        eregpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                eregpanelMouseMoved(evt);
            }
        });
        eregpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eregpanelMouseEntered(evt);
            }
        });
        eregpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reglist1.setBackground(new java.awt.Color(255, 255, 255));
        reglist1.setkEndColor(new java.awt.Color(255, 255, 255));
        reglist1.setkStartColor(new java.awt.Color(255, 255, 255));
        reglist1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                reglist1MouseMoved(evt);
            }
        });

        kGradientPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 0, 0)));
        kGradientPanel5.setkEndColor(new java.awt.Color(51, 0, 0));
        kGradientPanel5.setkStartColor(new java.awt.Color(102, 0, 0));
        kGradientPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel5MouseMoved(evt);
            }
        });
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        machlabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        machlabel1.setForeground(new java.awt.Color(255, 255, 255));
        machlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Barbell_25px.png"))); // NOI18N
        machlabel1.setText(" Machine");
        machlabel1.setIconTextGap(5);
        machlabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                machlabel1MouseMoved(evt);
            }
        });
        machlabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                machlabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                machlabel1MouseExited(evt);
            }
        });
        kGradientPanel5.add(machlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, 50));

        parlabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        parlabel1.setForeground(new java.awt.Color(255, 255, 255));
        parlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Weightlifting_25px.png"))); // NOI18N
        parlabel1.setText(" Participant");
        parlabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                parlabel1MouseMoved(evt);
            }
        });
        parlabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parlabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parlabel1MouseExited(evt);
            }
        });
        kGradientPanel5.add(parlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 50));

        emplabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        emplabel1.setForeground(new java.awt.Color(255, 255, 255));
        emplabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Employee_25px_3.png"))); // NOI18N
        emplabel1.setText(" Employee");
        emplabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                emplabel1MouseMoved(evt);
            }
        });
        emplabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emplabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emplabel1MouseExited(evt);
            }
        });
        kGradientPanel5.add(emplabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 48));

        deplabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        deplabel1.setForeground(new java.awt.Color(255, 255, 255));
        deplabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Department_25px_1.png"))); // NOI18N
        deplabel1.setText("Department");
        deplabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deplabel1MouseMoved(evt);
            }
        });
        deplabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deplabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deplabel1MouseExited(evt);
            }
        });
        kGradientPanel5.add(deplabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, 50));

        javax.swing.GroupLayout reglist1Layout = new javax.swing.GroupLayout(reglist1);
        reglist1.setLayout(reglist1Layout);
        reglist1Layout.setHorizontalGroup(
            reglist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reglist1Layout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        reglist1Layout.setVerticalGroup(
            reglist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reglist1Layout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        eregpanel.add(reglist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, -1));

        fnametxt1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        fnametxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        fnametxt1.setOpaque(false);
        fnametxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fnametxt1MouseClicked(evt);
            }
        });
        fnametxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxt1ActionPerformed(evt);
            }
        });
        eregpanel.add(fnametxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 145, 50));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("First Name");
        eregpanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Last Name");
        eregpanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 40));

        lnametxt1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        lnametxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        lnametxt1.setOpaque(false);
        lnametxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lnametxt1MouseClicked(evt);
            }
        });
        lnametxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnametxt1ActionPerformed(evt);
            }
        });
        eregpanel.add(lnametxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 161, 50));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Social Security Number(SSN)");
        eregpanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, 40));

        ssntxt1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        ssntxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        ssntxt1.setOpaque(false);
        ssntxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ssntxt1MouseClicked(evt);
            }
        });
        ssntxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssntxt1ActionPerformed(evt);
            }
        });
        eregpanel.add(ssntxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 324, 50));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Phone-Number");
        eregpanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, 40));

        pnumbertxt1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        pnumbertxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        pnumbertxt1.setOpaque(false);
        pnumbertxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnumbertxt1ActionPerformed(evt);
            }
        });
        eregpanel.add(pnumbertxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 331, 50));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("City");
        eregpanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, 40));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("Street Number");
        eregpanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, 40));

        streettxt1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        streettxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        streettxt1.setOpaque(false);
        streettxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streettxt1ActionPerformed(evt);
            }
        });
        eregpanel.add(streettxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 145, 50));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Day");
        eregpanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, -1, 40));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("Month");
        eregpanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, -1, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Year");
        eregpanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, -1, 40));

        daybox1.setMaximumRowCount(5);
        daybox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        daybox1.setLightWeightPopupEnabled(false);
        daybox1.setOpaque(false);
        eregpanel.add(daybox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 74, 30));

        yearbox1.setMaximumRowCount(5);
        yearbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003" }));
        yearbox1.setLightWeightPopupEnabled(false);
        yearbox1.setOpaque(false);
        eregpanel.add(yearbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 64, 30));

        dnumber1.setMaximumRowCount(5);
        dnumber1.setLightWeightPopupEnabled(false);
        dnumber1.setOpaque(false);
        dnumber1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dnumber1MouseClicked(evt);
            }
        });
        eregpanel.add(dnumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 330, 50));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Gender");
        eregpanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, -1, 40));

        genderbox1.setMaximumRowCount(5);
        genderbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderbox1.setLightWeightPopupEnabled(false);
        genderbox1.setOpaque(false);
        eregpanel.add(genderbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 720, 74, 30));

        salarytxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        salarytxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        salarytxt.setOpaque(false);
        salarytxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salarytxtMouseClicked(evt);
            }
        });
        salarytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarytxtActionPerformed(evt);
            }
        });
        eregpanel.add(salarytxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 149, 50));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("salary");
        eregpanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, 40));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("work-hours");
        eregpanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, 40));

        work_hourstxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        work_hourstxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        work_hourstxt.setOpaque(false);
        work_hourstxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                work_hourstxtMouseClicked(evt);
            }
        });
        work_hourstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                work_hourstxtActionPerformed(evt);
            }
        });
        eregpanel.add(work_hourstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 145, 50));

        closepan5.setBackground(new java.awt.Color(255, 255, 255));
        closepan5.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb4.setBackground(new java.awt.Color(255, 255, 255));
        closeleb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeleb4MouseMoved(evt);
            }
        });
        closeleb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeleb4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closepan5Layout = new javax.swing.GroupLayout(closepan5);
        closepan5.setLayout(closepan5Layout);
        closepan5Layout.setHorizontalGroup(
            closepan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closepan5Layout.setVerticalGroup(
            closepan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeleb4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        eregpanel.add(closepan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 3, -1, 30));

        is_coach.setBackground(new java.awt.Color(255, 255, 255));
        is_coach.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        is_coach.setText("is coach");
        is_coach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                is_coachMouseClicked(evt);
            }
        });
        is_coach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is_coachActionPerformed(evt);
            }
        });
        eregpanel.add(is_coach, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 760, 260, 30));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("Experience");
        eregpanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 790, -1, 40));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, -1, 30));

        exptxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        exptxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        exptxt.setEnabled(false);
        exptxt.setOpaque(false);
        exptxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exptxtMouseClicked(evt);
            }
        });
        exptxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exptxtActionPerformed(evt);
            }
        });
        eregpanel.add(exptxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 830, 331, 50));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        eregpanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 910, -1, 38));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        eregpanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 840, -1, 30));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("Department-Number");
        eregpanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(0, 51, 51)));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/employee1.jpg"))); // NOI18N

        jLabel62.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 51, 51));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_25px_2.png"))); // NOI18N
        jLabel62.setText("egestration  ");
        jLabel62.setIconTextGap(0);

        jLabel63.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 51, 51));
        jLabel63.setText("Employee");

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_30px_3.png"))); // NOI18N

        kButton8.setkBackGroundColor(new java.awt.Color(0, 51, 51));
        kButton8.setkBorderRadius(80);
        kButton8.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton8.setkHoverEndColor(new java.awt.Color(51, 51, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton8.setkIndicatorColor(new java.awt.Color(153, 153, 153));
        kButton8.setkPressedColor(new java.awt.Color(0, 102, 102));
        kButton8.setkSelectedColor(new java.awt.Color(0, 153, 153));
        kButton8.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton8.setName(""); // NOI18N
        kButton8.setPreferredSize(new java.awt.Dimension(185, 7));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel63)))
                        .addGap(280, 280, 280)
                        .addComponent(jLabel64))
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        eregpanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 330, 360));

        registerbut4.setText("Regester");
        registerbut4.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut4.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut4.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut4.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut4.setkIndicatorThickness(0);
        registerbut4.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut4.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut4.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut4ActionPerformed(evt);
            }
        });
        eregpanel.add(registerbut4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 900, 325, 50));

        monthbox4.setMaximumRowCount(5);
        monthbox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        monthbox4.setLightWeightPopupEnabled(false);
        monthbox4.setOpaque(false);
        eregpanel.add(monthbox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 650, 102, 30));

        citybox1.setMaximumRowCount(5);
        citybox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenin", "Ramallah", "Nablus", "Tullkarem", "Tobas", "Hebron", "Bethlehem", " " }));
        citybox1.setLightWeightPopupEnabled(false);
        citybox1.setOpaque(false);
        citybox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citybox1ActionPerformed(evt);
            }
        });
        eregpanel.add(citybox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 150, 50));

        kGradientPanel3.add(eregpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 870, 1000));

        deppanel.setBackground(new java.awt.Color(255, 255, 255));
        deppanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deppanelMouseMoved(evt);
            }
        });
        deppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reglist3.setBackground(new java.awt.Color(255, 255, 255));
        reglist3.setkEndColor(new java.awt.Color(255, 255, 255));
        reglist3.setkStartColor(new java.awt.Color(255, 255, 255));
        reglist3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                reglist3MouseMoved(evt);
            }
        });
        reglist3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 0, 0)));
        kGradientPanel7.setkEndColor(new java.awt.Color(51, 0, 0));
        kGradientPanel7.setkStartColor(new java.awt.Color(102, 0, 0));
        kGradientPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel7MouseMoved(evt);
            }
        });
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deplabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        deplabel2.setForeground(new java.awt.Color(255, 255, 255));
        deplabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Department_25px_1.png"))); // NOI18N
        deplabel2.setText("Department");
        deplabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deplabel2MouseMoved(evt);
            }
        });
        deplabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deplabel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deplabel2MouseExited(evt);
            }
        });
        kGradientPanel7.add(deplabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, 50));

        parlabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        parlabel3.setForeground(new java.awt.Color(255, 255, 255));
        parlabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Weightlifting_25px.png"))); // NOI18N
        parlabel3.setText(" Participant");
        parlabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                parlabel3MouseMoved(evt);
            }
        });
        parlabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parlabel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parlabel3MouseExited(evt);
            }
        });
        kGradientPanel7.add(parlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 48));

        emplabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        emplabel3.setForeground(new java.awt.Color(255, 255, 255));
        emplabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Employee_25px_3.png"))); // NOI18N
        emplabel3.setText(" Employee");
        emplabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                emplabel3MouseMoved(evt);
            }
        });
        emplabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emplabel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emplabel3MouseExited(evt);
            }
        });
        kGradientPanel7.add(emplabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 48));

        machlabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        machlabel4.setForeground(new java.awt.Color(255, 255, 255));
        machlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Barbell_25px.png"))); // NOI18N
        machlabel4.setText(" Machine");
        machlabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                machlabel4MouseMoved(evt);
            }
        });
        machlabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                machlabel4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                machlabel4MouseExited(evt);
            }
        });
        kGradientPanel7.add(machlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, 50));

        reglist3.add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 248, 200));

        deppanel.add(reglist3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 200));

        dnumbertxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        dnumbertxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        dnumbertxt.setOpaque(false);
        dnumbertxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dnumbertxtMouseClicked(evt);
            }
        });
        dnumbertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnumbertxtActionPerformed(evt);
            }
        });
        deppanel.add(dnumbertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 330, 43));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(102, 102, 102));
        jLabel95.setText("Name Department");
        deppanel.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 38));

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        deppanel.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 28));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(102, 102, 102));
        jLabel98.setText("Department Number");
        deppanel.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 38));

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        deppanel.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, 28));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(0, 51, 51)));

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/department-icon-hr-finance-large.png"))); // NOI18N

        jLabel113.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 51, 51));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_25px_2.png"))); // NOI18N
        jLabel113.setText("egestration  ");
        jLabel113.setIconTextGap(0);

        jLabel114.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 51, 51));
        jLabel114.setText("Department");

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_30px_3.png"))); // NOI18N

        kButton7.setkBackGroundColor(new java.awt.Color(0, 51, 51));
        kButton7.setkBorderRadius(80);
        kButton7.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton7.setkHoverEndColor(new java.awt.Color(51, 51, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton7.setkIndicatorColor(new java.awt.Color(153, 153, 153));
        kButton7.setkPressedColor(new java.awt.Color(0, 102, 102));
        kButton7.setkSelectedColor(new java.awt.Color(0, 153, 153));
        kButton7.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton7.setName(""); // NOI18N
        kButton7.setPreferredSize(new java.awt.Dimension(185, 7));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel113)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel114)))))
                .addGap(293, 293, 293)
                .addComponent(jLabel115)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel115)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114)
                        .addGap(5, 5, 5)
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        deppanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 330, 340));

        closepan7.setBackground(new java.awt.Color(255, 255, 255));
        closepan7.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb6.setBackground(new java.awt.Color(255, 255, 255));
        closeleb6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeleb6MouseMoved(evt);
            }
        });
        closeleb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeleb6MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeleb6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout closepan7Layout = new javax.swing.GroupLayout(closepan7);
        closepan7.setLayout(closepan7Layout);
        closepan7Layout.setHorizontalGroup(
            closepan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closepan7Layout.setVerticalGroup(
            closepan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeleb6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        deppanel.add(closepan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 3, -1, 30));

        registerbut7.setText("Register");
        registerbut7.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut7.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut7.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut7.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut7.setkIndicatorThickness(0);
        registerbut7.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut7.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut7.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerbut7MouseClicked(evt);
            }
        });
        registerbut7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut7ActionPerformed(evt);
            }
        });
        deppanel.add(registerbut7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 330, 50));

        dnametxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        dnametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        dnametxt.setOpaque(false);
        dnametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dnametxtMouseClicked(evt);
            }
        });
        dnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnametxtActionPerformed(evt);
            }
        });
        deppanel.add(dnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 330, 43));

        kGradientPanel3.add(deppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 870, 1000));

        mregpanel.setBackground(new java.awt.Color(255, 255, 255));
        mregpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mregpanelMouseMoved(evt);
            }
        });
        mregpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reglist2.setBackground(new java.awt.Color(255, 255, 255));
        reglist2.setkEndColor(new java.awt.Color(255, 255, 255));
        reglist2.setkStartColor(new java.awt.Color(255, 255, 255));
        reglist2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                reglist2MouseMoved(evt);
            }
        });

        kGradientPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 0, 0)));
        kGradientPanel6.setkEndColor(new java.awt.Color(51, 0, 0));
        kGradientPanel6.setkStartColor(new java.awt.Color(102, 0, 0));
        kGradientPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel6MouseMoved(evt);
            }
        });
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        machlabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        machlabel2.setForeground(new java.awt.Color(255, 255, 255));
        machlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Barbell_25px.png"))); // NOI18N
        machlabel2.setText(" machine");
        machlabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                machlabel2MouseMoved(evt);
            }
        });
        machlabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                machlabel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                machlabel2MouseExited(evt);
            }
        });
        kGradientPanel6.add(machlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, 50));

        parlabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        parlabel2.setForeground(new java.awt.Color(255, 255, 255));
        parlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Weightlifting_25px.png"))); // NOI18N
        parlabel2.setText(" Participant");
        parlabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                parlabel2MouseMoved(evt);
            }
        });
        parlabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parlabel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parlabel2MouseExited(evt);
            }
        });
        kGradientPanel6.add(parlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 48));

        emplabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        emplabel2.setForeground(new java.awt.Color(255, 255, 255));
        emplabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Employee_25px_3.png"))); // NOI18N
        emplabel2.setText(" employee");
        emplabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                emplabel2MouseMoved(evt);
            }
        });
        emplabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emplabel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emplabel2MouseExited(evt);
            }
        });
        kGradientPanel6.add(emplabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 48));

        deplabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        deplabel3.setForeground(new java.awt.Color(255, 255, 255));
        deplabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Department_25px_1.png"))); // NOI18N
        deplabel3.setText("Department");
        deplabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deplabel3MouseMoved(evt);
            }
        });
        deplabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deplabel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deplabel3MouseExited(evt);
            }
        });
        kGradientPanel6.add(deplabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, 50));

        javax.swing.GroupLayout reglist2Layout = new javax.swing.GroupLayout(reglist2);
        reglist2.setLayout(reglist2Layout);
        reglist2Layout.setHorizontalGroup(
            reglist2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reglist2Layout.createSequentialGroup()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        reglist2Layout.setVerticalGroup(
            reglist2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reglist2Layout.createSequentialGroup()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mregpanel.add(reglist2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, -1));

        nametxt2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        nametxt2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        nametxt2.setOpaque(false);
        nametxt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nametxt2MouseClicked(evt);
            }
        });
        nametxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxt2ActionPerformed(evt);
            }
        });
        mregpanel.add(nametxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 330, 50));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Company Name");
        mregpanel.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 40));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        mregpanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        id_machinetxt.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        id_machinetxt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(102, 0, 0)));
        id_machinetxt.setOpaque(false);
        id_machinetxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_machinetxtMouseClicked(evt);
            }
        });
        id_machinetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_machinetxtActionPerformed(evt);
            }
        });
        mregpanel.add(id_machinetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 120, 50));

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        mregpanel.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 30));

        closepan6.setBackground(new java.awt.Color(255, 255, 255));
        closepan6.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb5.setBackground(new java.awt.Color(255, 255, 255));
        closeleb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeleb5MouseMoved(evt);
            }
        });
        closeleb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeleb5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closepan6Layout = new javax.swing.GroupLayout(closepan6);
        closepan6.setLayout(closepan6Layout);
        closepan6Layout.setHorizontalGroup(
            closepan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closepan6Layout.setVerticalGroup(
            closepan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeleb5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mregpanel.add(closepan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 3, -1, 30));

        registerbut3.setText("Regester");
        registerbut3.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut3.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut3.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut3.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut3.setkIndicatorThickness(0);
        registerbut3.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut3.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut3.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut3ActionPerformed(evt);
            }
        });
        mregpanel.add(registerbut3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, 325, 50));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 102, 102));
        mregpanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 910, -1, 38));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(102, 102, 102));
        jLabel61.setText("ID");
        mregpanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("Target muscle ");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox2.setText("Foot");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox3.setText("Chest");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox4.setText("Piceps");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox5.setText("Triceps");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox6.setText("Shoulder ");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox8.setText("neck");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox7.setText("stomach ");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox9.setText("Travis");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel58)
                        .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 11, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jCheckBox3)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox2)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox4)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox5)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox6)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox7)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox9)
                    .addGap(8, 8, 8)
                    .addComponent(jCheckBox8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        mregpanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 330, 380));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(0, 51, 51)));

        jLabel66.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 30)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 51, 51));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Registered_Trademark_25px_2.png"))); // NOI18N
        jLabel66.setText("egestration  ");
        jLabel66.setIconTextGap(0);

        jLabel67.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 30)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 51, 51));
        jLabel67.setText("Machine");

        kButton9.setkBackGroundColor(new java.awt.Color(0, 51, 51));
        kButton9.setkBorderRadius(80);
        kButton9.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton9.setkHoverEndColor(new java.awt.Color(51, 51, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton9.setkIndicatorColor(new java.awt.Color(153, 153, 153));
        kButton9.setkPressedColor(new java.awt.Color(0, 102, 102));
        kButton9.setkSelectedColor(new java.awt.Color(0, 153, 153));
        kButton9.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton9.setName(""); // NOI18N
        kButton9.setPreferredSize(new java.awt.Dimension(185, 7));

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/machine.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel66)
                .addGap(0, 171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(36, 36, 36))
            .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel75)
                .addGap(32, 32, 32))
        );

        mregpanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 380, 390));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        mregpanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));

        kGradientPanel3.add(mregpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 870, 1000));

        eprofile_page.setBackground(new java.awt.Color(255, 255, 255));
        eprofile_page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel8.setkEndColor(new java.awt.Color(255, 153, 153));
        kGradientPanel8.setkStartColor(new java.awt.Color(153, 153, 255));
        kGradientPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel8MouseDragged(evt);
            }
        });
        kGradientPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kGradientPanel8MouseReleased(evt);
            }
        });
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Picture_35px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel97))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel97))
        );

        pename.setBackground(new java.awt.Color(0, 0, 51));
        pename.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        pename.setForeground(new java.awt.Color(0, 153, 153));
        pename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Name_20px_3.png"))); // NOI18N
        pename.setText("first  , second name");

        kGradientPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        kGradientPanel9.setkEndColor(new java.awt.Color(0, 153, 153));
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel101.setFont(new java.awt.Font("Microsoft Uighur", 1, 48)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Settings_30px.png"))); // NOI18N
        jLabel101.setText("Setting");

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel102.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(102, 102, 102));
        jLabel102.setText("First  Name");
        jLabel102.setToolTipText("");

        pefname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        pefname.setOpaque(false);

        jLabel103.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(102, 102, 102));
        jLabel103.setText("Last Name");
        jLabel103.setToolTipText("");

        pelname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        pelname.setOpaque(false);

        jLabel104.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(102, 102, 102));
        jLabel104.setText("City");
        jLabel104.setToolTipText("");

        pestreet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        pestreet.setOpaque(false);

        jLabel105.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(102, 102, 102));
        jLabel105.setText("Street number");
        jLabel105.setToolTipText("");

        peday.setMaximumRowCount(5);
        peday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        peday.setLightWeightPopupEnabled(false);
        peday.setOpaque(false);

        peyear.setMaximumRowCount(5);
        peyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003" }));
        peyear.setSelectedIndex(18);
        peyear.setSelectedItem(2019);
        peyear.setLightWeightPopupEnabled(false);
        peyear.setOpaque(false);
        peyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peyearActionPerformed(evt);
            }
        });

        pemonth.setMaximumRowCount(5);
        pemonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        pemonth.setLightWeightPopupEnabled(false);
        pemonth.setOpaque(false);
        pemonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemonthActionPerformed(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(102, 102, 102));
        jLabel106.setText("Gender");
        jLabel106.setToolTipText("");

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(102, 102, 102));
        jLabel107.setText("salary");

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(102, 102, 102));
        jLabel108.setText("work_hours");

        pesalary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        pesalary.setOpaque(false);
        pesalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesalaryActionPerformed(evt);
            }
        });

        pework.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        pework.setOpaque(false);

        pepnumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        pepnumber.setOpaque(false);
        pepnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepnumberActionPerformed(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(102, 102, 102));
        jLabel109.setText("Phone Number");

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(102, 102, 102));
        jLabel110.setText("Department Name");

        jLabel111.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(102, 102, 102));
        jLabel111.setText("Birthdate");
        jLabel111.setToolTipText("");

        pegender.setMaximumRowCount(5);
        pegender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Famale" }));
        pegender.setLightWeightPopupEnabled(false);
        pegender.setOpaque(false);

        registerbut8.setText("save");
        registerbut8.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut8.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut8.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut8.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut8.setkIndicatorThickness(0);
        registerbut8.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut8.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut8.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut8ActionPerformed(evt);
            }
        });

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        pecity.setMaximumRowCount(5);
        pecity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenin", "Ramallah", "Nablus", "Tullkarem", "Tobas", "Hebron", "Bethlehem", " " }));
        pecity.setLightWeightPopupEnabled(false);
        pecity.setOpaque(false);
        pecity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pecityActionPerformed(evt);
            }
        });

        pednumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pednumberMouseClicked(evt);
            }
        });
        pednumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pednumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel116)
                    .addComponent(jLabel117)
                    .addComponent(jLabel118)
                    .addComponent(jLabel119)
                    .addComponent(jLabel120))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel111)
                    .addComponent(pegender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(pesalary, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(pework, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel106)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(peday, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pemonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(peyear, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel102)
                            .addComponent(pefname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel107)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel104)
                                    .addComponent(pecity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel108)
                            .addComponent(jLabel105)
                            .addComponent(pestreet, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pelname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel103)))
                    .addComponent(pepnumber)
                    .addComponent(jLabel110)
                    .addComponent(registerbut8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pednumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pefname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel116))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel105)
                            .addComponent(jLabel104))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pestreet)
                            .addComponent(pecity, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                    .addComponent(jLabel117, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107)
                    .addComponent(jLabel108))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pesalary, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pework, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel118))
                .addGap(10, 10, 10)
                .addComponent(jLabel109)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pepnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel110)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel120))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pednumber, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pemonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pegender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerbut8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel9Layout.setVerticalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Denied_35px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel121))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel121)
        );

        jPanel19.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        peid.setBackground(new java.awt.Color(0, 0, 51));
        peid.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        peid.setForeground(new java.awt.Color(0, 153, 153));
        peid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Identity_Theft_20px.png"))); // NOI18N
        peid.setText("ID");

        jLabel123.setBackground(new java.awt.Color(0, 0, 51));
        jLabel123.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 15)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(102, 255, 51));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ok_15px.png"))); // NOI18N
        jLabel123.setText("status");

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/empprofile.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(profileimage1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peid, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pename, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileimage1)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(pename, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(peid)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel123))
                    .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        kGradientPanel8.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 570, 980));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Back_Arrow_45px_2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        eprofile_page.add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 970));

        kGradientPanel3.add(eprofile_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 1000));

        infpage.setBackground(new java.awt.Color(255, 255, 255));
        infpage.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), java.awt.Color.black));
        infpage.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                infpageMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                infpageMouseMoved(evt);
            }
        });
        infpage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infpageMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                infpageMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                infpageMouseReleased(evt);
            }
        });
        infpage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closepan2.setBackground(new java.awt.Color(255, 255, 255));
        closepan2.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb1.setBackground(new java.awt.Color(255, 255, 255));
        closeleb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeleb1MouseMoved(evt);
            }
        });
        closeleb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeleb1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closepan2Layout = new javax.swing.GroupLayout(closepan2);
        closepan2.setLayout(closepan2Layout);
        closepan2Layout.setHorizontalGroup(
            closepan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb1))
        );
        closepan2Layout.setVerticalGroup(
            closepan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb1))
        );

        infpage.add(closepan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

        listinf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Prev_50px.png"))); // NOI18N
        listinf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listinfMouseClicked(evt);
            }
        });
        infpage.add(listinf, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 51));

        tablepanel.setBackground(new java.awt.Color(255, 255, 255));
        tablepanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(102, 102, 102)));
        tablepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablelist.setBackground(new java.awt.Color(51, 0, 51));
        tablelist.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));

        jLabel1.setFont(new java.awt.Font("Broadway", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("of");

        jLabel40.setBackground(new java.awt.Color(0, 153, 153));
        jLabel40.setFont(new java.awt.Font("Broadway", 1, 30)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N
        jLabel40.setText("Information ");

        jLabel45.setFont(new java.awt.Font("Broadway", 1, 10)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 204, 204));
        jLabel45.setText("2018");

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 204)));

        emplist_labe.setFont(new java.awt.Font("Broadway", 0, 30)); // NOI18N
        emplist_labe.setForeground(new java.awt.Color(255, 255, 255));
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_User_Groups_30px_6.png"))); // NOI18N
        emplist_labe.setText("Employees");
        emplist_labe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                emplist_labeMouseMoved(evt);
            }
        });
        emplist_labe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emplist_labeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emplist_labeMouseExited(evt);
            }
        });

        sellist1.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout sellist1Layout = new javax.swing.GroupLayout(sellist1);
        sellist1.setLayout(sellist1Layout);
        sellist1Layout.setHorizontalGroup(
            sellist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sellist1Layout.setVerticalGroup(
            sellist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(sellist1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emplist_labe, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(859, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sellist1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(emplist_labe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 204)));

        parlist_labe.setFont(new java.awt.Font("Broadway", 0, 30)); // NOI18N
        parlist_labe.setForeground(new java.awt.Color(255, 255, 255));
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Personal_Trainer_30px_3.png"))); // NOI18N
        parlist_labe.setText("Participants");
        parlist_labe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                parlist_labeMouseMoved(evt);
            }
        });
        parlist_labe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parlist_labeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parlist_labeMouseExited(evt);
            }
        });

        sellist2.setBackground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout sellist2Layout = new javax.swing.GroupLayout(sellist2);
        sellist2.setLayout(sellist2Layout);
        sellist2Layout.setHorizontalGroup(
            sellist2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sellist2Layout.setVerticalGroup(
            sellist2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(sellist2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parlist_labe, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parlist_labe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sellist2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel44.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("Dynamic");

        jLabel46.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("Gym");

        jPanel6.setBackground(new java.awt.Color(51, 0, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 204)));

        machlist_labe.setFont(new java.awt.Font("Broadway", 0, 30)); // NOI18N
        machlist_labe.setForeground(new java.awt.Color(255, 255, 255));
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Dumbbell_30px.png"))); // NOI18N
        machlist_labe.setText("Machine");
        machlist_labe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                machlist_labeMouseMoved(evt);
            }
        });
        machlist_labe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                machlist_labeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                machlist_labeMouseExited(evt);
            }
        });

        sellist3.setBackground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout sellist3Layout = new javax.swing.GroupLayout(sellist3);
        sellist3.setLayout(sellist3Layout);
        sellist3Layout.setHorizontalGroup(
            sellist3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sellist3Layout.setVerticalGroup(
            sellist3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(sellist3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(machlist_labe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(machlist_labe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sellist3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(51, 0, 51));

        deplist_labe.setFont(new java.awt.Font("Broadway", 0, 30)); // NOI18N
        deplist_labe.setForeground(new java.awt.Color(255, 255, 255));
        deplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Department_30px_1.png"))); // NOI18N
        deplist_labe.setText("Department");
        deplist_labe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deplist_labeMouseMoved(evt);
            }
        });
        deplist_labe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deplist_labeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deplist_labeMouseExited(evt);
            }
        });

        sellist4.setBackground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout sellist4Layout = new javax.swing.GroupLayout(sellist4);
        sellist4.setLayout(sellist4Layout);
        sellist4Layout.setHorizontalGroup(
            sellist4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sellist4Layout.setVerticalGroup(
            sellist4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(sellist4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deplist_labe)
                .addContainerGap(875, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deplist_labe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sellist4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tablelistLayout = new javax.swing.GroupLayout(tablelist);
        tablelist.setLayout(tablelistLayout);
        tablelistLayout.setHorizontalGroup(
            tablelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablelistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 645, Short.MAX_VALUE)
                .addGroup(tablelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablelistLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel45)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablelistLayout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(44, 44, 44))))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tablelistLayout.setVerticalGroup(
            tablelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablelistLayout.createSequentialGroup()
                .addGroup(tablelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tablelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jLabel1))
                    .addGroup(tablelistLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tablelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel45))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        tablepanel.add(tablelist, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1080, -1));

        emptable.setBackground(new java.awt.Color(255, 255, 255));
        emptable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SSN", "Name", "#Phone", "Salary", "Work-Hours", "Address", "Bdate", "Gender", "ID", "D_NUMBER"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        emptable.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1050, 460));

        tablepanel.add(emptable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1060, 470));

        partable.setBackground(new java.awt.Color(255, 255, 255));
        partable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SSN", "Name", "#Phone", "Address", "Weight", "Length", "Gender", "ID", "D_NUMBER", "State"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setGridColor(new java.awt.Color(0, 0, 0));
        jTable5.setRowHeight(35);
        jTable5.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane5.setViewportView(jTable5);

        partable.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1050, 460));

        tablepanel.add(partable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1060, 470));

        machtable.setBackground(new java.awt.Color(255, 255, 255));
        machtable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type of weights", "Type", "Company Name"
            }
        ));
        jTable6.setGridColor(new java.awt.Color(0, 0, 0));
        jTable6.setRowHeight(35);
        jTable6.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane6.setViewportView(jTable6);

        machtable.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1050, 460));

        tablepanel.add(machtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1060, 470));

        kButton6.setBorder(null);
        kButton6.setText("Show Profile");
        kButton6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        kButton6.setkBackGroundColor(new java.awt.Color(0, 0, 153));
        kButton6.setkBorderRadius(55);
        kButton6.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton6.setkHoverEndColor(new java.awt.Color(0, 0, 102));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(0, 51, 255));
        kButton6.setkSelectedColor(new java.awt.Color(51, 0, 51));
        kButton6.setkStartColor(new java.awt.Color(0, 0, 102));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });
        tablepanel.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        searchtxt1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        searchtxt1.setForeground(new java.awt.Color(153, 153, 153));
        searchtxt1.setText("Enter ID...");
        searchtxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        searchtxt1.setOpaque(false);
        searchtxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtxt1MouseClicked(evt);
            }
        });
        searchtxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtxt1ActionPerformed(evt);
            }
        });
        tablepanel.add(searchtxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 260, 50));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Search_27px.png"))); // NOI18N
        tablepanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 40));

        deptable.setBackground(new java.awt.Color(255, 255, 255));
        deptable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Department name", "Department number", "count of employee", "count of participants", "count of machine"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setRowHeight(35);
        jTable2.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTable2);

        deptable.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1050, 460));

        tablepanel.add(deptable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1060, 470));

        infpage.add(tablepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 1080, 880));

        kGradientPanel3.add(infpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1220, 1000));

        machinepage.setBackground(new java.awt.Color(255, 255, 255));
        machinepage.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));
        machinepage.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                machinepageMouseMoved(evt);
            }
        });

        closepan3.setBackground(new java.awt.Color(255, 255, 255));
        closepan3.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb2.setBackground(new java.awt.Color(255, 255, 255));
        closeleb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeleb2MouseMoved(evt);
            }
        });
        closeleb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeleb2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closepan3Layout = new javax.swing.GroupLayout(closepan3);
        closepan3.setLayout(closepan3Layout);
        closepan3Layout.setHorizontalGroup(
            closepan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb2))
        );
        closepan3Layout.setVerticalGroup(
            closepan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb2))
        );

        javax.swing.GroupLayout machinepageLayout = new javax.swing.GroupLayout(machinepage);
        machinepage.setLayout(machinepageLayout);
        machinepageLayout.setHorizontalGroup(
            machinepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, machinepageLayout.createSequentialGroup()
                .addGap(0, 833, Short.MAX_VALUE)
                .addComponent(closepan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        machinepageLayout.setVerticalGroup(
            machinepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(machinepageLayout.createSequentialGroup()
                .addComponent(closepan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 963, Short.MAX_VALUE))
        );

        kGradientPanel3.add(machinepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 870, 1000));

        notepage.setBackground(new java.awt.Color(255, 255, 255));
        notepage.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));
        notepage.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                notepageMouseMoved(evt);
            }
        });

        closepan4.setBackground(new java.awt.Color(255, 255, 255));
        closepan4.setPreferredSize(new java.awt.Dimension(33, 33));

        closeleb3.setBackground(new java.awt.Color(255, 255, 255));
        closeleb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Delete_33px_4.png"))); // NOI18N
        closeleb3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeleb3MouseMoved(evt);
            }
        });
        closeleb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeleb3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closepan4Layout = new javax.swing.GroupLayout(closepan4);
        closepan4.setLayout(closepan4Layout);
        closepan4Layout.setHorizontalGroup(
            closepan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb3))
        );
        closepan4Layout.setVerticalGroup(
            closepan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closepan4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeleb3))
        );

        javax.swing.GroupLayout notepageLayout = new javax.swing.GroupLayout(notepage);
        notepage.setLayout(notepageLayout);
        notepageLayout.setHorizontalGroup(
            notepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notepageLayout.createSequentialGroup()
                .addGap(0, 833, Short.MAX_VALUE)
                .addComponent(closepan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        notepageLayout.setVerticalGroup(
            notepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notepageLayout.createSequentialGroup()
                .addComponent(closepan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 963, Short.MAX_VALUE))
        );

        kGradientPanel3.add(notepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 870, 1000));

        profile_page.setBackground(new java.awt.Color(255, 255, 255));
        profile_page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 153, 153));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Picture_35px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel70))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel70))
        );

        jLabel72.setBackground(new java.awt.Color(0, 0, 51));
        jLabel72.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 153, 153));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Name_20px_3.png"))); // NOI18N
        jLabel72.setText("first  , second name");

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        kGradientPanel2.setkEndColor(new java.awt.Color(0, 153, 153));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel73.setFont(new java.awt.Font("Microsoft Uighur", 1, 48)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Settings_30px.png"))); // NOI18N
        jLabel73.setText("Setting");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel74.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(102, 102, 102));
        jLabel74.setText("First  Name");
        jLabel74.setToolTipText("");

        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField1.setOpaque(false);

        jLabel77.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("Last Name");
        jLabel77.setToolTipText("");

        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField2.setOpaque(false);

        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField3.setOpaque(false);

        jLabel79.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(102, 102, 102));
        jLabel79.setText("City");
        jLabel79.setToolTipText("");

        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField4.setOpaque(false);

        jLabel80.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(102, 102, 102));
        jLabel80.setText("Street number");
        jLabel80.setToolTipText("");

        daybox3.setMaximumRowCount(5);
        daybox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        daybox3.setLightWeightPopupEnabled(false);
        daybox3.setOpaque(false);

        yearbox3.setMaximumRowCount(5);
        yearbox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
        yearbox3.setSelectedIndex(18);
        yearbox3.setSelectedItem(2019);
        yearbox3.setLightWeightPopupEnabled(false);
        yearbox3.setOpaque(false);
        yearbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearbox3ActionPerformed(evt);
            }
        });

        monthbox3.setMaximumRowCount(5);
        monthbox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        monthbox3.setLightWeightPopupEnabled(false);
        monthbox3.setOpaque(false);
        monthbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthbox3ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(102, 102, 102));
        jLabel81.setText("Gender");
        jLabel81.setToolTipText("");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(102, 102, 102));
        jLabel82.setText("Wieght");

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(102, 102, 102));
        jLabel83.setText("Length");

        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField5.setOpaque(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField6.setOpaque(false);

        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField7.setOpaque(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(102, 102, 102));
        jLabel84.setText("Phone Number");

        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField8.setOpaque(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(102, 102, 102));
        jLabel85.setText("Department Name");

        jLabel86.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(102, 102, 102));
        jLabel86.setText("Birthdate");
        jLabel86.setToolTipText("");

        daybox4.setMaximumRowCount(5);
        daybox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Famale" }));
        daybox4.setLightWeightPopupEnabled(false);
        daybox4.setOpaque(false);

        registerbut6.setText("save");
        registerbut6.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut6.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut6.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut6.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut6.setkIndicatorThickness(0);
        registerbut6.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut6.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut6.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut6ActionPerformed(evt);
            }
        });

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76)
                    .addComponent(jLabel87)
                    .addComponent(jLabel89)
                    .addComponent(jLabel90)
                    .addComponent(jLabel91))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(daybox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel84)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel81)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(daybox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(monthbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(yearbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel74)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel79)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel82))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel83)
                                .addComponent(jLabel80)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel77)))
                        .addComponent(jTextField7)
                        .addComponent(jLabel85)
                        .addComponent(jTextField8)
                        .addComponent(registerbut6, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel89))
                .addGap(10, 10, 10)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addGap(32, 32, 32)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daybox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daybox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(registerbut6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Denied_35px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel88))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel88)
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel92.setBackground(new java.awt.Color(0, 0, 51));
        jLabel92.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 153, 153));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Identity_Theft_20px.png"))); // NOI18N
        jLabel92.setText("ID");

        jLabel94.setBackground(new java.awt.Color(0, 0, 51));
        jLabel94.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 15)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(102, 255, 51));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ok_15px.png"))); // NOI18N
        jLabel94.setText("status");

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icon-bodybuilding.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(profileimage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileimage)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel92)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94))
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 570, 990));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Back_Arrow_45px_2.png"))); // NOI18N
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        profile_page.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 990));

        kGradientPanel3.add(profile_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1220, 990));

        mprofile_page.setBackground(new java.awt.Color(255, 255, 255));
        mprofile_page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel10.setkEndColor(new java.awt.Color(255, 153, 153));
        kGradientPanel10.setkStartColor(new java.awt.Color(153, 153, 255));
        kGradientPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Picture_35px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel125))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel125))
        );

        jLabel126.setBackground(new java.awt.Color(0, 0, 51));
        jLabel126.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 153, 153));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Name_20px_3.png"))); // NOI18N
        jLabel126.setText("first  , second name");

        kGradientPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        kGradientPanel11.setkEndColor(new java.awt.Color(0, 153, 153));
        kGradientPanel11.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel127.setFont(new java.awt.Font("Microsoft Uighur", 1, 48)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Settings_30px.png"))); // NOI18N
        jLabel127.setText("Setting");

        javax.swing.GroupLayout kGradientPanel11Layout = new javax.swing.GroupLayout(kGradientPanel11);
        kGradientPanel11.setLayout(kGradientPanel11Layout);
        kGradientPanel11Layout.setHorizontalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel127)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel11Layout.setVerticalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel128.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(102, 102, 102));
        jLabel128.setText("First  Name");
        jLabel128.setToolTipText("");

        jTextField17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField17.setOpaque(false);

        jLabel129.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(102, 102, 102));
        jLabel129.setText("Last Name");
        jLabel129.setToolTipText("");

        jTextField18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField18.setOpaque(false);

        jTextField19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField19.setOpaque(false);

        jLabel130.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(102, 102, 102));
        jLabel130.setText("City");
        jLabel130.setToolTipText("");

        jTextField20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField20.setOpaque(false);

        jLabel131.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(102, 102, 102));
        jLabel131.setText("Street number");
        jLabel131.setToolTipText("");

        daybox7.setMaximumRowCount(5);
        daybox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        daybox7.setLightWeightPopupEnabled(false);
        daybox7.setOpaque(false);

        yearbox5.setMaximumRowCount(5);
        yearbox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
        yearbox5.setSelectedIndex(18);
        yearbox5.setSelectedItem(2019);
        yearbox5.setLightWeightPopupEnabled(false);
        yearbox5.setOpaque(false);
        yearbox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearbox5ActionPerformed(evt);
            }
        });

        monthbox6.setMaximumRowCount(5);
        monthbox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        monthbox6.setLightWeightPopupEnabled(false);
        monthbox6.setOpaque(false);
        monthbox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthbox6ActionPerformed(evt);
            }
        });

        jLabel132.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(102, 102, 102));
        jLabel132.setText("Gender");
        jLabel132.setToolTipText("");

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(102, 102, 102));
        jLabel133.setText("Wieght");

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(102, 102, 102));
        jLabel134.setText("Length");

        jTextField21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField21.setOpaque(false);
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jTextField22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField22.setOpaque(false);

        jTextField23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField23.setOpaque(false);
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(102, 102, 102));
        jLabel135.setText("Phone Number");

        jTextField24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField24.setOpaque(false);
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(102, 102, 102));
        jLabel136.setText("Department Name");

        jLabel137.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(102, 102, 102));
        jLabel137.setText("Birthdate");
        jLabel137.setToolTipText("");

        daybox8.setMaximumRowCount(5);
        daybox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Famale" }));
        daybox8.setLightWeightPopupEnabled(false);
        daybox8.setOpaque(false);

        registerbut9.setText("save");
        registerbut9.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut9.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut9.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut9.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut9.setkIndicatorThickness(0);
        registerbut9.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut9.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut9.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut9ActionPerformed(evt);
            }
        });

        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel138)
                    .addComponent(jLabel139)
                    .addComponent(jLabel140)
                    .addComponent(jLabel141)
                    .addComponent(jLabel142))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel137)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(daybox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel135)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel132)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(daybox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(monthbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(yearbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel128)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel130)
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel133))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel134)
                                .addComponent(jLabel131)
                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel129)))
                        .addComponent(jTextField23)
                        .addComponent(jLabel136)
                        .addComponent(jTextField24)
                        .addComponent(registerbut9, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel138))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel131)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel133)
                    .addComponent(jLabel134))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel140))
                .addGap(10, 10, 10)
                .addComponent(jLabel135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel141))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel136)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel142))
                .addGap(32, 32, 32)
                .addComponent(jLabel137)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daybox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel132)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daybox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(registerbut9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Denied_35px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel143))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel143)
        );

        jPanel24.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel144.setBackground(new java.awt.Color(0, 0, 51));
        jLabel144.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(0, 153, 153));
        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Identity_Theft_20px.png"))); // NOI18N
        jLabel144.setText("ID");

        jLabel145.setBackground(new java.awt.Color(0, 0, 51));
        jLabel145.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 15)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(102, 255, 51));
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ok_15px.png"))); // NOI18N
        jLabel145.setText("status");

        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icon-bodybuilding.png"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(profileimage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileimage2)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel144)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel145))
                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel10.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 570, 990));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Back_Arrow_45px_2.png"))); // NOI18N
        kGradientPanel10.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        mprofile_page.add(kGradientPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 990));

        kGradientPanel3.add(mprofile_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1220, 990));

        dprofile_page.setBackground(new java.awt.Color(255, 255, 255));
        dprofile_page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel12.setkEndColor(new java.awt.Color(255, 153, 153));
        kGradientPanel12.setkStartColor(new java.awt.Color(153, 153, 255));
        kGradientPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(102, 102, 102)));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Picture_35px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel147))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel147))
        );

        jLabel148.setBackground(new java.awt.Color(0, 0, 51));
        jLabel148.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(0, 153, 153));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Name_20px_3.png"))); // NOI18N
        jLabel148.setText("first  , second name");

        kGradientPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        kGradientPanel13.setkEndColor(new java.awt.Color(0, 153, 153));
        kGradientPanel13.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel149.setFont(new java.awt.Font("Microsoft Uighur", 1, 48)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Settings_30px.png"))); // NOI18N
        jLabel149.setText("Setting");

        javax.swing.GroupLayout kGradientPanel13Layout = new javax.swing.GroupLayout(kGradientPanel13);
        kGradientPanel13.setLayout(kGradientPanel13Layout);
        kGradientPanel13Layout.setHorizontalGroup(
            kGradientPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel149)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel13Layout.setVerticalGroup(
            kGradientPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel150.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(102, 102, 102));
        jLabel150.setText("First  Name");
        jLabel150.setToolTipText("");

        jTextField25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField25.setOpaque(false);

        jLabel151.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(102, 102, 102));
        jLabel151.setText("Last Name");
        jLabel151.setToolTipText("");

        jTextField26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField26.setOpaque(false);

        jTextField27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField27.setOpaque(false);

        jLabel152.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(102, 102, 102));
        jLabel152.setText("City");
        jLabel152.setToolTipText("");

        jTextField28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField28.setOpaque(false);

        jLabel153.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(102, 102, 102));
        jLabel153.setText("Street number");
        jLabel153.setToolTipText("");

        daybox9.setMaximumRowCount(5);
        daybox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12 ", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        daybox9.setLightWeightPopupEnabled(false);
        daybox9.setOpaque(false);

        yearbox6.setMaximumRowCount(5);
        yearbox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
        yearbox6.setSelectedIndex(18);
        yearbox6.setSelectedItem(2019);
        yearbox6.setLightWeightPopupEnabled(false);
        yearbox6.setOpaque(false);
        yearbox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearbox6ActionPerformed(evt);
            }
        });

        monthbox7.setMaximumRowCount(5);
        monthbox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "Abril", "May", "June", "July", "August", "September", "October", "November", "Decmber" }));
        monthbox7.setLightWeightPopupEnabled(false);
        monthbox7.setOpaque(false);
        monthbox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthbox7ActionPerformed(evt);
            }
        });

        jLabel154.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(102, 102, 102));
        jLabel154.setText("Gender");
        jLabel154.setToolTipText("");

        jLabel155.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(102, 102, 102));
        jLabel155.setText("Wieght");

        jLabel156.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(102, 102, 102));
        jLabel156.setText("Length");

        jTextField29.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField29.setOpaque(false);
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        jTextField30.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField30.setOpaque(false);

        jTextField31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField31.setOpaque(false);
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });

        jLabel157.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(102, 102, 102));
        jLabel157.setText("Phone Number");

        jTextField32.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        jTextField32.setOpaque(false);
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });

        jLabel158.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(102, 102, 102));
        jLabel158.setText("Department Name");

        jLabel159.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(102, 102, 102));
        jLabel159.setText("Birthdate");
        jLabel159.setToolTipText("");

        daybox10.setMaximumRowCount(5);
        daybox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Famale" }));
        daybox10.setLightWeightPopupEnabled(false);
        daybox10.setOpaque(false);

        registerbut10.setText("save");
        registerbut10.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        registerbut10.setkEndColor(new java.awt.Color(0, 51, 51));
        registerbut10.setkHoverEndColor(new java.awt.Color(0, 0, 51));
        registerbut10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        registerbut10.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        registerbut10.setkIndicatorThickness(0);
        registerbut10.setkPressedColor(new java.awt.Color(0, 0, 0));
        registerbut10.setkSelectedColor(new java.awt.Color(0, 153, 153));
        registerbut10.setkStartColor(new java.awt.Color(0, 102, 102));
        registerbut10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbut10ActionPerformed(evt);
            }
        });

        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel163.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ask_Question_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel160)
                    .addComponent(jLabel161)
                    .addComponent(jLabel162)
                    .addComponent(jLabel163)
                    .addComponent(jLabel164))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel159)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(daybox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel157)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel154)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addComponent(daybox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(monthbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(yearbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel150)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel152)
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel155))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel156)
                                .addComponent(jLabel153)
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel151)))
                        .addComponent(jTextField31)
                        .addComponent(jLabel158)
                        .addComponent(jTextField32)
                        .addComponent(registerbut10, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel151)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel160))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel152)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel153)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel161, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel155)
                    .addComponent(jLabel156))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel162))
                .addGap(10, 10, 10)
                .addComponent(jLabel157)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel158)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164))
                .addGap(32, 32, 32)
                .addComponent(jLabel159)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daybox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel154)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daybox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(registerbut10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Denied_35px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel165))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel165)
        );

        jPanel29.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel166.setBackground(new java.awt.Color(0, 0, 51));
        jLabel166.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(0, 153, 153));
        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Identity_Theft_20px.png"))); // NOI18N
        jLabel166.setText("ID");

        jLabel167.setBackground(new java.awt.Color(0, 0, 51));
        jLabel167.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 15)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(102, 255, 51));
        jLabel167.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Ok_15px.png"))); // NOI18N
        jLabel167.setText("status");

        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icon-bodybuilding.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(profileimage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileimage3)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel166)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel167))
                    .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel12.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 570, 990));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3/icons8_Back_Arrow_45px_2.png"))); // NOI18N
        kGradientPanel12.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        dprofile_page.add(kGradientPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 990));

        kGradientPanel3.add(dprofile_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1220, 990));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
boolean pf = true;
    boolean ef = false;
    boolean mf = false;
    boolean df = false;

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void kGradientPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MousePressed
        // TODO add your handling code here:
        q = evt.getX();
        w = evt.getY();

    }//GEN-LAST:event_kGradientPanel3MousePressed
    int q, w;

    private void listpanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listpanelMouseReleased
        setOpacity((float) 1.0);
    }//GEN-LAST:event_listpanelMouseReleased

    private void listpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listpanelMousePressed
        // setOpacity((float)0.7);
        q = evt.getX();
        w = evt.getY();
        new Drag(listpanel).onPress(evt);
    }//GEN-LAST:event_listpanelMousePressed

    private void listpanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listpanelMouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - q, yy - w);
        setOpacity((float) 0.7);
        //new Drag(listpanel).moveWindow(evt);

    }//GEN-LAST:event_listpanelMouseDragged

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        try {
            // TODO add your handling code here:
            OracleDataSource ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("C##GYM");
            ods.setPassword("0595");
            Connection con=ods.getConnection();
            InputStream input=new FileInputStream(new File("gym.jrxml"));
            JasperDesign jd=JRXmlLoader.load(input);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, con);
            OutputStream output=new FileOutputStream(new File("gym5.pdf"));
            JasperExportManager.exportReportToPdfStream(jp, output);
            output.close();
            input.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
       /* try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PARTICIPANTS");
            participants par;
            ArrayList<participants> parlist = new ArrayList<participants>();
            while (rs.next()) {
                par = new participants(rs.getString("END_DATE"),rs.getString("START_DATE"),rs.getString("SSN"),rs.getString("PHONE_NUMBER"),rs.getString("ID_PART"),rs.getString("B_DATE"),rs.getString("GENDER"),rs.getString("CITY"),rs.getString("STREET"),rs.getInt("D_NUMBER"),rs.getInt("WEIGHT"),rs.getInt("HEIGHT"));
                parlist.add(par);
                
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] op = new Object[10];
            model.setRowCount(0);
            for (int i = 0; i < parlist.size(); i++) {
               op[0] = (Object) parlist.get(i).getssn(); 
               op[1] = (Object) parlist.get(i).getname();
               op[2] = (Object) parlist.get(i).getphone();
               op[3] = (Object) parlist.get(i).getaddress();
               op[4] = (Object) parlist.get(i).getweight();
               op[5] = (Object) parlist.get(i).getheight();
               op[6] = (Object) parlist.get(i).getgender();
               op[7] = (Object) parlist.get(i).getid();
               op[8] = (Object) parlist.get(i).getdnumber();
               op[9] = (Object) parlist.get(i).getstate();
               model.addRow(op);
            }
            con.close();
            
        }
        
        catch (Exception E) {
            JOptionPane.showMessageDialog(null, "exception");

        }*/
        
        
        
    }//GEN-LAST:event_kButton5ActionPerformed
public void getdnumber(){
    try{
         Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            //JOptionPane.showMessageDialog(null, "receive here");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM department");
            dnumber.removeAllItems();
            while(rs.next()){
                dnumber.addItem(rs.getString("D_NUMBER"));
                 }
            st.close();
            rs.close();
            con.close();
            
    }
    catch (Exception ee){
        
    }
}
public void getdnumber2(){
    try{
         Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            //JOptionPane.showMessageDialog(null, "receive here");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM DEPARTMENT");
            dnumber1.removeAllItems();
            while(rs.next()){
                dnumber1.addItem(rs.getString("D_NUMBER"));
                 }
            st.close();
            rs.close();
            con.close();
            
    }
    catch (Exception ee){
        
    }
}

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            //JOptionPane.showMessageDialog(null, "receive here");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE");
            employee emp;
            ArrayList<employee> emplist = new ArrayList<employee>();
            //  JOptionPane.showMessageDialog(null, "receive here1");
            while (rs.next()) {
               
               emp = new employee(rs.getString("FNAME"),rs.getString("LNAME"),rs.getString("CITY")+rs.getString("STREET_NUMBER"),rs.getString("B_DATE"),rs.getString("SSN"),rs.getString("PHONE_NUMBER"),rs.getString("GENDER"),rs.getInt("SALARY"),rs.getInt("WORKING_HOURS"),rs.getInt("ID_EMPLOYEE"),rs.getInt("D_NUMBER"));
                emplist.add(emp);
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] op = new Object[10];
            model.setRowCount(0);
            // JOptionPane.showMessageDialog(null, deplist.size());

            for (int i = 0; i < emplist.size(); i++) {
                op[0] = (Object) emplist.get(i).getssn();
              op[1] = (Object)( emplist.get(i).getfname()+" "+emplist.get(i).getlname());
            op[2] = (Object) emplist.get(i).getphone();
            op[3] = (Object) emplist.get(i).getsalary();
            op[4] = (Object) emplist.get(i).getwh();
            op[5] = (Object) emplist.get(i).getaddress();
            op[6] = (Object) emplist.get(i).getdate();
            op[7] = (Object) emplist.get(i).getgender();
            op[8] = (Object) emplist.get(i).geteid();
            op[9] = (Object) emplist.get(i).getdn();
                model.addRow(op);

            }
//JOptionPane.showMessageDialog(null, "done");
            con.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "exception");

        }
        
    }//GEN-LAST:event_kButton3ActionPerformed

    private void fnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxtActionPerformed

    private void lnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnametxtActionPerformed

    private void ssntxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssntxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssntxtActionPerformed

    private void pnumbertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnumbertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnumbertxtActionPerformed

    private void streettxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streettxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streettxtActionPerformed

    private void closelebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelebMouseClicked
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_closelebMouseClicked

    private void closelebMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelebMouseMoved
        // TODO add your handling code here:
        closepan1.setBackground(Color.RED);
        closeleb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));
    }//GEN-LAST:event_closelebMouseMoved

    private void pregpanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pregpanelMouseMoved
        // TODO add your handling code here:
        closepan1.setBackground(Color.WHITE);
        closeleb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));
        reglist.setVisible(false);

    }//GEN-LAST:event_pregpanelMouseMoved

    private void kButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton4MouseClicked
        // TODO add your handling code here:

        pf = true;
        ef = mf = false;
        df = false;
        pregpanel.setVisible(true);
        deppanel.setVisible(true);

        infpage.setVisible(false);
        machinepage.setVisible(false);
        notepage.setVisible(false);

    }//GEN-LAST:event_kButton4MouseClicked

    private void kButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton3MouseClicked
        // TODO add your handling code here:
        listpanel.setVisible(false);
eprofile_page.setVisible(false);
        eregpanel.setVisible(false);
        pregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);
        pregpanel.setVisible(false);
        infpage.setVisible(true);
        machinepage.setVisible(false);
        notepage.setVisible(false);
        list1=true;
    }//GEN-LAST:event_kButton3MouseClicked

    private void kButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton5MouseClicked
        pf = true;
        ef = mf = false;
        pregpanel.setVisible(false);

        eregpanel.setVisible(false);
        pregpanel.setVisible(false);
        mregpanel.setVisible(false);
        infpage.setVisible(false);
        machinepage.setVisible(true);
        notepage.setVisible(false);    }//GEN-LAST:event_kButton5MouseClicked

    private void kButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton2MouseClicked
        // TODO add your handling code here:
        pf = true;
        ef = mf = false;
        eregpanel.setVisible(false);
        pregpanel.setVisible(false);
        mregpanel.setVisible(false);
        pregpanel.setVisible(false);
        infpage.setVisible(false);
        machinepage.setVisible(false);
        notepage.setVisible(true);
    }//GEN-LAST:event_kButton2MouseClicked

    private void closeleb3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb3MouseMoved
        // TODO add your handling code here:
        closepan4.setBackground(Color.RED);
        closeleb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));

    }//GEN-LAST:event_closeleb3MouseMoved

    private void closeleb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeleb3MouseClicked

    private void notepageMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notepageMouseMoved
        // TODO add your handling code here:
        closepan4.setBackground(Color.WHITE);
        closeleb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));

    }//GEN-LAST:event_notepageMouseMoved

    private void infpageMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infpageMouseMoved
        // TODO add your handling code here:
        closepan2.setBackground(Color.WHITE);
        closeleb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));
    }//GEN-LAST:event_infpageMouseMoved

    private void closeleb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeleb1MouseClicked

    private void closeleb1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb1MouseMoved
        // TODO add your handling code here:
        closepan2.setBackground(Color.RED);
        closeleb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));
    }//GEN-LAST:event_closeleb1MouseMoved
    Boolean f = false;
    private void kButton4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton4MouseMoved
        // TODO add your handling code here:
        if (pf) {
            reglist.setVisible(true);
            reglist1.setVisible(false);
            reglist2.setVisible(false);
            reglist3.setVisible(false);

        } else if (ef) {
            reglist1.setVisible(true);
            reglist.setVisible(false);
            reglist2.setVisible(false);
            reglist3.setVisible(false);

        } else if (mf) {
            reglist.setVisible(false);
            reglist1.setVisible(false);
            reglist2.setVisible(true);
            reglist3.setVisible(false);

        } else if (df) {
            reglist.setVisible(false);
            reglist1.setVisible(false);
            reglist2.setVisible(false);
            reglist3.setVisible(true);

        }
    }//GEN-LAST:event_kButton4MouseMoved

    private void reglistMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reglistMouseMoved
        // TODO add your handling code here:
        reglist.setVisible(true);

    }//GEN-LAST:event_reglistMouseMoved

    private void kGradientPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel4MouseMoved
        // TODO add your handling code here:

        reglist.setVisible(true);
    }//GEN-LAST:event_kGradientPanel4MouseMoved

    private void parlabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabelMouseMoved
        // TODO add your handling code here:
        parlabel.setForeground(new Color(51, 51, 255));
        parlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px_3.png"))); // NOI18N


    }//GEN-LAST:event_parlabelMouseMoved

    private void parlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabelMouseExited
        // TODO add your handling code here:
        parlabel.setForeground(Color.white);
        parlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px.png"))); // NOI18N

    }//GEN-LAST:event_parlabelMouseExited

    private void emplabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabelMouseMoved
        // TODO add your handling code here:
        emplabel.setForeground(new Color(51, 51, 255));
        emplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_2.png"))); // NOI18N


    }//GEN-LAST:event_emplabelMouseMoved

    private void emplabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabelMouseExited
        // TODO add your handling code here:
        emplabel.setForeground(Color.white);
        emplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_emplabelMouseExited

    private void machlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabelMouseExited
        // TODO add your handling code here:
        machlabel.setForeground(Color.white);
        machlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px.png"))); // NOI18N


    }//GEN-LAST:event_machlabelMouseExited

    private void machlabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabelMouseMoved
        // TODO add your handling code here:
        machlabel.setForeground(new Color(51, 51, 255));
        machlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_machlabelMouseMoved

    private void listpanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listpanelMouseMoved
        // TODO add your handling code here:
        reglist.setVisible(false);
        reglist1.setVisible(false);
        reglist2.setVisible(false);
        reglist3.setVisible(false);

    }//GEN-LAST:event_listpanelMouseMoved

    private void parlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabelMouseClicked
        // TODO add your handling code here:

        pf = true;
        mf = ef = false;
        df = false;
        pregpanel.setVisible(true);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);
        reglist.setVisible(false);


    }//GEN-LAST:event_parlabelMouseClicked

    private void emplabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabelMouseClicked
        // TODO add your handling code here:
        ef = true;
        mf = pf = false;
        df = false;
        pregpanel.setVisible(false);
        eregpanel.setVisible(true);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);
        reglist.setVisible(false);

    }//GEN-LAST:event_emplabelMouseClicked

    private void wtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wtxtActionPerformed

    private void ltxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ltxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ltxtActionPerformed

    private void machinepageMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machinepageMouseMoved
        // TODO add your handling code here:
        closepan3.setBackground(Color.WHITE);
        closeleb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));
    }//GEN-LAST:event_machinepageMouseMoved

    private void closeleb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeleb2MouseClicked

    private void closeleb2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb2MouseMoved
        // TODO add your handling code here:
        closepan3.setBackground(Color.RED);
        closeleb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));
    }//GEN-LAST:event_closeleb2MouseMoved

    private void mregpanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mregpanelMouseMoved
        // TODO add your handling code here:
        closepan6.setBackground(Color.WHITE);
        closeleb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));
        reglist2.setVisible(false);

    }//GEN-LAST:event_mregpanelMouseMoved

    private void closeleb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeleb5MouseClicked

    private void closeleb5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb5MouseMoved
        // TODO add your handling code here:
        closepan6.setBackground(Color.RED);
        closeleb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));

    }//GEN-LAST:event_closeleb5MouseMoved

    private void id_machinetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_machinetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_machinetxtActionPerformed

    private void nametxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxt2ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void machlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabelMouseClicked
        // TODO add your handling code here:eregpanel.setVisible(true);
        mf = true;
        ef = pf = false;
        df = false;

        pregpanel.setVisible(false);
        mregpanel.setVisible(true);
        eregpanel.setVisible(false);
        deppanel.setVisible(false);

        reglist.setVisible(false);


    }//GEN-LAST:event_machlabelMouseClicked

    private void machlabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel2MouseMoved
        // TODO add your handling code here:
        machlabel2.setForeground(new Color(51, 51, 255));
        machlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_machlabel2MouseMoved

    private void machlabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel2MouseClicked
        // TODO add your handling code here:
        mf = true;
        ef = pf = false;
        df = false;
        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(true);
        reglist2.setVisible(false);
        deppanel.setVisible(false);

    }//GEN-LAST:event_machlabel2MouseClicked

    private void machlabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel2MouseExited
        // TODO add your handling code here:
        machlabel2.setForeground(Color.white);
        machlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px.png"))); // NOI18N


    }//GEN-LAST:event_machlabel2MouseExited

    private void parlabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel2MouseMoved
        // TODO add your handling code here:
        parlabel2.setForeground(new Color(51, 51, 255));
        parlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_parlabel2MouseMoved
    private void parlabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel2MouseClicked
        // TODO add your handling code here:
        pf = true;
        mf = ef = false;
        df = false;

        pregpanel.setVisible(true);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);
        reglist2.setVisible(false);
    }//GEN-LAST:event_parlabel2MouseClicked

    private void parlabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel2MouseExited
        // TODO add your handling code here:
        parlabel2.setForeground(Color.white);
        parlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px.png"))); // NOI18N

    }//GEN-LAST:event_parlabel2MouseExited

    private void emplabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel2MouseMoved
        // TODO add your handling code here:
        emplabel2.setForeground(new Color(51, 51, 255));
        emplabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_2.png"))); // NOI18N

    }//GEN-LAST:event_emplabel2MouseMoved

    private void emplabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel2MouseClicked
        // TODO add your handling code here:
        ef = true;
        mf = pf = false;
        df = false;
        deppanel.setVisible(false);

        pregpanel.setVisible(false);
        eregpanel.setVisible(true);
        mregpanel.setVisible(false);
        reglist2.setVisible(false);
    }//GEN-LAST:event_emplabel2MouseClicked

    private void emplabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel2MouseExited
        // TODO add your handling code here:
        emplabel2.setForeground(Color.white);
        emplabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_emplabel2MouseExited

    private void kGradientPanel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel6MouseMoved

    private void reglist2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reglist2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_reglist2MouseMoved

    private void kButton3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton3MouseMoved
        // TODO add your handling code here:
        reglist.setVisible(false);
        reglist1.setVisible(false);
        reglist2.setVisible(false);
        reglist3.setVisible(false);


    }//GEN-LAST:event_kButton3MouseMoved

    private void eyearboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyearboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eyearboxActionPerformed

    private void emonthboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emonthboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emonthboxActionPerformed

    private void eregpanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eregpanelMouseMoved
        // TODO add your handling code here:
        closepan5.setBackground(Color.WHITE);
        closeleb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));
        reglist1.setVisible(false);
    }//GEN-LAST:event_eregpanelMouseMoved

    private void exptxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exptxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exptxtActionPerformed

    private void is_coachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is_coachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_is_coachActionPerformed

    private void is_coachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_is_coachMouseClicked
        // TODO add your handling code here:
        if (is_coach.isSelected()) {
            exptxt.enable(true);
            exptxt.setBackground(new Color(255, 255, 255));

        } else {
            exptxt.enable(false);
            exptxt.setBackground(new Color(80, 80, 80, 120));
            exptxt.setBorder(pnumbertxt.getBorder());

        }

    }//GEN-LAST:event_is_coachMouseClicked

    private void closeleb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeleb4MouseClicked

    private void closeleb4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb4MouseMoved
        // TODO add your handling code here:
        closepan5.setBackground(Color.RED);
        closeleb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));
    }//GEN-LAST:event_closeleb4MouseMoved

    private void work_hourstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_work_hourstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_work_hourstxtActionPerformed

    private void salarytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarytxtActionPerformed

    private void streettxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streettxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streettxt1ActionPerformed

    private void pnumbertxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnumbertxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnumbertxt1ActionPerformed

    private void ssntxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssntxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssntxt1ActionPerformed

    private void lnametxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnametxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnametxt1ActionPerformed

    private void fnametxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxt1ActionPerformed

    private void reglist1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reglist1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_reglist1MouseMoved

    private void kGradientPanel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel5MouseMoved
        // TODO add your handling code here:
        reglist1.setVisible(true);
    }//GEN-LAST:event_kGradientPanel5MouseMoved

    private void emplabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel1MouseExited
        // TODO add your handling code here:
        emplabel1.setForeground(Color.white);
        emplabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_3.png"))); // NOI18N
    }//GEN-LAST:event_emplabel1MouseExited

    private void emplabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel1MouseClicked
        // TODO add your handling code here:
        ef = true;
        mf = pf = false;
        df = false;
        deppanel.setVisible(false);

        pregpanel.setVisible(false);
        eregpanel.setVisible(true);
        mregpanel.setVisible(false);
        reglist1.setVisible(false);
    }//GEN-LAST:event_emplabel1MouseClicked

    private void emplabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel1MouseMoved
        // TODO add your handling code here:
        emplabel1.setForeground(new Color(51, 51, 255));
        emplabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_2.png"))); // NOI18N
    }//GEN-LAST:event_emplabel1MouseMoved

    private void parlabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel1MouseExited
        // TODO add your handling code here:
        parlabel1.setForeground(Color.white);
        parlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px.png"))); // NOI18N
    }//GEN-LAST:event_parlabel1MouseExited

    private void parlabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel1MouseClicked
        // TODO add your handling code here:
        pf = true;
        mf = ef = false;
        df = false;

        pregpanel.setVisible(true);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);

        reglist1.setVisible(false);
    }//GEN-LAST:event_parlabel1MouseClicked

    private void parlabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel1MouseMoved
        // TODO add your handling code here:
        parlabel1.setForeground(new Color(51, 51, 255));
        parlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px_3.png"))); // NOI18N
    }//GEN-LAST:event_parlabel1MouseMoved

    private void machlabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel1MouseExited
        // TODO add your handling code here:
        machlabel1.setForeground(Color.white);
        machlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px.png"))); // NOI18N

    }//GEN-LAST:event_machlabel1MouseExited

    private void machlabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel1MouseClicked
        // TODO add your handling code here:
        mf = true;
        ef = pf = false;
        df = false;
        deppanel.setVisible(false);

        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(true);
        reglist1.setVisible(false);
    }//GEN-LAST:event_machlabel1MouseClicked

    private void machlabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel1MouseMoved
        // TODO add your handling code here:
        machlabel1.setForeground(new Color(51, 51, 255));
        machlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_machlabel1MouseMoved

    private void listinfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listinfMouseClicked
        // TODO add your handling code here:
        if (pf) {
            listpanel.setVisible(true);
            pregpanel.setVisible(true);
            eregpanel.setVisible(false);
            mregpanel.setVisible(false);
            deppanel.setVisible(false);

        } else if (ef) {
            listpanel.setVisible(true);
            eregpanel.setVisible(true);
            pregpanel.setVisible(false);
            mregpanel.setVisible(false);
            deppanel.setVisible(false);

        } else if (mf) {
            listpanel.setVisible(true);
            mregpanel.setVisible(true);
            pregpanel.setVisible(false);
            eregpanel.setVisible(false);
            deppanel.setVisible(false);

        } else if (df) {
            listpanel.setVisible(true);
            deppanel.setVisible(true);
            mregpanel.setVisible(false);
            pregpanel.setVisible(false);
            eregpanel.setVisible(false);

        }

        infpage.setVisible(false);
    }//GEN-LAST:event_listinfMouseClicked
    Boolean list1, list2, list3;
    int fx, fy;
    private void infpageMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infpageMouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - fx, yy - fy);
        setOpacity((float) 0.7);
        //new Drag(listpanel).moveWindow(evt);

    }//GEN-LAST:event_infpageMouseDragged

    private void infpageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infpageMousePressed
        // TODO add your handling code here:
        fx = evt.getX();
        fy = evt.getY();
    }//GEN-LAST:event_infpageMousePressed

    private void infpageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infpageMouseReleased
        // TODO add your handling code here:
        setOpacity((float) 1.0);

    }//GEN-LAST:event_infpageMouseReleased

    private void kGradientPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MouseReleased
        // TODO add your handling code here:
        setOpacity((float) 1.0);

    }//GEN-LAST:event_kGradientPanel3MouseReleased

    private void kGradientPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        setLocation(xx - q, yy - w);
        setOpacity((float) 0.7);
        new Drag(kGradientPanel3).moveWindow(evt);
    }//GEN-LAST:event_kGradientPanel3MouseDragged

    private void infpageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infpageMouseClicked
        // TODO add your handling code here:
        listpanel.setVisible(false);
    }//GEN-LAST:event_infpageMouseClicked

    private void parlist_labeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlist_labeMouseExited
        // TODO add your handling code here:
        parlist_labe.setForeground(Color.white);
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Personal_Trainer_30px_3.png"))); // NOI18N

    }//GEN-LAST:event_parlist_labeMouseExited

    private void parlist_labeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlist_labeMouseClicked
        // TODO add your handling code here:
        list1 = false;
        list2 = true;
        list3 = false;
        list4 = false;
        /* parlist_labe.setForeground(new Color(204,204,0));
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Personal_Trainer_30px_5.png"))); // NOI18N
        emplist_labe.setForeground(Color.white);
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_User_Groups_30px_6.png"))); // NOI18N
machlist_labe.setForeground(Color.WHITE);
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Dumbbell_30px.png"))); // NOI18N
         */
        sellist1.setBackground(new Color(51, 0, 51));
        sellist2.setBackground(new Color(0, 204, 204));
        sellist3.setBackground(new Color(51, 0, 51));
        sellist4.setBackground(new Color(51, 0, 51));

        partable.setVisible(true);
        emptable.setVisible(false);
        machtable.setVisible(false);
        machtable.setVisible(false);
try {

            Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            //JOptionPane.showMessageDialog(null, "receive here");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PAR");
            participants part;
            ArrayList<participants> parlist = new ArrayList <participants>();
              //JOptionPane.showMessageDialog(null, "receive here1");
            
            while (rs.next()) {
               
               part = new participants(rs.getString("END_DATE"),rs.getString("START_DATE"),rs.getString("SSN"),rs.getString("Fname")+" "+rs.getString("LNAME"),rs.getString("PHONE_NUMBER"),rs.getString("ID_PART"),rs.getString("B_DATE"),rs.getString("GENDER"),rs.getString("CITY")+"//"+rs.getString("STREET"),rs.getInt("D_NUMBER"),rs.getInt("WEIGHT"),rs.getInt("HEIGHT"));
                parlist.add(part);
            }
            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            Object[] op = new Object[10];
            model.setRowCount(0);
          // JOptionPane.showMessageDialog(null, parlist.size());

            for (int i = 0; i < parlist.size(); i++) {
                op[0] = (Object) parlist.get(i).getssn();
              op[1] = (Object) parlist.get(i).getname();
            op[2] = (Object) parlist.get(i).getphone();
            op[3] = (Object) parlist.get(i).getaddress();
            op[4] = (Object) parlist.get(i).getweight();
            op[5] = (Object) parlist.get(i).getheight();
            op[6] = (Object) parlist.get(i).getgender();
            op[7] = (Object) parlist.get(i).getid();
            op[8] = (Object) parlist.get(i).getdnumber();
            op[9] = (Object) parlist.get(i).getstate();
                model.addRow(op);
            }
//JOptionPane.showMessageDialog(null, "done");
            con.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "exception");

        }
    }//GEN-LAST:event_parlist_labeMouseClicked

    private void parlist_labeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlist_labeMouseMoved
        // TODO add your handling code here:
        parlist_labe.setForeground(new Color(0, 204, 204));
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Personal_Trainer_30px_6.png"))); // NOI18N

    }//GEN-LAST:event_parlist_labeMouseMoved

    private void emplist_labeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplist_labeMouseExited
        // TODO add your handling code here:

        emplist_labe.setForeground(Color.white);
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_User_Groups_30px_6.png"))); // NOI18N


    }//GEN-LAST:event_emplist_labeMouseExited
    boolean list4 = false;
    public void showtable1(){
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            //JOptionPane.showMessageDialog(null, "receive here");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE");
            employee emp;
            ArrayList<employee> emplist = new ArrayList<employee>();
            //  JOptionPane.showMessageDialog(null, "receive here1");
            while (rs.next()) {
               
               emp = new employee(rs.getString("FNAME"),rs.getString("LNAME"),rs.getString("CITY")+"-"+rs.getString("STREET_NUMBER"),rs.getString("B_DATE"),rs.getString("SSN"),rs.getString("PHONE_NUMBER"),rs.getString("GENDER"),rs.getInt("SALARY"),rs.getInt("WORKING_HOURS"),rs.getInt("ID_EMPLOYEE"),rs.getInt("D_NUMBER"));
               
               
                emplist.add(emp);
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] op = new Object[10];
            model.setRowCount(0);
            // JOptionPane.showMessageDialog(null, deplist.size());

            for (int i = 0; i < emplist.size(); i++) {
                op[0] = (Object) emplist.get(i).getssn();
              op[1] = (Object) (emplist.get(i).getfname()+" "+emplist.get(i).getfname());
            op[2] = (Object) emplist.get(i).getphone();
            op[3] = (Object) emplist.get(i).getsalary();
            op[4] = (Object) emplist.get(i).getwh();
            op[5] = (Object) emplist.get(i).getaddress();
            op[6] = (Object) emplist.get(i).getdate();
            op[7] = (Object) emplist.get(i).getgender();
            op[8] = (Object) emplist.get(i).geteid();
            op[9] = (Object) emplist.get(i).getdn();
                model.addRow(op);

            }
//JOptionPane.showMessageDialog(null, "done");
            con.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "exception");

        }
    }
    private void emplist_labeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplist_labeMouseClicked
        // TODO add your handling code here:.
        list1 = true;
        list2 = false;
        list3 = false;
        list4 = false;


        /*        emplist_labe.setForeground(new Color(204,204,0));
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_User_Groups_30px_8.png"))); // NOI18N
        parlist_labe.setForeground(Color.white);
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Personal_Trainer_30px_3.png"))); // NOI18N
machlist_labe.setForeground(Color.WHITE);
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Dumbbell_30px.png"))); // NOI18N
         */
        sellist1.setBackground(new Color(0, 204, 204));
        sellist2.setBackground(new Color(51, 0, 51));
        sellist3.setBackground(new Color(51, 0, 51));
        sellist4.setBackground(new Color(51, 0, 51));

        emptable.setVisible(true);
        partable.setVisible(false);
        machtable.setVisible(false);
        deptable.setVisible(false);
        showtable1();

    }//GEN-LAST:event_emplist_labeMouseClicked

    private void emplist_labeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplist_labeMouseMoved
        // TODO add your handling code here:
        emplist_labe.setForeground(new Color(0, 204, 204));
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_User_Groups_30px_9.png"))); // NOI18N
    }//GEN-LAST:event_emplist_labeMouseMoved
    private boolean invalidname(String s) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || s.charAt(i) == ' ')) {
                return true;
            }
        }

        return false;
    }

    public boolean invalidnumber(String s) {
        if (s.split(s).length > 1) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return true;
            }
        }
        return false;
    }
    private void registerbut5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut5ActionPerformed
        // TODO add your handling code here:

        Boolean f = false;
        if (fnametxt.getText().equals("") || invalidname(fnametxt.getText()) || fnametxt.getText().toCharArray().length > 15) {
            fnametxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (lnametxt.getText().equals("") || invalidname(lnametxt.getText()) || lnametxt.getText().toCharArray().length > 15) {
            lnametxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (ssntxt.getText().equals("") || invalidnumber(ssntxt.getText()) || ssntxt.getText().toCharArray().length > 10) {
            ssntxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (ltxt.getText().equals("") || invalidnumber(ltxt.getText()) || Integer.parseInt(ltxt.getText()) > 250) {
            ltxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (wtxt.getText().equals("") || invalidnumber(wtxt.getText()) || Integer.parseInt(wtxt.getText()) > 300) {
            wtxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (dnumber.getSelectedItem() == null) {
            dnumber.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            // f=true;

        }
        if (invalidnumber(pnumbertxt.getText()) || pnumbertxt.getText().toCharArray().length > 14) {
            pnumbertxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (invalidnumber(streettxt.getText())) {
            streettxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (f) {
            return;
        }
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            PreparedStatement ps = con.prepareStatement("INSERT INTO PAR (FNAME,LNAME,SSN,WEIGHT,HEIGHT,ID_PART,D_NUMBER,B_DATE,START_DATE,END_DATE,GENDER,STREET,CITY,PHONE_NUMBER)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //   JOptionPane.showMessageDialog(null, "HERE1");

            //Statement st=con.createStatement();
            //ResultSet rs=st.executeQuery("SELECT COUNT(SSN) FROM PARTICIPANTS");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(ssn) from PAR");
            
           rs.next();
            int i=(int)rs.getInt(1);

            ps.setString(1, fnametxt.getText());
           // JOptionPane.showMessageDialog(null, "HERE2");
            ps.setString(2, lnametxt.getText());
            //   JOptionPane.showMessageDialog(null, "HERE3");

            ps.setString(3, ssntxt.getText());
            // JOptionPane.showMessageDialog(null, "HERE4");
            ps.setInt(4, Integer.parseInt(wtxt.getText()));
            //   JOptionPane.showMessageDialog(null, "HERE5");
            ps.setInt(5, Integer.parseInt(ltxt.getText()));
            //    JOptionPane.showMessageDialog(null, "HERE6");
            ps.setInt(6, i+1);
            //     JOptionPane.showMessageDialog(null, "HERE7");
            if (dnumber.getSelectedItem() != null) {
                ps.setInt(7, Integer.parseInt(dnumber.getSelectedItem().toString()));
            } else {
                ps.setInt(7, 0);
            }

          //  JOptionPane.showMessageDialog(null, "HERE8");
            /*    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date myDate = (java.sql.Date) formatter.parse(yearbox.getSelectedItem().toString()+"-"+monthbox.getSelectedIndex()+"-"+daybox.getSelectedItem().toString());
             */ ps.setString(8, yearbox.getSelectedItem().toString() + "-" + monthbox.getSelectedItem().toString() + "-" + daybox.getSelectedItem().toString());
            /*         SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
   Date myDate1 = (java.sql.Date) formatter.parse(syearbox.getSelectedItem().toString()+"-"+smonthbox.getSelectedIndex()+"-"+sdaybox.getSelectedItem().toString());
             */
            ps.setString(9, syearbox.getSelectedItem().toString() + "-" + smonthbox.getSelectedItem().toString() + "-" + sdaybox.getSelectedItem().toString());
            /*    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
    Date myDate2 = (java.sql.Date) formatter.parse( eyearbox.getSelectedItem().toString()+"-"+emonthbox.getSelectedIndex()+"-"+edaybox.getSelectedItem().toString());
             */

            ps.setString(10, eyearbox.getSelectedItem().toString() + "-" + emonthbox.getSelectedItem().toString() + "-" + edaybox.getSelectedItem().toString());
           // JOptionPane.showMessageDialog(null, "HERE9");
            ps.setString(11, genderbox.getSelectedItem().toString());
          //  JOptionPane.showMessageDialog(null, "HERE10");
            ps.setString(12, streettxt.getText());
         //   JOptionPane.showMessageDialog(null, "HERE11");
            ps.setString(13,citybox.getSelectedItem().toString());
         //   JOptionPane.showMessageDialog(null, "HERE12");
            ps.setString(14,pnumbertxt.getText());
        //    JOptionPane.showMessageDialog(null, "HERE13");

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "done");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "exception");
        }
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            Connection con=DriverManager.getConnection(url, "C##GYM", "0595");
            Statement stmt = con.createStatement();
            String insQry = "insert into PAR values("+this.fnametxt.getText()+","+this.lnametxt.getText()+","+this.ssntxt.getText()+","+this.wtxt.getText()+","+this.ltxt.getText()+","+this.dnumber.getSelectedItem().toString()+","+this.yearbox.getSelectedItem().toString() + "-" + monthbox.getSelectedItem().toString() + "-" + daybox.getSelectedItem().toString()+","+this.syearbox.getSelectedItem().toString() + "-" + smonthbox.getSelectedItem().toString() + "-" + sdaybox.getSelectedItem().toString()+","+this.eyearbox.getSelectedItem().toString() + "-" + emonthbox.getSelectedItem().toString() + "-" + edaybox.getSelectedItem().toString()+","+this.genderbox.getSelectedItem().toString()+","+this.streettxt.getText()+","+this.citybox.getSelectedItem().toString()+","+this.pnumbertxt.getText()+")";
            stmt.executeQuery(insQry);
            con.setAutoCommit(false);
            con.commit();
            con.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "exception");
        }
    }//GEN-LAST:event_registerbut5ActionPerformed

    private void machlist_labeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlist_labeMouseMoved
        // TODO add your handling code here:
        machlist_labe.setForeground(new Color(0, 204, 204));
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Dumbbell_30px_2.png"))); // NOI18N


    }//GEN-LAST:event_machlist_labeMouseMoved

    private void machlist_labeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlist_labeMouseClicked
        // TODO add your handling code here:
        list1 = false;
        list2 = false;
        list3 = true;
        list4 = false;

        /*  machlist_labe.setForeground(new Color(204,204,0));
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Dumbbell_30px_1.png"))); // NOI18N
        parlist_labe.setForeground(Color.white);
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Personal_Trainer_30px_3.png"))); // NOI18N
        emplist_labe.setForeground(Color.white);
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_User_Groups_30px_6.png"))); // NOI18N
         */
        sellist1.setBackground(new Color(51, 0, 51));
        sellist2.setBackground(new Color(51, 0, 51));
        sellist3.setBackground(new Color(0, 204, 204));
        sellist4.setBackground(new Color(51, 0, 51));

        machtable.setVisible(true);
        emptable.setVisible(false);
        partable.setVisible(false);
        deptable.setVisible(false);

    }//GEN-LAST:event_machlist_labeMouseClicked

    private void machlist_labeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlist_labeMouseExited
        // TODO add your handling code here:
        machlist_labe.setForeground(Color.WHITE);
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Dumbbell_30px.png"))); // NOI18N


    }//GEN-LAST:event_machlist_labeMouseExited

    private void yearbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearbox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearbox3ActionPerformed

    private void monthbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthbox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthbox3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void registerbut6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerbut6ActionPerformed

    private void searchtxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtxt1ActionPerformed

    private void registerbut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut4ActionPerformed
        // TODO add your handling code here:
        Boolean f = false;
        if (fnametxt1.getText().equals("") || invalidname(fnametxt1.getText()) || fnametxt1.getText().toCharArray().length > 15) {
            fnametxt1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (lnametxt1.getText().equals("") || invalidname(lnametxt1.getText()) || lnametxt1.getText().toCharArray().length > 15) {
            lnametxt1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (ssntxt1.getText().equals("") || invalidnumber(ssntxt1.getText()) || ssntxt1.getText().toCharArray().length > 10) {
            ssntxt1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (work_hourstxt.getText().equals("") || invalidnumber(work_hourstxt.getText()) || Integer.parseInt(work_hourstxt.getText()) > 12) {
            work_hourstxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }
        if (streettxt1.getText().toCharArray().length > 4) {
            streettxt1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (pnumbertxt1.getText().toCharArray().length > 14) {
            pnumbertxt1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (salarytxt.getText().equals("") || invalidnumber(salarytxt.getText()) || Integer.parseInt(salarytxt.getText()) > 2800) {
            salarytxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;

        }

        if (dnumber1.getSelectedItem() == null) {
            dnumber1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            //f=true;

        }
        /*   if(is_coach.isSelected()&&exptxt.getText().equals("")||invalidname(exptxt.getText())||exptxt.getText().toCharArray().length>10){
                                  exptxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
                      f=true;    
                                  }*/

        if (f) {
            return;
        }
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM",
                    "0595");
            PreparedStatement ps = con.prepareStatement("INSERT INTO EMP (salary,working_hours,id_employee,d_number,b_date,phone_number,ssn,fname,city,street_number,lname)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select count(D_NUMBER) from EMP");
            ps.setInt(1, Integer.parseInt(salarytxt.getText()));
            // JOptionPane.showMessageDialog(null, "here1");
            ps.setInt(2, Integer.parseInt(work_hourstxt.getText()));
//JOptionPane.showMessageDialog(null, "here2");
rs.next();

            ps.setInt(3, rs.getInt(1)+1);
//JOptionPane.showMessageDialog(null, "here3");
            if (dnumber1.getSelectedItem() != null) {
                ps.setInt(4, Integer.parseInt(dnumber1.getSelectedItem().toString()));
                //     JOptionPane.showMessageDialog(null, "here4");
            } else {
                ps.setInt(4, 0);
            }
            // JOptionPane.showMessageDialog(null, "here5");
            ps.setString(5, yearbox1.getSelectedItem().toString() + "-" + monthbox4.getSelectedItem().toString() + "-" + daybox1.getSelectedItem().toString());
//JOptionPane.showMessageDialog(null, "here6");

            ps.setInt(6, Integer.parseInt(pnumbertxt1.getText()));
//JOptionPane.showMessageDialog(null, "here7");
            ps.setInt(7, Integer.parseInt(ssntxt1.getText()));
//JOptionPane.showMessageDialog(null, "here7");
            ps.setString(8, fnametxt1.getText());
//JOptionPane.showMessageDialog(null, "here8");
            ps.setString(9, citybox1.getSelectedItem().toString());
//JOptionPane.showMessageDialog(null, "here9");
            ps.setString(10, streettxt1.getText());
//JOptionPane.showMessageDialog(null, "here10");
            ps.setString(11, lnametxt1.getText());
            JOptionPane.showMessageDialog(null, "here11");

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "here12");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "execption");

        }

    }//GEN-LAST:event_registerbut4ActionPerformed

    private void dnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnumberActionPerformed

    private void fnametxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnametxtMouseClicked
        // TODO add your handling code here:
        fnametxt.setBorder(pnumbertxt.getBorder());
    }//GEN-LAST:event_fnametxtMouseClicked

    private void lnametxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnametxtMouseClicked
        // TODO add your handling code here:
        lnametxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_lnametxtMouseClicked

    private void ssntxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssntxtMouseClicked
        // TODO add your handling code here:
        ssntxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_ssntxtMouseClicked

    private void wtxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wtxtMouseClicked
        // TODO add your handling code here:
        wtxt.setBorder(pnumbertxt.getBorder());
    }//GEN-LAST:event_wtxtMouseClicked

    private void ltxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltxtMouseClicked
        // TODO add your handling code here:
        ltxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_ltxtMouseClicked

    private void dnumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dnumberMouseClicked
        // TODO add your handling code here:
        dnumber.setBorder(BorderFactory.createLineBorder(Color.white));

    }//GEN-LAST:event_dnumberMouseClicked

    private void fnametxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnametxt1MouseClicked
        // TODO add your handling code here:
        fnametxt1.setBorder(pnumbertxt.getBorder());
    }//GEN-LAST:event_fnametxt1MouseClicked

    private void dnumber1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dnumber1MouseClicked
        // TODO add your handling code here:
        dnumber1.setBorder(BorderFactory.createLineBorder(Color.white));

    }//GEN-LAST:event_dnumber1MouseClicked

    private void lnametxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnametxt1MouseClicked
        // TODO add your handling code here:
        lnametxt1.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_lnametxt1MouseClicked

    private void ssntxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssntxt1MouseClicked
        // TODO add your handling code here:
        ssntxt1.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_ssntxt1MouseClicked

    private void salarytxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salarytxtMouseClicked
        // TODO add your handling code here:
        salarytxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_salarytxtMouseClicked

    private void work_hourstxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_work_hourstxtMouseClicked
        // TODO add your handling code here:
        work_hourstxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_work_hourstxtMouseClicked

    private void exptxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exptxtMouseClicked
        // TODO add your handling code here:
        if (is_coach.isSelected()) {
            exptxt.setBorder(pnumbertxt.getBorder());
        }

    }//GEN-LAST:event_exptxtMouseClicked

    private void registerbut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut3ActionPerformed
        // TODO add your handling code here:
        Boolean f = false;
        if (nametxt2.getText().equals("") || invalidname(nametxt2.getText())) {
            nametxt2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (id_machinetxt.getText().equals("") || invalidnumber(id_machinetxt.getText())) {
            id_machinetxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (f) {
            return;
        }
    }//GEN-LAST:event_registerbut3ActionPerformed

    private void nametxt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nametxt2MouseClicked
        // TODO add your handling code here:
        nametxt2.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_nametxt2MouseClicked

    private void id_machinetxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_machinetxtMouseClicked
        // TODO add your handling code here:
        id_machinetxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_id_machinetxtMouseClicked

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
        
       if(list1){
          if(searchtxt1.getText().equals("")||searchtxt1.getText().equals("Enter ID...")){
              JOptionPane.showMessageDialog(null, "Please enter id or select item","warning",JOptionPane.WARNING_MESSAGE);}
              else{
                    try{
            //JOptionPane.showMessageDialog(null, "receive here");
String s=searchtxt1.getText();
            if(invalidnumber(s)){
                JOptionPane.showMessageDialog(null, "This ID is invlid !");
            }
            else{
                                           Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE");
            employee emp;
            ArrayList<employee> emplist = new ArrayList<employee>();
            //  JOptionPane.showMessageDialog(null, "receive here1");
            while (rs.next()) {
               
               emp = new employee(rs.getString("FNAME"),rs.getString("LNAME"),rs.getString("CITY")+"-"+rs.getString("STREET_NUMBER"),rs.getString("B_DATE"),rs.getString("SSN"),rs.getString("PHONE_NUMBER"),rs.getString("GENDER"),rs.getInt("SALARY"),rs.getInt("WORKING_HOURS"),rs.getInt("ID_EMPLOYEE"),rs.getInt("D_NUMBER"));
                emplist.add(emp);
            }
            int id=Integer.parseInt(s);
            boolean f=false;
            
           for(int i=0;i<emplist.size();i++){
              if(emplist.get(i).geteid()==id){
           employee ob=emplist.get(i);

                  peid.setText(""+ob.geteid());

pename.setText(ob.getfname()+" "+ob.getlname());
String add[]=ob.getaddress().split("-");
String date[]=ob.getdate().split("-");

                  pefname.setText(ob.getfname());
                  pelname.setText(ob.getlname());
 pecity.setSelectedItem((Object)add[0]);
                  pestreet.setText(add[1]);
                  pesalary.setText(""+ob.getsalary());
                  pework.setText(""+ob.getwh());
                  pepnumber.setText(ob.getphone());
                  pednumber.setSelectedItem((Object)ob.getdn());
                  peday.setSelectedItem((Object)date[2]);
                  pemonth.setSelectedItem((Object)date[1]);
                  peyear.setSelectedItem((Object)date[0]);
                  pegender.setSelectedItem((Object)ob.getgender());
                  infpage.setVisible(false);
eprofile_page.setVisible(true);
mprofile_page.setVisible(false);
profile_page.setVisible(false);
dprofile_page.setVisible(false);

f=true;
break;
              }
                   
            }
             
           if(!f) {
                        JOptionPane.showMessageDialog(null, " DOESN'T exist");
                   }
                      }
                    }
                    catch (Exception e){
                                               JOptionPane.showMessageDialog(null, "exception");
 
                    }
                          
          }
       }
    }//GEN-LAST:event_kButton6ActionPerformed

    private void searchtxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtxt1MouseClicked
        // TODO add your handling code here:
        if (searchtxt1.getText().equals("Enter ID...")) {
            searchtxt1.setText("");
        }
    }//GEN-LAST:event_searchtxt1MouseClicked

    private void deplabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel2MouseMoved
        // TODO add your handling code here:
        deplabel2.setForeground(new Color(51, 51, 255));
        deplabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_deplabel2MouseMoved

    private void deplabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel2MouseClicked
        // TODO add your handling code here:
        mf = false;
        ef = pf = false;
        df = true;
        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(true);

        reglist3.setVisible(false);
    }//GEN-LAST:event_deplabel2MouseClicked

    private void deplabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel2MouseExited
        // TODO add your handling code here:
        deplabel2.setForeground(Color.white);
        deplabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_deplabel2MouseExited

    private void parlabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel3MouseMoved
        // TODO add your handling code here:
        parlabel3.setForeground(new Color(51, 51, 255));
        parlabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_parlabel3MouseMoved

    private void parlabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel3MouseClicked
        // TODO add your handling code here:
        mf = false;
        ef = false;
        pf = true;
        df = false;
        pregpanel.setVisible(true);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);

        reglist3.setVisible(false);

    }//GEN-LAST:event_parlabel3MouseClicked

    private void parlabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parlabel3MouseExited
        // TODO add your handling code here:
        parlabel3.setForeground(Color.white);
        parlabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Weightlifting_25px.png"))); // NOI18N

    }//GEN-LAST:event_parlabel3MouseExited

    private void emplabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel3MouseMoved
        // TODO add your handling code here:
        emplabel3.setForeground(new Color(51, 51, 255));
        emplabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_2.png"))); // NOI18N

    }//GEN-LAST:event_emplabel3MouseMoved

    private void emplabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel3MouseClicked
        // TODO add your handling code here:
        mf = false;
        ef = true;
        pf = false;
        df = false;
        pregpanel.setVisible(false);
        eregpanel.setVisible(true);
        mregpanel.setVisible(false);
        deppanel.setVisible(false);

        reglist3.setVisible(false);
    }//GEN-LAST:event_emplabel3MouseClicked

    private void emplabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplabel3MouseExited
        // TODO add your handling code here:
        emplabel3.setForeground(Color.white);
        emplabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Employee_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_emplabel3MouseExited

    private void kGradientPanel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel7MouseMoved

    private void reglist3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reglist3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_reglist3MouseMoved

    private void dnumbertxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dnumbertxtMouseClicked
        // TODO add your handling code here:
        dnumbertxt.setBorder(pnumbertxt.getBorder());

    }//GEN-LAST:event_dnumbertxtMouseClicked

    private void dnumbertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnumbertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnumbertxtActionPerformed

    private void closeleb6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb6MouseMoved
        // TODO add your handling code here:
        closepan7.setBackground(Color.RED);
        closeleb6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_5.png")));

    }//GEN-LAST:event_closeleb6MouseMoved

    private void closeleb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeleb6MouseClicked

    private void registerbut7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut7ActionPerformed
        // TODO add your handling code here:
        boolean f = false;
        if (dnametxt.getText().equals("") || invalidname(dnametxt.getText()) || dnametxt.getText().toCharArray().length > 15) {
            dnametxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (dnumbertxt.getText().equals("") || invalidnumber(dnumbertxt.getText()) || dnumbertxt.getText().toCharArray().length > 9) {
            dnumbertxt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            f = true;
        }
        if (f) {
            return;
        }

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            // JOptionPane.showMessageDialog(null, "receive here");

            PreparedStatement ps = con.prepareStatement("INSERT INTO department(NAME,D_NUMBER) " + "Values(?,?)");
            //     JOptionPane.showMessageDialog(null, "HERE");
            /*  PreparedStatement ps0 = con.prepareStatement("select fname FROM EMPLOYEE,DEPARTMENT,MANAGMENT WHERE DEPARTMENT.D_NUMBER= "+dnumbertxt.getText()+";");
//ps0.execute();
                 JOptionPane.showMessageDialog(null, ps0.getResultSet().toString());

            PreparedStatement ps1 = con.prepareStatement("select count(E_NUMBER) FROM MANAGMENT WHERE D_NUMBER='"+dnumber.getName()+"' group by D_NUMBER; ");
            ps1.execute();
            PreparedStatement ps2 = con.prepareStatement("select count(ID_PART) FROM PARTICIPANTS WHERE D_NUMBER='"+dnumber.getName()+"' group by D_NUMBER; ");
            ps2.execute();*/
            ps.setString(1, dnametxt.getText());
            ps.setString(2, dnumbertxt.getText());
            //JOptionPane.showMessageDialog(null, "HERE");

            /*s.setString(3, ps0.getResultSet().toString()); 
         
                     ps.setString(4, ps1.getResultSet().toString()); 
                     ps.setString(5, ps2.getResultSet().toString()); 
             */
            JOptionPane.showMessageDialog(null, "here");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "done");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "exception");

        }
    }//GEN-LAST:event_registerbut7ActionPerformed

    private void deppanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deppanelMouseMoved
        // TODO add your handling code here:
        closepan7.setBackground(Color.WHITE);
        closeleb6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));
        reglist3.setVisible(false);
    }//GEN-LAST:event_deppanelMouseMoved

    private void machlabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel4MouseMoved
        // TODO add your handling code here:
        machlabel4.setForeground(new Color(51, 51, 255));
        machlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_machlabel4MouseMoved

    private void machlabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel4MouseClicked
        // TODO add your handling code here:
        mf = true;
        ef = pf = false;
        df = false;
        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(true);
        deppanel.setVisible(false);

        reglist3.setVisible(false);
    }//GEN-LAST:event_machlabel4MouseClicked

    private void machlabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_machlabel4MouseExited
        // TODO add your handling code here:
        machlabel4.setForeground(Color.white);
        machlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Barbell_25px.png"))); // NOI18N

    }//GEN-LAST:event_machlabel4MouseExited

    private void deplabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabelMouseMoved
        // TODO add your handling code here:
        deplabel.setForeground(new Color(51, 51, 255));
        deplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_deplabelMouseMoved

    private void deplabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabelMouseClicked
        // TODO add your handling code here:
        pf = false;
        mf = ef = false;
        df = true;
        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(true);
        reglist.setVisible(false);
    }//GEN-LAST:event_deplabelMouseClicked

    private void deplabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabelMouseExited
        // TODO add your handling code here:
        deplabel.setForeground(Color.white);
        deplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_deplabelMouseExited

    private void deplabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel1MouseMoved
        // TODO add your handling code here:
        deplabel1.setForeground(new Color(51, 51, 255));
        deplabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_deplabel1MouseMoved

    private void deplabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel1MouseClicked
        // TODO add your handling code here:
        mf = false;
        ef = pf = false;
        df = true;
        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(true);

        reglist2.setVisible(false);
    }//GEN-LAST:event_deplabel1MouseClicked

    private void deplabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel1MouseExited
        // TODO add your handling code here:
        deplabel1.setForeground(Color.white);
        deplabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_1.png"))); // NOI18N

    }//GEN-LAST:event_deplabel1MouseExited

    private void deplabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel3MouseMoved
        // TODO add your handling code here:
        deplabel3.setForeground(new Color(51, 51, 255));
        deplabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_3.png"))); // NOI18N

    }//GEN-LAST:event_deplabel3MouseMoved

    private void deplabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel3MouseClicked
        // TODO add your handling code here:
        mf = false;
        ef = pf = false;
        df = true;
        pregpanel.setVisible(false);
        eregpanel.setVisible(false);
        mregpanel.setVisible(false);
        deppanel.setVisible(true);

        reglist2.setVisible(false);
    }//GEN-LAST:event_deplabel3MouseClicked

    private void deplabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplabel3MouseExited
        // TODO add your handling code here:
        deplabel3.setForeground(Color.white);
        deplabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_25px_1.png"))); // NOI18N


    }//GEN-LAST:event_deplabel3MouseExited

    private void dnametxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dnametxtMouseClicked
        // TODO add your handling code here:
        dnametxt.setBorder(pnumbertxt.getBorder());
    }//GEN-LAST:event_dnametxtMouseClicked

    private void dnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnametxtActionPerformed

    private void closeleb6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeleb6MouseExited
        // TODO add your handling code here:
        closepan7.setBackground(Color.WHITE);
        closeleb6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Delete_33px_4.png")));

    }//GEN-LAST:event_closeleb6MouseExited

    private void registerbut7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerbut7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registerbut7MouseClicked

    private void deplist_labeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplist_labeMouseMoved
        // TODO add your handling code here:
        deplist_labe.setForeground(new Color(0, 204, 204));
        deplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_30px.png"))); // NOI18N

    }//GEN-LAST:event_deplist_labeMouseMoved

    private void deplist_labeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplist_labeMouseClicked
        // TODO add your handling code here:
        list1 = false;
        list2 = false;
        list3 = false;
        list4 = true;


        /*  machlist_labe.setForeground(new Color(204,204,0));
        machlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Dumbbell_30px_1.png"))); // NOI18N
        parlist_labe.setForeground(Color.white);
        parlist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Personal_Trainer_30px_3.png"))); // NOI18N
        emplist_labe.setForeground(Color.white);
        emplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_User_Groups_30px_6.png"))); // NOI18N
         */
        sellist1.setBackground(new Color(51, 0, 51));
        sellist2.setBackground(new Color(51, 0, 51));
        sellist3.setBackground(new Color(51, 0, 51));
        sellist4.setBackground(new Color(0, 204, 204));

        machtable.setVisible(false);
        emptable.setVisible(false);
        partable.setVisible(false);
        deptable.setVisible(true);

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            //   JOptionPane.showMessageDialog(null, "receive here");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            //JOptionPane.showMessageDialog(null, "receive here");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM DEPARTMENT");
            department dp;
            ArrayList<department> deplist = new ArrayList<department>();
            ResultSet rs1, rs2, rs3;
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();
            Statement st3 = con.createStatement();

            //  JOptionPane.showMessageDialog(null, "receive here1");
            while (rs.next()) {
                //  rs1=st1.executeQuery("SELECT count(D_NUMBER) from MANAGMENT WHERE D_NUMBER="+rs.getInt("D_NUMBER")+" group by D_NUMBER");
                /*   rs1=st1.executeQuery("select count(d_number) from DEPARTMENT");

  JOptionPane.showMessageDialog(null, "receive here1");
  if(rs1.wasNull())
            System.out.println("null");
    rs2=st2.executeQuery("SELECT count(D_NUMBER) from PARTICIPANTS WHERE D_NUMBER= '"+rs.getInt("D_NUMBER")+"' group by D_NUMBER");
     JOptionPane.showMessageDialog(null, "receive here2");
        if(rs2.next())
            System.out.println(rs2.getString(1));

     rs3=st3.executeQuery("SELECT count(D_NUMBER) from MACHINE WHERE D_NUMBER= '"+rs.getInt("D_NUMBER")+"' group by D_NUMBER");
                 */
                dp = new department(rs.getInt("D_NUMBER"), rs.getString("NAME")/*,rs1.getInt("count(D_NUMBER)"),rs2.getInt("count(D_NUMBER)"),rs3.getInt("count(D_NUMBER)")*/);

                deplist.add(dp);
            }
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            Object[] op = new Object[2];
            model.setRowCount(0);
            // JOptionPane.showMessageDialog(null, deplist.size());

            for (int i = 0; i < deplist.size(); i++) {
                op[0] = (Object) deplist.get(i).getname();
                op[1] = (Object) deplist.get(i).getnumber();
                /* op[2]=(Object)deplist.get(i).getecount();
                    op[3]=(Object)deplist.get(i).getpcount();
                    op[4]=(Object)deplist.get(i).getmcount();
                 */
                //   System.out.println(op[0]);
                // System.out.println(op[1]);

                model.addRow(op);

            }
//JOptionPane.showMessageDialog(null, "done");
            con.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "exception");

        }
    }//GEN-LAST:event_deplist_labeMouseClicked

    private void deplist_labeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplist_labeMouseExited
        // TODO add your handling code here:
        deplist_labe.setForeground(Color.white);
        deplist_labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gym3//icons8_Department_30px_1.png"))); // NOI18N

    }//GEN-LAST:event_deplist_labeMouseExited

    private void streettxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_streettxtMouseClicked
        // TODO add your handling code here:
        streettxt.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, new Color(102, 0, 0)));
    }//GEN-LAST:event_streettxtMouseClicked

    private void pnumbertxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnumbertxtMouseClicked
        // TODO add your handling code here:
        pnumbertxt.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, new Color(102, 0, 0)));

    }//GEN-LAST:event_pnumbertxtMouseClicked

    private void citybox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citybox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_citybox1ActionPerformed

    private void cityboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityboxActionPerformed

    private void pregpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pregpanelMouseEntered
        // TODO add your handling code here:
        getdnumber();
    }//GEN-LAST:event_pregpanelMouseEntered

    private void eregpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eregpanelMouseEntered
        // TODO add your handling code here:
        getdnumber2();
    }//GEN-LAST:event_eregpanelMouseEntered

    private void peyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peyearActionPerformed

    private void pemonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pemonthActionPerformed

    private void pesalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesalaryActionPerformed

    private void pepnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pepnumberActionPerformed

    private void registerbut8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut8ActionPerformed
        // TODO add your handling code here:
        Color c=Color.red;
        boolean f=false;
        if(invalidname(pefname.getText())||pefname.getText().toCharArray().length>15){
            pefname.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, c));
            f=true;
        }
        if(invalidname(pelname.getText())||pelname.getText().toCharArray().length>15){
            pelname.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, c));
                        f=true;

        }
        if(invalidnumber(pestreet.getText())||pestreet.getText().toCharArray().length>4){
            pestreet.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, c));
                        f=true;

        }
        if(invalidnumber(pepnumber.getText())||pepnumber.getText().toCharArray().length>14){
            pepnumber.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, c));
                        f=true;

        }
                if(invalidnumber(pework.getText())||Integer.parseInt(pework.getText())>12){
            pework.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, c));
                        f=true;

        }
        if(invalidnumber(pesalary.getText())||Integer.parseInt(pesalary.getText())>2600){
            pesalary.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, c));
                        f=true;

        }
        if(f)return;
try{
     Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##GYM", "0595");
            PreparedStatement ps = con.prepareStatement("update employee set fname=?,lname=?,city=?,street_number=?,salary=?,working_hours=?,"
                    + "phone_number=?,d_number=?,b_date=?,gender=? where ID_EMPLOYEE=?");
            
        ps.setString(1,pefname.getText());
                ps.setString(2,pelname.getText());
        ps.setString(3,pecity.getSelectedItem().toString());
                ps.setString(4,pestreet.getText());
        ps.setInt(5,Integer.parseInt(pesalary.getText()));
        ps.setInt(6,Integer.parseInt(pework.getText()));
        ps.setString(7,pepnumber.getText());
        if(pednumber.getSelectedItem()==null){
                    ps.setInt(8,11);

        }
        else
        ps.setInt(8,Integer.parseInt(pednumber.getSelectedItem().toString()));
        ps.setString(9,peyear.getSelectedItem().toString()+"-"+pemonth.getSelectedItem().toString()+"-"+peday.getSelectedItem().toString());
        ps.setString(10,pegender.getSelectedItem().toString());
        ps.setInt(11,Integer.parseInt(peid.getText()));
ps.executeUpdate();
JOptionPane.showMessageDialog(null, "done");
}
catch(Exception e){
    JOptionPane.showMessageDialog(null, "exeption");

}
        
        
    
    }//GEN-LAST:event_registerbut8ActionPerformed

    private void yearbox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearbox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearbox5ActionPerformed

    private void monthbox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthbox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthbox6ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void registerbut9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerbut9ActionPerformed

    private void yearbox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearbox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearbox6ActionPerformed

    private void monthbox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthbox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthbox7ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void registerbut10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbut10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerbut10ActionPerformed

    private void pecityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pecityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pecityActionPerformed

    private void pednumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pednumberMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pednumberMouseClicked

    private void pednumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pednumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pednumberActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        eprofile_page.setVisible(false);
        infpage.setVisible(true);
        showtable1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kGradientPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel8MousePressed
 q = evt.getX();
        w = evt.getY();
        new Drag(listpanel).onPress(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel8MousePressed

    private void kGradientPanel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel8MouseReleased
        // TODO add your handling code here:
                setOpacity((float) 1.0);

    }//GEN-LAST:event_kGradientPanel8MouseReleased

    private void kGradientPanel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel8MouseDragged
        // TODO add your handling code here:
         int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        setLocation(xx - q, yy - w);
        setOpacity((float) 0.7);
        new Drag(kGradientPanel3).moveWindow(evt);
    }//GEN-LAST:event_kGradientPanel8MouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> citybox;
    private javax.swing.JComboBox<String> citybox1;
    private javax.swing.JLabel closeleb;
    private javax.swing.JLabel closeleb1;
    private javax.swing.JLabel closeleb2;
    private javax.swing.JLabel closeleb3;
    private javax.swing.JLabel closeleb4;
    private javax.swing.JLabel closeleb5;
    private javax.swing.JLabel closeleb6;
    private javax.swing.JPanel closepan1;
    private javax.swing.JPanel closepan2;
    private javax.swing.JPanel closepan3;
    private javax.swing.JPanel closepan4;
    private javax.swing.JPanel closepan5;
    private javax.swing.JPanel closepan6;
    private javax.swing.JPanel closepan7;
    private javax.swing.JComboBox<String> daybox;
    private javax.swing.JComboBox<String> daybox1;
    private javax.swing.JComboBox<String> daybox10;
    private javax.swing.JComboBox<String> daybox3;
    private javax.swing.JComboBox<String> daybox4;
    private javax.swing.JComboBox<String> daybox7;
    private javax.swing.JComboBox<String> daybox8;
    private javax.swing.JComboBox<String> daybox9;
    private javax.swing.JLabel deplabel;
    private javax.swing.JLabel deplabel1;
    private javax.swing.JLabel deplabel2;
    private javax.swing.JLabel deplabel3;
    private javax.swing.JLabel deplist_labe;
    private javax.swing.JPanel deppanel;
    private javax.swing.JPanel deptable;
    private javax.swing.JTextField dnametxt;
    private javax.swing.JComboBox<String> dnumber;
    private javax.swing.JComboBox<String> dnumber1;
    private javax.swing.JTextField dnumbertxt;
    private javax.swing.JPanel dprofile_page;
    private javax.swing.JComboBox<String> edaybox;
    private javax.swing.JComboBox<String> emonthbox;
    private javax.swing.JLabel emplabel;
    private javax.swing.JLabel emplabel1;
    private javax.swing.JLabel emplabel2;
    private javax.swing.JLabel emplabel3;
    private javax.swing.JLabel emplist_labe;
    private javax.swing.JPanel emptable;
    private javax.swing.JPanel eprofile_page;
    private javax.swing.JPanel eregpanel;
    private javax.swing.JTextField exptxt;
    private javax.swing.JComboBox<String> eyearbox;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JTextField fnametxt1;
    private javax.swing.JComboBox<String> genderbox;
    private javax.swing.JComboBox<String> genderbox1;
    private javax.swing.JTextField id_machinetxt;
    private javax.swing.JPanel infpage;
    private javax.swing.JCheckBox is_coach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel13;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JLabel listinf;
    private keeptoo.KGradientPanel listpanel;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField lnametxt1;
    private javax.swing.JTextField ltxt;
    private javax.swing.JPanel machinepage;
    private javax.swing.JLabel machlabel;
    private javax.swing.JLabel machlabel1;
    private javax.swing.JLabel machlabel2;
    private javax.swing.JLabel machlabel4;
    private javax.swing.JLabel machlist_labe;
    private javax.swing.JPanel machtable;
    private javax.swing.JComboBox<String> monthbox;
    private javax.swing.JComboBox<String> monthbox3;
    private javax.swing.JComboBox<String> monthbox4;
    private javax.swing.JComboBox<String> monthbox6;
    private javax.swing.JComboBox<String> monthbox7;
    private javax.swing.JPanel mprofile_page;
    private javax.swing.JPanel mregpanel;
    private javax.swing.JTextField nametxt2;
    private javax.swing.JPanel notepage;
    private javax.swing.JLabel parlabel;
    private javax.swing.JLabel parlabel1;
    private javax.swing.JLabel parlabel2;
    private javax.swing.JLabel parlabel3;
    private javax.swing.JLabel parlist_labe;
    private javax.swing.JPanel partable;
    private javax.swing.JComboBox<String> pecity;
    private javax.swing.JComboBox<String> peday;
    private javax.swing.JComboBox<String> pednumber;
    private javax.swing.JTextField pefname;
    private javax.swing.JComboBox<String> pegender;
    private javax.swing.JLabel peid;
    private javax.swing.JTextField pelname;
    private javax.swing.JComboBox<String> pemonth;
    private javax.swing.JLabel pename;
    private javax.swing.JTextField pepnumber;
    private javax.swing.JTextField pesalary;
    private javax.swing.JTextField pestreet;
    private javax.swing.JTextField pework;
    private javax.swing.JComboBox<String> peyear;
    private javax.swing.JTextField pnumbertxt;
    private javax.swing.JTextField pnumbertxt1;
    private javax.swing.JPanel pregpanel;
    private javax.swing.JPanel profile_page;
    private javax.swing.JLabel profileimage;
    private javax.swing.JLabel profileimage1;
    private javax.swing.JLabel profileimage2;
    private javax.swing.JLabel profileimage3;
    private keeptoo.KButton registerbut10;
    private keeptoo.KButton registerbut3;
    private keeptoo.KButton registerbut4;
    private keeptoo.KButton registerbut5;
    private keeptoo.KButton registerbut6;
    private keeptoo.KButton registerbut7;
    private keeptoo.KButton registerbut8;
    private keeptoo.KButton registerbut9;
    private keeptoo.KGradientPanel reglist;
    private keeptoo.KGradientPanel reglist1;
    private keeptoo.KGradientPanel reglist2;
    private keeptoo.KGradientPanel reglist3;
    private javax.swing.JTextField salarytxt;
    private javax.swing.JComboBox<String> sdaybox;
    private javax.swing.JTextField searchtxt1;
    private javax.swing.JPanel sellist1;
    private javax.swing.JPanel sellist2;
    private javax.swing.JPanel sellist3;
    private javax.swing.JPanel sellist4;
    private javax.swing.JComboBox<String> smonthbox;
    private javax.swing.JTextField ssntxt;
    private javax.swing.JTextField ssntxt1;
    private javax.swing.JTextField streettxt;
    private javax.swing.JTextField streettxt1;
    private javax.swing.JComboBox<String> syearbox;
    private javax.swing.JPanel tablelist;
    private javax.swing.JPanel tablepanel;
    private javax.swing.JTextField work_hourstxt;
    private javax.swing.JTextField wtxt;
    private javax.swing.JComboBox<String> yearbox;
    private javax.swing.JComboBox<String> yearbox1;
    private javax.swing.JComboBox<String> yearbox3;
    private javax.swing.JComboBox<String> yearbox5;
    private javax.swing.JComboBox<String> yearbox6;
    // End of variables declaration//GEN-END:variables
}
