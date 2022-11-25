# openkm-plugin-archetype

Openkm plugin template

## Install

### Bash

```bash
./build.sh
```

### PowerShell

```bash
pwsh ./build.ps1
```

## Usage

1.  Open `IntelliJ IDEA`
    Select menu `File` -> `New` -> `Project` -> `Maven`             
    Check `Create from Darchetype``             
    Click `Add Darchetype` , input text as below               

    ```
    GroupId:space.terwer         
    ArtifactId:openkm-plugin-archetype                   
    Version:1.1.0             
    ```

2.  Select the added archetype, click `next` , input info for the new project:
    
    ```
    GroupId:space.terwer                      
    ArtifactId:demo-plugin                                 
    Version:1.0.0           
    ```
    
    Click `Next` , add other parameter            

    ```
    package=space.terwer.plugins.demo
    pluginName=Demo
    pluginShortName=demo
    ```

3.  Click `Next` , input project name and path            
    
    ```
    demo-plugin      
    C:\Users\Terwer\IdeaProjects\openkm-plugins\demo-plugin
    ```

4.  Click `Finish` , that's all.

    Wait about 2 minutes，a plugin demo project is done.                 

## Contact

[https://terwer.space](https://blog.terwergreen.com/guestbook.html)