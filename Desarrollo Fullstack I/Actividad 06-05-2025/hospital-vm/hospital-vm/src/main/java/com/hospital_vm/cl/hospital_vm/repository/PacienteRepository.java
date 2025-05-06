package com.hospital_vm.cl.hospital_vm.repository;


import com.hospital_vm.cl.hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    //Usando JPQL
    @Query("SELECT p FROM Paciente p WHERE p.apellidos = :apellido")
    List<Paciente> buscarPorApellidos(@Param("apellido") String apellido);

    //Usando SQL nativo
    @Query(value = "SELECT * FROM paciente WHERE correo= :correo", nativeQuery = true)
    Paciente buscarPorCorreo(@Param("correo")String correo);






}
