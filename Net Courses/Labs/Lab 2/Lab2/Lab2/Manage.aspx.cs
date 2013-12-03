using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Lab2_Manage : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
    }

    protected void ButtonAddEmployee_Click(object sender, EventArgs e)
    {
        //Validate the page so any flags will come up
        Page.Validate("wholePage");

        //get the employee list from the session
        List<Employee> employees = (List<Employee>)Session["employees"];

        //create a new employee to add to the list
        Employee current = new Employee();

        //if its someone in the IT crowd get the value from the passcode textbox that's normally hidden
        if (DropDownListEmployees.SelectedItem.Text.Equals("IT"))
        {
            current.Passcode = TextBoxPasscode.Text;
        }
        else
        {
            RequiredFieldValidatorPasscode.IsValid = true;
        }

        
        //check and see if the page is valid
        if (Page.IsValid)
        {
            //get the other values from the text box
            current.Department = DropDownListEmployees.SelectedValue;
            current.Name = TextBoxName.Text;
            current.Phone = TextBoxPhoneNumber.Text;

            //then add it to the list
            employees.Add(current);

            //remove the old list, then put the new one into the session
            Session.Remove("employees");
            Session.Add("employees", employees);

            //Clear the textboxes, drop down list and make the passcode invisible
            DropDownListEmployees.ClearSelection();
            TextBoxName.Text = null;
            TextBoxPhoneNumber.Text = null;
            TextBoxPasscode.Text = null;
            LiteralITPasscode.Visible = false;
            TextBoxPasscode.Visible = false;
        }
    }
    protected void DropDownListEmployees_SelectedIndexChanged(object sender, EventArgs e)
    {
        if (DropDownListEmployees.SelectedItem.Text.Equals("IT"))
        {
            LiteralITPasscode.Visible = true;
            TextBoxPasscode.Visible = true;
        }
        else
        {
            LiteralITPasscode.Visible = false;
            TextBoxPasscode.Visible = false;
        }
    }
}