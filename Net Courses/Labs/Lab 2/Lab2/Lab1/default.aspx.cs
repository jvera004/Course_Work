using System;
using System.Data;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _default : System.Web.UI.Page
{
    int duplicate = 0;
    Boolean duplicateFile = false;
    String lastFileUploaded = "";
    public int duplicateCount(String fileName)
    {
        if (!lastFileUploaded.Equals(fileName))
        {
            duplicate = 0;
        }
        DirectoryInfo FilesDirectory = new DirectoryInfo(Server.MapPath("~/Lab1/Files/"));
        FileInfo[] files = FilesDirectory.GetFiles();
        for (int i = 0; i < files.Count(); i++)
        {
            if (files[i].Name.Equals(fileName) || files[i].Name.Equals(fileName + "_" + duplicate))
            {
                duplicate++;
            }
        }
        return duplicate;
    }

    public Boolean checkForDuplicates(String fileName)
    {
        duplicateFile = false;
        try
        {
            DirectoryInfo FilesDirectory = new DirectoryInfo(Server.MapPath("~/Lab1/Files/"));
            FileInfo[] files = FilesDirectory.GetFiles();
            for(int i = 0; i < files.Count(); i++){
                if (files[i].Name.Equals(fileName))
                {
                    duplicateFile = true;
                }
            }
        }
        catch (Exception e)
        {
            LabelUploadStatus.Text = "Error while checking for duplicates!";
        }
        return duplicateFile;
    }
    protected void Page_Load(object sender, EventArgs e)
    {
        displayFiles();
        if (GridViewFilesList.Rows.Count >= 1)
            MultiViewForFiles.ActiveViewIndex = 1;
        else
            MultiViewForFiles.ActiveViewIndex = 0;
    }
    protected void ButtonUploadFile_Click(object sender, EventArgs e)
    {
        if (FileUploadOptionBox.HasFile)
        {
            try
            {
                string fileName = Path.GetFileName(FileUploadOptionBox.FileName);
                if (checkForDuplicates(fileName))
                    FileUploadOptionBox.SaveAs(Server.MapPath("~/Lab1/Files/") + fileName + "_" + (duplicateCount(fileName)));
                else
                {
                    FileUploadOptionBox.SaveAs(Server.MapPath("~/Lab1/Files/") + fileName);
                    lastFileUploaded = fileName;
                }
                LabelUploadStatus.Text = "File Uploaded!";
                displayFiles();
                MultiViewForFiles.ActiveViewIndex = 1;
            }
            catch (Exception ex)
            {
                LabelUploadStatus.Text = "Upload status: The file could not be uploaded. The following error occured: " + ex.Message;
            }
        }
        else
            LabelUploadStatus.Text = "You need to select a file first man...";
    }

    protected void displayFiles()
    {
        try
        {
            DirectoryInfo FilesDirectory = new DirectoryInfo(Server.MapPath("~/Lab1/Files/"));
            FileInfo[] files = FilesDirectory.GetFiles();
            DataTable fileInfo = new DataTable();
            fileInfo.Columns.Add("File Name");
            fileInfo.Columns.Add("File Size");
            fileInfo.Columns.Add("Date Modified");
            ViewState["fileInfo"] = fileInfo;
            for (int i = 0; i < files.Count(); i++)
            {
                DataRow currentFile = fileInfo.NewRow();
                currentFile["File Name"] = files[i].Name;
                currentFile["File Size"] = files[i].Length + " bytes";
                currentFile["Date Modified"] = files[i].CreationTime.ToShortDateString() + " " + files[i].CreationTime.ToLongTimeString();
                fileInfo.Rows.Add(currentFile);
                fileInfo.AcceptChanges();
            }
            GridViewFilesList.DataSource = fileInfo;
            GridViewFilesList.DataBind();
        }
        catch (Exception e)
        {
            LabelUploadStatus.Text = "No Deal." + e.Message;
        }
    }
}