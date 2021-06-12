package practice.tower_backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TowerController {
    @Autowired
    private TowerJPARepository towerRepository;
    @PostMapping(path = "/thePostEndpoint", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public TowerDto thePostMapping(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute TowerDto theBody) throws IOException {
        String newName = UUID.randomUUID()+ multipartFile
        .getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String fileLocation = new File("tower_backend/src/main/resources/uploads").getAbsolutePath() + "\\" + newName; 
        System.out.println(fileLocation);
        System.out.println(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(fileLocation);
        fos.write(multipartFile.getBytes());
        fos.close();
        theBody.setFileAddress(newName);
        
        TowerDto dt = towerRepository.save(theBody);
        System.out.println(dt.toString());
        
        return dt;

    }

   
}
