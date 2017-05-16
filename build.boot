(set-env!
  :resource-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.9.0-alpha15"]
                  [nightlight "1.6.4" :scope "test"]
                  [com.google.cloud/google-cloud-storage "1.0.1"]])

(require
  '[nightlight.boot :refer [nightlight]]
  'google-cloud-storage-clj.core)

(deftask night []
  (comp
    (wait)
    (nightlight :port 4000)))
