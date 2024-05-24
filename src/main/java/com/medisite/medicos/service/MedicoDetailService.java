package com.medisite.medicos.service;

import com.medisite.medicos.repository.MedicoRepository;
import com.medisite.medicos.repository.entity.MedicoEntity;
import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class MedicoDetailService implements UserDetailsService {
    @Autowired
    private MedicoRepository medicoRepository;

    private MedicoEntity medicoDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        medicoDetails = medicoRepository.findByEmail(username);
        if(!Objects.isNull(medicoDetails)){
            return new User(medicoDetails.getEmail(), medicoDetails.getContraseña(), new ArrayList<>());
        } else{
            throw new UsernameNotFoundException("Medico no encontrado");
        }
    }
}
