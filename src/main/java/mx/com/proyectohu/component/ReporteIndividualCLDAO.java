package mx.com.proyectohu.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.proyectohu.dto.CLRequestDTO;
import mx.com.proyectohu.dto.CLResponseCargaDTO;
import mx.com.proyectohu.dto.CLResponseDTO;
import mx.com.proyectohu.dto.CLResponseEnvioDTO;

@Component
public class ReporteIndividualCLDAO {

	@Autowired
	private DataSource dataSource;

	public List<CLResponseCargaDTO> consultarCLRegistroIndividualCarga(CLRequestDTO clRequestDTO) {
		List<CLResponseCargaDTO> clResponseDTOLista = new ArrayList<CLResponseCargaDTO>(); 
		CLResponseCargaDTO  clResponseDTO= new CLResponseCargaDTO();
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALCL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, clRequestDTO.getCustomerID());
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
				cs.setString(14, clRequestDTO.getCustomerID());
				cs.setString(15, clRequestDTO.getTipoActividad()); 
				if (clRequestDTO.getIdMapeoLinea() != null) {
					cs.setLong(16, clRequestDTO.getIdMapeoLinea());
				} else {
				    cs.setNull(16, java.sql.Types.NUMERIC);
				}
				   

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					clResponseDTO= new CLResponseCargaDTO();
					
					clResponseDTO.setIdListaContacto(resultado.getLong("ID_LISTA_CONTACTO"));
					clResponseDTO.setIdTarea(resultado.getLong("ID_TAREA_LINEA"));
					clResponseDTO.setNombre(resultado.getString("FCNOMBRE"));
					clResponseDTO.setApellidoPaterno(resultado.getString("FCAPELLIDO_PATERNO"));
					clResponseDTO.setApellidoMaterno(resultado.getString("FCAPELLIDO_MATERNO"));
					clResponseDTO.setCorreo(resultado.getString("FCEMAIL_ADDRESS_"));
					clResponseDTO.setTelefono1(resultado.getString("FCMOBILE_NUMBER_"));
					clResponseDTO.setTelefono2(resultado.getString("FCMOBILE_COUNTRY_"));
					clResponseDTO.setNoCuenta(resultado.getString("FCNUMERO_DE_CUENTA"));
					clResponseDTO.setNss(resultado.getString("FCNSS"));
					clResponseDTO.setCurp(resultado.getString("FCCURP"));
					clResponseDTO.setRfc(resultado.getString("FCRFC"));
					clResponseDTO.setPoliza(resultado.getString("FCPOLIZA"));
					clResponseDTO.setFechaNacimiento(resultado.getString("FCDATE_OF_BIRTH"));
					clResponseDTO.setCp(resultado.getString("FCPOSTAL_CODE_"));
					clResponseDTO.setCalle1(resultado.getString("FCPOSTAL_STREET_1_"));
					clResponseDTO.setCalle2(resultado.getString("FCPOSTAL_STREET_2_"));
					clResponseDTO.setCiudad(resultado.getString("FCCITY_"));
					clResponseDTO.setEstado(resultado.getString("FCSTATE_"));
					clResponseDTO.setGenero(resultado.getString("FCGENERO"));
					clResponseDTO.setPrueba(resultado.getString("FCUSUARIO_PRUEBA"));
					clResponseDTO.setSuspension(resultado.getString("FCSUSPENSION_LOGICA"));
					clResponseDTO.setLineaNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					clResponseDTO.setFecha(resultado.getTimestamp("FECHA_CREACION").getTime());
					clResponseDTO.setIdCliente(resultado.getString("FCCUSTOMER_ID_"));
					clResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					
					if (clResponseDTO.getIdTarea()==0) {
						clResponseDTO.setIdTarea(null);
					}
					
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
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALCL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, clRequestDTO.getCustomerID());
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
				cs.setString(14, clRequestDTO.getCustomerID());
				cs.setString(15, clRequestDTO.getTipoActividad());      
				if (clRequestDTO.getIdMapeoLinea() != null) {
					cs.setLong(16, clRequestDTO.getIdMapeoLinea());
				} else {
				    cs.setNull(16, java.sql.Types.NUMERIC);
				}
				

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					clResponseDTO= new CLResponseDTO();
					clResponseDTO.setIdListaContacto(resultado.getLong("ID_LISTA_CONTACTO"));
					clResponseDTO.setIdTarea(resultado.getLong("ID_TAREA_LINEA"));
					clResponseDTO.setNombre(resultado.getString("FCNOMBRE"));
					clResponseDTO.setApellidoPaterno(resultado.getString("FCAPELLIDO_PATERNO"));
					clResponseDTO.setApellidoMaterno(resultado.getString("FCAPELLIDO_MATERNO"));
					clResponseDTO.setCorreo(resultado.getString("FCEMAIL_ADDRESS_"));
					clResponseDTO.setTelefono1(resultado.getString("FCMOBILE_NUMBER_"));
					clResponseDTO.setTelefono2(resultado.getString("FCMOBILE_COUNTRY_"));
					clResponseDTO.setNoCuenta(resultado.getString("FCNUMERO_DE_CUENTA"));
					clResponseDTO.setNss(resultado.getString("FCNSS"));
					clResponseDTO.setCurp(resultado.getString("FCCURP"));
					clResponseDTO.setRfc(resultado.getString("FCRFC"));
					clResponseDTO.setPoliza(resultado.getString("FCPOLIZA"));
					clResponseDTO.setFechaNacimiento(resultado.getString("FCDATE_OF_BIRTH"));
					clResponseDTO.setCp(resultado.getString("FCPOSTAL_CODE_"));
					clResponseDTO.setCalle1(resultado.getString("FCPOSTAL_STREET_1_"));
					clResponseDTO.setCalle2(resultado.getString("FCPOSTAL_STREET_2_"));
					clResponseDTO.setCiudad(resultado.getString("FCCITY_"));
					clResponseDTO.setEstado(resultado.getString("FCSTATE_"));
					clResponseDTO.setGenero(resultado.getString("FCGENERO"));
					clResponseDTO.setPrueba(resultado.getString("FCUSUARIO_PRUEBA"));
					clResponseDTO.setSuspension(resultado.getString("FCSUSPENSION_LOGICA"));
					clResponseDTO.setLineaNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					clResponseDTO.setFecha(resultado.getTimestamp("FECHA_CREACION").getTime());
					clResponseDTO.setEstatus(resultado.getString("ESTATUS_ABC"));
					clResponseDTO.setDetalle(resultado.getString("FCDETALLE"));
					clResponseDTO.setIdCliente(resultado.getString("FCCUSTOMER_ID_"));
					clResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					
					clResponseDTOLista.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clResponseDTOLista;
	}
	
	
	public List<CLResponseEnvioDTO> consultarCLRegistroIndividualEnvio(CLRequestDTO clRequestDTO) {
		List<CLResponseEnvioDTO> clResponseDTOLista = new ArrayList<CLResponseEnvioDTO>(); 
		CLResponseEnvioDTO  clResponseDTO= new CLResponseEnvioDTO();
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALCL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				clResponseDTO= new CLResponseEnvioDTO();
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, clRequestDTO.getCustomerID());
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
				cs.setString(14, clRequestDTO.getCustomerID());
				cs.setString(15, clRequestDTO.getTipoActividad());     
				if (clRequestDTO.getIdMapeoLinea() != null) {
					cs.setLong(16, clRequestDTO.getIdMapeoLinea());
				} else {
				    cs.setNull(16, java.sql.Types.NUMERIC);
				}
				cs.setString(17, clRequestDTO.getRiid());  

				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					clResponseDTO= new CLResponseEnvioDTO();
					
					clResponseDTO.setIdListaContacto(resultado.getLong("ID_LISTA_CONTACTO"));
					clResponseDTO.setIdTarea(resultado.getLong("ID_TAREA_LINEA"));
					clResponseDTO.setRiid(resultado.getString("FCRIID_"));
					clResponseDTO.setNombre(resultado.getString("FCNOMBRE"));
					clResponseDTO.setApellidoPaterno(resultado.getString("FCAPELLIDO_PATERNO"));
					clResponseDTO.setApellidoMaterno(resultado.getString("FCAPELLIDO_MATERNO"));
					clResponseDTO.setCorreo(resultado.getString("FCEMAIL_ADDRESS_"));
					clResponseDTO.setTelefono1(resultado.getString("FCMOBILE_NUMBER_"));
					clResponseDTO.setTelefono2(resultado.getString("FCMOBILE_COUNTRY_"));
					clResponseDTO.setNoCuenta(resultado.getString("FCNUMERO_DE_CUENTA"));
					clResponseDTO.setNss(resultado.getString("FCNSS"));
					clResponseDTO.setCurp(resultado.getString("FCCURP"));
					clResponseDTO.setRfc(resultado.getString("FCRFC"));
					clResponseDTO.setPoliza(resultado.getString("FCPOLIZA"));
					clResponseDTO.setFechaNacimiento(resultado.getString("FCDATE_OF_BIRTH"));
					clResponseDTO.setCp(resultado.getString("FCPOSTAL_CODE_"));
					clResponseDTO.setCalle1(resultado.getString("FCPOSTAL_STREET_1_"));
					clResponseDTO.setCalle2(resultado.getString("FCPOSTAL_STREET_2_"));
					clResponseDTO.setCiudad(resultado.getString("FCCITY_"));
					clResponseDTO.setEstado(resultado.getString("FCSTATE_"));
					clResponseDTO.setGenero(resultado.getString("FCGENERO"));
					clResponseDTO.setPrueba(resultado.getString("FCUSUARIO_PRUEBA"));
					clResponseDTO.setSuspension(resultado.getString("FCSUSPENSION_LOGICA"));
					clResponseDTO.setLineaNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					clResponseDTO.setFecha(resultado.getTimestamp("FECHA_CREACION").getTime());
					clResponseDTO.setEstatus(resultado.getString("ESTATUS_ABC"));
					clResponseDTO.setDetalle(resultado.getString("FCDETALLE"));
					clResponseDTO.setIdCliente(resultado.getString("FCCUSTOMER_ID_"));
					clResponseDTO.setNombreMapeo(resultado.getString("NOMBRE_MAPEO"));
					
					clResponseDTOLista.add(clResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clResponseDTOLista;
	}	
	
	
	

}



