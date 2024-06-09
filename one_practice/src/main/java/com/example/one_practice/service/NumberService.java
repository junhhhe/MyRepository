package com.example.one_practice.service;

import com.example.one_practice.dto.NumberRequestDto;
import com.example.one_practice.entity.Number;
import com.example.one_practice.repository.NumberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NumberService {

    @Autowired
    private final NumberRepository numberRepository;

    public Number create(NumberRequestDto dto) {

        Number number = Number.builder().
                name(dto.getName()).
                phone(dto.getPhone()).build();

        return numberRepository.save(number);
    }

    public Optional<Number> findByName(String name) {
        return numberRepository.findByName(name);
    }
    public List<Number> findAll() {
        return numberRepository.findAll();
    }

    public Optional<Number> findById(Long id) {
        return numberRepository.findById(id);
    }

    public Number update(Long id, NumberRequestDto dto) {
        Number existingNumber = numberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾지못함 : " + id));

        Number updatedNumber = Number.builder()
                .id(existingNumber.getId())  // Retain the existing ID
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();
        return numberRepository.save(updatedNumber);
    }

    public void delete(Long id) {
        Number number = numberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾지못함 : " + id));

        numberRepository.delete(number);
    }
}
