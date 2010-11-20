/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.entity.QuestionsFacadeRemote;
import ejb.EjbAdapter;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

/**
 *
 * @author root
 */

public class EditQuestionBean {
    
    private QuestionsFacadeRemote questionsFacade;
private Long quesid;
private Questions question;
private String questiondetail;
private String option1;
private String option2;
private String option3;
private String option4;
private int optionCorrect;

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getOptionCorrect() {
        return optionCorrect;
    }

    public void setOptionCorrect(int optionCorrect) {
        this.optionCorrect = optionCorrect;
    }

    public String getQuestiondetail() {
        return questiondetail;
    }

    public void setQuestiondetail(String questiondetail) {
        this.questiondetail = questiondetail;
    }

    public Long getQuesid() {
        return quesid;
    }

    public void setQuesid(Long quesid) {
        this.quesid = quesid;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }
    /** Creates a new instance of EditQuestionBean */
    public EditQuestionBean() {
        this.questionsFacade=EjbAdapter.lookupQuestionsFacade();
    }

public String updateAction()
{
    this.question.setQuestion(questiondetail);
    this.question.setOption1(option1);
    this.question.setOption2(option2);
    this.question.setOption3(option3);
    this.question.setOption4(option4);
    this.question.setOptionCorrect(optionCorrect);
    this.questionsFacade.edit(question);
    FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully Edited The Question","Successfully Edited The Question");
    FacesContext.getCurrentInstance().addMessage(null, msg);
    
    return null;
}
public void actionPerformed(ActionEvent e)
{
    HtmlAjaxCommandButton cmd=(HtmlAjaxCommandButton)e.getComponent();
    Long id=(Long)cmd.getData();
    this.quesid=id;
    this.question=this.questionsFacade.find(quesid);
    this.questiondetail=this.question.getQuestion();
    this.option1=this.question.getOption1();
    this.option2=this.question.getOption2();
    this.option3=this.question.getOption3();
    this.option4=this.question.getOption4();
    this.optionCorrect=this.question.getOptionCorrect();
    
}
}
