package mx.com.proyectohu.component;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.CLResponseDTO;
import mx.com.proyectohu.dto.PETRequestDTO;
import mx.com.proyectohu.dto.ReporteGeneralLCResponseDTO;
import mx.com.proyectohu.dto.ReporteGeneralPETResponseDTO;

@Component
public class ReporteGeneralPETDAO {

	@Autowired
	private DataSource dataSource;

	public List<ReporteGeneralPETResponseDTO> consultarCLRegistroGeneralCarga(Long idLineaNegocio, PETRequestDTO petRequestDTO) {
		List<ReporteGeneralPETResponseDTO> reporteGeneralpetResponseDTOlist = new ArrayList<ReporteGeneralPETResponseDTO>();
		ReporteGeneralPETResponseDTO  petResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEGENERAL(?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				if (idLineaNegocio != null) {
				    cs.setLong(2, idLineaNegocio);
				} else {
				    cs.setNull(2, java.sql.Types.NUMERIC);
				}
				cs.setDate(3, java.sql.Date.valueOf(petRequestDTO.getFechaInicio()));
				cs.setDate(4, java.sql.Date.valueOf(petRequestDTO.getFechaFin()));
				cs.setString(5, petRequestDTO.getTipoConsulta());
				cs.setString(6, petRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					petResponseDTO= new ReporteGeneralPETResponseDTO();
				
					petResponseDTO.setNombreLineaNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					petResponseDTO.setNombreCampana(resultado.getString("FCNOMBRE_CAMPANA"));
					petResponseDTO.setFdFechaFin(resultado.getTimestamp("FDFECHAFIN"));
					petResponseDTO.setTotalRegistros(resultado.getInt("FINOREGISTROS"));
										
					reporteGeneralpetResponseDTOlist.add(petResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reporteGeneralpetResponseDTOlist;
	}

	
	public List<ReporteGeneralPETResponseDTO> consultarPETRegistroGeneralValidacion(Long idLineaNegocio, PETRequestDTO petRequestDTO) {
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOlist = new ArrayList<ReporteGeneralPETResponseDTO>();
		ReporteGeneralPETResponseDTO  petResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEGENERAL(?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				if (idLineaNegocio != null) {
				    cs.setLong(2, idLineaNegocio);
				} else {
				    cs.setNull(2, java.sql.Types.NUMERIC);
				}
				cs.setDate(3, java.sql.Date.valueOf(petRequestDTO.getFechaInicio()));
				cs.setDate(4, java.sql.Date.valueOf(petRequestDTO.getFechaFin()));
				cs.setString(5, petRequestDTO.getTipoConsulta());
				cs.setString(6, petRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					petResponseDTO= new ReporteGeneralPETResponseDTO();
					petResponseDTO.setNombreLineaNegocio(resultado.getString("NOMBRE_LINEA_NEGOCIO"));
					petResponseDTO.setNombreCampana(resultado.getString("NOMBRE_CAMPANA"));
					petResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					petResponseDTO.setFdFechaFin(resultado.getTimestamp("FDFECHAFIN"));
					petResponseDTO.setTotalRegistros(resultado.getInt("FINOREGISTROS"));
					petResponseDTO.setTotalRegistrosAprobados(resultado.getInt("FINOAPROBADOS"));	
					petResponseDTO.setTotalRegistrosRechazados(resultado.getInt("FINORECHAZADOS"));
					petResponseDTO.setPendientes(resultado.getInt("FINOPENDIENTES"));
					reporteGeneralPETResponseDTOlist.add(petResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reporteGeneralPETResponseDTOlist;
	}
	
	
	public List<ReporteGeneralPETResponseDTO> consultarPETRegistroGeneralEnvio(Long idLineaNegocio, PETRequestDTO petRequestDTO) {
		List<ReporteGeneralPETResponseDTO> reporteGeneralPETResponseDTOlist = new ArrayList<ReporteGeneralPETResponseDTO>();
		ReporteGeneralPETResponseDTO  petResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEGENERAL(?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				if (idLineaNegocio != null) {
				    cs.setLong(2, idLineaNegocio);
				} else {
				    cs.setNull(2, java.sql.Types.NUMERIC);
				}
				cs.setDate(3, java.sql.Date.valueOf(petRequestDTO.getFechaInicio()));
				cs.setDate(4, java.sql.Date.valueOf(petRequestDTO.getFechaFin()));
				cs.setString(5, petRequestDTO.getTipoConsulta());
				cs.setString(6, petRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					petResponseDTO= new ReporteGeneralPETResponseDTO();
					petResponseDTO.setNombreLineaNegocio(resultado.getString("NOMBRE_LINEA_NEGOCIO"));
					petResponseDTO.setNombreCampana(resultado.getString("NOMBRE_CAMPANA"));
					petResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					petResponseDTO.setFdFechaFin(resultado.getTimestamp("FDFECHAFIN"));
					petResponseDTO.setTotalRegistros(resultado.getInt("FINOREGISTROS"));
					petResponseDTO.setTotalRegistrosAprobados(0);	
					petResponseDTO.setTotalRegistrosRechazados(0);
					
					
					
					
					reporteGeneralPETResponseDTOlist.add(petResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reporteGeneralPETResponseDTOlist;
	}
	
	
	

}



