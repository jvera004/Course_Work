<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Department.aspx.cs" Inherits="Lab2_Department" MasterPageFile="~/Lab2/Lab2.master" %>

<asp:Content ContentPlaceHolderID="Lab2Content" runat="server">
    <div style="margin:30px; width: 666px;">
    <h2>By Department</h2><br />
    Show users from: 
    <asp:DropDownList ID="DropDownListEmployees" runat="server" AutoPostBack="True" 
            onselectedindexchanged="DropDownListEmployees_SelectedIndexChanged" 
            DataTextField="DataTextField" DataValueField="DataValueField">
    </asp:DropDownList><br />
    The following are the users from the 
    <asp:Literal ID="LiteralDepartment" Text = "ALL EMPLOYEES" runat="server"></asp:Literal>
    department.<br />
    <asp:GridView ID="GridViewDepartments" runat="server" Width="666px" 
            BackColor="#660002" ForeColor="#CCCCCC" GridLines="Horizontal" 
            HorizontalAlign="Center">
            <RowStyle HorizontalAlign="Center" VerticalAlign="Middle" Wrap="True" />
        </asp:GridView>
    </div>
</asp:Content>
