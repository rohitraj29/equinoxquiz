/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quizengineapp;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class showQuestionPanel extends JPanel{
    public showQuestionPanel(Vector<QuestionWrapper> vector)
    {
        this.setLayout(new GridLayout(vector.size(),1,3,3));
        Iterator itr=vector.iterator();
        while(itr.hasNext())
        {
            QuestionWrapper temp=(QuestionWrapper)itr.next();
            this.add(temp.getQuestionlabel());
            
        }
    }

}
