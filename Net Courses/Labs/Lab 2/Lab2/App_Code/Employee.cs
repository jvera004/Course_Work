using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Employee
/// </summary>
public class Employee
{
    public string Department { get; set; }
    public string Name { get; set; }
    public string Phone { get; set; }
    public string Passcode { get; set; }
    
    public Employee()
	{
	}

    public Employee(string department, string name, string phone, string passcode)
    {
        Department = department;
        Name = name;
        Phone = phone;
        Passcode = passcode;
    }
}