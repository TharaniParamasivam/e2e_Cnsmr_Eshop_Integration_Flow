'=============================================================================================================================
'General_Functions
'=============================================================================================================================

'Excplicit Declaration
'Option Explicit

'Declaration of Variables
Dim gstrInputFilePath,gstrXMLPath
Public gstrConfigFilePath

'=========================================================================================================================================
' Procedure Name : cp_Configuration
' Objective		 : Procedure to initialize input parameters as prerequisite
' Input Value    : None
' Example        : Call cp_Configuration()
'=========================================================================================================================================

Sub cp_Configuration()

	'Error Handling
	On Error Resume Next
	
	'Declaration of Variables
	gstrConfigFilePath = Environment("TestFramework")&"Test_Data\Configuration.ini"
	Environment("ProjectName") = cfn_GetConfigurationData("ProjectName")
    Environment("TestApplication") = cfn_GetConfigurationData("TestApplication")
    Environment("URLType") = cfn_GetConfigurationData("URLType")
    Environment("Environment") = cfn_GetConfigurationData("Environment")
    Environment("EnvironmentDetail") = cfn_GetConfigurationData("EnvironmentDetail")
    Environment("UserLogin") = cfn_GetConfigurationData("UserLogin")
    Environment("TestOutputSheet") = cfn_GetConfigurationData("TestOutputSheet")
    Environment("ValidateError") = cfn_GetConfigurationData("ValidateError")
    Environment("TakeScreenshotFailedStep") = cfn_GetConfigurationData("TakeScreenshotFailedStep")
    Environment("TakeScreenshotPassedStep") = cfn_GetConfigurationData("TakeScreenshotPassedStep")
    Environment("FetchMasterData") = cfn_GetConfigurationData("FetchMasterData")
    Environment("MasterTestDataDirectory") = cfn_GetConfigurationData("MasterTestDataDirectory")
    Environment("MasterTestDataFile") = cfn_GetConfigurationData("MasterTestDataFile")   
    Environment("UploadResultToQC") = cfn_GetConfigurationData("UploadResultToQC")   
    Environment("RecoveryScenario") = cfn_GetConfigurationData("RecoveryScenario")  
	Environment("ValidationType") = cfn_GetConfigurationData("ValidationType")
	Environment("VerifyEmailOutlook") = cfn_GetConfigurationData("VerifyEmailOutlook")
	
	gstrInputFilePath = Environment("TestFramework")&"Test_Data\Test_Data.xlsx"
	gstrXMLPath = Environment("TestFramework")&"Test_Data\MDW_No_CC.xml"
	
     'Code to handle error by proceeding to nextstep or pop dialog box or stop the execution
    Set qtpApp = CreateObject("QuickTest.Application")  
	strValidateError =  Lcase(Environment("ValidateError"))  
	If  strValidateError= "true" or strValidateError = "nextstep"  Then     
		qtpApp.Test.Settings.Run.OnError = "NextStep"
	 ElseIf strValidateError= "false" or strValidateError = "dialog" Then
		qtpApp.Test.Settings.Run.OnError = "Dialog"
	 Else
		qtpApp.Test.Settings.Run.OnError = "Stop"
	End If
	Set qtApp = Nothing

	'Report and clear the error
	If Err.Number<>0 Then
	    Reporter.ReportEvent 1, "Error in procedure cp_Configuration", "Error # " & Err.Number & " ==> " & Err.Description
	    Err.Clear
	End If
End Sub

'=========================================================================================================================================
'  End of Sub cp_Configuration()
'=========================================================================================================================================

'=========================================================================================================================================
' Function Name	: cfn_GetConfigurationData
' Objective		: Function to retrieve value for the passed parameter in Configuration file
' Input Value   : strKey: Key for which value need to be retrieved.
' Return Value  : Value corresponding to key specified
' Example       : Print cfn_GetConfigurationData("ProjectName")
'=========================================================================================================================================
Function cfn_GetConfigurationData(strkey)
	
	'On Error Resume Next
	On Error Resume Next

	'Declaration of Variable(s)
	Dim objFileSystemObject, objTextFileObject
	Dim strLine, strValue

	'Retrieve value for the passed parameter in Configuration file
	Set objFileSystemObject = CreateObject ("Scripting.FileSystemObject")
	If objFileSystemObject.FileExists(gstrConfigFilePath) = True Then
		Set objTextFileObject=objFileSystemObject.OpenTextFile(gstrConfigFilePath,1)
		
		Do Until objTextFileObject.AtEndOfStream = True
			strLine=objTextFileObject.ReadLine
			If InStr(1, strLine, strkey) > 0 Then
				strLine = Split(strLine,"=")
				If strLine(0) = strkey Then
					strValue = strLine(1)
					Exit Do
				End If
			End If
		Loop					
		objTextFileObject.Close
		Set objTextFileObject=Nothing
	End If
	Set objFileSystemObject =Nothing 
	'Return the retrieved value
	cfn_GetConfigurationData = CStr(strValue)

	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in function cfn_GetConfigurationData", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If

End Function
'=========================================================================================================================================
'  End of function cfn_GetConfigurationData
'=========================================================================================================================================

'=========================================================================================================================================
' Procedure Name 	: cp_AutoClosingMsgBox
' Objective			: Procedure to Use Message Box That Close Automatically 
' Input Value       : strText:Reporting text to display
'					  strTitle: Title of the message
'					  intTimeOut: Time for which Auto Closing box will remain
' Example           : cp_AutoClosingMsgBox "Test execution completed. Kindly browse through test execution reports.", "Thank you for running the Test Script.", 5
'=========================================================================================================================================
Sub cp_AutoClosingMsgBox(strText, strTitle, intTimeOut) 

	'On Error Resume Next
	If Environment("ValidateError") = "True" Then On Error Resume Next

	'Declaration of variable(s)
	Dim WshShell

	'Display the message on message box.
    Set WshShell = CreateObject("WScript.Shell") 
    WshShell.Popup strText, intTimeOut, strTitle 
	Set WshShell = Nothing

	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in procedure cp_AutoClosingMsgBox", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If

End Sub
'=========================================================================================================================================
'  End of procedure cp_AutoClosingMsgBox
'=========================================================================================================================================

'=========================================================================================================================================
' Function Name	    : cfn_GetRandomNumber
' Objective			: Function to generate random number
' Input Value       : intStart,intEnd
' Example           : intNum = cfn_GetRandomNumber(1000,5000)
'=========================================================================================================================================
Function cfn_GetRandomNumber(intStart, intEnd)

	'On Error Resume Next
    If Environment("ValidateError") = "True" Then On Error Resume Next

	cfn_GetRandomNumber = RandomNumber.Value(intStart, intEnd)
	
	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in function cfn_GetRandomNumber", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If

End Function
'=========================================================================================================================================
'  End of function cfn_GetRandomNumber
'=========================================================================================================================================

'=========================================================================================================================================
' Function Name	    : cfn_RandomAlphabetGeneration
' Objective			: Function to generate random alphabet
' Input Value       : intLength
' Example           : strPNR = cfn_RandomAlphabetGeneration(5)
'=========================================================================================================================================
Function cfn_RandomAlphabetGeneration(intLength)
	
	'On Error Resume Next
    If Environment("ValidateError") = "True" Then On Error Resume Next
	
	Dim GenerateRandomString	
	For intIndex = 1 To intLength
	  GenerateRandomString = GenerateRandomString + Chr(RandomNumber(65, 90))
	Next 
	cfn_RandomAlphabetgeneration = GenerateRandomString
	
	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in function cfn_RandomAlphabetGeneration", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If
End Function
'=========================================================================================================================================
'  End of function cfn_RandomAlphabetGeneration
'=========================================================================================================================================

'=================================================================================================================================
' Function Name	: cfn_FormatDate
' Objective		: This function is used to Convert Date into any given format
' Input Value   : format, intTimeStamp
' Return Value  : formated date
' Example       : cfn_FormatDate("%M %d, %Y", "11/21/2016") => will give output as-> Nov 21, 2016
				'MsgBox cfn_FormatDate("%g:%i%a %l %d/ %F/ %Y", "11/21/2016") ' o/p=> 0:00am Monday 21/ November/ 2016
				'MsgBox cfn_FormatDate("%l %d/ %F/ %Y", "11/21/2016")  'O/p=> Monday 21/Nov/2016
				'MsgBox cfn_FormatDate("%d/ %F/ %Y", "11/21/2016")  'O/p=> 21/Nov/2016
				'MsgBox cfn_FormatDate("%d %F, %Y", "11/21/2016") 'O/p=> 21 November, 2016
				'MsgBox cfn_FormatDate("%F %d , %Y", "11/21/2016") 'O/P=> November 21, 2016
				'MsgBox cfn_FormatDate("%M %d, %Y", "11/21/2016")  'O/P: Nov 21, 2016
'=================================================================================================================================
Function cfn_FormatDate(format, intTimeStamp)

	'On Error Resume Next
    If Environment("ValidateError") = "True" Then On Error Resume Next
    
	Dim monthname()
	Redim monthname(12)
	monthname(1) = "January"
	monthname(2) = "February"
	monthname(3) = "March"
	monthname(4) = "April"
	monthname(5) = "May"
	monthname(6) = "June"
	monthname(7) = "July"
	monthname(8) = "August"
	monthname(9) = "September"
	monthname(10) = "October"
	monthname(11) = "November"
	monthname(12) = "December"
	dim unUDate, A
	dim OriginalLocale
	dim res
	OriginalLocale = GetLocale
	res = SetLocale("en-gb")

	' Test to see if intTimeStamp looks valid. If not, they have passed a normal date
	if not (isnumeric(intTimeStamp)) then
		if isdate(intTimeStamp) then
			intTimeStamp = DateDiff("S", "01/01/1970 00:00:00", intTimeStamp)
		else
			response.write "Date Invalid"
			exit function
		end if
	end if
	if (intTimeStamp=0) then
		unUDate = now()
	else
		unUDate = DateAdd("s", intTimeStamp, "01/01/1970 00:00:00")
	end if
	unUDate = trim(unUDate)
	
	'bug fix for midnight problems
	If (Len(unUDate) <= 11) Then unUDate = Trim(unUDate) & " 00:00:00"	
	dim startM : startM = 1
	dim startD : startD = InStr(startM, unUDate, "/")+1
	dim startY : startY = InStr(startD, unUDate, "/")+1
	dim startHour : startHour = InStr(startY, unUDate, " ")+1
	dim startMin : startMin = InStr(startHour, unUDate, ":")+1
	dim startSec : startSec = InStr(startMin+1, unUDate, ":")+1
	dim dateMonth : dateMonth = mid(unUDate, startD, ((startY - 1) - startD)) 
	dim dateDay : dateDay = mid(unUDate, 1, ((startD - 1) - 1)) 
	dim dateYear : dateYear = Year(unUDate)
	dim dateHour : dateHour = mid(unUDate, startHour, ((startMin - startHour) - 1))
	dim dateMinute : dateMinute = mid(unUDate, startMin, 2)
	dim dateSecond : dateSecond = mid(unUDate, InStr(startMin, unUDate, ":") + 1, 2)
	
	format = replace(format, "%Y", right(dateYear, 4))
	format = replace(format, "%y", right(dateYear, 2))
	format = replace(format, "%m", dateMonth)
	format = replace(format, "%n", cint(dateMonth))	
	format = replace(format, "%F", monthname(cint(dateMonth)))
	format = replace(format, "%M", left(monthname(cint(dateMonth)), 3))
	format = replace(format, "%d", dateDay)
	format = replace(format, "%j", cint(dateDay))
	format = replace(format, "%h", mid(unUDate, startHour, 2))
	format = replace(format, "%g", cint(mid(unUDate, startHour, 2)))
	if (cint(dateHour) > 12) then
		A = "PM"
	else
		A = "AM"
	end if
	format = replace(format, "%A", A)
	format = replace(format, "%a", lcase(A))
	if (A = "PM") then format = replace(format, "%H", Right("00" & dateHour - 12, 2))
	format = replace(format, "%H", dateHour)
	if (A = "PM") then format = replace(format, "%G", left("0" & cint(dateHour) - 12, 2))
	format = replace(format, "%G", cint(dateHour))	
	format = replace(format, "%i", dateMinute)
	format = replace(format, "%I", cint(dateMinute))
	format = replace(format, "%s", dateSecond)
	format = replace(format, "%S", cint(dateSecond))
	format = replace(format, "%L", WeekDay(unUDate))
	format = replace(format, "%D", left(WeekDayName(WeekDay(unUDate)), 3))
	format = replace(format, "%l", WeekDayName(WeekDay(unUDate)))
	format = replace(format, "%U", intTimeStamp)
	format = replace(format, "11%O", "11th")
	format = replace(format, "1%O", "1st")
	format = replace(format, "12%O", "12th")
	format = replace(format, "2%O", "2nd")
	format = replace(format, "13%O", "13th")
	format = replace(format, "3%O", "3rd")
	format = replace(format, "%O", "th")	
	cfn_FormatDate = format

	'On Error  Report and Clear    
	If Err.Number <> 0 Then
		Reporter.ReportEvent micFail, "Error in Function cfn_FormatDate", "Error # " & CStr(Err.Number) & " " & Err.Description
		Err.Clear 'Clear the error.
	End if
	
End function
'=================================================================================================================================
' End of Function cfn_FormatDate
'=================================================================================================================================

'================================================================================================================================
' Function Name : p_Send_Hot_Key
' Objective     : Procedure to send Hot Key
' Input Value   : strHotKey
' Return Value  : NA
' Example       : 	
'================================================================================================================================
Sub p_Send_Hot_Key(ByVal strHotKey)
	
	'Error Handling
	On Error Resume Next
	'Declaration of Variable(s)
	Dim WshShell
	
	Set WshShell = CreateObject("WScript.Shell")
	WshShell.Sendkeys strHotKey
	Set WshShell = Nothing		
	
	'On Error  Report and Clear 
	If Err.Number <> 0 Then
	    Reporter.ReportEvent 1, "Error in the function " &p_Send_Hot_Key & ".", "Error # " & Err.Number & " ==> " & Err.Description
	    Err.Clear
	End If
End Sub
'================================================================================================================================
'End of the Procedure p_Send_Hot_Key
'================================================================================================================================

'================================================================================================================================
' Function Name : fnKillIE
' Objective     : Procedure to close all ie browsers except ALM
' Input Value   : NA
' Return Value  : NA
' Example       : fnKillIE
'================================================================================================================================
Function fnKillIE
	
	'Error Handling
	On Error Resume Next
	Set objShell = CreateObject("Shell.Application")
	For Each Application In objShell.Windows
		If InStr(1,Application.fullName,"iexplore.exe",1) > 0 And InStr(1,Application.LocationName,"Application Lifecycle Management",1) = 0 Then
			Application.Quit
		End If
	Next 
	
	'On Error  Report and Clear 
	If Err.Number <> 0 Then
	    Reporter.ReportEvent 1, "Error in the function " &fnKillIE & ".", "Error # " & Err.Number & " ==> " & Err.Description
	    Err.Clear
	End If
	
End Function
'================================================================================================================================
'End of the Procedure fnKillIE
'================================================================================================================================

'=========================================================================================================================================
' Function Name	: cfn_ConnectExcel
' Objective		: Function to Connect excel file and retrieve the value using SQL query
' Input Value   : strInputFilePath: Input test data sheet path
'				  strSQLQuery:  SQL Query to retrieve data from the input test data sheet
' Return Value  : Get recordset value or update sheet corresponding to the specified column
' Example       : Print cfn_ConnectExcel(strInputFilePath, strSQLQuery)
'=========================================================================================================================================
Function cfn_ConnectExcel(strInputFilePath, strSQLQuery)
	
	'Error Handling
	On Error Resume Next
	Dim objADOConnection,objRecordSet
	'On Error Resume Next
	If Environment("ValidateError") = "True" Then On Error Resume Next
	
	'Get the recordset value from the input data sheet
	Set  objADOConnection = CreateObject("ADODB.Connection")
	Set  objRecordSet = CreateObject("ADODB.Recordset")
'	objADOConnection.open "provider=microsoft.jet.oledb.4.0;"&"data source=" & strInputFilePath & ";" &"Extended properties=""Excel 8.0;HDR=YES;"";"
	objADOConnection.open "DSN=Excel Files;DBQ=" & strInputFilePath & ";"
	objRecordSet.Open strSQLQuery, objADOConnection
	Set  cfn_ConnectExcel =  objRecordSet 
	
	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in function cfn_ConnectExcel", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If

End Function
'=========================================================================================================================================
'  End of function cfn_ConnectExcel
'=========================================================================================================================================


'=========================================================================================================================================
' Function Name	: cfn_GetData_Multiple
' Objective		: Function to get multiple data from input datasheet
' Input Value   : strInputFilePath: Input test data sheet path
'				  strPrimaryKey:  Environment/User/Primary Key (Test Case Id)
'				  strPrimaryKey2: Second Primary Key
'				  strSheetName: Worksheet name
'				  strColumnName: Column name
' Return Value  : Get the value corresponding to Primary key and column specified for the sheet
' Example       : Print Trimcfn_GetData_Multiple(strInputFilePath, strSheetName, strPrimaryKey, strPrimaryKey2, strColumnName)
'========================================================================================================================================
Function cfn_GetData_Multiple(strInputFilePath, strSheetName, strPrimaryKey, strPrimaryKey2, strColumnName)
	'Error Handling
	On Error Resume Next
	'On Error Resume Next
                If Environment("ValidateError") = "True" Then On Error Resume Next
                
                Dim strValue
    		Set  objADOConnection = CreateObject("ADODB.Connection")
                Set  objRecordSet = CreateObject("ADODB.Recordset")
'                objADOConnection.open "provider=microsoft.jet.oledb.4.0;"&"data source=" & strInputFilePath & ";" &"Extended properties=""Excel 8.0;HDR=YES;"";"
                objADOConnection.open "DSN=Excel Files;DBQ=" & strInputFilePath & ";"
                set objRecordSet = objADOConnection.Execute("Select " & strColumnName & " from [" & strSheetName & "$] where (Environment = '" & strPrimaryKey & "' and Application = '" & strPrimaryKey2 & "')")
                
                strValue = objRecordset.fields.item(0)
		
                
    		cfn_GetData_Multiple =  strValue
                objADOConnection.Close()
                set objRecordSet = Nothing
                Set objADOConnection = Nothing
				
	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in function cfn_GetData_Multiple", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If

End function
'=========================================================================================================================================
'  End of function cfn_GetData_Multiple
'=========================================================================================================================================
'=========================================================================================================================================
' Function Name               : cfn_GetData
' Objective                          : Function to get data from input datasheet
' Input Value   : strInputFilePath: Input test data sheet path
'                                                                 strPrimaryKey:  Environment/User/Primary Key (Test Case Id)
'                                                                 strSheetName: Worksheet name
'                                                                 strColumnName: Column name
' Return Value  : Get the value corresponding to Primary key and column specified for the sheet
' Example       : Print Trim(cfn_GetData(gstrInputFilePath, strPrimaryKey, "Eligibility", "Company"))
'=========================================================================================================================================
Function cfn_GetData(strInputFilePath, strPrimaryKey, strSheetName, strColumnName)
	'Error Handling
	On Error Resume Next
	'On Error Resume Next
	If Environment("ValidateError") = "True" Then On Error Resume Next
                
	Dim strValue
	Set  objADOConnection = CreateObject("ADODB.Connection")
	Set  objRecordSet = CreateObject("ADODB.Recordset")
	objADOConnection.open "DSN=Excel Files;DBQ=" & strInputFilePath & ";"
	Set objRecordSet = objADOConnection.Execute("Select " & strColumnName & " from [" & strSheetName & "$] where TC_IDENTIFIER = '" & strPrimaryKey & "'")
	strValue = objRecordset.fields.item(0)
	cfn_GetData =  strValue
	objADOConnection.Close()
	Set objRecordSet = Nothing
	Set objADOConnection = Nothing
	'Report and clear the error
	If Err.Number<>0 Then
					Reporter.ReportEvent 1, "Error in function cfn_GetData", "Error # " & Err.Number & " ==> " & Err.Description
					Err.Clear
	End If
                
End function
'=========================================================================================================================================
'  End of function cfn_GetData
'=========================================================================================================================================

'=========================================================================================================================================
' Sub Name		: cp_OpenURL
' Objective		: Sub to open the URL in Internet Explorer
' Input Value   : strURL
'				  strBrowser
' Example       : Print Trim(cp_OpenURL(strURL,strBrowser)
'=========================================================================================================================================
Sub cp_OpenURL(strURL,strBrowser)
	'Error Handling
	On Error Resume Next
	'On Error Resume Next
	If Environment("ValidateError") = "True" Then On Error Resume Next
	
	Call fnKillChrome
	'Declaration of Variable(s)
	Dim objShell

	If  strBrowser = "Chrome" Then
		'SystemUtil.Run "Chrome.exe" , strURL ,,,3
		SystemUtil.Run "chrome.exe",strURL,"C:\","",3
		Wait(20)
		
	 Else
	 	Set objShell = CreateObject("WScript.Shell")
	 	Call killProcess("iexplore.exe")
	 	'Delete IE Browsing History
	 	objShell.Run ("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8")  
	 	objShell.Run ("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2")  
	 	objShell.Run ("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1")  
	 	objShell.Run ("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16")
		Wait(10)	 	
		SystemUtil.Run "iexplore.exe",strURL ,,,3
		Wait(30)
		Set objShell = Nothing
	End If

	'Report and clear the error
	If Err.Number<>0 Then
		'Reporter.ReportEvent Browser("creationtime:=0").GetROProperty("name")
		Reporter.ReportEvent 1, "Error in sub cp_OpenURL", Browser("creationtime:=0").GetROProperty("name")
		Err.Clear
	End If

End Sub
'=========================================================================================================================================
'  End of Sub cp_OpenURL
'=========================================================================================================================================

'=========================================================================================================================================
' Sub Name		: cp_CitrixLauncher
' Objective		: Open CitrixLauncher Application
' Input Value   : strUserName
'				  strPassword
' Example       : Print Trim(cp_CitrixLauncher(strUserName,strPassword)
'=========================================================================================================================================
Sub cp_CitrixLauncher(strUserName,strPassword,strInputFilePath)
	'Error Handling
	On Error Resume Next
	'On Error Resume Next
	If Environment("ValidateError") = "True" Then On Error Resume Next

	strCitrixUserName = cfn_GetData_Multiple(gstrInputFilePath, "Master_Sheet", Environment("Environment") ,"CitrixLauncher", "UserName")
	strCitrixPassword = cfn_GetData_Multiple(gstrInputFilePath, "Master_Sheet", Environment("Environment") ,"CitrixLauncher", "Password")
	strCitrixDomain = cfn_GetData_Multiple(gstrInputFilePath, "Master_Sheet", Environment("Environment") ,"CitrixLauncher", "Domain")
	
	Browser("Citrix Receiver").Page("Citrix Receiver").WebEdit("wbedt_Citrx_UserName").Set strCitrixUserName
	Browser("Citrix Receiver").Page("Citrix Receiver").WebEdit("wbedt_Citrx_Password").Set strCitrixPassword
	Browser("Citrix Receiver").Page("Citrix Receiver").Link("wblnk_Logon").Click
	Wait(20)
	
	Browser("Citrix Receiver").Page("Citrix Receiver").WebElement("wbelem_Apps").Click
	Wait(10)
	Browser("Citrix Receiver").Page("Citrix Receiver").WebEdit("wbedt_SearchApps").Set strCitrixDomain
	
	If  Environment("Environment") = "E2E"  Then
		Browser("Citrix Receiver").Page("Citrix Receiver").Image("img_Domain_Dep1").Click
		Wait(20)
	 ElseIf Environment("Environment") = "TEST1" Then
	 	Browser("Citrix Receiver").Page("Citrix Receiver").Image("img_Domain_Dep2").Click
		Wait(20)
	 Else
	 	Browser("Citrix Receiver").Page("Citrix Receiver").Image("img_Domain_Dep3").Click
	 	Wait(20)
	End If
	p_Send_Hot_Key "{Enter}"
	
	Wait(20)
	'Report and clear the error
	If Err.Number<>0 Then
		Reporter.ReportEvent 1, "Error in sub cp_OpenURL", "Error # " & Err.Number & " ==> " & Err.Description
		Err.Clear
	End If
End Sub
'=========================================================================================================================================
'  End of Sub cp_CitrixLauncher
'=========================================================================================================================================

Function cfn_Total_Execution_Time(strInitialTimer,strFinalTimer)
	'Error Handling
	On Error Resume Next
    'total number of seconds
    TotalTime_Secs  = Datediff("s",strInitialTimer,strFinalTimer)

    'convert  total  Seconds into "Seconds only/ Mins+Secs/ Hrs+Mins+Secs"
    If TotalTime_Secs < 60 Then
        TotalTime = "Script Execution Time = " & TotalTime_Secs  & " Second(s)"
    ElseIf    TotalTime_Secs >=60 and TotalTime_Secs < 3600 Then
        TotalTime = "Script Execution Time = " & int(TotalTime_Secs/60) & " Minute(s) and "& TotalTime_Secs Mod 60 & " Second(s)"
    ElseIf    TotalTime_Secs >= 3600 Then
        TotalTime = "Script Execution Time = " & int(TotalTime_Secs/3600) & " Hour(s) , " & int((TotalTime_Secs Mod 3600)/60)  & " Minute(s) and "& ((TotalTime_Secs Mod 3600 ) Mod 60) & " Second(s)"
    End If

    'Return the Message
    cfn_Total_Execution_Time = TotalTime
End Function


Function cfn_Month_Number(strMonth)
'Error Handling
	On Error Resume Next
	Select Case strMonth
	Case "January","JAN"
	intMonth = 1
	
	Case "February","FEB"
	intMonth = 2
	
	Case "March","MAR"
	intMonth = 3
	
	Case "April","APR"
	intMonth = 4
	
	Case "May","MAY"
	intMonth = 5
	
	Case "June","JUN"
	intMonth = 6
	
	Case "July","JUL"
	intMonth = 7
	
	Case "August","AUG"
	intMonth = 8
	
	Case "September","SEP"
	intMonth = 9
	
	Case "October","OCT"
	intMonth = 10
	
	Case "November","NOV"
	intMonth = 11
	
	Case "December","DEC"
	intMonth = 12
End Select
	cfn_Month_Number = intMonth
End Function


Function cfn_Database_Record(strDataSource,strSqlQuery)
'Error Handling
	On Error Resume Next
	
	Select Case strDataSource 
	
		Case 	"FFWF-E2E"        
       			Protocol="TCP"
                Host="ffwfe2edb.dev.qintra.com"
                Port="1542"
               	ServiceName="ffwfe2e"
            	Username="ffwf_app"
                Password="ffwfe2e_suomt102"
                
        Case 	"FFWF-TS1"        
       			Protocol="TCP"
                Host="ffwfst1db.dev.qintra.com"
                Port="1539"
               	ServiceName="ffwfst1"
            	Username="ffwf_app"
                Password="ffwfst1_suomt102"
                
        Case 	"FFWF-TS2"        
       			Protocol="TCP"
                Host="ffwfst2db.dev.qintra.com"
                Port="1541"
               	ServiceName="ffwfst2"
            	Username="ffwf_app"
                Password="ffwfst2_suomt102"
                
		Case 	"nicosrt1"        
       			Protocol="TCP"
                Host="nicosrt1db.dev.qintra.com"
                Port="1533"
               	ServiceName="nicosrt1"
            	Username="osr_app_user"
                Password="osr_app_user"
         
         Case 	"nicosrt2"
           		Protocol="TCP"
        		Host="nicosrt2db.dev.qintra.com"
            	Port="1532"
            	ServiceName="nicosrt2"
           		Username="osr_app_user"
            	Password="osr_app_user"
                                                                
        Case 	"nicosre1"
    			Protocol="TCP"
           		Host="nicosre1db.dev.qintra.com"
            	Port="1534"
                ServiceName="nicosre1"
       			Username="osr_app_user"
            	Password="osr_app_user"
            	
        Case 	"DEPLOYI1"        
				Protocol="TCP"
				Host="jobse2edb.test.intranet"
				Port="1385"
				ServiceName="jobse2e"
				Username="jobsapp"
				Password="Xjb43st!"
                                                                                                
		Case 	"DEPLOYI2"
				Protocol="TCP"
				Host="jobs001tdb.test.intranet"
				Port="1550"
				ServiceName="jobs001t"
				Username="jobsapp"
				Password="sbt94jts!"
                                                                
		Case 	"DEPLOYI3"
				Protocol="TCP"
				Host="jobs002tdb.test.intranet"
				Port="1551"
				ServiceName="jobs002t"
				Username="jobsapp"
				Password="sbt94jts!"
				
		Case 	"DSP001T"
				Protocol="TCP"
				Host="dsp001tdb.test.intranet"
				Port="1532"
				ServiceName="dsp001t"
				Username="DSPADMIN"
				Password="DSP55tst1"
				
		Case 	"DSP002T"
				Protocol="TCP"
				Host="dsp002tdb.test.intranet"
				Port="1541"
				ServiceName="dsp002t"
				Username="DSPADMIN"
				Password="X08may18T2"
				
		Case 	"DSP003T"
				Protocol="TCP"
				Host="dsp003tdb.test.intranet"
				Port="1531"
				ServiceName="dsp003t"
				Username="DSPADMIN"
				Password="DSP55e2e3"
				
		Case 	"ENSDEP2"        
   				Protocol="TCP"
                Host="lxmdtsdxdp2-scan.test.intranet"
                Port="1521"
               	ServiceName="ENSDEP2"
            	Username="qasel"
                Password="qaseldep2"
                                                                                            
    	Case 	"ENSDEP3"
           		Protocol="TCP"
        		Host="lxmdtsdxdp3-scan.test.intranet"
            	Port="1521"
            	ServiceName="ENSDEP3"
           		Username="qasel"
            	Password="qaseldep3"
                                                            
        Case 	"ENSDEP1"
    			Protocol="TCP"
           		Host="lxmdtsdxdp1-scan.test.intranet"
            	Port="1521"
                ServiceName="ENSDEP1"
       			Username="qasel"
            	Password="qaseldep1"
	End Select
	Dim strConnectionString
	
	strConnectionString	 = "Driver={Microsoft ODBC for Oracle}; " & _
        				   "CONNECTSTRING=(DESCRIPTION=" & _
         				   "(ADDRESS=(PROTOCOL="&Protocol&")" & _
        				   "(HOST="&Host&")(PORT="&Port&"))" & _
        				   "(CONNECT_DATA=(SERVICE_NAME="&ServiceName&"))); uid="&Username&";pwd="&Password&";"
        				   
    Dim oCon: Set oCon = CreateObject("ADODB.Connection")
	Dim oRs: Set oRs = CreateObject("ADODB.Recordset")
	
	oCon.Open strConnectionString
	
	oRs.Open strSqlQuery,strConnectionString,3
	strRecordCount = oRs.RecordCount
	
	While Not oRs.EOF
	If strRecordCount = 1 Then
		strRecord = oRs.Fields(0).Value
		cfn_Database_Record = strRecord
		Exit Function
	ElseIf strRecordCount > 1 Then
		strRecord = strRecord & ";" & oRs.Fields(0).Value
		oRs.MoveNext
	ElseIf strRecordCount < 1 Then
		ExitTest
	End If
	Wend
	
	cfn_Database_Record = strRecord
	
End Function


'================================================================================================================================
' Function Name : fnKillChrome
' Objective     : Procedure to close all chrome browsers
' Input Value   : NA
' Return Value  : NA
' Example       : fnKillChrome
'================================================================================================================================
Function fnKillChrome
	'Error Handling
	On Error Resume Next
	Set objShell = CreateObject("Shell.Application")
	For Each Application In objShell.Windows
		If InStr(1,Application.fullName,"chrome.exe",1) > 0 Then
			Application.Quit
		End If
	Next 
	
	'On Error  Report and Clear 
	If Err.Number <> 0 Then
	    Reporter.ReportEvent 1, "Error in the function " &fnKillIE & ".", "Error # " & Err.Number & " ==> " & Err.Description
	    Err.Clear
	End If
	
End Function
'================================================================================================================================
'End of the Procedure fnKillChrome
'================================================================================================================================

function readFromRegistry (strRegistryKey, strDefault)
'Error Handling
	On Error Resume Next
    Dim WSHShell, value



    On Error Resume Next
    Set WSHShell = CreateObject ("WScript.Shell")
    value = WSHShell.RegRead (strRegistryKey)

    if err.number <> 0 then
        readFromRegistry= strDefault
    else
        readFromRegistry=value
    end if

    set WSHShell = nothing
end function


function OpenWithChrome(strURL)
'Error Handling
	On Error Resume Next
    Dim strChrome
    Dim WShellChrome



    strChrome = readFromRegistry ( "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\App Paths\chrome.exe\Path", "") 
    if (strChrome = "") then
        strChrome = "chrome.exe"
    else
        strChrome = strChrome & "\chrome.exe"
    end if
    Set WShellChrome = CreateObject("WScript.Shell")
    strChrome = """" & strChrome & """" & " " & strURL
    WShellChrome.Run strChrome, 1, false
end function


sub killProcess(strProcessName)
    strComputer = "."
strProcessToKill = "iexplore.exe" 

SET objWMIService = GETOBJECT("winmgmts:" _
	& "{impersonationLevel=impersonate}!\\" _ 
	& strComputer & "\root\cimv2") 

SET colProcess = objWMIService.ExecQuery _
	("Select * from Win32_Process Where Name = '" & strProcessName & "'")

count = 0
FOR EACH objProcess in colProcess
	objProcess.Terminate()
	count = count + 1
NEXT 
end sub 
