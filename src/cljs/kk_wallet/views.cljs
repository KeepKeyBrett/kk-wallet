(ns kk-wallet.views
  (:require
   [re-frame.core :as re-frame]
   [kk-wallet.subs :as subs]
   [kk-wallet.events :as events]
   ))

(defn nav-account [{:keys [name]} account]
  [:div
   [:h5 name]])

(defn side-nav []
  (let [accounts (re-frame/subscribe [::subs/accounts])]
    [:div {:style {:padding "10px"
                   :height "100vh"
                   :flex "1"
                   :borderRight "1px solid black"}}
     [:h3 {:on-click #(re-frame/dispatch [:add-account])} "Sidebar"]
     (for [acct @accounts]
       [nav-account acct])]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div {:style {:width "100%" :height "100vh" :display "flex"}}
     [side-nav]
     [:div.content {:style {:padding "20px" :flex 5}}
      [:h1 @name]]]))

