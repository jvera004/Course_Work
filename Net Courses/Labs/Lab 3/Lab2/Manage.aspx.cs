using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DatabaseModel;

public partial class Lab2_Manage : System.Web.UI.Page
{
    DatabaseEntities database = new DatabaseEntities();
    
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            UpdateDepartments();
        }
    }

    private void UpdateDepartments()
    {
        
        DropDownListEmployees.DataSource = from t in database.Departments
                                           select new
                                           {
                                               DataTextField = t.Name,
                                               DataValueField = t.ID
                                           };
        DropDownListEmployees.DataBind();
    }

    protected void ButtonAddEmployee_Click(object sender, EventArgs e)
    {
        //Validate the page so any flags will come up
        Page.Validate("wholePage");

        RequiredFieldValidatorDepartment.IsValid = true;

        //create a new employee to add to the list
        Employee current = new Employee();

        //if its someone in the IT crowd get the value from the passcode textbox that's normally hidden
        if (DropDownListEmployees.SelectedItem.Text.Equals("IT"))
        {
            current.ITPasscode = TextBoxPasscode.Text;
        }
        else
        {
            RequiredFieldValidatorPasscode.IsValid = true;
        }

        
        //check and see if the page is valid
        if (Page.IsValid)
        {
            //get the other values from the text box
            current.DepartmentID = int.Parse(DropDownListEmployees.SelectedValue);
            current.Name = TextBoxName.Text;
            current.Phone = TextBoxPhoneNumber.Text.Replace("-","");
            current.Email = TextBoxEmail.Text;
            //then add it to the database
            database.Employees.AddObject(current);
            database.SaveChanges();

            //Clear the textboxes, drop down list and make the passcode invisible
            DropDownListEmployees.ClearSelection();
            TextBoxName.Text = null;
            TextBoxPhoneNumber.Text = null;
            TextBoxPasscode.Text = null;
            TextBoxEmail.Text = null;
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
    protected void ButtonAddDepartment_Click(object sender, EventArgs e)
    {
        Page.Validate("wholePage");
        //Bypass the add employee validators
        RequiredFieldValidatorEmail.IsValid = true;
        RequiredFieldValidatorName.IsValid = true;
        RequiredFieldValidatorPhoneNumber.IsValid = true;
        RequiredFieldValidatorPasscode.IsValid = true;

        if (Page.IsValid)
        {
            //create a temporary department
            Department current = new Department();

            //set the name to the current department entry from the textbox
            current.Name = TextBoxDepartment.Text;

            //add the department entry into the database
            database.Departments.AddObject(current);

            //save changes made to the database and update the drop down list with the departments
            database.SaveChanges();
            UpdateDepartments();

            //clear the department textbox
            TextBoxDepartment.Text = null;
        }
    }
}