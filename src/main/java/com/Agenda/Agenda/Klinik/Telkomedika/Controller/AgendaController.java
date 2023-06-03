package com.Agenda.Agenda.Klinik.Telkomedika.Controller;

import com.Agenda.Agenda.Klinik.Telkomedika.Jwt.JwtResponse;
import com.Agenda.Agenda.Klinik.Telkomedika.Jwt.JwtTokenUtil;
import com.Agenda.Agenda.Klinik.Telkomedika.entity.AgendaEntity;
import com.Agenda.Agenda.Klinik.Telkomedika.service.AgendaService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private final AgendaService agendaService;
    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }
    @GetMapping
    public List<AgendaEntity> findAllAgenda(){
        return agendaService.findAllAgenda();
    }
    @GetMapping("/{id}")
    public ResponseEntity<JwtResponse> findAgendaById(@PathVariable("id") Long id) {
        AgendaEntity agenda = agendaService.findById(id).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("judul", agenda.getJudul());
        claims.put("deskripsi", agenda.getDeskripsi());
        claims.put("waktu", agenda.getWaktu());
        final String token = jwtTokenUtil.doGenerateToken(claims,"fatah");
        return ResponseEntity.ok(new JwtResponse(token));

//        return agendaService.findById(id);
    }
    @PostMapping
    public AgendaEntity saveAgenda(@RequestBody AgendaEntity agendaEntity){
        return agendaService.saveAgenda(agendaEntity);
    }
    @PutMapping
    public AgendaEntity updateAgenda(@RequestBody AgendaEntity agendaEntity) {
        return agendaService.updateAgenda(agendaEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable("id")Long id){
        agendaService.deleteAgenda(id);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity<?> createAuthenticationToken() throws Exception {
        Map<String, Object> claims = new HashMap<>();
        final String token = jwtTokenUtil.doGenerateToken(claims,"fatah");

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
