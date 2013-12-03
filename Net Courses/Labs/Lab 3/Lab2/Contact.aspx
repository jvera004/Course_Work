<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Contact.aspx.cs" Inherits="Lab2_Contact" MasterPageFile="~/Lab2/Lab2.master"%>
<asp:Content ContentPlaceHolderID="Lab2Content" runat="server">
    <style>
        spacer
        {
            margin-left: 60px;
            margin-right: 60px;
            margin-bottom: 60px;
        }
    </style>
    <div>
        <h2>Contact</h2>
        <br />
        <br />


        <spacer></spacer>
        <asp:Literal ID="LiteralTo" Text="To:" runat="server"></asp:Literal>
        <br />
        <spacer></spacer>
        <asp:DropDownList ID="DropDownListEmployees" runat="server" 
        ViewStateMode="Enabled" AutoPostBack="True" 
        DataTextField="DataTextField" DataValueField="DataValueField">
        </asp:DropDownList>
        <br />



        <spacer></spacer>
        <asp:Literal ID="LiteralSubject" Text="Subject:" runat="server"></asp:Literal>
        <br />
        <spacer></spacer>
        <asp:TextBox ID="TextBoxSubject" runat="server" CausesValidation="True" ValidationGroup="wholePage"></asp:TextBox>
        <br />
        <spacer></spacer>
        <asp:RequiredFieldValidator ID="RequiredFieldValidatorSubject" runat="server" 
                                    ControlToValidate="TextBoxSubject" CssClass="lab2Validation" Display="Dynamic" 
                                    ErrorMessage="Subject required, cannot leave empty." ValidationGroup="wholePage">
        </asp:RequiredFieldValidator>
        <br />



        <spacer></spacer>
        <asp:Literal ID="LiteralBody" Text="Body:" runat="server"></asp:Literal>
        <br />
        <spacer></spacer>
        <asp:TextBox ID="TextBoxBody" runat="server" TextMode="MultiLine" Rows="4" 
            Width="400px"></asp:TextBox>
        <br />
        <spacer></spacer>
        <asp:RequiredFieldValidator ID="RequiredFieldValidatorBody" runat="server" 
                                    ControlToValidate="TextBoxBody" CssClass="lab2Validation" Display="Dynamic" 
                                    ErrorMessage="Body required, cannot leave empty." ValidationGroup="wholePage">
        </asp:RequiredFieldValidator>
        <br />


        <spacer></spacer>
        <asp:Button ID="ButtonSend" runat="server" Text="Send" onclick="ButtonSend_Click" />
    </div>
</asp:Content>
