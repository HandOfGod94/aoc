(ns clojure-aoc.dive-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [clojure-aoc.dive :as dive]
   [clojure.java.io :as io]))

(deftest parse-line-test
  (testing "line in correct format"
    (is (= [:forward 5] (dive/parse-line "forward 5")))))

(deftest parse-input-test
  (is (= [[:forward 5] [:down 3]] (dive/parse-input "forward 5" "down 3"))))


(deftest dive-test
  (testing "with sample input"
    (is (= 150 (dive/final-coord [[:forward 5]
                                  [:down 5]
                                  [:forward 8]
                                  [:up 3]
                                  [:down 8]
                                  [:forward 2]]))))
  (testing "with my input"
    (with-open [rdr (io/reader "test/clojure_aoc/dive-testdata.txt")]
      (is (= 1746616 (dive/final-coord (dive/parse-input (line-seq rdr))))))))
