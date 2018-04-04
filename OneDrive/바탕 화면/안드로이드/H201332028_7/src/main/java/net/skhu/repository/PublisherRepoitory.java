package net.skhu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Publisher;

public interface PublisherRepoitory extends JpaRepository<Publisher, Integer> {

}

