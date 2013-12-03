using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DatabaseModel;
using System.Net;
using System.Net.Mail;

public partial class Lab2_Contact : System.Web.UI.Page
{
    DatabaseEntities database = new DatabaseEntities();

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            DropDownListEmployees.DataSource = from t in database.Employees
                                               select new
                                               {
                                                   DataTextField = t.Name,
                                                   DataValueField = t.Email
                                               };
            DropDownListEmployees.DataBind();
        }
    }

    protected void ButtonSend_Click(object sender, EventArgs e)
    {
        Page.Validate("wholePage");
        if (Page.IsValid)
        {
            MailMessage msg = new MailMessage(DropDownListEmployees.SelectedItem.Value, DropDownListEmployees.SelectedValue, TextBoxSubject.Text, TextBoxBody.Text);

            SmtpClient client = new SmtpClient("smtp.gmail.com", 587);
            NetworkCredential ncre = new NetworkCredential("jonspamact@gmail.com", "omgwtfbbq");
            client.Credentials = ncre;
            client.EnableSsl = true;
            client.Send(msg);

            TextBoxBody.Text = null;
            TextBoxSubject.Text = null;
        }
    }
}