(ns db-examples.yesql
  (:require [db-examples.core :refer [db]]
            [clojure.java.jdbc :as sql]
            [yesql.core :refer [defquery defqueries]]))

(defqueries "queries.sql" {:connection db})

(defn find-users-transaction []
  (sql/with-db-transaction [t-conn db]
    {:limeys (find-user {:id "foo"} {:connection t-conn})
     :yanks  (find-user {:id "bar"} {:connection t-conn})}))

; (find-users-transaction)

; (select-date
;  {}
;  {:result-set-fn first
;   :row-fn :now
;   :identifiers identity})

; (macroexpand '(defquery find-user "find_user.sql"))

; (find-user {:id "foo"} {:connection db})
