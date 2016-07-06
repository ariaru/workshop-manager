(ns user
  (:require [mount.core :as mount]
            workshop-manager.core))

(defn start []
  (mount/start-without #'workshop-manager.core/repl-server))

(defn stop []
  (mount/stop-except #'workshop-manager.core/repl-server))

(defn restart []
  (stop)
  (start))


