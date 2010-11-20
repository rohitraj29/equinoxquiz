
package beans;
import com.equinox.ejb.entity.Questions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author root
 */

public class QuestionWrap implements Serializable{
    private Questions questio;
    private String cssclass;
    private int qnumber;
    private String background;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getQnumber() {
        return qnumber;
    }

    public void setQnumber(int qnumber) {
        this.qnumber = qnumber;
    }

    public String getCssclass() {
        return cssclass;
    }

    public void setCssclass(String cssclass) {
        this.cssclass = cssclass;
    }

    public Questions getQuestio() {
        return questio;
    }

    public void setQuestio(Questions questio) {
        this.questio = questio;
    }

    public QuestionWrap()
    {
        
      
    }
}
