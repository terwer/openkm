$os = [environment]::OSVersion.Platform
Write-Output "You are running scripts in $os ..."
if ( "Unix" -eq $os)
{
    ./build.sh
}
else
{
    cmd.exe /c "mvnw.cmd -v"
    cmd.exe /c "echo 'not implemented.'"
}
Write-Output "finished."