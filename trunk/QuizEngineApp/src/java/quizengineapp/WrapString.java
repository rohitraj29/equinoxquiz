/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quizengineapp;

import java.util.StringTokenizer;

/**
 *
 * @author root
 */
public class WrapString {
    public static String wrapString(String s)
    {
        StringBuffer sb=new StringBuffer();
        
        StringTokenizer token=new StringTokenizer(s," ");
        int i=0;
        while(token.hasMoreTokens())
        {
           String frag=token.nextToken();
         
           i+=frag.length();
           if(i<80)  {
           sb.append(token.nextToken());
             i++;
           }
           else
           {
               i=0;
               sb.append("\n");
           }
         
            
        }
        return sb.toString();
    }

}
