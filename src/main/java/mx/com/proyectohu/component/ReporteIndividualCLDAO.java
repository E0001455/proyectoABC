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

@Component
public class ReporteIndividualCLDAO {

	@Autowired
	private DataSource dataSource;

	public List<CLResponseDTO> consultarCLRegistroIndividualCarga(CLRequestDTO clRequestDTO) {
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>(); 
		CLResponseDTO  clResponseDTO= new CLResponseDTO();
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALCL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, clRequestDTO.getRiid());
				cs.setString(3, clRequestDTO.getNombre());
				cs.setString(4, clRequestDTO.getApellidoPaterno());
				cs.setString(5, clRequestDTO.getCorreo());
				cs.setString(6, clRequestDTO.getTelefono());
				cs.setString(7, clRequestDTO.getNoCuenta());
				cs.setString(8, clRequestDTO.getNss());
				cs.setString(9, clRequestDTO.getCurp());
				cs.setString(10, clRequestDTO.getRfc());
				cs.setString(11, clRequestDTO.getPoliza());
				cs.setDate(12, java.sql.Date.valueOf(clRequestDTO.getFechaInicio()));
				cs.setDate(13, java.sql.Date.valueOf(clRequestDTO.getFechaFin()));
				cs.setString(14, clRequestDTO.getRiid());
				cs.setString(15, clRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					clResponseDTO.setRiid(resultado.getString("RIID_"));
					clResponseDTO.setNombre(resultado.getString("NOMBRE"));
					clResponseDTO.setApellidoPaterno(resultado.getString("APELLIDO_PATERNO"));
					clResponseDTO.setApellidoMaterno(resultado.getString("APELLIDO_MATERNO"));
					clResponseDTO.setCorreo(resultado.getString("EMAIL_ADDRESS_"));
					clResponseDTO.setTelefono1(resultado.getString("MOBILE_NUMBER_"));
					clResponseDTO.setTelefono2(resultado.getString("MOBILE_COUNTRY_"));
					clResponseDTO.setNoCuenta(resultado.getString("NUMERO_DE_CUENTA"));
					clResponseDTO.setNss(resultado.getString("NSS"));
					clResponseDTO.setCurp(resultado.getString("CURP"));
					clResponseDTO.setRfc(resultado.getString("RFC"));
					clResponseDTO.setPoliza(resultado.getString("POLIZA"));
					clResponseDTO.setFechaNacimiento(resultado.getString("FECHA_NACIMIENTO"));
					clResponseDTO.setCp(resultado.getString("POSTAL_CODE_"));
					clResponseDTO.setCalle1(resultado.getString("POSTAL_STREET_1_"));
					clResponseDTO.setCalle2(resultado.getString("POSTAL_STREET_2_"));
					clResponseDTO.setCiudad(resultado.getString("CITY_"));
					clResponseDTO.setEstado(resultado.getString("STATE_"));
					clResponseDTO.setGenero(resultado.getString("GENERO"));
					clResponseDTO.setPrueba(resultado.getString("USUARIO_PRUEBA"));
					clResponseDTO.setSuspension(resultado.getString("SUSPENSION_LOGICA"));
					clResponseDTO.setLineaNegocio(resultado.getString("LINEA_DE_NEGOCIO"));
					clResponseDTO.setFecha(resultado.getDate("FECHA_CREACION").toLocalDate());
					
					clResponseDTOLista.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clResponseDTOLista;
	}

	
	public List<CLResponseDTO> consultarCLRegistroIndividualValidacion(CLRequestDTO clRequestDTO) {
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>(); 
		CLResponseDTO  clResponseDTO= new CLResponseDTO();
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALCL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, clRequestDTO.getRiid());
				cs.setString(3, clRequestDTO.getNombre());
				cs.setString(4, clRequestDTO.getApellidoPaterno());
				cs.setString(5, clRequestDTO.getCorreo());
				cs.setString(6, clRequestDTO.getTelefono());
				cs.setString(7, clRequestDTO.getNoCuenta());
				cs.setString(8, clRequestDTO.getNss());
				cs.setString(9, clRequestDTO.getCurp());
				cs.setString(10, clRequestDTO.getRfc());
				cs.setString(11, clRequestDTO.getPoliza());
				cs.setDate(12, java.sql.Date.valueOf(clRequestDTO.getFechaInicio()));
				cs.setDate(13, java.sql.Date.valueOf(clRequestDTO.getFechaFin()));
				cs.setString(14, clRequestDTO.getRiid());
				cs.setString(15, clRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					clResponseDTO.setRiid(resultado.getString("RIID_"));
					clResponseDTO.setNombre(resultado.getString("NOMBRE"));
					clResponseDTO.setApellidoPaterno(resultado.getString("APELLIDO_PATERNO"));
					clResponseDTO.setApellidoMaterno(resultado.getString("APELLIDO_MATERNO"));
					clResponseDTO.setCorreo(resultado.getString("EMAIL_ADDRESS_"));
					clResponseDTO.setTelefono1(resultado.getString("MOBILE_NUMBER_"));
					clResponseDTO.setTelefono2(resultado.getString("MOBILE_COUNTRY_"));
					clResponseDTO.setNoCuenta(resultado.getString("NUMERO_DE_CUENTA"));
					clResponseDTO.setNss(resultado.getString("NSS"));
					clResponseDTO.setCurp(resultado.getString("CURP"));
					clResponseDTO.setRfc(resultado.getString("RFC"));
					clResponseDTO.setPoliza(resultado.getString("POLIZA"));
					clResponseDTO.setFechaNacimiento(resultado.getString("FECHA_NACIMIENTO"));
					clResponseDTO.setCp(resultado.getString("POSTAL_CODE_"));
					clResponseDTO.setCalle1(resultado.getString("POSTAL_STREET_1_"));
					clResponseDTO.setCalle2(resultado.getString("POSTAL_STREET_2_"));
					clResponseDTO.setCiudad(resultado.getString("CITY_"));
					clResponseDTO.setEstado(resultado.getString("STATE_"));
					clResponseDTO.setGenero(resultado.getString("GENERO"));
					clResponseDTO.setPrueba(resultado.getString("USUARIO_PRUEBA"));
					clResponseDTO.setSuspension(resultado.getString("SUSPENSION_LOGICA"));
					clResponseDTO.setLineaNegocio(resultado.getString("LINEA_DE_NEGOCIO"));
					clResponseDTO.setFecha(resultado.getDate("FECHA_CREACION").toLocalDate());
					clResponseDTO.setEstatus(resultado.getString("ESTATUS_ABC"));
					clResponseDTO.setDetalle(resultado.getString("DETALLE"));
					clResponseDTOLista.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clResponseDTOLista;
	}
	
	
	public List<CLResponseDTO> consultarCLRegistroIndividualEnvio(CLRequestDTO clRequestDTO) {
		List<CLResponseDTO> clResponseDTOLista = new ArrayList<CLResponseDTO>(); 
		CLResponseDTO  clResponseDTO= new CLResponseDTO();
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALCL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, clRequestDTO.getRiid());
				cs.setString(3, clRequestDTO.getNombre());
				cs.setString(4, clRequestDTO.getApellidoPaterno());
				cs.setString(5, clRequestDTO.getCorreo());
				cs.setString(6, clRequestDTO.getTelefono());
				cs.setString(7, clRequestDTO.getNoCuenta());
				cs.setString(8, clRequestDTO.getNss());
				cs.setString(9, clRequestDTO.getCurp());
				cs.setString(10, clRequestDTO.getRfc());
				cs.setString(11, clRequestDTO.getPoliza());
				cs.setDate(12, java.sql.Date.valueOf(clRequestDTO.getFechaInicio()));
				cs.setDate(13, java.sql.Date.valueOf(clRequestDTO.getFechaFin()));
				cs.setString(14, clRequestDTO.getRiid());
				cs.setString(15, clRequestDTO.getTipoActividad());                

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					clResponseDTO.setRiid(resultado.getString("RIID_"));
					clResponseDTO.setNombre(resultado.getString("NOMBRE"));
					clResponseDTO.setApellidoPaterno(resultado.getString("APELLIDO_PATERNO"));
					clResponseDTO.setApellidoMaterno(resultado.getString("APELLIDO_MATERNO"));
					clResponseDTO.setCorreo(resultado.getString("EMAIL_ADDRESS_"));
					clResponseDTO.setTelefono1(resultado.getString("MOBILE_NUMBER_"));
					clResponseDTO.setTelefono2(resultado.getString("MOBILE_COUNTRY_"));
					clResponseDTO.setNoCuenta(resultado.getString("NUMERO_DE_CUENTA"));
					clResponseDTO.setNss(resultado.getString("NSS"));
					clResponseDTO.setCurp(resultado.getString("CURP"));
					clResponseDTO.setRfc(resultado.getString("RFC"));
					clResponseDTO.setPoliza(resultado.getString("POLIZA"));
					clResponseDTO.setFechaNacimiento(resultado.getString("FECHA_NACIMIENTO"));
					clResponseDTO.setCp(resultado.getString("POSTAL_CODE_"));
					clResponseDTO.setCalle1(resultado.getString("POSTAL_STREET_1_"));
					clResponseDTO.setCalle2(resultado.getString("POSTAL_STREET_2_"));
					clResponseDTO.setCiudad(resultado.getString("CITY_"));
					clResponseDTO.setEstado(resultado.getString("STATE_"));
					clResponseDTO.setGenero(resultado.getString("GENERO"));
					clResponseDTO.setPrueba(resultado.getString("USUARIO_PRUEBA"));
					clResponseDTO.setSuspension(resultado.getString("SUSPENSION_LOGICA"));
					clResponseDTO.setLineaNegocio(resultado.getString("LINEA_DE_NEGOCIO"));
					clResponseDTO.setFecha(resultado.getDate("FECHA_CREACION").toLocalDate());
					clResponseDTO.setEstatus(resultado.getString("ESTATUS_ABC"));
					clResponseDTO.setDetalle(resultado.getString("DETALLE"));
					clResponseDTOLista.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clResponseDTOLista;
	}	
	
	
	

}



