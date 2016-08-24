(ns workshop-manager.views.attendees.sign-up)

(defn sign-up-html []
  (list ; other option: wrap h1 + div in top-level div with a class:
        ; [:div.sign-up-html] --> easy to inspect!
    [:h1 "Sign up for the next ClojureBridge workshop"]
    [:div [:p "This is a boring placeholder"]]))