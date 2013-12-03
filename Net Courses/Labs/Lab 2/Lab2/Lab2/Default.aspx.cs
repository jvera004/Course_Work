using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Lab2_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            //Create the employees list and put it into the session for the other pages to use
            List<Employee> employees = new List<Employee>();
            Session.Add("employees", employees);
        }
    }
}