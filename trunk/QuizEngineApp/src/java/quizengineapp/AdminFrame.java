/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quizengineapp;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Anachronox
 */
public class AdminFrame extends JFrame{
  private JPanel panel=new JPanel();
  private JMenuBar menubar=new JMenuBar();
  private JMenu usermenu=new JMenu("User Menu");
  private JMenu testmenu =new JMenu("Test Menu");
  private JMenu resultmenu =new JMenu("Result Menu");
  private JMenuItem createuser=new JMenuItem("Create User");
  private JMenuItem authorizelogin=new JMenuItem("Authorize Relogin");
  private JMenuItem createtest=new JMenuItem("Create Tests");
  private JMenuItem addques=new JMenuItem("Add Questions to test");
  private JMenuItem viewres=new JMenuItem("View Results");
  private JMenuItem viewstatus=new JMenuItem("View Status of Test");
  private JMenu logoutmenu=new JMenu("Logout");
  private JMenuItem logoutmenuitem=new JMenuItem("Logout");
  private JMenuItem generateuser=new JMenuItem("Generate Users");
  MasterController master;
  public AdminFrame(MasterController master)
  {   super("Quiz Admin");
      this.master=master;
      this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
      this.preparemenu();
      usermenu.add(this.createuser);
        usermenu.add(this.authorizelogin);
        usermenu.add(generateuser);
        testmenu.add(this.createtest);
        testmenu.add(this.addques);
        resultmenu.add(this.viewres);
        resultmenu.add(this.viewstatus);
        logoutmenu.add(this.logoutmenuitem);
        menubar.add(usermenu);
        menubar.add(testmenu);
        menubar.add(resultmenu);
        menubar.add(logoutmenu);
      this.setJMenuBar(menubar);
      this.panel.setBackground(new Color(167,198,205));
      this.setContentPane(panel);
      
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

    private void generateuserAction()
    {
     this.setContentPane(new GenerateUser(master));
     this.setVisible(false);
     this.setVisible(true);
    }
    public void createuserAction()
    {
        
     this.setContentPane(new RegisterUserPanel(master));   
     this.setVisible(false);
     this.setVisible(true);
    }
    public void createtestAction()
    {
        this.setContentPane(new CreateTestPanel(master));
        this.setVisible(false);
        this.setVisible(true);
    }
    public void authorizeReloginAction()
    {
    }
    public void addquesAction()
    {
    this.setContentPane(new QuestionEntryPanel(master));
    this.setVisible(false);
    this.setVisible(true);
    }
    public void viewresAction()
    {
        this.setContentPane(new viewResultPanel(master));
        this.setVisible(false);
        this.setVisible(true);
    }
    public void viewstatusAction()
    {}
    public void logoutaction()
    {
        this.setVisible(false);
        LoginFrame frm1=new LoginFrame(master);
        frm1.setVisible(true);
        this.dispose();
        
    }
    
    private void preparemenu()
    { try{
        createuser.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e)
          {
              createuserAction();
          }

          
      }
      );
      
      authorizelogin.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e)
          {
              authorizeReloginAction();
          }
      }
      );
      generateuser.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){generateuserAction();}});
      createtest.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){createtestAction();}});
      addques.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){addquesAction();}});
      viewres.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){viewresAction();}});
      viewstatus.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){viewstatusAction();}});
      logoutmenuitem.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){logoutaction();}});
        
        
      }catch(Exception e){e.printStackTrace();}
    }
    
      
    
    
}
