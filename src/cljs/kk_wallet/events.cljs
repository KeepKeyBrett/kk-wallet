(ns kk-wallet.events
  (:require
   [re-frame.core :as re-frame]
   [kk-wallet.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
  :add-account
  (fn [db [_ new-value]]
    (assoc db :accounts (conj (:accounts db) {:name "Shitcoin"}))))
