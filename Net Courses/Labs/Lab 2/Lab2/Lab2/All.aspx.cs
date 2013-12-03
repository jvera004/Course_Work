using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

public partial class Lab2_All : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //is it isn't a postback and is a new page request, display the employee table
        if (!IsPostBack)
        {
            displayEmployeeTable();
        }
    }

    protected void displayEmployeeTable()
    {
        DataTable employeeInfo = new DataTable();
        employeeInfo.Columns.Add("Name");
        employeeInfo.Columns.Add("Department");
        employeeInfo.Columns.Add("Phone");
        employeeInfo.Columns.Add("IT Passcode");
        ViewState["employeeInfo"] = employeeInfo;

        List<Employee> employees = (List<Employee>) Session["employees"];
        for (int i = 0; i < employees.Count(); i++)
        {
            DataRow currentFile = employeeInfo.NewRow();
            currentFile["Name"] = employees[i].Name;
            currentFile["Department"] = employees[i].Department;
            currentFile["Phone"] = employees[i].Phone;
            currentFile["IT Passcode"] = employees[i].Passcode;
            employeeInfo.Rows.Add(currentFile);
            employeeInfo.AcceptChanges();
        }
        GridViewEmployees.DataSource = employeeInfo;
        GridViewEmployees.DataBind();
    }
}