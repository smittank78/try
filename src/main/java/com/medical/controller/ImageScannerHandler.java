package com.medical.controller;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@RestController
public class ImageScannerHandler {

	String dataPath = "/home/qtech/tessdata";

	public ImageScannerHandler() {
		super();
		System.out.println("handler cnstr called!!!");
	}

	@GetMapping("/read")
	String readImage() {
		String rs = "fail";
    	File imageFile = new File("read-image.png");
		ITesseract tesseract = new Tesseract();
		try {
			tesseract.setDatapath(dataPath);
			rs = tesseract.doOCR(imageFile);
			System.out.println(rs);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	/*
	 * 
	 *  Metacine (10)
	 *  Paracitamol (10)
	 *  Combiflam (10)]
	 *  
	 */
	 @PostMapping("/ocr")
	    public String performOCR(@RequestParam("image") int id) {
	       try {
	        	File image = new File(id+".png");
	            // Create an instance of Tesseract OCR engine
	            ITesseract tesseract = new Tesseract();

	            // Set the path to Tesseract installation directory (adjust accordingly)
	            tesseract.setDatapath(dataPath);

	            // Perform OCR on the image file
	            String result = tesseract.doOCR(image);
	            System.out.println("Extracted Text : " + result);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error performing OCR on the image.";
	        }
	    }
	    
}