/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizengineapp;

import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.entity.Results;
import com.equinox.ejb.entity.Test;

import com.equinox.ejb.entity.Users;
import com.equinox.ejb.session.CreateUserRemote;
import com.equinox.ejb.session.FinalResultRemote;
import com.equinox.ejb.session.HitEntryRemote;
import com.equinox.ejb.session.QuestionEntryRemote;
import com.equinox.ejb.session.ResultBeanRemote;
import com.equinox.ejb.session.TestEntryRemote;
import com.equinox.ejb.session.TestFacadeRemote;
import com.equinox.stub.beans.ComputeBean;
import com.equinox.stub.beans.HitBean;
import com.equinox.stub.beans.LoginInfo;
import com.equinox.stub.beans.QuestionBean;
import com.equinox.stub.beans.ResultBean;
import com.equinox.stub.beans.TestBean;
import com.equinox.stub.beans.UserBean;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rohit
 */
public class MasterController implements ActionListener {

    public List getTestList() {
        return (testremote.findAll());

    }
    private List<Questions> questionList;

    public List<Questions> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Questions> questionList) {
        this.questionList = questionList;
    }
    private UserBean userdata;
    private LoginSession session;
    private HitBean hit;
    private QuestionBean question;
    private ResultBean res;
    private ComputeBean compute = new ComputeBean();
    private TestBean test = new TestBean();
    private LoginInfo loginfo = new LoginInfo();
    private Users userid;
    private HitEntryRemote hitremote;
    private TestEntryRemote testEntryremote;
    private UserFrame frame;
    private Vector<Hits> resultvector;
    private ResultBeanRemote resultRemote;
    private Vector<QuestionWrapper> questionmasterlist;

    public Vector<QuestionWrapper> getQuestionmasterlist() {
        return questionmasterlist;
    }

    public void setQuestionmasterlist(Vector<QuestionWrapper> questionmasterlist) {
        this.questionmasterlist = questionmasterlist;
    }
    public Vector<Hits> getResultvector() {
        return resultvector;
    }

    public void setResultvector(Vector<Hits> resultvector) {
        this.resultvector = resultvector;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }
    private CreateUserRemote userRemote;
    private TestFacadeRemote testremote;
    private Test currentTest;
    private QuestionEntryRemote questionremote;
    private Vector<QuestionWrapper> readyqueslist = new Vector<QuestionWrapper>();

    public QuestionEntryRemote getQuestionremote() {
        return questionremote;
    }

    public void setQuestionremote(QuestionEntryRemote questionremote) {
        this.questionremote = questionremote;
    }
    
    public List<Results> getResult(Test test)
    {
        ResultBeanRemote r1=this.lookupResultBeanBean();
        try {
            return (r1.getResult(test));

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        

        
    }
    public Test getCurrentTest() {
        return currentTest;
    }

    public void setCurrentTest(Test currentTest) {
        this.currentTest = currentTest;
    }

    public ComputeBean getCompute() {
        return compute;
    }

    public MasterController() {
       
        this.userRemote = this.lookupCreateUserBean();
        this.testremote = this.lookupTestFacade();
        this.questionremote = this.lookupQuestionEntryBean();
        this.testEntryremote = this.lookupTestEntryBean();
        this.resultRemote = this.lookupResultBeanBean();


    }

    public void setCompute(ComputeBean compute) {
        this.compute = compute;
    }

    public Vector<QuestionWrapper> getReadyqueslist() {
        return readyqueslist;
    }

    public void setReadyqueslist(Vector<QuestionWrapper> readyqueslist) {
        this.readyqueslist = readyqueslist;
    }

    public HitBean getHit() {
        return hit;
    }

    public void setHit(HitBean hit) {
        this.hit = hit;
    }

    public LoginInfo getLoginfo() {
        return loginfo;
    }

    public void setLoginfo(LoginInfo loginfo) {
        this.loginfo = loginfo;
    }

    public QuestionBean getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBean question) {
        this.question = question;
    }

    public ResultBean getRes() {
        return res;
    }

    public void setRes(ResultBean res) {
        this.res = res;
    }

    public LoginSession getSession() {
        return session;
    }

    public void setSession(LoginSession session) {
        this.session = session;
    }

    public TestBean getTest() {
        return test;
    }

    public void setTest(TestBean test) {
        this.test = test;
    }

    public UserBean getUserdata() {
        return userdata;
    }

    public void setUserdata(UserBean userdata) {
        this.userdata = userdata;
    }

    public boolean validateLogin(UserBean user) {
        this.userdata = user;
        this.session = userRemote.validateUser(user.getUsername(), user.getPassword(), user.getRoleplayed());
        if (session != null) {
            this.userid = this.userRemote.findByName(user.getUsername());
            this.loginfo.setSession(session);
            this.loginfo.setUser(userid);
            return (true);

        } else {
            return false;
        }
    }

    public Vector<QuestionWrapper> prepareQuestions() {
        this.questionList = this.questionremote.findByTestObject(this.currentTest);
        Iterator itr = questionList.iterator();
        while (itr.hasNext()) {
            this.readyqueslist.add(new QuestionWrapper((Questions) itr.next()));

        }
        
        return (readyqueslist);
        
    }

    void createTest(TestBean test) {
        this.testEntryremote.registerTest(test);
    }

    void insertQuestion(QuestionBean ques) {
        this.questionremote.registerQuestions(ques);
    }
    private javax.swing.Timer timer;

    void persistFinal(ResultBean res) {
       FinalResultRemote frr=this.lookupFinalResultBean();
       frr.persistResult(res);
    }

    void startTest(UserFrame frm) {
        this.res = new ResultBean();
        res.setUserid(this.userid);
        res.setSession(this.session);
        res.setTestid(currentTest);
        this.frame = frm;
        timer = new javax.swing.Timer(this.getCurrentTest().getDurationMin() * 3600, this);
        timer.start();
    }

    void submitResponse(QuestionWrapper current, int optsub) {
        HitBean response = new HitBean();
        response.setQid(current.getQuestion());
        response.setResponse(optsub);
        response.setSession(this.loginfo.getSession());
        response.setTestid(this.getCurrentTest());
        response.setUserid(this.loginfo.getUser());
        if (optsub == current.getQuestion().getOptionCorrect()) {
            response.setScore(this.getCurrentTest().getOnCorrect());
        } else {
            response.setScore(this.getCurrentTest().getOnWrong());
        }
        this.hit = response;
        this.hitremote = this.lookupHitEntryBean();
        hitremote.persistHit(response);


    }

    private CreateUserRemote lookupCreateUserBean() {
        try {
            Context c = new InitialContext();
            return (CreateUserRemote) c.lookup("java:comp/env/CreateUserBean");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void showAdminFrame() {
         AdminFrame frm1=new AdminFrame(this);
         
         frm1.setVisible(true);
    }

    public void showUserFrame() {
        UserFrame frm1 = new UserFrame(this);
        frm1.setVisible(true);

    }

    public void registerUser(UserBean user) {
        this.userRemote.createUser(user);
    }

    private TestFacadeRemote lookupTestFacade() {
        try {
            Context c = new InitialContext();
            return (TestFacadeRemote) c.lookup("java:comp/env/TestFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private QuestionEntryRemote lookupQuestionEntryBean() {
        try {
            Context c = new InitialContext();
            return (QuestionEntryRemote) c.lookup("java:comp/env/QuestionEntryBean");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private HitEntryRemote lookupHitEntryBean() {
        try {
            Context c = new InitialContext();
            return (HitEntryRemote) c.lookup("java:comp/env/HitEntryBean");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TestEntryRemote lookupTestEntryBean() {
        try {
            Context c = new InitialContext();
            return (TestEntryRemote) c.lookup("java:comp/env/TestEntryBean");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void endQuiz()
    {
        int tempscore = 0;
        
        Vector temp = resultRemote.computeResult(this.res);
        this.resultvector = temp;
        Iterator itr = resultvector.iterator();
        while (itr.hasNext()) {
            Hits hittemp = (Hits) itr.next();
            tempscore += hittemp.getScore();
        }
        this.res.setScore(tempscore);
        frame.setContentPane(new ResultPanel(this));
        frame.setVisible(false);
        frame.setVisible(true);
        frame.repaint();
        
    }
    public void actionPerformed(ActionEvent e) {
        endQuiz();
        
    }
    

    private ResultBeanRemote lookupResultBeanBean() {
        try {
            Context c = new InitialContext();
            return (ResultBeanRemote) c.lookup("java:comp/env/ResultBeanBean");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private FinalResultRemote lookupFinalResultBean() {
        try {
            Context c = new InitialContext();
            return (FinalResultRemote) c.lookup("java:comp/env/FinalResultBean");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
