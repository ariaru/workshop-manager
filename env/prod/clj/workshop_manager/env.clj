(ns workshop-manager.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[workshop-manager started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[workshop-manager has shut down successfully]=-"))
   :middleware identity})
