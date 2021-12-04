(ns clojure-aoc.dive-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [clojure-aoc.dive :as dive]))

(deftest parse-line-test
  (testing "line in correct format"
    (is (= `(:forward 5) (dive/parse-line "forward 5")))))

(deftest parse-input-test
  (is (= `((:forward 5) (:down 3)) (dive/parse-input "forward 5" "down 3"))))
