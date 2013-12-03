using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using DatabaseModel;

public partial class Lab2_All : System.Web.UI.Page
{
    DatabaseEntities database = new DatabaseEntities();

    protected void Page_Load(object sender, EventArgs e)
    {
        //is it isn't a postback and is a new page request, display the employee table
        if (!IsPostBack)
        {
            GridViewEmployees.DataSource = from t in database.Employees
                                           select new
                                           {
                                               Name = t.Name,
                                               Phone = t.Phone,
                                               ITPasscode = t.ITPasscode,
                                               Department = t.Department.Name,
                                               Email = t.Email
                                           };
            GridViewEmployees.DataBind();
        }
    }
}