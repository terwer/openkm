$os = [environment]::OSVersion.Platform
Write-Output "You are running scripts in $os ..."
if ( "Unix" -eq $os)
{
    ./build.sh
}
else
{
    cmd.exe /c "mvnw.cmd -v"
    & 'C:/Program Files/Git/bin/bash.exe' --login -i -c "./build.sh"
}
Write-Output "finished."