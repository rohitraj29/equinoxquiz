/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohit
 */

public class PageBean {
private String text;
private String richpaneltitle;
private String panelcontent;
    public String getText() {
      
        return text;
    }

    public void setText(String text) {
        this.text = text;
     
    }

    /** Creates a new instance of PageBean */
    public PageBean() {
        this.richpaneltitle="Equinox";
        homeaction();
    }
public String action()
{
    this.text="Ajax Enabled Component";
    return null;
}
public String homeaction()
{   this.richpaneltitle="Equinox";
    this.panelcontent=
            "The Equinox Group is Back with the Blessing of our Seniors, we Hereby present you the Efficient Engine ANACHRONOX " +
            "which we believe to be the most efficient Quiz Engine to help our fellow SRMSCETians to develop their Skills and " +
            "getPrepared for the Companies and other Placement activities . In case of Any Queries Please Feel Free to Contact our Administrators" ;
            return null;
}

    public String getPanelcontent() {
        return panelcontent;
    }

    public void setPanelcontent(String panelcontent) {
        this.panelcontent = panelcontent;
    }

    public String getRichpaneltitle() {
        return richpaneltitle;
    }

    public void setRichpaneltitle(String richpaneltitle) {
        this.richpaneltitle = richpaneltitle;
    }
    public String aboutaction()
    {
        this.richpaneltitle="About Us";
        this.panelcontent="We are The technical Club Of the SRMSCET Bareilly, the very Experienced and best of my fellow " +
                "Friends have been working to induce technical skills and give them the experience they require to take over the world" +
                "we are hereby Inviting all the SRMSCETIans to be a Part of our Club and feel the difference in their lives" ;
        return null;
                
                
    }
    public String testaction()
    {
        return"testpage";
    }

}
