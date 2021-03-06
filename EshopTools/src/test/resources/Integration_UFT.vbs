Dim qtApp
Dim qtTest

'Create the QTP Application object
Set qtApp = CreateObject("QuickTest.Application")

'If QTP is notopen then open it
If qtApp.launched <> True then

qtApp.Launch

End If

'Make the QuickTest application visible
qtApp.Visible = True

'Set QuickTest run options
'Instruct QuickTest to perform next step when error occurs

qtApp.Options.Run.ImageCaptureForTestResults = "OnError"
qtApp.Options.Run.RunMode = "Fast"
qtApp.Options.Run.ViewResults = False

'Open the test in read-only mode
qtApp.Open "C:\Users\ab72075\Downloads\jsl-eshop-test-sample-Eshop_Code_Merge_ALL (1)\jsl-eshop-test-sample-Eshop_Code_Merge_ALL\EshopTools\src\test\resources\WebSop_UFT\Test_Scripts\WebSop Script", True

'qtApp.Open "C:\Users\ab72075\Downloads\WebSop_UFT\WebSop_UFT\Test_Scripts\WebSop Script", True

'set run settings for the test
Set qtTest = qtApp.Test

'Instruct QuickTest to perform next step when error occurs
qtApp.Test.Settings.Run.OnError = "NextStep"

'Run the test
qtApp.Test.Run

'Check the results of the test run
MsgBox qtApp.Test.LastRunResults.Status

' Close the test
qtApp.Test.Close

'Close QTP
qtApp.quit

'Release Object
Set qtTest = Nothing
Set qtApp = Nothing

'End of the script