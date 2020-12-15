/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import java.io.File;
import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ateubohk
 */
public interface CoudServiceInterface {
    public String uploadfile(MultipartFile file) ;

	public File convertMultiPartToFile(MultipartFile file) throws IOException;
    
}
