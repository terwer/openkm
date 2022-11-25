# openkm

an opensource light-weight , pluggable knowledge management platform

## Structure

- openkm-common

  common libraries for openkm

- openkm-core 

  core module, the smallest runnable unit     

- openkm-apps
  
  plugins directory, every function act as a plugin , `openkm-dev-plugins` is for development , and `openkm-prod-plugins` is for production. 
  
  - appstore-plugin

    appstore plugin for openkm

- openkm-plugin-tools
 
  plugin template and other helpful tools