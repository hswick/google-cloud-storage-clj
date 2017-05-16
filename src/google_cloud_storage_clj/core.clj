(ns google-cloud-storage-clj.core
  (:import [com.google.cloud.storage StorageOptions 
            BucketInfo
            BlobInfo
            StorageImpl
            Storage$BucketTargetOption 
            Storage$BucketGetOption
            Storage$BucketSourceOption
            Storage$BucketListOption
            Storage$BlobGetOption
            Storage$BlobListOption
            Storage$BlobTargetOption
            Storage$BlobWriteOption]))
            

(defn storage-client
  "Instantiate storage client using default authorization"
  []
  (.getService (StorageOptions/getDefaultInstance)))

(defn create-bucket
  "Pass in a string for bucket name and returns a bucket object"
  [bucket-name]
  (.create (storage-client)
    (BucketInfo/of bucket-name)
    (make-array Storage$BucketTargetOption 0)))

(defn get-bucket [bucket-name]
  "Returns Bucket object"
  (.get (storage-client)
    bucket-name
    (make-array Storage$BucketGetOption 0)))

(defn delete-bucket
  "Returns boolean success value"
  [bucket-name]
  (.delete (storage-client)
    bucket-name
    (make-array Storage$BucketSourceOption 0)))

(defn list-buckets 
  "Returns a page object"
  []
  (.list (storage-client) (make-array Storage$BucketListOption 0)))

(defn list-blobs
  [bucket-name]
  (.list (storage-client)
    bucket-name
    (make-array Storage$BlobListOption 0)))
    
(defn get-blob
  [bucket-name blob-name]
  (.get (storage-client) 
    bucket-name
    blob-name
    (make-array Storage$BlobGetOption 0)))

(defn get-blob-by-id 
  [blob-id]
  (.get (storage-client)
    (make-array Storage$BlobGetOption 0)))

(defn create-blob-from-bytes [blob-info bytes-content]
  (.create (storage-client)
    blob-info
    bytes-content
    (make-array Storage$BlobTargetOption 0)))

(defn create-blob-from-input-stream [blob-info input-stream]
  (.create (storage-client)
    blob-info
    input-stream
    (make-array Storage$BlobWriteOption)))
    
