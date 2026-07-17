(ns amime.methods.test-social
  (:require [amime.cells.social-post.state-machine :as state-machine]
            [amime.methods.social :as social]
            [clojure.test :refer [deftest is]]))

(deftest shared-publication-adapter
  (let [post (social/draft-observation-post "mesh" "observed" ["flow" "ledger"])
        state (state-machine/transition-to-drafted
               {"subject" "mesh" "sources" ["flow" "ledger"]})]
    (is (= ":dry-run" (get post ":post/status")))
    (is (false? (get post ":post/server-held-key")))
    (is (= state-machine/phase-drafted (get-in state ["cell_state" "phase"])))))
