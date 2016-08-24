(ns workshop-manager.routes.home
  (:require [workshop-manager.layout :as layout]
            [workshop-manager.views.attendees.sign-up :refer :all]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [workshop-manager.db.core :as db]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [ring.util.response :refer [redirect]]
            [hiccup.core :refer [html]]))

(defn validate-attendee [params]
	(first
		(b/validate
			params
			:email v/required)))

(defn save-attendee! [{:keys [params]}]
  (if-let [errors (validate-attendee params)]
    (-> (response/found "/")
        (assoc :flash (assoc params :errors errors)))
    (do
      (db/save-attendee!
      ;; This ^ method has to be added to src/clj/workshop_manager/db/core.clj
       (assoc params :timestamp (java.util.Date.)))
      (response/found "/"))))

(defn home-page [{:keys [flash]}]
  (layout/render-hiccup (sign-up-html)
    (merge {:attendees (db/get-attendees)}
    				(select-keys flash [:email :errors]))))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" request (home-page request))
  (POST "/" request (save-attendee! request))
  (GET "/about" [] (about-page)))

