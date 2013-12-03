Public Class frmMain
    Private airports As String() = {"MIA", "JFK", "HNL", "LAX", "DFW"}
    Private utcOffsets As Integer() =  {-5, -5, -10, -8, -6}
    Private travelTimes As Double(,) = {{0, 3, 12, 8, 2.5}, _
                                        {3, 0, 14, 8.5, 3.5}, {12, 12, 0, 4.5, 8.5}, _
                                        {8, 8.5, 4.5, 0, 3.5}, {2.5, 3.5, 8.5, 3.5, 0}}

    Private Sub btnGo_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btnGo.Click
        If (checkErrors()) Then
            MessageBox.Show("Please fix the errors before I can continue!")
        Else
            Dim departAirline As String = cboxDepartFrom.SelectedItem.ToString
            Dim departIndex As Integer
            Dim arriveAirline As String = cboxArriveAt.SelectedItem.ToString
            Dim arriveIndex As Integer
            Dim departDate As DateTime = dtpickerDepartDate.Value
            Dim departTime As DateTime = DateTime.Parse(txtbxDepartureTime.Text)
            Dim departureFullDateAndTime As New Date(departDate.Year, departDate.Month, departDate.Day, departTime.Hour, departTime.Minute, 0)

            For Each airport As String In airports
                If (airport.Equals(departAirline)) Then
                    Exit For
                Else
                    departIndex += 1
                End If
            Next
            For Each port As String In airports
                If (port.Equals(arriveAirline)) Then
                    Exit For
                Else
                    arriveIndex += 1
                End If
            Next
            Dim arrivalOffset As Integer = utcOffsets(arriveIndex)
            Dim localOffset As Integer = utcOffsets(departIndex)
            Dim travelHours As Double = travelTimes(departIndex, arriveIndex)
            Dim travelMinutes As Integer = 0
            If (travelHours.ToString.Contains(".5")) Then
                travelHours -= 0.5
                travelMinutes = 30
            End If


            Dim travelTime As New TimeSpan(travelHours, travelMinutes, 0)
            Dim arrivalTime As DateTime = departureFullDateAndTime.Subtract(New TimeSpan(localOffset, 0, 0))

            arrivalTime = arrivalTime.Add(travelTime)
            arrivalTime = arrivalTime.Add(New TimeSpan(arrivalOffset, 0, 0))
            lblArrivalTime.Text = arrivalTime.ToShortDateString + " at " + arrivalTime.ToShortTimeString + ". The travel time is " + travelTime.Hours.ToString + " hours"
            If (travelMinutes = 30) Then
                lblArrivalTime.Text += " and 30 minutes."
            Else
                lblArrivalTime.Text += "."
            End If
        End If
    End Sub

    Private Function checkErrors()
        Dim errorChecker As ErrorProvider = New ErrorProvider
        Dim flag As Boolean = False
        Dim departureTime As Date
        If (String.IsNullOrEmpty(cboxDepartFrom.SelectedItem)) Then
            errorChecker.SetError(cboxDepartFrom, "Must select an airline to depart from!")
            flag = True
        Else
            If (String.IsNullOrEmpty(cboxArriveAt.SelectedItem)) Then
                flag = True
                errorChecker.SetError(cboxArriveAt, "Must select an airline to arrive at!")
            Else
                If (cboxArriveAt.SelectedItem.Equals(cboxDepartFrom.SelectedItem)) Then
                    flag = True
                    errorChecker.SetError(cboxArriveAt, "Cannot choose the same airport for departing and arriving!")
                End If
            End If
        End If
        If (DateTime.TryParse(txtbxDepartureTime.Text, departureTime)) Then
        Else
            flag = True
            errorChecker.SetError(txtbxDepartureTime, "Time must be as follows: hh:mm or h:mmPM")
        End If
        Return flag
    End Function
End Class
