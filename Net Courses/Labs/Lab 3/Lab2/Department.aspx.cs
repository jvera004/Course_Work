using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DatabaseModel;

public partial class Lab2_Department : System.Web.UI.Page
{
    DatabaseEntities database = new DatabaseEntities();

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            DropDownListEmployees.DataSource = from t in database.Departments
                                               select new
                                               {
                                                   DataTextField = t.Name,
                                                   DataValueField = t.ID
                                               };
            DropDownListEmployees.DataBind();

            GridViewDepartments.DataSource = from t in database.Employees
                                           select new
                                           {
                                               Name = t.Name,
                                               Phone = t.Phone,
                                               ITPasscode = t.ITPasscode,
                                               Department = t.Department.Name,
                                               Email = t.Email
                                           };
            GridViewDepartments.DataBind();
        }
    }
    protected void DropDownListEmployees_SelectedIndexChanged(object sender, EventArgs e)
    {
        int selected = int.Parse(DropDownListEmployees.SelectedValue);
        GridViewDepartments.DataSource = from t in database.Employees
                                         where t.Department.ID == selected
                                         select new
                                           {
                                               Name = t.Name,
                                               Phone = t.Phone,
                                               ITPasscode = t.ITPasscode,
                                               Department = t.Department.Name,
                                               Email = t.Email
                                           };
        GridViewDepartments.DataBind();
        LiteralDepartment.Text = DropDownListEmployees.SelectedItem.Text;
    }
}