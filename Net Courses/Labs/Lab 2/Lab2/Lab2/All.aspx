<%@ Page Language="C#" AutoEventWireup="true" CodeFile="All.aspx.cs" Inherits="Lab2_All" MasterPageFile="~/Lab2/Lab2.master"%>
<asp:Content ContentPlaceHolderID="Lab2Content" runat=server>
    <div style="margin:30px; width: 666px;">
        <asp:GridView ID="GridViewEmployees" runat="server" Width="666px" 
            BackColor="#660002" ForeColor="#CCCCCC" GridLines="Horizontal" 
            HorizontalAlign="Center">
            <RowStyle HorizontalAlign="Center" VerticalAlign="Middle" Wrap="True" />
        </asp:GridView>
    </div>
</asp:Content>
