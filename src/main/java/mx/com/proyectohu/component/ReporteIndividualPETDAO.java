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
import mx.com.proyectohu.dto.PETResponseDTO;

@Component
public class ReporteIndividualPETDAO {

	@Autowired
	private DataSource dataSource;

	public List<PETResponseDTO> consultarPETRegistroIndividualCarga(PETRequestDTO petRequestDTO) {
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>(); 
		PETResponseDTO  petResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALPET(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, petRequestDTO.getNoLote());
				cs.setString(3, petRequestDTO.getIdCliente());
				cs.setString(4, petRequestDTO.getIdAfore());
				cs.setString(5, petRequestDTO.getIdClienteAhorrador());
				cs.setString(6, petRequestDTO.getIdPrestamoPensionado());
				cs.setString(7, petRequestDTO.getIdSusceptiblePrestamo());
				cs.setString(8, petRequestDTO.getIdBajaCambio());
				cs.setString(9, petRequestDTO.getIdComunicacion());
				cs.setString(10, petRequestDTO.getIdPersona());
				cs.setString(11, petRequestDTO.getNombre());
				cs.setString(12, petRequestDTO.getApellido());
				cs.setString(13, petRequestDTO.getCorreo());
				cs.setString(14, petRequestDTO.getTelefono());    
				cs.setDate(15, java.sql.Date.valueOf(petRequestDTO.getFechaInicio()));
				cs.setDate(16, java.sql.Date.valueOf(petRequestDTO.getFechaFin()));
				cs.setString(17, petRequestDTO.getTipoConsulta());
				cs.setString(18, petRequestDTO.getTipoActividad());   
				


				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					petResponseDTO= new PETResponseDTO();
					
					
					petResponseDTO.setLineaDeNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					petResponseDTO.setIdCampana(resultado.getString("FCID_CAMPANA"));
					petResponseDTO.setNumLote(resultado.getString("FCNUM_LOTE"));
					petResponseDTO.setCustomerId(resultado.getString("FCCUSTOMER_ID_"));
					petResponseDTO.setIdAfore(resultado.getString("FCID_AFORE"));
					petResponseDTO.setDescripcionDeAfore(resultado.getString("FCDESCRIPCION_DE_AFORE"));
					petResponseDTO.setIdClienteAhorrrador(resultado.getString("FCID_CLIENTE_AHORRADOR"));
					petResponseDTO.setIdPrestamoPensionado(resultado.getString("FCID_PRESTAMO_PENSIONADO"));
					petResponseDTO.setIdSusceptiblePrestamo(resultado.getString("FCID_SUSCEPTIBLE_PRESTAMO"));
					petResponseDTO.setIdBajaCambio(resultado.getString("FCID_BAJA_CAMBIO"));
					petResponseDTO.setIdComunicacion(resultado.getString("FCID_COMUNICACION"));
					petResponseDTO.setIdPersona(resultado.getString("FCIDPERSONA"));
					petResponseDTO.setFirstName(resultado.getString("FCFIRST_NAME"));
					petResponseDTO.setLastName(resultado.getString("FCLAST_NAME"));
					//petResponseDTO.setCorreo(resultado.getString("EMAIL_ADDRESS_"));
					//petResponseDTO.setTelefono(resultado.getString("MOBILE_NUMBER_"));
					petResponseDTO.setSiefore(resultado.getString("FCSIEFORE"));
					petResponseDTO.setSegmento(resultado.getString("FCSEGMENTO"));
					petResponseDTO.setRegimen(resultado.getString("FCREGIMEN"));
					petResponseDTO.setTipoPension(resultado.getString("FCTIPO_PENSION"));
					petResponseDTO.setGrupoPago(resultado.getString("FCGRUPO_PAGO"));
					petResponseDTO.setFechaBajaCambio(resultado.getString("FCFECHA_BAJA_CAMBIO"));
					petResponseDTO.setRegimenImss(resultado.getString("FCREGIMEN_IMSS"));
					petResponseDTO.setSegmentoAfo(resultado.getString("FCSEGMENTO_AFO"));
					petResponseDTO.setEdad(resultado.getString("FCEDAD"));
					petResponseDTO.setGenero(resultado.getString("FCGENERO"));
					petResponseDTO.setLigaRsaldos(resultado.getString("FCLIGA_RSALDOS"));
					petResponseDTO.setSegmentoPre(resultado.getString("FCSEGMENTO_PRE"));
					petResponseDTO.setDomicilioPreferente(resultado.getString("FCDOMICILIO_PREFERENTE"));
					petResponseDTO.setEmpresa(resultado.getString("FCEMPRESA"));
					petResponseDTO.setSegmentoProy(resultado.getString("FCSEGMENTO_PROY"));
					petResponseDTO.setPaterno(resultado.getString("FCPATERNO"));
					petResponseDTO.setLigaTitular(resultado.getString("FCLIGA_TITULAR"));
					petResponseDTO.setInstituto(resultado.getString("FCINSTITUTO"));
					petResponseDTO.setTrabajador(resultado.getString("FCTRABAJADOR"));
					petResponseDTO.setEntidad(resultado.getString("FCENTIDAD"));
					petResponseDTO.setMediosDigitales(resultado.getString("FCMEDIOS_DIGITALES"));
					petResponseDTO.setApertura(resultado.getString("FCAPERTURA"));
					petResponseDTO.setNumeroHijos(resultado.getString("FCNUMERO_HIJOS"));
					petResponseDTO.setMasy65(resultado.getString("FCMASY65"));
					petResponseDTO.setMenores(resultado.getString("FCMENORES"));
					petResponseDTO.setCuentaMenor1(resultado.getString("FCCUENTA_MENOR_1"));
					petResponseDTO.setNombreHijo1(resultado.getString("FCNOMBRE_HIJO_1"));
					petResponseDTO.setLigaHijo1(resultado.getString("FCLIGA_HIJO_1"));
					petResponseDTO.setCuentaMenor2(resultado.getString("FCCUENTA_MENOR_2"));
					petResponseDTO.setNombreHijo2(resultado.getString("FCNOMBRE_HIJO_2"));
					petResponseDTO.setLigaHijo2(resultado.getString("FCLIGA_HIJO_2"));
					petResponseDTO.setCuentaMenor3(resultado.getString("FCCUENTA_MENOR_3"));
					petResponseDTO.setNombreHijo3(resultado.getString("FCNOMBRE_HIJO_3"));
					petResponseDTO.setLigaHijo3(resultado.getString("FCLIGA_HIJO_3"));
					petResponseDTO.setCuentaMenor4(resultado.getString("FCCUENTA_MENOR_4"));
					petResponseDTO.setNombreHijo4(resultado.getString("FCNOMBRE_HIJO_4"));
					petResponseDTO.setLigaHijo4(resultado.getString("FCLIGA_HIJO_4"));
					petResponseDTO.setCuentaMenor5(resultado.getString("FCCUENTA_MENOR_5"));
					petResponseDTO.setNombreHijo5(resultado.getString("FCNOMBRE_HIJO_5"));
					petResponseDTO.setLigaHijo5(resultado.getString("FCLIGA_HIJO_5"));
					petResponseDTO.setCuentaMenor6(resultado.getString("FCCUENTA_MENOR_6"));
					petResponseDTO.setNombreHijo6(resultado.getString("FCNOMBRE_HIJO_6"));
					petResponseDTO.setLigaHijo6(resultado.getString("FCLIGA_HIJO_6"));
					petResponseDTO.setPerfil(resultado.getString("FCPERFIL"));
					petResponseDTO.setHijos(resultado.getString("FCHIJOS"));
					petResponseDTO.setEstatusExp(resultado.getString("FCESTATUS_EXP"));
					petResponseDTO.setSucursal(resultado.getString("FCSUCURSAL"));
					petResponseDTO.setDomSucursal(resultado.getString("FCDOM_SUCURSAL"));
					petResponseDTO.setFecha(resultado.getDate("FECHA_CREACION").toLocalDate());
					petResponseDTO.setCampana(resultado.getString("FCNOMBRE_CAMPANA"));
					
					petResponseDTOLista.add(petResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return petResponseDTOLista;
	}
	
	public List<PETResponseDTO> consultarPETRegistroIndividualValidacion(PETRequestDTO petRequestDTO) {
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>(); 
		PETResponseDTO  petResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALPET(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, petRequestDTO.getNoLote());
				cs.setString(3, petRequestDTO.getIdCliente());
				cs.setString(4, petRequestDTO.getIdAfore());
				cs.setString(5, petRequestDTO.getIdClienteAhorrador());
				cs.setString(6, petRequestDTO.getIdPrestamoPensionado());
				cs.setString(7, petRequestDTO.getIdSusceptiblePrestamo());
				cs.setString(8, petRequestDTO.getIdBajaCambio());
				cs.setString(9, petRequestDTO.getIdComunicacion());
				cs.setString(10, petRequestDTO.getIdPersona());
				cs.setString(11, petRequestDTO.getNombre());
				cs.setString(12, petRequestDTO.getApellido());
				cs.setString(13, petRequestDTO.getCorreo());
				cs.setString(14, petRequestDTO.getTelefono());    
				cs.setDate(15, java.sql.Date.valueOf(petRequestDTO.getFechaInicio()));
				cs.setDate(16, java.sql.Date.valueOf(petRequestDTO.getFechaFin()));
				cs.setString(17, petRequestDTO.getTipoConsulta());
				cs.setString(18, petRequestDTO.getTipoActividad());   
				


				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					petResponseDTO= new PETResponseDTO();
					
					
					petResponseDTO.setLineaDeNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					petResponseDTO.setIdCampana(resultado.getString("FCID_CAMPANA"));
					petResponseDTO.setNumLote(resultado.getString("FCNUM_LOTE"));
					petResponseDTO.setCustomerId(resultado.getString("FCCUSTOMER_ID_"));
					petResponseDTO.setIdAfore(resultado.getString("FCID_AFORE"));
					petResponseDTO.setDescripcionDeAfore(resultado.getString("FCDESCRIPCION_DE_AFORE"));
					petResponseDTO.setIdClienteAhorrrador(resultado.getString("FCID_CLIENTE_AHORRADOR"));
					petResponseDTO.setIdPrestamoPensionado(resultado.getString("FCID_PRESTAMO_PENSIONADO"));
					petResponseDTO.setIdSusceptiblePrestamo(resultado.getString("FCID_SUSCEPTIBLE_PRESTAMO"));
					petResponseDTO.setIdBajaCambio(resultado.getString("FCID_BAJA_CAMBIO"));
					petResponseDTO.setIdComunicacion(resultado.getString("FCID_COMUNICACION"));
					petResponseDTO.setIdPersona(resultado.getString("FCIDPERSONA"));
					petResponseDTO.setFirstName(resultado.getString("FCFIRST_NAME"));
					petResponseDTO.setLastName(resultado.getString("FCLAST_NAME"));
					//petResponseDTO.setCorreo(resultado.getString("EMAIL_ADDRESS_"));
					//petResponseDTO.setTelefono(resultado.getString("MOBILE_NUMBER_"));
					petResponseDTO.setSiefore(resultado.getString("FCSIEFORE"));
					petResponseDTO.setSegmento(resultado.getString("FCSEGMENTO"));
					petResponseDTO.setRegimen(resultado.getString("FCREGIMEN"));
					petResponseDTO.setTipoPension(resultado.getString("FCTIPO_PENSION"));
					petResponseDTO.setGrupoPago(resultado.getString("FCGRUPO_PAGO"));
					petResponseDTO.setFechaBajaCambio(resultado.getString("FCFECHA_BAJA_CAMBIO"));
					petResponseDTO.setRegimenImss(resultado.getString("FCREGIMEN_IMSS"));
					petResponseDTO.setSegmentoAfo(resultado.getString("FCSEGMENTO_AFO"));
					petResponseDTO.setEdad(resultado.getString("FCEDAD"));
					petResponseDTO.setGenero(resultado.getString("FCGENERO"));
					petResponseDTO.setLigaRsaldos(resultado.getString("FCLIGA_RSALDOS"));
					petResponseDTO.setSegmentoPre(resultado.getString("FCSEGMENTO_PRE"));
					petResponseDTO.setDomicilioPreferente(resultado.getString("FCDOMICILIO_PREFERENTE"));
					petResponseDTO.setEmpresa(resultado.getString("FCEMPRESA"));
					petResponseDTO.setSegmentoProy(resultado.getString("FCSEGMENTO_PROY"));
					petResponseDTO.setPaterno(resultado.getString("FCPATERNO"));
					petResponseDTO.setLigaTitular(resultado.getString("FCLIGA_TITULAR"));
					petResponseDTO.setInstituto(resultado.getString("FCINSTITUTO"));
					petResponseDTO.setTrabajador(resultado.getString("FCTRABAJADOR"));
					petResponseDTO.setEntidad(resultado.getString("FCENTIDAD"));
					petResponseDTO.setMediosDigitales(resultado.getString("FCMEDIOS_DIGITALES"));
					petResponseDTO.setApertura(resultado.getString("FCAPERTURA"));
					petResponseDTO.setNumeroHijos(resultado.getString("FCNUMERO_HIJOS"));
					petResponseDTO.setMasy65(resultado.getString("FCMASY65"));
					petResponseDTO.setMenores(resultado.getString("FCMENORES"));
					petResponseDTO.setCuentaMenor1(resultado.getString("FCCUENTA_MENOR_1"));
					petResponseDTO.setNombreHijo1(resultado.getString("FCNOMBRE_HIJO_1"));
					petResponseDTO.setLigaHijo1(resultado.getString("FCLIGA_HIJO_1"));
					petResponseDTO.setCuentaMenor2(resultado.getString("FCCUENTA_MENOR_2"));
					petResponseDTO.setNombreHijo2(resultado.getString("FCNOMBRE_HIJO_2"));
					petResponseDTO.setLigaHijo2(resultado.getString("FCLIGA_HIJO_2"));
					petResponseDTO.setCuentaMenor3(resultado.getString("FCCUENTA_MENOR_3"));
					petResponseDTO.setNombreHijo3(resultado.getString("FCNOMBRE_HIJO_3"));
					petResponseDTO.setLigaHijo3(resultado.getString("FCLIGA_HIJO_3"));
					petResponseDTO.setCuentaMenor4(resultado.getString("FCCUENTA_MENOR_4"));
					petResponseDTO.setNombreHijo4(resultado.getString("FCNOMBRE_HIJO_4"));
					petResponseDTO.setLigaHijo4(resultado.getString("FCLIGA_HIJO_4"));
					petResponseDTO.setCuentaMenor5(resultado.getString("FCCUENTA_MENOR_5"));
					petResponseDTO.setNombreHijo5(resultado.getString("FCNOMBRE_HIJO_5"));
					petResponseDTO.setLigaHijo5(resultado.getString("FCLIGA_HIJO_5"));
					petResponseDTO.setCuentaMenor6(resultado.getString("FCCUENTA_MENOR_6"));
					petResponseDTO.setNombreHijo6(resultado.getString("FCNOMBRE_HIJO_6"));
					petResponseDTO.setLigaHijo6(resultado.getString("FCLIGA_HIJO_6"));
					petResponseDTO.setPerfil(resultado.getString("FCPERFIL"));
					petResponseDTO.setHijos(resultado.getString("FCHIJOS"));
					petResponseDTO.setEstatusExp(resultado.getString("FCESTATUS_EXP"));
					petResponseDTO.setSucursal(resultado.getString("FCSUCURSAL"));
					petResponseDTO.setDomSucursal(resultado.getString("FCDOM_SUCURSAL"));
					petResponseDTO.setFecha(resultado.getDate("FECHA_CREACION").toLocalDate());
				petResponseDTO.setEstatus(resultado.getString("ESTATUS_ABC"));
				petResponseDTO.setDetalle(resultado.getString("FCDETALLE"));
				petResponseDTO.setCampana(resultado.getString("FCNOMBRE_CAMPANA"));
					
					
					petResponseDTOLista.add(petResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return petResponseDTOLista;
	}

	public List<PETResponseDTO> consultarPETRegistroIndividualEnvio(PETRequestDTO petRequestDTO) {
		List<PETResponseDTO> petResponseDTOLista = new ArrayList<PETResponseDTO>(); 
		PETResponseDTO  petResponseDTO= null;
		try (Connection conn = dataSource.getConnection()) {
		
			String sql = "{call SPCONSULTARREPORTEINDIVIDUALPET(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try (CallableStatement cs = conn.prepareCall(sql)) {
				
				cs.registerOutParameter(1, java.sql.Types.REF_CURSOR);
				cs.setString(2, petRequestDTO.getNoLote());
				cs.setString(3, petRequestDTO.getIdCliente());
				cs.setString(4, petRequestDTO.getIdAfore());
				cs.setString(5, petRequestDTO.getIdClienteAhorrador());
				cs.setString(6, petRequestDTO.getIdPrestamoPensionado());
				cs.setString(7, petRequestDTO.getIdSusceptiblePrestamo());
				cs.setString(8, petRequestDTO.getIdBajaCambio());
				cs.setString(9, petRequestDTO.getIdComunicacion());
				cs.setString(10, petRequestDTO.getIdPersona());
				cs.setString(11, petRequestDTO.getNombre());
				cs.setString(12, petRequestDTO.getApellido());
				cs.setString(13, petRequestDTO.getCorreo());
				cs.setString(14, petRequestDTO.getTelefono());    
				cs.setDate(15, java.sql.Date.valueOf(petRequestDTO.getFechaInicio()));
				cs.setDate(16, java.sql.Date.valueOf(petRequestDTO.getFechaFin()));
				cs.setString(17, petRequestDTO.getTipoConsulta());
				cs.setString(18, petRequestDTO.getTipoActividad());   
				


				cs.execute();

				ResultSet  resultado= (ResultSet) cs.getObject(1);  
				while (resultado.next()) {
					petResponseDTO= new PETResponseDTO();
					
					
					petResponseDTO.setLineaDeNegocio(resultado.getString("FCLINEA_DE_NEGOCIO"));
					petResponseDTO.setIdCampana(resultado.getString("FCID_CAMPANA"));
					petResponseDTO.setNumLote(resultado.getString("FCNUM_LOTE"));
					petResponseDTO.setCustomerId(resultado.getString("FCCUSTOMER_ID_"));
					petResponseDTO.setIdAfore(resultado.getString("FCID_AFORE"));
					petResponseDTO.setDescripcionDeAfore(resultado.getString("FCDESCRIPCION_DE_AFORE"));
					petResponseDTO.setIdClienteAhorrrador(resultado.getString("FCID_CLIENTE_AHORRADOR"));
					petResponseDTO.setIdPrestamoPensionado(resultado.getString("FCID_PRESTAMO_PENSIONADO"));
					petResponseDTO.setIdSusceptiblePrestamo(resultado.getString("FCID_SUSCEPTIBLE_PRESTAMO"));
					petResponseDTO.setIdBajaCambio(resultado.getString("FCID_BAJA_CAMBIO"));
					petResponseDTO.setIdComunicacion(resultado.getString("FCID_COMUNICACION"));
					petResponseDTO.setIdPersona(resultado.getString("FCIDPERSONA"));
					petResponseDTO.setFirstName(resultado.getString("FCFIRST_NAME"));
					petResponseDTO.setLastName(resultado.getString("FCLAST_NAME"));
					//petResponseDTO.setCorreo(resultado.getString("EMAIL_ADDRESS_"));
					//petResponseDTO.setTelefono(resultado.getString("MOBILE_NUMBER_"));
					petResponseDTO.setSiefore(resultado.getString("FCSIEFORE"));
					petResponseDTO.setSegmento(resultado.getString("FCSEGMENTO"));
					petResponseDTO.setRegimen(resultado.getString("FCREGIMEN"));
					petResponseDTO.setTipoPension(resultado.getString("FCTIPO_PENSION"));
					petResponseDTO.setGrupoPago(resultado.getString("FCGRUPO_PAGO"));
					petResponseDTO.setFechaBajaCambio(resultado.getString("FCFECHA_BAJA_CAMBIO"));
					petResponseDTO.setRegimenImss(resultado.getString("FCREGIMEN_IMSS"));
					petResponseDTO.setSegmentoAfo(resultado.getString("FCSEGMENTO_AFO"));
					petResponseDTO.setEdad(resultado.getString("FCEDAD"));
					petResponseDTO.setGenero(resultado.getString("FCGENERO"));
					petResponseDTO.setLigaRsaldos(resultado.getString("FCLIGA_RSALDOS"));
					petResponseDTO.setSegmentoPre(resultado.getString("FCSEGMENTO_PRE"));
					petResponseDTO.setDomicilioPreferente(resultado.getString("FCDOMICILIO_PREFERENTE"));
					petResponseDTO.setEmpresa(resultado.getString("FCEMPRESA"));
					petResponseDTO.setSegmentoProy(resultado.getString("FCSEGMENTO_PROY"));
					petResponseDTO.setPaterno(resultado.getString("FCPATERNO"));
					petResponseDTO.setLigaTitular(resultado.getString("FCLIGA_TITULAR"));
					petResponseDTO.setInstituto(resultado.getString("FCINSTITUTO"));
					petResponseDTO.setTrabajador(resultado.getString("FCTRABAJADOR"));
					petResponseDTO.setEntidad(resultado.getString("FCENTIDAD"));
					petResponseDTO.setMediosDigitales(resultado.getString("FCMEDIOS_DIGITALES"));
					petResponseDTO.setApertura(resultado.getString("FCAPERTURA"));
					petResponseDTO.setNumeroHijos(resultado.getString("FCNUMERO_HIJOS"));
					petResponseDTO.setMasy65(resultado.getString("FCMASY65"));
					petResponseDTO.setMenores(resultado.getString("FCMENORES"));
					petResponseDTO.setCuentaMenor1(resultado.getString("FCCUENTA_MENOR_1"));
					petResponseDTO.setNombreHijo1(resultado.getString("FCNOMBRE_HIJO_1"));
					petResponseDTO.setLigaHijo1(resultado.getString("FCLIGA_HIJO_1"));
					petResponseDTO.setCuentaMenor2(resultado.getString("FCCUENTA_MENOR_2"));
					petResponseDTO.setNombreHijo2(resultado.getString("FCNOMBRE_HIJO_2"));
					petResponseDTO.setLigaHijo2(resultado.getString("FCLIGA_HIJO_2"));
					petResponseDTO.setCuentaMenor3(resultado.getString("FCCUENTA_MENOR_3"));
					petResponseDTO.setNombreHijo3(resultado.getString("FCNOMBRE_HIJO_3"));
					petResponseDTO.setLigaHijo3(resultado.getString("FCLIGA_HIJO_3"));
					petResponseDTO.setCuentaMenor4(resultado.getString("FCCUENTA_MENOR_4"));
					petResponseDTO.setNombreHijo4(resultado.getString("FCNOMBRE_HIJO_4"));
					petResponseDTO.setLigaHijo4(resultado.getString("FCLIGA_HIJO_4"));
					petResponseDTO.setCuentaMenor5(resultado.getString("FCCUENTA_MENOR_5"));
					petResponseDTO.setNombreHijo5(resultado.getString("FCNOMBRE_HIJO_5"));
					petResponseDTO.setLigaHijo5(resultado.getString("FCLIGA_HIJO_5"));
					petResponseDTO.setCuentaMenor6(resultado.getString("FCCUENTA_MENOR_6"));
					petResponseDTO.setNombreHijo6(resultado.getString("FCNOMBRE_HIJO_6"));
					petResponseDTO.setLigaHijo6(resultado.getString("FCLIGA_HIJO_6"));
					petResponseDTO.setPerfil(resultado.getString("FCPERFIL"));
					petResponseDTO.setHijos(resultado.getString("FCHIJOS"));
					petResponseDTO.setEstatusExp(resultado.getString("FCESTATUS_EXP"));
					petResponseDTO.setSucursal(resultado.getString("FCSUCURSAL"));
					petResponseDTO.setDomSucursal(resultado.getString("FCDOM_SUCURSAL"));
					petResponseDTO.setFecha(resultado.getDate("FECHA_CREACION").toLocalDate());
				petResponseDTO.setEstatus(resultado.getString("ESTATUS_ABC"));
				petResponseDTO.setDetalle(resultado.getString("FCDETALLE"));
				petResponseDTO.setCampana(resultado.getString("FCNOMBRE_CAMPANA"));
		
					
					petResponseDTOLista.add(petResponseDTO);
			
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return petResponseDTOLista;
	}


	

}



