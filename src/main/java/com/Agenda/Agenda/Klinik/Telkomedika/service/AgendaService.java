package com.Agenda.Agenda.Klinik.Telkomedika.service;

import com.Agenda.Agenda.Klinik.Telkomedika.entity.AgendaEntity;

import java.util.List;
import java.util.Optional;

public interface AgendaService {
    List<AgendaEntity> findAllAgenda();
    Optional<AgendaEntity> findById(Long id);
    AgendaEntity saveAgenda(AgendaEntity agendaEntity);
    AgendaEntity updateAgenda (AgendaEntity agendaEntity);
    void deleteAgenda (Long id);
}
