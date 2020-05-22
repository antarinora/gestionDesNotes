package com.examplegestionDesNotes.ws;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.util.ImportUtil;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/etudiant")
public class EtudiantRest {
@Autowired
public EtudiantService etudiantService;
@PostMapping("/")
public int save(@RequestBody Etudiant etudiant) {
	return etudiantService.save(etudiant);
	}


@GetMapping("/")
public List<Etudiant> findAll() {
	return etudiantService.findAll();
}

@GetMapping("/cne/{cne}")
public Etudiant findByCne(@PathVariable String cne) {
	return etudiantService.findByCne(cne);
}

@GetMapping("/cne/{cne}/codeApogee/{codeApogee}/dateNaissance/{dateNaissance}")
public int findByCneAndCodeApogeeAndDateNaissance(@PathVariable String cne, @PathVariable Long codeApogee,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateNaissance) {
	return etudiantService.findByCneAndCodeApogeeAndDateNaissance(cne, codeApogee, dateNaissance);
}
@PostMapping("/import/")
public ResponseEntity<List<Etudiant>> importExcelFile( @RequestParam(value = "file") MultipartFile file) throws IOException{
	return  etudiantService.importExcelFile(file);
}



@PostMapping("/upload")
public ResponseEntity<com.examplegestionDesNotes.util.ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
  String message = "";

  if (ImportUtil.hasExcelFormat(file)) {
    try {
    	etudiantService.save(file);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new com.examplegestionDesNotes.util.ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new com.examplegestionDesNotes.util.ResponseMessage(message));
    }
  }

  message = "Please upload an excel file!";
  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.examplegestionDesNotes.util.ResponseMessage(message));
}

@GetMapping("/tutorials")
public ResponseEntity<List<Etudiant>> getAllTutorials() {
  try {
    List<Etudiant> tutorials = etudiantService.getAllTutorials();

    if (tutorials.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(tutorials, HttpStatus.OK);
  } catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

@GetMapping("/download")
public ResponseEntity<Resource> getFile() {
  String filename = "tutorials.xlsx";
  InputStreamResource file = new InputStreamResource(etudiantService.load());

  return ResponseEntity.ok()
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
      .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
      .body(file);
}

}
