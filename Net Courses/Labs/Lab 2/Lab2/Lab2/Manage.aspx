<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Manage.aspx.cs" Inherits="Lab2_Manage" MasterPageFile="~/Lab2/Lab2.master" %>
<asp:Content ContentPlaceHolderID="Lab2Content" runat="server">
<div>
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
        Department:<spacerSmall></spacerSmall>     
        <asp:DropDownList ID="DropDownListEmployees" runat="server" ValidationGroup="wholePage" 
        ViewStateMode="Enabled" AutoPostBack="True" 
        onselectedindexchanged="DropDownListEmployees_SelectedIndexChanged" >
        <asp:ListItem Text="Sales" Value="Sales"></asp:ListItem>
        <asp:ListItem Text="IT" Value="IT"></asp:ListItem>
        <asp:ListItem Text="Marketing" Value="Marketing"></asp:ListItem>
        <asp:ListItem Text="Executives" Value="Executives"></asp:ListItem>
        </asp:DropDownList><br /><br />
        Name:<spacer></spacer><asp:TextBox ID="TextBoxName" runat="server" 
        CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox><br />
    <asp:RequiredFieldValidator ID="RequiredFieldValidatorName" runat="server" 
        ControlToValidate="TextBoxName" CssClass="lab2Validation" Display="Dynamic" 
        ErrorMessage="Name required, cannot leave empty." ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ID="RegularExpressionValidatorName" 
        runat="server" ControlToValidate="TextBoxName" CssClass="lab2Validation" 
        Display="Dynamic" ErrorMessage="Must enter full name like so: Hattori Hanzo" 
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
        <asp:Literal ID="LiteralITPasscode" runat="server" Visible="False" 
        ViewStateMode="Enabled" Text="IT Passcode:"></asp:Literal><spacerSmall></spacerSmall>
    <asp:TextBox ID="TextBoxPasscode" runat="server" Visible="false" 
        ViewStateMode="Enabled" CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox><br />
    <asp:RequiredFieldValidator ID="RequiredFieldValidatorPasscode" runat="server" 
        ControlToValidate="TextBoxPasscode" CssClass="lab2Validation" Display="Dynamic" 
        ErrorMessage="Passcode required, cannot leave empty." 
        ValidationGroup="wholePage"></asp:RequiredFieldValidator>
    <br />
        <spacerButton></spacerButton><asp:Button ID="ButtonAddEmployee" runat="server" Text="Add" onclick="ButtonAddEmployee_Click" />
        </div>
</asp:Content>
