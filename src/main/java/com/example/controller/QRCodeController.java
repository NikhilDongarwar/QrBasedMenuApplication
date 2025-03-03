package com.example.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.QRCodeService;
import com.google.zxing.WriterException;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String roomId) {
        try {
            BufferedImage qrImage = qrCodeService.generateQRCode(roomId);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "PNG", baos);
            byte[] imageBytes = baos.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
           //", roomId + ".png");"
            headers.setContentDispositionFormData("attachment", "qr_" + roomId + ".png");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(imageBytes);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}