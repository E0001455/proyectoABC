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
import mx.com.proyectohu.dto.ReporteGeneralLCResponseDTO;

@Component
public class ReporteGeneralCLDAO {

	@Autowired
	private DataSource dataSource;

	public List<ReporteGeneralLCResponseDTO> consultarCLRegistroGeneralCarga(Long idLineaNegocio, CLRequestDTO clRequestDTO) {
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		ReporteGeneralLCResponseDTO  clResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEGENERAL(?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				if (idLineaNegocio != null) {
				    cs.setLong(2, idLineaNegocio);
				} else {
				    cs.setNull(2, java.sql.Types.NUMERIC);
				}
				cs.setDate(3, java.sql.Date.valueOf(clRequestDTO.getFechaInicio()));
				cs.setDate(4, java.sql.Date.valueOf(clRequestDTO.getFechaFin()));
				cs.setString(5, clRequestDTO.getTipoConsulta());
				cs.setString(6, clRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					 clResponseDTO= new ReporteGeneralLCResponseDTO();
					clResponseDTO.setIdTarea(resultado.getLong("ID_TAREA_LINEA"));
					clResponseDTO.setNombreLineaNegocio(resultado.getString("NOMBRE_LINEA_NEGOCIO"));
					clResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					clResponseDTO.setFdFechaFin(resultado.getTimestamp("FDFECHAFIN"));
					clResponseDTO.setTotalRegistros(resultado.getInt("FINOREGISTROS"));
										
					reporteGeneralLCResponseDTOlist.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reporteGeneralLCResponseDTOlist;
	}

	
	public List<ReporteGeneralLCResponseDTO> consultarCLRegistroGeneralValidacion(Long idLineaNegocio, CLRequestDTO clRequestDTO) {
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		ReporteGeneralLCResponseDTO  clResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEGENERAL(?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				if (idLineaNegocio != null) {
				    cs.setLong(2, idLineaNegocio);
				} else {
				    cs.setNull(2, java.sql.Types.NUMERIC);
				}
				cs.setDate(3, java.sql.Date.valueOf(clRequestDTO.getFechaInicio()));
				cs.setDate(4, java.sql.Date.valueOf(clRequestDTO.getFechaFin()));
				cs.setString(5, clRequestDTO.getTipoConsulta());
				cs.setString(6, clRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					 clResponseDTO= new ReporteGeneralLCResponseDTO();
					 clResponseDTO.setIdTarea(resultado.getLong("ID_TAREA_LINEA"));
					clResponseDTO.setNombreLineaNegocio(resultado.getString("NOMBRE_LINEA_NEGOCIO"));
					clResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					clResponseDTO.setFdFechaFin(resultado.getTimestamp("FDFECHAFIN"));
					clResponseDTO.setTotalRegistros(resultado.getInt("FINOREGISTROS"));
					clResponseDTO.setTotalRegistrosAprobados(resultado.getInt("FINOAPROBADOS"));	
					clResponseDTO.setTotalRegistrosRechazados(resultado.getInt("FINORECHAZADOS"));
					
					
					
					reporteGeneralLCResponseDTOlist.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reporteGeneralLCResponseDTOlist;
	}
	
	
	public List<ReporteGeneralLCResponseDTO> consultarCLRegistroGeneralEnvio(Long idLineaNegocio, CLRequestDTO clRequestDTO) {
		List<ReporteGeneralLCResponseDTO> reporteGeneralLCResponseDTOlist = new ArrayList<ReporteGeneralLCResponseDTO>();
		ReporteGeneralLCResponseDTO  clResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEGENERAL(?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				if (idLineaNegocio != null) {
				    cs.setLong(2, idLineaNegocio);
				} else {
				    cs.setNull(2, java.sql.Types.NUMERIC);
				}
				cs.setDate(3, java.sql.Date.valueOf(clRequestDTO.getFechaInicio()));
				cs.setDate(4, java.sql.Date.valueOf(clRequestDTO.getFechaFin()));
				cs.setString(5, clRequestDTO.getTipoConsulta());
				cs.setString(6, clRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					 clResponseDTO= new ReporteGeneralLCResponseDTO();
					 clResponseDTO.setIdTarea(resultado.getLong("ID_TAREA_LINEA"));
					clResponseDTO.setNombreLineaNegocio(resultado.getString("NOMBRE_LINEA_NEGOCIO"));
					clResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					clResponseDTO.setFdFechaFin(resultado.getTimestamp("FDFECHAFIN"));
					clResponseDTO.setTotalRegistros(resultado.getInt("FINOREGISTROS"));
					clResponseDTO.setTotalRegistrosAprobados(0);	
					clResponseDTO.setTotalRegistrosRechazados(0);
				
					
					
					reporteGeneralLCResponseDTOlist.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reporteGeneralLCResponseDTOlist;
	}
	
	

}



