<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmMain
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(frmMain))
        Me.lblDepartFrom = New System.Windows.Forms.Label()
        Me.lblArriveAt = New System.Windows.Forms.Label()
        Me.lblDepartDate = New System.Windows.Forms.Label()
        Me.lblArrivalDate = New System.Windows.Forms.Label()
        Me.lblDepartureTime = New System.Windows.Forms.Label()
        Me.dtpickerDepartDate = New System.Windows.Forms.DateTimePicker()
        Me.txtbxDepartureTime = New System.Windows.Forms.TextBox()
        Me.btnGo = New System.Windows.Forms.Button()
        Me.lblArrivalTime = New System.Windows.Forms.Label()
        Me.cboxDepartFrom = New System.Windows.Forms.ComboBox()
        Me.cboxArriveAt = New System.Windows.Forms.ComboBox()
        Me.SuspendLayout()
        '
        'lblDepartFrom
        '
        Me.lblDepartFrom.AutoSize = True
        Me.lblDepartFrom.Location = New System.Drawing.Point(12, 15)
        Me.lblDepartFrom.Name = "lblDepartFrom"
        Me.lblDepartFrom.Size = New System.Drawing.Size(65, 13)
        Me.lblDepartFrom.TabIndex = 10
        Me.lblDepartFrom.Text = "Depart from:"
        '
        'lblArriveAt
        '
        Me.lblArriveAt.AutoSize = True
        Me.lblArriveAt.Location = New System.Drawing.Point(207, 15)
        Me.lblArriveAt.Name = "lblArriveAt"
        Me.lblArriveAt.Size = New System.Drawing.Size(49, 13)
        Me.lblArriveAt.TabIndex = 11
        Me.lblArriveAt.Text = "Arrive at:"
        '
        'lblDepartDate
        '
        Me.lblDepartDate.AutoSize = True
        Me.lblDepartDate.Location = New System.Drawing.Point(12, 65)
        Me.lblDepartDate.Name = "lblDepartDate"
        Me.lblDepartDate.Size = New System.Drawing.Size(68, 13)
        Me.lblDepartDate.TabIndex = 12
        Me.lblDepartDate.Text = "Depart Date:"
        '
        'lblArrivalDate
        '
        Me.lblArrivalDate.AutoSize = True
        Me.lblArrivalDate.Location = New System.Drawing.Point(207, 65)
        Me.lblArrivalDate.Name = "lblArrivalDate"
        Me.lblArrivalDate.Size = New System.Drawing.Size(93, 13)
        Me.lblArrivalDate.TabIndex = 13
        Me.lblArrivalDate.Text = "Arrival Date/Time:"
        '
        'lblDepartureTime
        '
        Me.lblDepartureTime.AutoSize = True
        Me.lblDepartureTime.Location = New System.Drawing.Point(12, 113)
        Me.lblDepartureTime.Name = "lblDepartureTime"
        Me.lblDepartureTime.Size = New System.Drawing.Size(83, 13)
        Me.lblDepartureTime.TabIndex = 14
        Me.lblDepartureTime.Text = "Departure Time:"
        '
        'dtpickerDepartDate
        '
        Me.dtpickerDepartDate.Format = System.Windows.Forms.DateTimePickerFormat.[Short]
        Me.dtpickerDepartDate.Location = New System.Drawing.Point(12, 81)
        Me.dtpickerDepartDate.Name = "dtpickerDepartDate"
        Me.dtpickerDepartDate.Size = New System.Drawing.Size(131, 20)
        Me.dtpickerDepartDate.TabIndex = 3
        '
        'txtbxDepartureTime
        '
        Me.txtbxDepartureTime.Location = New System.Drawing.Point(12, 129)
        Me.txtbxDepartureTime.Name = "txtbxDepartureTime"
        Me.txtbxDepartureTime.Size = New System.Drawing.Size(100, 20)
        Me.txtbxDepartureTime.TabIndex = 4
        '
        'btnGo
        '
        Me.btnGo.Location = New System.Drawing.Point(132, 180)
        Me.btnGo.Name = "btnGo"
        Me.btnGo.Size = New System.Drawing.Size(75, 23)
        Me.btnGo.TabIndex = 5
        Me.btnGo.Text = "Go"
        Me.btnGo.UseVisualStyleBackColor = True
        '
        'lblArrivalTime
        '
        Me.lblArrivalTime.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.lblArrivalTime.Location = New System.Drawing.Point(207, 87)
        Me.lblArrivalTime.Name = "lblArrivalTime"
        Me.lblArrivalTime.Size = New System.Drawing.Size(134, 62)
        Me.lblArrivalTime.TabIndex = 17
        '
        'cboxDepartFrom
        '
        Me.cboxDepartFrom.FormattingEnabled = True
        Me.cboxDepartFrom.Items.AddRange(New Object() {"MIA", "JFK", "HNL", "LAX", "DFW"})
        Me.cboxDepartFrom.Location = New System.Drawing.Point(12, 31)
        Me.cboxDepartFrom.Name = "cboxDepartFrom"
        Me.cboxDepartFrom.Size = New System.Drawing.Size(121, 21)
        Me.cboxDepartFrom.TabIndex = 1
        '
        'cboxArriveAt
        '
        Me.cboxArriveAt.FormattingEnabled = True
        Me.cboxArriveAt.Items.AddRange(New Object() {"MIA", "JFK", "HNL", "LAX", "DFW"})
        Me.cboxArriveAt.Location = New System.Drawing.Point(210, 31)
        Me.cboxArriveAt.Name = "cboxArriveAt"
        Me.cboxArriveAt.Size = New System.Drawing.Size(121, 21)
        Me.cboxArriveAt.TabIndex = 2
        '
        'frmMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(354, 213)
        Me.Controls.Add(Me.cboxArriveAt)
        Me.Controls.Add(Me.cboxDepartFrom)
        Me.Controls.Add(Me.lblArrivalTime)
        Me.Controls.Add(Me.btnGo)
        Me.Controls.Add(Me.txtbxDepartureTime)
        Me.Controls.Add(Me.dtpickerDepartDate)
        Me.Controls.Add(Me.lblDepartureTime)
        Me.Controls.Add(Me.lblArrivalDate)
        Me.Controls.Add(Me.lblDepartDate)
        Me.Controls.Add(Me.lblArriveAt)
        Me.Controls.Add(Me.lblDepartFrom)
        Me.ForeColor = System.Drawing.SystemColors.ControlText
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.MaximizeBox = False
        Me.Name = "frmMain"
        Me.Text = "Schedule a Flight"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents lblDepartFrom As System.Windows.Forms.Label
    Friend WithEvents lblArriveAt As System.Windows.Forms.Label
    Friend WithEvents lblDepartDate As System.Windows.Forms.Label
    Friend WithEvents lblArrivalDate As System.Windows.Forms.Label
    Friend WithEvents lblDepartureTime As System.Windows.Forms.Label
    Friend WithEvents dtpickerDepartDate As System.Windows.Forms.DateTimePicker
    Friend WithEvents txtbxDepartureTime As System.Windows.Forms.TextBox
    Friend WithEvents btnGo As System.Windows.Forms.Button
    Friend WithEvents lblArrivalTime As System.Windows.Forms.Label
    Friend WithEvents cboxDepartFrom As System.Windows.Forms.ComboBox
    Friend WithEvents cboxArriveAt As System.Windows.Forms.ComboBox

End Class
