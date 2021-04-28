'Excplicit Declaration
'Option Explicit

'Error Handling
On Error Resume Next

'Configuring Test Framework Folder
arrFramework = Split(Environment.Value("TestDir"),"Test_Scripts")
Environment("TestFramework") = arrFramework(0)

'Load Function Library
gGeneralFLPath =Environment("TestFramework")&"Function_Library\General_Functions.vbs"

'Add  Function Library
LoadFunctionLibrary gGeneralFLPath

'Selenium Framework Data Fetching
arrFrameworkPath = Split(Environment.Value("TestDir"),"\WebSop_UFT")
'strTestData = arrFrameworkPath(0) & "\OrderDetails.xlsx"
'strTestData = "C:\Users\AC49184\Desktop\OrderDetails.xlsx"
strTestData = "C:\Users\ab72075\Downloads\jsl-eshop-test-sample-Eshop_Code_Merge_ALL (1)\jsl-eshop-test-sample-Eshop_Code_Merge_ALL\EshopTools\src\test\resources\OrderDetails.xlsx"



Set objExcel = CreateObject("Excel.Application")
objExcel.Visible = False
Set ObjWorkBook = objExcel.Workbooks.open (strTestData)
Set ObjWorkSheet = ObjWorkbook.WorkSheets("Sheet1")
rowcount = ObjWorkSheet.usedrange.rows.count
strOrderNumber =  ObjWorkSheet.Cells(rowcount,4)
strSFCURL = ObjWorkSheet.Cells(rowcount,5)

'Environment Identification
If 	Instr(strSFCURL,"pp4uat") Then
	strWebsopURL = "https://websop7-e2e.test.intranet/websop/jsp/launch.html"
 ElseIf Instr(strSFCURL,"pp1uat")  Then
	strWebsopURL = "https://websop7-test1.test.intranet/websop/jsp/launch.html"
 ElseIf Instr(strSFCURL,"pp2uat") Then
	strWebsopURL = "https://websop7-test2.test.intranet/websop/jsp/launch.html"
 Else
 	Call cp_AutoClosingMsgBox("We are only available with Test Environments(Test1,Test2,Test4)", "Error", 5)
 	Call cp_Excel_Update(strTestData,rowcount,"FAIL")
 	ExitTest
 End  If

'Launch WebSOP
Call cp_OpenURL(strWebsopURL,"IE")

'Click here to Logon to WebSop
Browser("name:=WebSOP").Page("title:=WebSOP").Link("outertext:=Click here to logon to WebSOP").Click
Wait(10)

'Maximize
Browser("name:=WebSOP Login").Maximize

'Login
Browser("name:=WebSOP Login").Page("title:=WebSOP Login").WebEdit("name:=user").Set "AC49184"
Browser("name:=WebSOP Login").Page("title:=WebSOP Login").WebEdit("name:=password").SetSecure "6088fd9d96d3621fc8404ec9c9b987eea86f9fd314c35807"
Browser("name:=WebSOP Login").Page("title:=WebSOP Login").WebButton("name:=Login").Click

If 	Browser("title:=.*WebSOP Main Page.*").Page("title:=.*WebSOP Main Page.*").WebElement("innerhtml:=.*View/Update/Complete Orders.*","html tag:=CENTER").Exist(20) Then
	
	'View Order
	Browser("title:=.*WebSOP Main Page.*").Page("title:=.*WebSOP Main Page.*").WebElement("innerhtml:=.*View/Update/Complete Orders.*","html tag:=CENTER").Click
	
	'Search Order Number
	Browser("title:=.*WebSOP Main Page.*").Page("title:=.*WebSOP Main Page.*").WebEdit("name:=inqord").Set strOrderNumber 'sOrderNumber
	Browser("title:=.*WebSOP Main Page.*").Page("title:=.*WebSOP Main Page.*").WebList("name:=soptn").Select "TOM"
	Browser("title:=.*WebSOP Main Page.*").Page("title:=.*WebSOP Main Page.*").WebButton("name:=View").Click
	
	If 	Dialog("regexpwndtitle:=Message from webpage").Static("regexpwndtitle:=Network Communication Error.*").Exist(5) Then
		Call cp_AutoClosingMsgBox("WebSOP is down,Please try again Later", "Network", 5) 
		Dialog("regexpwndtitle:=Message from webpage").WinButton("regexpwndtitle:=OK").Click
		Call cp_Excel_Update(strTestData,rowcount,"FAIL")
		ExitTest
	 Else
	
		'Fetch Current Order Status
		arrFetch = Split(Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebTable("outertext:=STATUS.*","index:=2").GetROProperty("outertext"),"APP")
		strStatus = Split(arrFetch(0),"STATUS")
		strOrderStatus = Trim(strStatus(1))
		
		If 	strOrderStatus = "CP" Then
			Call cp_AutoClosingMsgBox("Order is already in Completion Status in WebSop", "Success", 5) 
			Call cp_Excel_Update(strTestData,rowcount,"PASS")
			ExitTest
		End If
		
		'Fetch Due Date
		arrFetch = Split(Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebTable("outertext:=STATUS.*","index:=2").GetROProperty("outertext"),"DD")
		arrFetch1 = Split(arrFetch(1),"APPT")
		strDueDate = Trim(arrFetch1(0))
			
		If 	Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebButton("name:=Unlock").Exist(5) Then
			Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebButton("name:=Unlock").Click
		End  If
		
		'Edit Button
		Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebButton("name:=Edit").Click	
		
		strtext = Browser("name:=Update Order.*").Page("title:=Update Order.*").WebTable("innertext:=1.*").GetROProperty("innertext")
		
		If 	Instr(strtext,"ERR") Then
			Call cp_AutoClosingMsgBox("Order have existing errors kindly resolve before proceeding", "Error", 5)
			Call cp_Excel_Update(strTestData,"FAIL",rowcount)
			ExitTest
		 Else
			
			'Get the Row Property to Insert a Row
			strworkrow = Split(Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebEdit("default value:=RMK","index:=0").GetROProperty("name"),"_")
			strworkrow1 = Split(strworkrow(0),"line")
			strfirstrmkrow =  strworkrow1(1)
			strnextrow = strfirstrmkrow + 1
			
			'Insert Row
			Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebEdit("name:=command"&strfirstrmkrow).Set "X"
			Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebButton("name:=Insert").Click
			Browser("title:=.*Update Order.*").Window("regexpwndtitle:=Insert Multiple.*").Page("title:=Insert Multiple.*").WebButton("name:=submit").Click
			
			'Update Remarks
			Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebEdit("name:=line"&strnextrow&"_2").Set "RMK"
			Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebEdit("name:=line"&strnextrow&"_3").Set "BYPASS DATE EDIT TOM TESTING"
			
			'Click on Issue
			Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebButton("name:=Issue").Click
			
			'Comments
		  	strtextformat = Browser("title:=.*Update Order.*").Window("regexpwndtitle:=Pending Order Remark.*").Page("title:=Pending Order Remark").WebEdit("name:=rmkcontent").GetROProperty("default value") & "Test Regression" 
		  	Browser("title:=.*Update Order.*").Window("regexpwndtitle:=Pending Order Remark.*").Page("title:=Pending Order Remark").WebEdit("name:=rmkcontent").Set strtextformat
			
			Browser("title:=.*Update Order.*").Window("regexpwndtitle:=Pending Order Remark.*").Page("title:=Pending Order Remark").WebButton("name:=Submit").Click
			
			Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebElement("innertext:= Navigation.*").FireEvent "onmouseover"
			Wait(3)
			Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebElement("class:=menuitemlink","innertext:=  Main Menu  Ctrl-M.*","index:=0").Click
			
			Browser("title:=.*WebSOP Main Page.*").Page("title:=.*WebSOP Main Page.*").WebButton("name:=Complete").Click
			
			'Fetch Current Order Status
			arrFetch = Split(Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebTable("outertext:=STATUS.*","index:=2").GetROProperty("outertext"),"APP")
			strStatus = Split(arrFetch(0),"STATUS")
			strOrderStatus = Trim(strStatus(1))
			
			If 	strOrderStatus = "CO" Then
				Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebButton("name:=Unlock").Click
				
'				 Save W/O Routing Code for status apart from RL	
				Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebButton("name:=Edit").Click
				Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebElement("outertext:=File").Click
				Browser("title:=.*Update Order.*").Page("title:=.*Update Order.*").WebElement("outertext:= Save w/o Routing").Click
				Dialog("regexpwndtitle:=Message from webpage").WinButton("text:=OK").Click
				Dialog("regexpwndtitle:=Message from webpage").WinButton("text:=OK").Click
				
				Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebElement("innertext:= Navigation.*").FireEvent "onmouseover"
				Wait(3)
				Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebElement("class:=menuitemlink","innertext:=  Main Menu  Ctrl-M.*","index:=0").Click
			End If
			
			Browser("title:=.*Complete Order.*").Window("regexpwndtitle:=.*Complete Order.*").Page("title:=.*Complete Order.*").WebEdit("name:=compdate").Set strDueDate
		  	Browser("title:=.*Complete Order.*").Window("regexpwndtitle:=.*Complete Order.*").Page("title:=.*Complete Order.*").WebEdit("name:=missapptdate").Set "SA"
		  	Browser("title:=.*Complete Order.*").Window("regexpwndtitle:=.*Complete Order.*").Page("title:=.*Complete Order.*").WebRadioGroup("name:=ocbtype").Select "#1"
		  	Browser("title:=.*Complete Order.*").Window("regexpwndtitle:=.*Complete Order.*").Page("title:=.*Complete Order.*").WebButton("name:=Ok").Click
			  
			Browser("name:=.*Complete Order.*").Page("title:=.*Complete Order.*").WebButton("name:=Complete").Click
		  	Wait(30)
		  	arrFetch = Split(Browser("title:=.*Inquire Order.*").Page("title:=.*Inquire Order.*").WebTable("outertext:=STATUS.*","index:=2").GetROProperty("outertext"),"APP")
			strStatus = Split(arrFetch(0)," ")
			strOrderStatus = strStatus(1)
			If 	strOrderStatus = "CP" Then
				Call cp_Excel_Update(strTestData,rowcount,"PASS")
			 Else
			 	Call cp_Excel_Update(strTestData,rowcount,"FAIL")
			End If
			Browser("title:=.*Complete Order.*").Close
		End  If
	End  If
	 Else
	 	Call cp_AutoClosingMsgBox("Unable to Login to Websop Application", "Login", 5)
	 	ExitTest
End If

Sub TerminateProcess

	Dim Process 
	For Each Process In GetObject("winmgmts:").ExecQuery("Select Name from Win32_Process Where Name = 'EXCEL.EXE'")
	Process.Terminate
	Next

End Sub

Sub cp_Excel_Update(strTestData,rowcount,strExcelstatus)
Call TerminateProcess
    Set objExcel = CreateObject("Excel.Application")
        objExcel.Visible = True
        Set ObjWorkBook = objExcel.Workbooks.open (strTestData,False,False)
           Set ObjWorkSheet = ObjWorkbook.WorkSheets("Sheet1")
           ObjWorkSheet.cells(rowcount,6).Value= strExcelstatus
           strExcelstatus = ObjWorkSheet.Cells(rowcount,6)
           If strExcelstatus = "PASS" Then
              ObjWorkSheet.Cells(rowcount,6).Interior.ColorIndex = 4
              ElseIf strExcelstatus = "FAIL" Then
              ObjWorkSheet.Cells(rowcount,6).Interior.ColorIndex = 3
               End If
               ObjWorkBook.Save
               ObjWorkBook.Close
               Set ObjWorkBook = Nothing
               Set objExcel = Nothing
    Call TerminateProcess

End Sub



