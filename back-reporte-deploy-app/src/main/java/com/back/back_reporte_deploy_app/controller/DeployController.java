package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.BugCreateDTO;
import com.back.back_reporte_deploy_app.dto.BugResponseDTO;
import com.back.back_reporte_deploy_app.dto.CambioCreateDTO;
import com.back.back_reporte_deploy_app.dto.CambioResponseDTO;
import com.back.back_reporte_deploy_app.dto.ComponenteDeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.ComponenteDeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.DeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.DeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.IncidenteCreateDTO;
import com.back.back_reporte_deploy_app.dto.IncidenteResponseDTO;
import com.back.back_reporte_deploy_app.dto.NewFuncionalidadCreateDTO;
import com.back.back_reporte_deploy_app.dto.NewFuncionalidadResponseDTO;
import com.back.back_reporte_deploy_app.dto.ValidacionDeployResponseDTO;
import com.back.back_reporte_deploy_app.service.DeployService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/deploy")
@RequiredArgsConstructor
public class DeployController {

    private final DeployService deployService;
    
    @PostMapping("")
    public ResponseEntity<DeployResponseDTO> registerDeploy(@RequestBody DeployCreateDTO deployRegister) {
        DeployResponseDTO deploy = deployService.registerDeploy(deployRegister);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(deploy);
    }

    @GetMapping("")
    public ResponseEntity<List<DeployResponseDTO>> getDeploys() {
        
        return ResponseEntity.ok(deployService.getDeploys());
    }
    

    @GetMapping("/{idDeploy}/validacion")
    public ResponseEntity<List<ValidacionDeployResponseDTO>> getValidacionesForDeploy(@PathVariable Long idDeploy) {

        List<ValidacionDeployResponseDTO> validaciones = deployService.getValidaciones(idDeploy);

        return ResponseEntity.ok(validaciones);
    }
    
    @PostMapping("/{idDeploy}/cambios")
    public ResponseEntity<List<CambioResponseDTO>> asignarCambiosRealizados(@PathVariable Long idDeploy, @RequestBody List<CambioCreateDTO> cambios) {
        
        var cambiosResponse = deployService.asignarCambios(idDeploy, cambios);

        return ResponseEntity.status(HttpStatus.CREATED).body(cambiosResponse);
    }

    @PostMapping("/{idDeploy}/funcionalidades")
    public ResponseEntity<List<NewFuncionalidadResponseDTO>> asignarFuncionalidadesNuevas(@PathVariable Long idDeploy, @RequestBody @Valid List<NewFuncionalidadCreateDTO> funcionalidades) {
        
        var response = deployService.asignarFuncionalidades(idDeploy, funcionalidades);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/{idDeploy}/componentes")
    public ResponseEntity<List<ComponenteDeployResponseDTO>> asignarComponentesDesplegados(@PathVariable Long idDeploy, @RequestBody @Valid List<ComponenteDeployCreateDTO> componentes) {
        
        var response = deployService.asignarComponentes(idDeploy, componentes);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{idDeploy}/incidentes")
    public ResponseEntity<List<IncidenteResponseDTO>> asignarIncidentes(@PathVariable Long idDeploy, @RequestBody @Valid List<IncidenteCreateDTO> incidentes) {
        
        var response = deployService.asignarIncidentes(idDeploy, incidentes);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/{idDeploy}/bugs")
    public ResponseEntity<List<BugResponseDTO>> agregarBugs(@PathVariable Long idDeploy, @RequestBody List<BugCreateDTO> bugs) {
        
        var response = deployService.agregarBugs(idDeploy, bugs);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);    
    }
    
}
