/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quizengineapp;

import com.equinox.ejb.entity.Questions;
import javax.swing.JLabel;

/**
 *
 * @author rohit
 */
public class QuestionWrapper {
    public static final int VIEWED =0;
    public static final int SUBMITTED=1;
    public static final int INDOUBT=2;
    
    private Questions question;
    private JLabel questionlabel=new JLabel();
    private int status;

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public JLabel getQuestionlabel() {
        return questionlabel;
    }

    public void setQuestionlabel(JLabel questionlabel) {
        this.questionlabel = questionlabel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public QuestionWrapper(Questions ques)
    {
        this.question=ques;
        questionlabel.setSize(200,30);
        questionlabel.setVisible(true);
    }

}
