package mx.com.proyectohu.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.proyectohu.dto.CuentaDTO;
import mx.com.proyectohu.entity.CuentaEntity;
import mx.com.proyectohu.repository.CuentaRepository;
import mx.com.proyectohu.repository.TareaCronRepository;



@Service
public class ArchivoCuentaCronService {
	
	@Autowired
	public CuentaRepository cuentaRepository;
	
	@Scheduled(fixedDelay = 100000)
	public void verificarFolder() {
		
		File folder = new File("C:\\Temp");
		
		 File[] files = folder.listFiles();

	        if (files == null || files.length == 0) {
	            return;
	        }

	        for (File file : files) {
	        	 if (file.isFile() && file.getName().toLowerCase().endsWith(".xlsx")) {
	        		 readExcel(file);
	        	    }
	        }
		
		
			
		
	}
	
	private void readExcel(File file) {

	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	    	CuentaDTO  cuentaDTO =null;
	    	CuentaEntity cuentaEntity = null;
	        Sheet sheet = workbook.getSheetAt(0);
	        boolean firstRow = true;

	        for (Row row : sheet) {
	        	
	        	if (firstRow) {
	                firstRow = false;
	                continue;
	            }
	        	cuentaDTO = new CuentaDTO();
	        	cuentaEntity = new CuentaEntity();
	        	
	        	cuentaDTO.setAccountId(row.getCell(0).getStringCellValue());
	        	cuentaDTO.setAggregatorId(row.getCell(1).getStringCellValue());
	        	
	        	cuentaEntity.setAccountId(cuentaDTO.getAccountId());
	        	cuentaEntity.setAggregatorId(cuentaDTO.getAggregatorId());
	        	cuentaRepository.save(cuentaEntity);

	           
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
