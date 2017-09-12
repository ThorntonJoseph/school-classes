#include <GuiConstants.au3>
#NoTrayIcon
Opt("GUIOnEventMode", 1)  ; Change to OnEvent mode 
#include <Process.au3>


$MainTitleName=IniRead("Clip.ini","main","MainTitleName","NotFound")
$MainTitleStatus=IniRead("Clip.ini","main","MainTitleStatus","NotFound")
$AppName="dosbox.exe" 
$CfgFile="CBdosbox.conf"
$ClipboardFile="clip.txt"

if not FileExists("..\" & $AppName) then
	MsgBox(4096, "Error", "Unable to open program:" & $AppName)
	exit
EndIf

if not FileExists($CfgFile) then
	MsgBox(4096, "Error", "Unable to open config file:" & $CfgFile)
	exit
EndIf


$DirResult = ".\" & StringTrimLeft ( @ScriptDir, StringInStr(@ScriptDir, "\",0,-1)) & "\"
	$prc=run("..\" & $AppName & " -conf " & $DirResult & $CfgFile ,"..\")
	WinWait($MainTitleName,"",3)
	
	if not WinExists($MainTitleName) then
		MsgBox(4096, "Error", "Unable to find DoxBox Window")
		exit
	EndIf


$MainWindowHandle=WinGetHandle($MainTitleName)
$StatusWindowHandle=WinGetHandle($MainTitleStatus)


;Hide the Status window
StatusWindowRefresh()
;Create Icons on Title bar
$sGUI = GuiCreate("WinBar App", 72, 23, -1, -1, BitOR($WS_POPUP, $WS_EX_TOPMOST),$WS_EX_TOOLWINDOW)
IconBarRefresh()
WinActivate($MainWindowHandle)
$btnConsole = GUICtrlCreateButton("(Not allowed)",-1, -1, 25, 25, BitOR($BS_ICON,$BS_FLAT ) )
GUICtrlSetImage($btnConsole, "Console.ico",-1,0)
GUICtrlSetOnEvent($btnConsole, "StatusWindowRefresh")

$btnCopy = GUICtrlCreateButton("(Not allowed)",23, -1, 25, 25, BitOR($BS_ICON,$BS_FLAT ) )
GUICtrlSetImage($btnCopy, "copy.ico",-1,0)
GUICtrlSetOnEvent($btnCopy, "CopyDosBox")

$btnPaste = GUICtrlCreateButton("(Not allowed)",47, -1, 25, 25, BitOR($BS_ICON,$BS_FLAT ) )
GUICtrlSetImage($btnPaste, "clipboard.ico",-1,0)
GUICtrlSetOnEvent($btnPaste, "PasteDosBox")

GuiSetState()
WinSetOnTop($sGUI, "", 1)
WinActivate($MainWindowHandle)

;Main Loop of program
While 1
	IconBarRefresh()
    sleep(1)
Wend


Func PasteDosBox()
	WinActivate($MainWindowHandle)
	Send(ClipGet())
EndFunc

Func CopyDosBox()
	BlockInput(1)    
    sleep(50)
	WinActivate($MainWindowHandle)


	$ClienSize=WinGetClientSize($MainWindowHandle)
	$WinPos= WinGetPos($MainWindowHandle)
	$MousePos=MouseGetPos()
	;Check if in fullscreen or cursor is over the client window
	if $MousePos[0]>=$WinPos[0] And $MousePos[0]<=$WinPos[0]+$WinPos[2] And _
		$MousePos[1]>=$WinPos[1]+30 And $MousePos[1]<=$WinPos[1]+$WinPos[3] or _ 
		($WinPos[2]==$ClienSize[0] AND $WinPos[3]==$ClienSize[1]) Then
			send("{SHIFTDOWN}{CTRLDOWN}")
			MouseClick("right")
			send("{SHIFTUP}{CTRLUP}")
		else
			_CurVisInv(0)
			send("{SHIFTDOWN}{CTRLDOWN}")
			MouseClick("right",$MousePos[0],$MousePos[1]+$WinPos[3]-$ClienSize[1]+5)
			send("{SHIFTUP}{CTRLUP}")
			MouseMove($MousePos[0],$MousePos[1])
			sleep(50)
			_CurVisInv(1)
	EndIf
	BlockInput(0)
	sleep(50)
	
	
	$file = FileOpen($ClipboardFile,0)
	; Check if file opened for reading OK
	If $file = -1 Then
		MsgBox(4096, "Error", "Unable to open " & $ClipboardFile)
		Exit
	EndIf
	; Read in lines of text until the EOF is reached
	While 1
		$temp = FileReadLine($file)
		If @error = -1 Then ExitLoop
		$line=$temp
	Wend
	;Last Line Read is what was copied
	ClipPut($line)
	FileClose($file)
	;Delete File so the file will not get huge
	FileDelete ($ClipboardFile)
EndFunc

Func StatusWindowRefresh()
	$state =WinGetState($StatusWindowHandle)
	if BitAnd($state, 2) then
		WinSetState($StatusWindowHandle,"",@SW_HIDE)
		WinActivate($MainWindowHandle)
	Else
		WinSetState($StatusWindowHandle,"",@SW_SHOW)
		WinActivate($StatusWindowHandle)
	endif
endfunc


Func IconBarRefresh()
	if WinExists($MainWindowHandle)	then
		$ClienSize=WinGetClientSize($MainWindowHandle)
		$WindowPos= WinGetPos($MainWindowHandle)
		if WinActive($MainWindowHandle)OR WinActive($sGUI) AND $WindowPos[2]<>$ClienSize[0] AND $WindowPos[3]<>$ClienSize[1] Then
			GuiSetState(@SW_SHOW,$sGUI)
			$x = $WindowPos[0] + $WindowPos[2] - 170
			$y = $WindowPos[1] +5
			WinMove($sGUI, "", $x, $y)
			WinSetOnTop($sGUI, "", 1)
			HotKeySet ( "^v", "PasteDosBox")
			HotKeySet ( "^c", "CopyDosBox")
		Else
			GuiSetState(@SW_HIDE,$sGUI)
			if WinActive($MainWindowHandle)OR WinActive($sGUI) Then
				HotKeySet ( "^v", "PasteDosBox")
				HotKeySet ( "^c", "CopyDosBox")
			Else
				HotKeySet ("^v")
				HotKeySet ("^c")
			endif
		endif
	Else
		exit
	EndIf
EndFunc

 
Func _CurVisInv($bV)
  Local $cursorinternalc
 
  Select
     Case $bV = 1
        Do
           $cursorinternalc = DllCall("User32.dll", "long", "ShowCursor", "long", $bV)
           Sleep(1)
        Until $cursorinternalc[0] > 0
     Case $bV = 0
        Do
           $cursorinternalc = DllCall("User32.dll", "long", "ShowCursor", "long", $bV)
           Sleep(1)
        Until $cursorinternalc[0] < 0
     Case Else
        Return 0
  EndSelect
  Return 1
EndFunc  ;==>_CurVisInv



;
; Function Name:    _ProcessGetHWnd
; Description:      Returns the HWND(s) owned by the specified process (PID only !).
;
; Parameter(s):     $iPid		- the owner-PID.
;					$iOption	- Optional : return/search methods :
;						0 - returns the HWND for the first non-titleless window.
;						1 - returns the HWND for the first found window (default).
;						2 - returns all HWNDs for all matches.
;
;                   $sTitle		- Optional : the title to match (see notes).
;					$iTimeout	- Optional : timeout in msec (see notes)
;
; Return Value(s):  On Success - returns the HWND (see below for method 2).
;						$array[0][0] - number of HWNDs
;						$array[x][0] - title
;						$array[x][1] - HWND
;
;                   On Failure	- returns 0 and sets @error to 1.
;
; Note(s):			When a title is specified it will then only return the HWND to the titles
;					matching that specific string. If no title is specified it will return as
;					described by the option used.
;
;					When using a timeout it's possible to use WinWaitDelay (Opt) to specify how
;					often it should wait before attempting another time to get the HWND.
;
;
; Author(s):        Helge
;
;===============================================================================
Func _ProcessGetHWnd($iPid, $iOption = 1, $sTitle = "", $iTimeout = 2000)
	Local $aReturn[1][1] = [[0]], $aWin, $hTimer = TimerInit()
	
	While 1
		
		; Get list of windows
		$aWin = WinList($sTitle)
		
		; Searches thru all windows
		For $i = 1 To $aWin[0][0]
			
			; Found a window owned by the given PID
			If $iPid = WinGetProcess($aWin[$i][1]) Then
				
				; Option 0 or 1 used
				If $iOption = 1 OR ($iOption = 0 And $aWin[$i][0] <> "") Then
					Return $aWin[$i][1]
				
				; Option 2 is used
				ElseIf $iOption = 2 Then
					ReDim $aReturn[UBound($aReturn) + 1][2]
					$aReturn[0][0] += 1
					$aReturn[$aReturn[0][0]][0] = $aWin[$i][0]
					$aReturn[$aReturn[0][0]][1] = $aWin[$i][1]
				EndIf
			EndIf
		Next
		
		; If option 2 is used and there was matches then the list is returned
		If $iOption = 2 And $aReturn[0][0] > 0 Then Return $aReturn
		
		; If timed out then give up
		If TimerDiff($hTimer) > $iTimeout Then ExitLoop
		
		; Waits before new attempt
		Sleep(Opt("WinWaitDelay"))
	WEnd
	
	
	; No matches
	SetError(1)
	Return 0
EndFunc   ;==>_ProcessGetHWnd