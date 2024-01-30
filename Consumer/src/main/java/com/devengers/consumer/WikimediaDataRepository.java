package com.devengers.consumer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<com.devengers.consumer.entity.WikimediaData, Long> {
}
