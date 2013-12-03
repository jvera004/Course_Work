<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" MasterPageFile="~/Site.master" %>
<asp:Content ContentPlaceHolderID="MainContent" runat="server">
    <table>
    <tr>
    <td valign="top">
        <asp:Label ID="NameLabel" runat="server" Text="Name:"></asp:Label><br />
        <asp:TextBox ID="NameTextBox" runat="server"></asp:TextBox><br />
        <asp:Label ID="NameAlertLabel" runat="server" Text="" ForeColor="Red"></asp:Label>
    </td>
    <td>
        <asp:Label ID="RegistrationsLabel" runat="server" Text="Registrations:"></asp:Label><br />
        <asp:ListBox ID="RegistrationsListBox" runat="server" Width="260px"></asp:ListBox>
    </td>
    <td>
        <asp:Label ID="CanceledRegistrationsLabel" runat="server" Text="Canceled Registrations:"></asp:Label><br />
        <asp:ListBox ID="CanceledRegistrationsListBox" runat="server" Width="260px"></asp:ListBox>
    </td>
    </tr>
    <tr>
    <td>
        <asp:Label ID="EventDateLabel" runat="server" Text="Event Date:"></asp:Label>
        <asp:Calendar ID="EventDateCalendar" runat="server" TabIndex="1"></asp:Calendar>
        <asp:Label ID="EventDateAlertLabel" runat="server" Text="" ForeColor="Red"></asp:Label><br />
        
    </td>
        <td valign="top">
        <asp:Button ID="CancelRegistrationButton" runat="server" Text="Cancel Registration" 
                onclick="CancelRegistrationButton_Click" TabIndex="4" /><br />
        <asp:Label ID="CancelRegistrationAlertLabel" runat="server" Text="" ForeColor="Red"></asp:Label></td>
    </tr>
    <tr>
    <td>
        <asp:Label ID="DietaryRequirementsLabel" runat="server" Text="Dietary Requirements:"></asp:Label>
        <asp:RadioButtonList ID="DietaryRequirementsRadioButtonList" runat="server" 
            TabIndex="2">
        <asp:ListItem Text="Gluten Free"></asp:ListItem>
        <asp:ListItem Text="Vegetarian"></asp:ListItem>
        <asp:ListItem Text="NA"></asp:ListItem>
        </asp:RadioButtonList>
        <br />
    </td>
    </tr>
    <tr>
    <td><asp:Button ID="AddRegistrationButton" runat="server" Text="Add Registration" 
            onclick="AddRegistrationButton_Click" TabIndex="3" /></td>
    </tr>
    </table>
</asp:Content>