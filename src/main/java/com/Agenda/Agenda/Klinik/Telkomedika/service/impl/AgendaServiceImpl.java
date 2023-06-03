package com.Agenda.Agenda.Klinik.Telkomedika.service.impl;

import com.Agenda.Agenda.Klinik.Telkomedika.entity.AgendaEntity;
import com.Agenda.Agenda.Klinik.Telkomedika.repository.AgendaRepository;
import com.Agenda.Agenda.Klinik.Telkomedika.service.AgendaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public List<AgendaEntity> findAllAgenda() {
        return agendaRepository.findAll();
    }

    @Override
    public Optional<AgendaEntity> findById(Long id) {
        return agendaRepository.findById(id);
    }

    @Override
    public AgendaEntity saveAgenda(AgendaEntity agendaEntity) {
        return agendaRepository.save(agendaEntity);
    }

    @Override
    public AgendaEntity updateAgenda(AgendaEntity agendaEntity) {
        return agendaRepository.save(agendaEntity);
    }

    @Override
    public void deleteAgenda(Long id) {
        agendaRepository.deleteById(id);

    }
}
