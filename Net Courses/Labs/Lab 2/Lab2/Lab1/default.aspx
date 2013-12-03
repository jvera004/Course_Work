<%@ Page Language="C#" AutoEventWireup="true" CodeFile="default.aspx.cs" Inherits="_default" MasterPageFile="~/Site.master" %>
<asp:Content ContentPlaceHolderID="MainContent" runat="server">
    <h1>File Upload</h1>
    <hr />
    <style>
        spacer
        {
            margin-left: 10px;
            margin-right: 10px;
        }
    </style>
    <asp:FileUpload ID="FileUploadOptionBox" runat="server" />
    <spacer><asp:Button ID="ButtonUploadFile" runat="server" Text="Upload File" 
        Height="22px" onclick="ButtonUploadFile_Click" Margin="5px"/></spacer>
    <spacer><asp:Label ID="LabelUploadStatus" runat="server" Text="Waiting for files..." 
            Height="22px" Font-Names="Courier New" Font-Size="Small" Width="250px"></asp:Label></spacer>
    <hr />
    <asp:MultiView ID="MultiViewForFiles" runat="server">
    <asp:View ID="ViewNoFilesFound" runat="server"><div style="border:1px solid red; padding:10px"><div style="border:1px solid blue; text-align:center">No Files Found...</div></div></asp:View>
    <asp:View ID="ViewFilesFound" runat="server">
    <div>
        <asp:GridView ID="GridViewFilesList" runat="server" BackColor="#787878" 
            BorderColor="#CC0000" BorderStyle="Solid" AutoGenerateColumns="True" 
            HorizontalAlign="Left" CellPadding="5" CellSpacing="25" ForeColor="Maroon">
            <HeaderStyle BorderColor="#990000" BorderStyle="Solid" BorderWidth="3px" 
                Font-Bold="True" Font-Names="Times New Roman" Font-Size="Large" 
                ForeColor="#000066" />
            <RowStyle BorderColor="#000066" BorderStyle="Dotted" BorderWidth="2px" 
                Font-Names="Courier New" Font-Size="Smaller" />
        </asp:GridView>
    </div>
    <%--<div>
        <asp:ListBox ID="ListBoxFilesList" runat="server" Rows="10"></asp:ListBox>
    </div>--%>
    </asp:View>
    </asp:MultiView>
</asp:Content>