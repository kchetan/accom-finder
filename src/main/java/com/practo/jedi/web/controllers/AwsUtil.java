//package com.practo.jedi.web.controllers;
//
//import com.amazonaws.auth.PropertiesCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.services.s3.model.PutObjectResult;
//import com.amazonaws.services.s3.transfer.Upload;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//
//
//public class AwsUtil {
//
//  public void imageUpload() {
//    String existingBucketName = "<your Bucket Name>";
//    String keyName = "mypic.JPG";
//
//    String filePath = "E://Pics//mypic.JPG";
//    String amazonFileUploadLocationOriginal = existingBucketName + "/";
//
//
//    AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(
//        Upload.class.getResourceAsStream("AwsCredentials.properties")));
//
//    FileInputStream stream = new FileInputStream(filePath);
//    ObjectMetadata objectMetadata = new ObjectMetadata();
//    PutObjectRequest putObjectRequest =
//        new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, stream, objectMetadata);
//    PutObjectResult result = s3Client.putObject(putObjectRequest);
//    System.out.println("Etag:" + result.getETag() + "-->" + result);
//
//  }
//
//}
