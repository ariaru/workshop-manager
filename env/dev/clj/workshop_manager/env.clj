(ns workshop-manager.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [workshop-manager.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[workshop-manager started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[workshop-manager has shut down successfully]=-"))
   :middleware wrap-dev})
