using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            DietaryRequirementsRadioButtonList.SelectedIndex = 2;
        }
    }
    protected void AddRegistrationButton_Click(object sender, EventArgs e)
    {
        //If Name text box is empty, set Alert label text
        if (NameTextBox.Text.Length == 0)
        {
            NameAlertLabel.Text = "Please enter a name. ";
        }
        //Else if Monday thru Friday is selected, set event date alert label text to specify weekends only
        else if (EventDateCalendar.SelectedDate.DayOfWeek.ToString().Equals("Monday") || EventDateCalendar.SelectedDate.DayOfWeek.ToString().Equals("Tuesday")
                || EventDateCalendar.SelectedDate.DayOfWeek.ToString().Equals("Wednesday") || EventDateCalendar.SelectedDate.DayOfWeek.ToString().Equals("Thursday")
                || EventDateCalendar.SelectedDate.DayOfWeek.ToString().Equals("Friday"))
        {
            NameAlertLabel.Text = "";
            EventDateAlertLabel.Text = "Please select a date on the weekends only.";
        }
        else
        {
            //Clear Alerts
            NameAlertLabel.Text = "";
            EventDateAlertLabel.Text = "";
            //Create List Item to add to Canceled Registrations List Box
            String name = NameTextBox.Text.ToString();
            String date = EventDateCalendar.SelectedDate.ToShortDateString();
            String dietaryRequirements = DietaryRequirementsRadioButtonList.SelectedItem.Text.ToString();
            ListItem currentRegistration = new ListItem(name + ", " + date + ", " + dietaryRequirements);
            //Add ListItem to Registrations
            RegistrationsListBox.Items.Add(currentRegistration);
            //Clear Name text box. reset calendar to today's date
            NameTextBox.Text = "";
            EventDateCalendar.SelectedDate = EventDateCalendar.TodaysDate;
        }
    }
    protected void CancelRegistrationButton_Click(object sender, EventArgs e)
    {
        //If the registration list box doesn't have anything selected, warn user with appropriate alert label
        if (RegistrationsListBox.SelectedItem != null)
        {
            /*Otherwise reset alert label, make a temp copy of the selected item, then remove it from the
            registration list box and add it to the canceled registrations list box and unselect the item
            in the canceled registrations listbox*/
            CancelRegistrationAlertLabel.Text = "";
            ListItem selectedRegistration = RegistrationsListBox.SelectedItem;
            RegistrationsListBox.Items.Remove(RegistrationsListBox.SelectedItem);
            CanceledRegistrationsListBox.Items.Add(selectedRegistration);
            CanceledRegistrationsListBox.SelectedItem.Selected = false;
        }
        else
            CancelRegistrationAlertLabel.Text = "Please select a registration to cancel.";
    }
}