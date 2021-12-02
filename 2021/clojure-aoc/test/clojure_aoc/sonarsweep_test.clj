(ns clojure-aoc.sonarsweep-test
  (:require [clojure.test :refer :all]
            [clojure-aoc.sonarsweep :refer :all]
            [clojure.java.io :as io]))

(deftest calc-increment-test
  (testing "with sample input"
    (is (= 2 (calc-increment "1" "2" "3")))
    (is (= 7 (calc-increment "199" "200" "208" "210" "200" "207" "240" "269" "260" "263"))))
  (testing "with empty input"
    (is (= 0 (calc-increment))))
  (testing "with strictly decreasing"
    (is (= 0 (calc-increment "3" "2" "1"))))
  (testing "with monotonically increase"
    (is (= 2 (calc-increment "3" "4" "4" "2" "2" "5"))))
  (testing "with all the values same"
    (is (= 0 (calc-increment "2" "2" "2" "2")))))

(deftest calc-increment-my-input
  (testing "read from testdata file and assert"
    (with-open [rdr (io/reader "test/clojure_aoc/sonarsweep-testdata.txt")]
      (is (= 1462 (calc-increment (line-seq rdr)))))))


