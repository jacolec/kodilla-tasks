#!/usr/bin/env bash

export CATALINA_HOME=/home/jacolec/apache-tomcat-9.0.68

stop_tomcat()
{
   $CATALINA_HOME/bin/catalina.sh stop
}

start_tomcat()
{
   $CATALINA_HOME/bin/catalina.sh start
   end
}

run_browser()
 {
  if sh runcrud.sh; then
    xdg-open http://localhost:8080/crud/v1/tasks;
  else
    fail
    end
    fi
  }


fail() {
   echo "ERROR!"
}

end() {
   echo "END"
}

run_browser;
