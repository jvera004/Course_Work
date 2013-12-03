<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Manage.aspx.cs" Inherits="Lab2_Manage" MasterPageFile="~/Lab2/Lab2.master" %>
<asp:Content ContentPlaceHolderID="Lab2Content" runat="server">
    <style>
        spacerSmall
        {
            margin-left: 42px;
            margin-right: 42px;
        }
        spacer
        {
            margin-left: 80px;
            margin-right: 80px;
        }
        spacerButton
        {
            margin-left: 100px;
            margin-right: 100px;
        }
    </style>




    <div style="margin-bottom:40px">
        <h2>Add Department</h2>
        Department: <spacerSmall></spacerSmall>
        <asp:TextBox ID="TextBoxDepartment" runat="server"></asp:TextBox><br />
        <asp:RequiredFieldValidator ID="RequiredFieldValidatorDepartment" runat="server" 
        ControlToValidate="TextBoxDepartment" CssClass="lab2Validation" Display="Dynamic" 
        ErrorMessage="Department required, cannot leave empty." ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ID="RegularExpressionValidatorDepartment" 
        runat="server" ControlToValidate="TextBoxDepartment" CssClass="lab2Validation" 
        Display="Dynamic" ErrorMessage="Must enter a valid department name." 
        ValidationExpression="([A-Za-z]+\s[A-Za-z]+|[A-Za-z]+)" ValidationGroup="wholePage"></asp:RegularExpressionValidator>
    <br />
        <asp:Button ID="ButtonAddDepartment" runat="server" Text="Add Department" 
            onclick="ButtonAddDepartment_Click" />
    </div>





    <div>
        <h2>Add Employee</h2>
        Department:<spacerSmall></spacerSmall>     
        <asp:DropDownList ID="DropDownListEmployees" runat="server" ValidationGroup="wholePage" 
        ViewStateMode="Enabled" AutoPostBack="True" 
        onselectedindexchanged="DropDownListEmployees_SelectedIndexChanged" DataTextField="DataTextField" DataValueField="DataValueField">
        </asp:DropDownList>
        <br /><br />
        Name:<spacer></spacer><asp:TextBox ID="TextBoxName" runat="server" 
        CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox><br />
    <asp:RequiredFieldValidator ID="RequiredFieldValidatorName" runat="server" 
        ControlToValidate="TextBoxName" CssClass="lab2Validation" Display="Dynamic" 
        ErrorMessage="Name required, cannot leave empty." ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ID="RegularExpressionValidatorName" 
        runat="server" ControlToValidate="TextBoxName" CssClass="lab2Validation" 
        Display="Dynamic" ErrorMessage="Must enter full name like so: Peter Peterson" 
        ValidationExpression="[A-Za-z]+\s[A-Za-z]+" ValidationGroup="wholePage"></asp:RegularExpressionValidator>
    <br />
        Phone:<spacer></spacer><asp:TextBox ID="TextBoxPhoneNumber" runat="server" 
        CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox><br />
    <asp:RequiredFieldValidator ID="RequiredFieldValidatorPhoneNumber" 
        runat="server" ControlToValidate="TextBoxPhoneNumber" CssClass="lab2Validation" 
        Display="Dynamic" ErrorMessage="Phone number required, cannot leave empty." 
        ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ID="RegularExpressionValidatorPhoneNumber" 
        runat="server" ControlToValidate="TextBoxPhoneNumber" CssClass="lab2Validation" 
        Display="Dynamic" 
        ErrorMessage="Phone number must be in this format: 555-555-5555" 
        ValidationExpression="\d{3}-\d{3}-\d{4}" ValidationGroup="wholePage"></asp:RegularExpressionValidator>
    <br />
    Email:<spacer></spacer><asp:TextBox ID="TextBoxEmail" runat="server" 
        CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox><br />
    <asp:RequiredFieldValidator ID="RequiredFieldValidatorEmail" runat="server" 
        ControlToValidate="TextBoxEmail" CssClass="lab2Validation" Display="Dynamic" 
        ErrorMessage="Email required, cannot leave empty." ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ID="RegularExpressionValidatorEmail" 
        runat="server" ControlToValidate="TextBoxEmail" CssClass="lab2Validation" 
        Display="Dynamic" ErrorMessage="Must enter email like so: yourEmail@somesite.com" 
        ValidationExpression="[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z0-9]{2,3}" ValidationGroup="wholePage"></asp:RegularExpressionValidator>
    <br />
        <asp:Literal ID="LiteralITPasscode" runat="server" Visible="False" 
        ViewStateMode="Enabled" Text="IT Passcode:"></asp:Literal><spacerSmall></spacerSmall>
    <asp:TextBox ID="TextBoxPasscode" runat="server" Visible="false" 
        ViewStateMode="Enabled" CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox><br />
    <asp:RequiredFieldValidator ID="RequiredFieldValidatorPasscode" runat="server" 
        ControlToValidate="TextBoxPasscode" CssClass="lab2Validation" Display="Dynamic" 
        ErrorMessage="Passcode required, cannot leave empty." 
        ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <br />
        <spacerButton></spacerButton><asp:Button ID="ButtonAddEmployee" runat="server" Text="Add Employee" onclick="ButtonAddEmployee_Click" />
    </div>
</asp:Content>
